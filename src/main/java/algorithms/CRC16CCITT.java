package algorithms;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class CRC16CCITT {

//    public static void main(String[] args) {
//        int crc = 0xFFFF;          // initial value
////        int polynomial = 0x1021;   // 0001 0000 0010 0001  (0, 5, 12)
//        int polynomial = 0x8408;   // 1000 0100 0000 1000  (0, 5, 12, 16)
//
//        int SYNC = 0xFC;
//        int LNG = 0x05;
//        int CMD = 0x11;
//
//         byte[] testBytes = new byte[]{(byte) SYNC,(byte) LNG,(byte) CMD};
//
////        byte[] bytes = args[0].getBytes();
//
//        for (byte b : testBytes) {
//            for (int i = 0; i < 8; i++) {
//                boolean bit = ((b   >> (7-i) & 1) == 1);
//                boolean c15 = ((crc >> 15    & 1) == 1);
//                crc <<= 1;
//                if (c15 ^ bit) crc ^= polynomial;
//            }
//        }
//
//        crc &= 0xffff;
//        System.out.println("CRC16-CCITT = " + Integer.toHexString(crc));
//
//        int crcHigh = (crc >> 8) & 0xFF;
//        int crcLow = crc & 0xFF;
//        System.out.println(crcHigh);
//        System.out.println(crcLow);
//    }

    public static byte[] hexStringToByteArray(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }


    private static final int POLYNOMIAL = 0x8408;

    public static void mai2n(String[] args) throws IOException {
// Message bytes
        byte[] message = new byte[]{(byte) 0xFC, (byte) 0x05, (byte) 0x11};

        // Calculate CRC
        int crc = calculateCRC(message);

        // Extract CRC high and low bytes
        byte crcLow = (byte) (crc & 0xFF);
        byte crcHigh = (byte) ((crc >> 8) & 0xFF);

        // Print CRC values
//        System.out.println("Calculated CRC (H): [" + String.format("%02XH", crcHigh) + "]");
//        System.out.println("Calculated CRC (L): [" + String.format("%02XH", crcLow) + "]");
//        System.out.println("Expected CRC (H): [56H]");
//        System.out.println("Expected CRC (L): [27H]");


        //Message Id line 100 => ComputeChecksum(kermit)
//        byte[] crc2 = intToByteArray(CRC16_BYPASS(message));
//
//        System.out.println(crc2[2]);
//        System.out.println(crc2[3]);
        calculateCrCStartOver();
    }

    private static int calculateCRC(byte[] bytes) {
        int crc = 0xFFFF; // Initial value

        for (byte b : bytes) {
            crc ^= (b & 0xFF) << 8;
            for (int i = 0; i < 8; i++) {
                if ((crc & 0x8000) != 0) {
                    crc = (crc << 1) ^ POLYNOMIAL;
                } else {
                    crc <<= 1;
                }
            }
        }

        return crc & 0xFFFF;
    }


    public static int CRC16_BYPASS(byte[] buffer) {
        int wCRCin = 0;
        int wCPoly = '者';
        byte[] var3 = buffer;
        int var4 = buffer.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            byte b = var3[var5];

            for (int i = 0; i < 8; ++i) {
                boolean bit = (b >> 7 - i & 1) == 1;
                boolean c15 = (wCRCin >> 15 & 1) == 1;
                wCRCin <<= 1;
                if (c15 ^ bit) {
                    wCRCin ^= wCPoly;
                }
            }
        }

        wCRCin &= 65535;
        return wCRCin ^= 0;
    }

    public static byte[] intToByteArray(int i) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        dos.writeInt(i);
        dos.flush();
        return bos.toByteArray();
    }


    public static void calculateCrCStartOver() {

        int sync = 252;
        int cmd = 11;
        ArrayList<Integer> tempBody = new ArrayList(5);

        tempBody.add(sync);

        int n;
        n = tempBody.size();

        n += 4; //4 more for full bits
        int lng = Integer.valueOf(String.valueOf(n), 16);
        tempBody.add(lng);

        tempBody.add(cmd);

        //if inhibit add data


        //crc high, low

        int CRC = ComputeChecksum(tempBody);
        System.out.println(Integer.toHexString(CRC));
        ByteBuffer b = ByteBuffer.allocate(4);
        b.putInt(CRC);
        byte[] result = b.array();
        int crcl = result[3];
        int crch = result[2];
        tempBody.add(crcl);
        tempBody.add(crch);

        System.out.println(tempBody);
    }

    private static int[] table2 = new int[]{0, 4489, 8978, 12955, 17956, 22445, 25910, 29887, 35912, 40385, 44890, 48851, 51820, 56293, 59774, 63735, 4225, 264, 13203, 8730, 22181, 18220, 30135, 25662, 40137, 36160, 49115, 44626, 56045, 52068, 63999, 59510, 8450, 12427, 528, 5017, 26406, 30383, 17460, 21949, 44362, 48323, 36440, 40913, 60270, 64231, 51324, 55797, 12675, 8202, 4753, 792, 30631, 26158, 21685, 17724, 48587, 44098, 40665, 36688, 64495, 60006, 55549, 51572, 16900, 21389, 24854, 28831, 1056, 5545, 10034, 14011, 52812, 57285, 60766, 64727, 34920, 39393, 43898, 47859, 21125, 17164, 29079, 24606, 5281, 1320, 14259, 9786, 57037, 53060, 64991, 60502, 39145, 35168, 48123, 43634, 25350, 29327, 16404, 20893, 9506, 13483, 1584, 6073, 61262, 65223, 52316, 56789, 43370, 47331, 35448, 39921, 29575, 25102, 20629, 16668, 13731, 9258, 5809, 1848, 65487, 60998, 56541, 52564, 47595, 43106, 39673, 35696, 33800, 38273, 42778, 46739, 49708, 54181, 57662, 61623, 2112, 6601, 11090, 15067, 20068, 24557, 28022, 31999, 38025, 34048, 47003, 42514, 53933, 49956, 61887, 57398, 6337, 2376, 15315, 10842, 24293, 20332, 32247, 27774, 42250, 46211, 34328, 38801, 58158, 62119, 49212, 53685, 10562, 14539, 2640, 7129, 28518, 32495, 19572, 24061, 46475, 41986, 38553, 34576, 62383, 57894, 53437, 49460, 14787, 10314, 6865, 2904, 32743, 28270, 23797, 19836, 50700, 55173, 58654, 62615, 32808, 37281, 41786, 45747, 19012, 23501, 26966, 30943, 3168, 7657, 12146, 16123, 54925, 50948, 62879, 58390, 37033, 33056, 46011, 41522, 23237, 19276, 31191, 26718, 7393, 3432, 16371, 11898, 59150, 63111, 50204, 54677, 41258, 45219, 33336, 37809, 27462, 31439, 18516, 23005, 11618, 15595, 3696, 8185, 63375, 58886, 54429, 50452, 45483, 40994, 37561, 33584, 31687, 27214, 22741, 18780, 15843, 11370, 7921, 3960};

    public static int ComputeChecksum(ArrayList<Integer> buffer) {
        int crc = 0;

        for (int i = 0; i < buffer.size(); ++i) {
            crc = crc >> 8 ^ table2[(crc ^ buffer.get(i)) & 255];
        }

        return crc;
    }




    //---------------------------------------------------------------------------------------------------------------------------------

//https://stackoverflow.com/questions/5059268/c-sharp-crc-implementation
    //----------------------------------------------CORRECT SOLUTION FOR CRC PART--------------------------------------------------------

    public static void main(String[] args) {
        byte[] data = {(byte)0xFC, (byte)0x05, (byte)0x11 };
//
//
//        int crc16Bypass = CRC16_BYPASS(data);
//
//        System.out.println(Integer.toHexString(crc16Bypass));
//
//        System.out.println("=============================================================");
//
//        calculateCrCStartOver();

        System.out.println("=============================================================");


        System.out.println(Integer.toHexString(252));


        // Example usage
//        byte[] data = {(byte) 0xFC, (byte) 0x05, (byte) 0x50};
        int checksum = computeCRC(data);
        System.out.println("Checksum: " + Integer.toHexString(checksum)); // convert to hexadecimal
        byte[] checksumBytes = getHighLowCRCBytes(checksum);

        System.out.println("CRCLow: " + Integer.toHexString(checksumBytes[0]));
        System.out.println("CRCHigh: " + Integer.toHexString(checksumBytes[1]));


        System.out.printf("%02x%n", checksumBytes[0]);// correct way of converting to hexadecimal(at least returning correct result

//        System.out.println(Integer.valueOf(Integer.toHexString(checksumBytes[0]),16));

    }


    private static int[] table = {
            0x0000, 0x1189, 0x2312, 0x329B, 0x4624, 0x57AD, 0x6536, 0x74BF,
            0x8C48, 0x9DC1, 0xAF5A, 0xBED3, 0xCA6C, 0xDBE5, 0xE97E, 0xF8F7,
            0x1081, 0x0108, 0x3393, 0x221A, 0x56A5, 0x472C, 0x75B7, 0x643E,
            0x9CC9, 0x8D40, 0xBFDB, 0xAE52, 0xDAED, 0xCB64, 0xF9FF, 0xE876,
            0x2102, 0x308B, 0x0210, 0x1399, 0x6726, 0x76AF, 0x4434, 0x55BD,
            0xAD4A, 0xBCC3, 0x8E58, 0x9FD1, 0xEB6E, 0xFAE7, 0xC87C, 0xD9F5,
            0x3183, 0x200A, 0x1291, 0x0318, 0x77A7, 0x662E, 0x54B5, 0x453C,
            0xBDCB, 0xAC42, 0x9ED9, 0x8F50, 0xFBEF, 0xEA66, 0xD8FD, 0xC974,
            0x4204, 0x538D, 0x6116, 0x709F, 0x0420, 0x15A9, 0x2732, 0x36BB,
            0xCE4C, 0xDFC5, 0xED5E, 0xFCD7, 0x8868, 0x99E1, 0xAB7A, 0xBAF3,
            0x5285, 0x430C, 0x7197, 0x601E, 0x14A1, 0x0528, 0x37B3, 0x263A,
            0xDECD, 0xCF44, 0xFDDF, 0xEC56, 0x98E9, 0x8960, 0xBBFB, 0xAA72,
            0x6306, 0x728F, 0x4014, 0x519D, 0x2522, 0x34AB, 0x0630, 0x17B9,
            0xEF4E, 0xFEC7, 0xCC5C, 0xDDD5, 0xA96A, 0xB8E3, 0x8A78, 0x9BF1,
            0x7387, 0x620E, 0x5095, 0x411C, 0x35A3, 0x242A, 0x16B1, 0x0738,
            0xFFCF, 0xEE46, 0xDCDD, 0xCD54, 0xB9EB, 0xA862, 0x9AF9, 0x8B70,
            0x8408, 0x9581, 0xA71A, 0xB693, 0xC22C, 0xD3A5, 0xE13E, 0xF0B7,
            0x0840, 0x19C9, 0x2B52, 0x3ADB, 0x4E64, 0x5FED, 0x6D76, 0x7CFF,
            0x9489, 0x8500, 0xB79B, 0xA612, 0xD2AD, 0xC324, 0xF1BF, 0xE036,
            0x18C1, 0x0948, 0x3BD3, 0x2A5A, 0x5EE5, 0x4F6C, 0x7DF7, 0x6C7E,
            0xA50A, 0xB483, 0x8618, 0x9791, 0xE32E, 0xF2A7, 0xC03C, 0xD1B5,
            0x2942, 0x38CB, 0x0A50, 0x1BD9, 0x6F66, 0x7EEF, 0x4C74, 0x5DFD,
            0xB58B, 0xA402, 0x9699, 0x8710, 0xF3AF, 0xE226, 0xD0BD, 0xC134,
            0x39C3, 0x284A, 0x1AD1, 0x0B58, 0x7FE7, 0x6E6E, 0x5CF5, 0x4D7C,
            0xC60C, 0xD785, 0xE51E, 0xF497, 0x8028, 0x91A1, 0xA33A, 0xB2B3,
            0x4A44, 0x5BCD, 0x6956, 0x78DF, 0x0C60, 0x1DE9, 0x2F72, 0x3EFB,
            0xD68D, 0xC704, 0xF59F, 0xE416, 0x90A9, 0x8120, 0xB3BB, 0xA232,
            0x5AC5, 0x4B4C, 0x79D7, 0x685E, 0x1CE1, 0x0D68, 0x3FF3, 0x2E7A,
            0xE70E, 0xF687, 0xC41C, 0xD595, 0xA12A, 0xB0A3, 0x8238, 0x93B1,
            0x6B46, 0x7ACF, 0x4854, 0x59DD, 0x2D62, 0x3CEB, 0x0E70, 0x1FF9,
            0xF78F, 0xE606, 0xD49D, 0xC514, 0xB1AB, 0xA022, 0x92B9, 0x8330,
            0x7BC7, 0x6A4E, 0x58D5, 0x495C, 0x3DE3, 0x2C6A, 0x1EF1, 0x0F78
    };

    public static int computeCRC(byte[] buffer) {
        if (buffer == null) throw new IllegalArgumentException("Buffer cannot be null.");
        int crc = 0;
        for (byte b : buffer) {
            crc = ((crc >> 8) ^ table[(crc ^ b) & 0xFF]);
        }
        return crc;
    }

    public static byte[] getHighLowCRCBytes(int crc) {
//        int crc = computeChecksum(buffer);
        return new byte[]{(byte) (crc & 0xFF), (byte) ((crc >> 8) & 0xFF)};
    }

}
