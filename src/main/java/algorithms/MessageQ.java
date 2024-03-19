package algorithms;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class MessageQ {
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    private String msg = " ";
    private byte[] msgbyte = new byte[]{0};

    public MessageQ(String msg) {
        this.msg = msg;
    }

    public MessageQ(byte[] msgbyte) {
        this.msgbyte = msgbyte;
    }

    public String toString() {
        return this.msg;
    }

    public String obtainString() {
        return this.msg;
    }

    public byte[] obtainByte() {
        return this.msgbyte;
    }

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];

        for(int j = 0; j < bytes.length; ++j) {
            int v = bytes[j] & 255;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 15];
        }

        return new String(hexChars);
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];

        for(int i = 0; i < len; i += 2) {
            data[i / 2] = (byte)((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }

        return data;
    }

    public static String charToHex(char[] bytes) {
        char[] hexChars = new char[bytes.length * 2];

        for(int j = 0; j < bytes.length; ++j) {
            int v = bytes[j] & 255;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 15];
        }

        return new String(hexChars);
    }

    public static char[] bytesToChar(byte[] bytes) {
        char[] hexChars = new char[bytes.length];

        for(int j = 0; j < bytes.length; ++j) {
            hexChars[j] = (char)bytes[j];
        }

        return hexChars;
    }

    public static byte[] stringToCByte(String argString) {
        byte[] bytesstring = argString.getBytes(Charset.forName("windows-1251"));
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytesstring.length + 1);
        byteBuffer.put(bytesstring);
        byte zero = 0;
        byteBuffer.put(zero);
        byte[] byteswithzero = byteBuffer.array();
        return byteswithzero;
    }

    public static byte[] intToByteArray(int i) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        dos.writeInt(i);
        dos.flush();
        return bos.toByteArray();
    }

    public static short twoBytesToShort(byte b1, byte b2) {
        return (short)(b1 << 8 | b2 & 255);
    }
}
