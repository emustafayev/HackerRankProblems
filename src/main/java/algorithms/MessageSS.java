//package algorithms;
//
//import java.io.IOException;
//import java.nio.ByteBuffer;
//import java.util.ArrayList;
//import java.util.Iterator;
//
//public class MessageSS {
//    private String name;
//    private byte stx = 0;
//    private byte ll = 0;
//    private byte lh = 0;
//    private ArrayList<MessageSSPart> messagePart;
//    private byte crc16l = 0;
//    private byte crc16h = 0;
//    private ByteBuffer messageBody;
//    private byte[] dataBodyByte;
//    private byte[] messageBodyByte;
//    private byte[] noCRCBodyBite;
//    private ArrayList<Byte> noHeadMessage;
//    private ArrayList<Byte> fullMessage;
//
//    public MessageSS(String name, byte stx, byte ll, byte lh, ArrayList<MessageSSPart> messagePart) {
//        this.name = name;
//        this.stx = stx;
//        this.ll = ll;
//        this.lh = lh;
//        this.messagePart = messagePart;
//    }
//
//    public MessageSS(String name) {
//        this.name = name;
//        this.messagePart = new ArrayList();
//    }
//
//    public String getName() {
//        return this.name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public byte getStx() {
//        return this.stx;
//    }
//
//    public void setStx(byte stx) {
//        this.stx = stx;
//    }
//
//    public byte getLl() {
//        return this.ll;
//    }
//
//    public void setLl(byte ll) {
//        this.ll = ll;
//    }
//
//    public byte getLh() {
//        return this.lh;
//    }
//
//    public void setLh(byte lh) {
//        this.lh = lh;
//    }
//
//    public ArrayList<MessageSSPart> getMessagePart() {
//        return this.messagePart;
//    }
//
//    public void setMessagePart(MessageSSPart messagePart) {
//        this.messagePart.add(messagePart);
//    }
//
//    public byte getCrc16l() {
//        return this.crc16l;
//    }
//
//    public void setCrc16l(byte crc16l) {
//        this.crc16l = crc16l;
//    }
//
//    public byte getCrc16h() {
//        return this.crc16h;
//    }
//
//    public void setCrc16h(byte crc16h) {
//        this.crc16h = crc16h;
//    }
//
//    public byte[] formMessageBodyData() throws IOException {
//        Iterator<MessageSSPart> iterator = this.messagePart.iterator();
//        this.noHeadMessage = new ArrayList();
//
//        while(iterator.hasNext()) {
//            MessageSSPart messageSSPart = (MessageSSPart)iterator.next();
//            this.noHeadMessage.add(messageSSPart.getN());
//            this.noHeadMessage.add(messageSSPart.getLl());
//            this.noHeadMessage.add(messageSSPart.getLh());
//            byte[] bb = messageSSPart.getData();
//
//            for(int i = 0; i < bb.length; ++i) {
//                this.noHeadMessage.add(bb[i]);
//            }
//        }
//
//        Iterator<Byte> iteratorb = this.noHeadMessage.iterator();
//        this.messageBody = ByteBuffer.allocate(this.noHeadMessage.size());
//
//        while(iteratorb.hasNext()) {
//            this.messageBody.put((Byte)iteratorb.next());
//        }
//
//        this.dataBodyByte = this.messageBody.array();
//        this.ll = this.calcLengthBytes(this.dataBodyByte, 1);
//        this.lh = this.calcLengthBytes(this.dataBodyByte, 0);
//        return this.dataBodyByte;
//    }
//
//    public byte[] getMessageBody() throws IOException {
//        this.formMessageBodyData();
//        this.fullMessage = new ArrayList();
//        this.fullMessage.add(this.stx);
//        this.fullMessage.add(this.ll);
//        this.fullMessage.add(this.lh);
//
//        for(int i = 0; i < this.dataBodyByte.length; ++i) {
//            this.fullMessage.add(this.dataBodyByte[i]);
//        }
//
//        Iterator<Byte> iteratorb = this.fullMessage.iterator();
//        this.messageBody = ByteBuffer.allocate(this.fullMessage.size());
//
//        while(iteratorb.hasNext()) {
//            this.messageBody.put((Byte)iteratorb.next());
//        }
//
//        this.noCRCBodyBite = this.messageBody.array();
//        int crc6 = CRC16.CRC16_BYPASS(this.noCRCBodyBite);
//        byte[] crc = MessageQ.intToByteArray(crc6);
//        this.crc16l = crc[2];
//        this.crc16h = crc[3];
//        this.fullMessage.add(this.crc16l);
//        this.fullMessage.add(this.crc16h);
//        Iterator<Byte> iterator = this.fullMessage.iterator();
//        this.messageBody = ByteBuffer.allocate(this.fullMessage.size());
//
//        while(iterator.hasNext()) {
//            this.messageBody.put((Byte)iterator.next());
//        }
//
//        this.messageBodyByte = this.messageBody.array();
//        return this.messageBodyByte;
//    }
//
//    private byte calcLengthBytes(byte[] mBytes, int i) throws IOException {
//        int length = mBytes.length;
//        byte[] lengthBB = ByteBuffer.allocate(4).putInt(length).array();
//        if (i == 0) {
//            return lengthBB[2];
//        } else if (i == 1) {
//            return lengthBB[3];
//        } else {
//            byte r = 0;
//            return r;
//        }
//    }
//
//    public static byte[] calcCRC(byte[] messageByte) throws IOException {
//        int crc6 = CRC16.CRC16_BYPASS(messageByte);
//        byte[] crc = MessageQ.intToByteArray(crc6);
//        return crc;
//    }
//
//    public static byte[] calcCRC(ArrayList<Byte> listByte) throws IOException {
//        Byte[] soundBytes = (Byte[])listByte.toArray(new Byte[listByte.size()]);
//        byte[] messageByte = new byte[soundBytes.length - 2];
//
//        int crc6;
//        for(crc6 = 0; crc6 < soundBytes.length - 2; ++crc6) {
//            messageByte[crc6] = soundBytes[crc6];
//        }
//
//        crc6 = CRC16.CRC16_BYPASS(messageByte);
//        byte[] crc = MessageQ.intToByteArray(crc6);
//        return crc;
//    }
//
//    public byte[] getFieldData(String name) {
//        for(int i = 0; i < this.messagePart.size(); ++i) {
//            MessageSSPart message1Part = (MessageSSPart)this.messagePart.get(i);
//            if (message1Part.getName().equals(name)) {
//                return message1Part.getData();
//            }
//        }
//
//        byte[] nullarray = new byte[]{0, 0};
//        return nullarray;
//    }
//}
