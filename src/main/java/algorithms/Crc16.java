package algorithms;

import lombok.Getter;

import java.nio.ByteBuffer;
import java.util.Arrays;


public class Crc16 {
    private final int[] table = new int[256];

    public Crc16(Crc16Mode mode) {
        int polynomial = mode.getValue();
        int value;
        int temp;
        for (int i = 0; i < table.length; ++i) {
            value = 0;
            temp = i;
            for (byte j = 0; j < 8; ++j) {
                if (((value ^ temp) & 0x0001) != 0) {
                    value = (value >> 1) ^ polynomial;
                } else {
                    value >>= 1;
                }
                temp >>= 1;
            }
            table[i] = value;
        }
    }

    public int computeChecksum(byte[] bytes) {
        int crc = 0;
        for (byte b : bytes) {
            int index = (crc ^ b) & 0xFF;
            crc = (crc >> 8) ^ table[index];
        }
        return crc;
    }

    public byte[] computeChecksumBytes(byte[] bytes) {
        int crc = computeChecksum(bytes);
        System.out.println(crc);
        ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.putShort((short) crc);
        return buffer.array();
    }
    @Getter
    private enum Crc16Mode {
        Standard(0xA001),
        CcittKermit(0x8408);

        private final int value;

        Crc16Mode(int value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {
        int SYNC = 0xFC;
        int LNG = 0x05;
        int CMD = 0x11;

        byte[] testBytes = new byte[]{(byte) SYNC,(byte) LNG,(byte) CMD};
        Crc16 crc16 = new Crc16(Crc16Mode.Standard);

        System.out.println(Arrays.toString(crc16.computeChecksumBytes(testBytes)));
    }
}