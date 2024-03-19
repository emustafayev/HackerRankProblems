package algorithms;

import org.usb4java.BufferUtils;
import org.usb4java.Context;
import org.usb4java.Device;
import org.usb4java.DeviceDescriptor;
import org.usb4java.DeviceHandle;
import org.usb4java.DeviceList;
import org.usb4java.LibUsb;
import org.usb4java.LibUsbException;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SmartSaleThreadLibUsbRunnable {
    byte[] byteMessageSS;
    byte[] byteReceived;
    byte[] byteTemp;
    int succesful = 0;
    MessageSS messageSS;
    MessageSS messageSSreceived;
    LinkedList<MessageQ> queue;
    MessageQ msg;
    ArrayList<Byte> messageArray = null;
    ArrayList<byte[]> byteMessageToSend = null;
    ByteBuffer header = null;
    short vendorID = 4554;
    short productID = 546;
    int nak = 0;
    private volatile boolean abort;
    private static Logger Log = Logger.getLogger(SmartSaleThreadLibUsbRunnable.class.getName());
    FileHandler fh;
    Callback caller;
    private static final byte INTERFACE = 1;
    private static final int TIMEOUT = 2000;

    public SmartSaleThreadLibUsbRunnable(LinkedList<MessageQ> queue, MessageSS messageSS, Callback caller) {
        this.queue = queue;
        this.messageSS = messageSS;
        this.caller = caller;
    }

    public SmartSaleThreadLibUsbRunnable(MessageSS messageSS, Callback caller) {
        this.queue = new LinkedList();
        this.messageSS = messageSS;
        this.caller = caller;
    }

    public void abort() {
        this.abort = true;
    }

    public MessageSS getMessageArray() {
        return this.messageSSreceived;
    }

    public static void main(String[] args) {


//        formMessageBodyData =>  adding data diff protocol


        SmartSaleThreadLibUsbRunnable smartSaleThreadLibUsbRunnable = new SmartSaleThreadLibUsbRunnable(new MessageSS("test"), new Callback() {
            @Override
            public void toCallback() {
                System.out.println("callback called");
            }
        });
        smartSaleThreadLibUsbRunnable.run();
    }

    public void run() {
        try {
            this.fh = new FileHandler("Comm.log");
        } catch (IOException var22) {
            var22.printStackTrace();
        }

        LogManager.getLogManager().reset();
        Log.setUseParentHandlers(false);
        Log.addHandler(this.fh);
        SimpleFormatter formatter = new SimpleFormatter();
        this.fh.setFormatter(formatter);
        int result = LibUsb.init((Context)null);
        if (result != 0) {
            throw new LibUsbException("Unable to initialize libusb", result);
        } else {
            this.msg = new MessageQ("Transaction started");
            this.queue.offer(this.msg);
            DeviceHandle handle = new DeviceHandle();
            if (handle == null) {
                System.err.println("DeviceHandle not found.");
                this.msg = new MessageQ("DeviceHandle not found.");
                this.queue.offer(this.msg);
            }



            Device device = this.findDevice(this.vendorID, this.productID);

            //assume device found
//            if (device == null) {
//                System.err.println("Missile launcher not found.");
//                this.msg = new MessageQ("Device not found.");
//                this.queue.offer(this.msg);
//            }



            //---------------------------------------------------------------------------


            try {
                this.byteMessageSS = this.messageSS.getMessageBody();
                System.out.println(Arrays.toString(this.byteMessageSS));
            } catch (IOException var21) {
                var21.printStackTrace();
            }

            int lengthstart = MessageQ.twoBytesToShort(this.messageSS.getLh(), this.messageSS.getLl());
            int resultstart = (int)Math.ceil((double)(lengthstart + 5) / 32.0);
            Log.info("lengthstart:" + lengthstart + "resultstart:" + resultstart);
            this.byteMessageToSend = new ArrayList();
            int start32 = 0;
            int end32 = 32;
            if (lengthstart + 5 <= end32) {
                end32 = lengthstart + 5;
            } else if (lengthstart + 5 > end32) {
                end32 = 32;
            }

            int i;
            Logger var10000;
            String var10001;
            for(i = 0; i < resultstart; ++i) {
                this.byteTemp = Arrays.copyOfRange(this.byteMessageSS, start32, end32);
                this.byteMessageToSend.add(this.byteTemp);
                start32 += 32;
                if (lengthstart + 5 - end32 > end32) {
                    end32 += 32;
                } else if (lengthstart + 5 - end32 <= end32) {
                    end32 = lengthstart + 5;
                }

                var10000 = Log;
                var10001 = MessageQ.bytesToHex(this.byteTemp);
                var10000.info(var10001 + "\nLengthstart:" + lengthstart);
            }

//            System.out.println(this.byteMessageToSend.get(i));

            for(i = 0; i < resultstart; ++i) {
                write(handle, (byte[])this.byteMessageToSend.get(i));
            }

            Log.info("Start message sent");
            i = 0;
//                            int lengthj = false;

            label201:
            do {
                this.messageArray = new ArrayList();
                this.header = read(handle, 64);
                this.byteReceived = new byte[this.header.capacity()];

                int length;
                for(length = 0; length < this.header.capacity(); ++length) {
                    this.byteReceived[length] = this.header.get(length);
                }

                Log.info("Data:" + MessageQ.bytesToHex(this.byteReceived));
                length = MessageQ.twoBytesToShort(this.byteReceived[2], this.byteReceived[1]);
                int lengthj;
                if (length > 0 && length <= 64) {
                    lengthj = length + 5;
                } else if (length == 0) {
                    lengthj = 1;
                } else {
                    lengthj = 64;
                }

                for(int j = 0; j < lengthj; ++j) {
                    this.messageArray.add(this.byteReceived[j]);
                }

                switch ((Byte)this.messageArray.get(0)) {
                    case 2:
                        byte[] checkbyte = new byte[]{(Byte)this.messageArray.get(3), 0};
                        this.msg = new MessageQ(MessageQ.bytesToHex(checkbyte) + "ANSWER STX");
                        this.queue.offer(this.msg);
                        byte[] byteNAK;
                        if (Byte.compare(checkbyte[0], (byte)0) == 0 || Byte.compare((Byte)this.messageArray.get(3), (byte)6) == 0) {
                            int loopcount = (int)Math.ceil((double)length / 64.0);
                            this.msg = new MessageQ("ANSWER FULL, result:" + loopcount);
                            this.queue.offer(this.msg);
                            Log.info("ANSWER FULL, result:" + loopcount);

                            for(int j = 1; j < loopcount; ++j) {
                                this.header = read(handle, 64);
                                this.byteReceived = new byte[this.header.capacity()];

                                int lengthlocal;
                                for(lengthlocal = 0; lengthlocal < this.header.capacity(); ++lengthlocal) {
                                    this.byteReceived[lengthlocal] = this.header.get(lengthlocal);
                                }

//                                               lengthlocal = false;
                                if (length - lengthj > 64) {
                                    lengthlocal = 64;
                                    length -= 64;
                                } else {
                                    lengthlocal = length - lengthj + 5;
                                }

                                for(int k = 0; k < lengthlocal; ++k) {
                                    this.messageArray.add(this.byteReceived[k]);
                                }

                                Log.info("" + j + "attempt\nData:" + MessageQ.bytesToHex(this.byteReceived) + "\nSize:" + this.messageArray.size());
                            }

                            byteNAK = new byte[2];

                            try {
                                byteNAK = MessageSS.calcCRC(this.messageArray);
                            } catch (IOException var19) {
                                var19.printStackTrace();
                            }

                            String var10003 = MessageQ.bytesToHex(byteNAK);
                            this.msg = new MessageQ("CRC:" + var10003 + "\nSize:" + this.messageArray.size());
                            this.queue.offer(this.msg);
                            var10000 = Log;
                            var10001 = MessageQ.bytesToHex(byteNAK);
                            var10000.info("CRC:" + var10001 + "\nSize:" + this.messageArray.size());
//                                            byte[] byteNAK;
                            if ((Byte)this.messageArray.get(this.messageArray.size() - 1) == byteNAK[3] && (Byte)this.messageArray.get(this.messageArray.size() - 2) == byteNAK[2]) {
                                byteNAK = new byte[]{6};
                                write(handle, byteNAK);
                                this.msg = new MessageQ("ACK bytes sent:" + MessageQ.bytesToHex(byteNAK));
                                this.queue.offer(this.msg);
                                Log.info("ACK bytes sent:" + MessageQ.bytesToHex(byteNAK));
                                this.succesful = 1;
                                break label201;
                            }

                            byteNAK = new byte[]{21};
                            write(handle, byteNAK);
                            this.msg = new MessageQ("CRC is wrong. NAK sent:" + MessageQ.bytesToHex(byteNAK));
                            this.queue.offer(this.msg);
                            break label201;
                        }

                        if (Byte.compare((Byte)this.messageArray.get(3), (byte)25) == 0) {
                            byte[] crc = new byte[2];

                            try {
                                crc = MessageSS.calcCRC(this.messageArray);
                            } catch (IOException var20) {
                                var20.printStackTrace();
                            }

                            this.msg = new MessageQ("WAIT\nCRC:" + MessageQ.bytesToHex(crc));
                            this.queue.offer(this.msg);
                            if ((Byte)this.messageArray.get(this.messageArray.size() - 1) == crc[3] && (Byte)this.messageArray.get(this.messageArray.size() - 2) == crc[2]) {
                                byteNAK = new byte[]{6};
                                write(handle, byteNAK);
                                this.msg = new MessageQ("ACK byte sent");
                                this.queue.offer(this.msg);
                            } else {
                                byteNAK = new byte[]{21};
                                write(handle, byteNAK);
                                this.msg = new MessageQ("CRC is wrong. NAK sent");
                                this.queue.offer(this.msg);
                            }
                            break;
                        }
                    default:
                        Log.info("No message");
                        break;
                    case 4:
                        this.msg = new MessageQ("EOT");
                        this.queue.offer(this.msg);
                        break;
                    case 6:
                        this.msg = new MessageQ("ACK");
                        this.queue.offer(this.msg);
                        break;
                    case 21:
                        this.msg = new MessageQ("NAK");
                        this.queue.offer(this.msg);
                        if (this.nak == 2) {
                            break label201;
                        }

                        ++this.nak;
                }

                ++i;
            } while(!this.abort);

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException var18) {
                var18.printStackTrace();
            }

            byte[] byteEOT = new byte[]{4};
            write(handle, byteEOT);
            result = LibUsb.releaseInterface(handle, 1);
            if (result != 0) {
                this.msg = new MessageQ("Unable to release interface" + result);
                this.queue.offer(this.msg);
                throw new LibUsbException("Unable to release interface", result);
            } else {
                LibUsb.close(handle);
                LibUsb.exit((Context)null);
                this.msg = new MessageQ("Finished");
                this.queue.offer(this.msg);
                this.caller.toCallback();
            }

            //------------------------------------------------------------------------------

//            result = LibUsb.open(device, handle);
            if (result != 0) {
                this.msg = new MessageQ("Unable to open USB device:" + result);
                this.queue.offer(this.msg);
                throw new LibUsbException("Unable to open USB device", result);
            } else {
                int attached = LibUsb.kernelDriverActive(handle, 1);
                if (attached < 0) {
                    this.msg = new MessageQ("Unable to check kernel driver active" + result);
                    this.queue.offer(this.msg);
                    throw new LibUsbException("Unable to check kernel driver active", result);
                } else {
                    result = LibUsb.detachKernelDriver(handle, 1);
                    if (result != 0 && result != -12 && result != -5) {
                        this.msg = new MessageQ("Unable to detach kernel driver" + result);
                        this.queue.offer(this.msg);
                        throw new LibUsbException("Unable to detach kernel driver", result);
                    } else {
                    }
                }
            }
        }
    }

    public Device findDevice(short vendorId, short productId) {
        DeviceList list = new DeviceList();
        int result = LibUsb.getDeviceList((Context)null, list);
        System.out.println("Usb list: ");
        System.out.println(result);
        System.out.println(list);

        Iterator<Device> iterator = list.iterator();
        while (iterator.hasNext()){
            Device currentDevice = iterator.next();
            DeviceDescriptor deviceDescriptor = new DeviceDescriptor();
            result = LibUsb.getDeviceDescriptor(currentDevice, deviceDescriptor);
            System.out.println(deviceDescriptor);

        }

        if (result < 0) {
            throw new LibUsbException("Unable to get device list", result);
        } else {
            try {
                Iterator var5 = list.iterator();

                Device device;
                DeviceDescriptor descriptor;
//                do {
//                    if (!var5.hasNext()) {
//                        return null;
//                    }
//
//                    device = (Device)var5.next();
//                    descriptor = new DeviceDescriptor();
//                    result = LibUsb.getDeviceDescriptor(device, descriptor);
//                    if (result != 0) {
//                        throw new LibUsbException("Unable to read device descriptor", result);
//                    }
//                } while(descriptor.idVendor() != vendorId || descriptor.idProduct() != productId);

                Device var8 = (Device) var5.next();
                return var8;
            } finally {
                LibUsb.freeDeviceList(list, true);
            }
        }
    }

    public static void write(DeviceHandle handle, byte[] data) {
        ByteBuffer buffer = BufferUtils.allocateByteBuffer(data.length);
        buffer.put(data);
        IntBuffer transferred = BufferUtils.allocateIntBuffer();
        int result = LibUsb.bulkTransfer(handle, (byte)3, buffer, transferred, 2000L);
        if (result != 0) {
            throw new LibUsbException("Unable to send data", result);
        } else {
            Log.info(transferred.get() + " bytes sent to device");
        }
    }

    public static ByteBuffer read(DeviceHandle handle, int size) {
        ByteBuffer buffer = BufferUtils.allocateByteBuffer(size).order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer transferred = BufferUtils.allocateIntBuffer();
        int result = LibUsb.bulkTransfer(handle, (byte)-127, buffer, transferred, 2000L);
        if (result != 0) {
            buffer.put((byte)0);
        }

        Log.info("" + result + ":result" + transferred.get() + " bytes read from device");
        buffer.rewind();
        return buffer;
    }
}
