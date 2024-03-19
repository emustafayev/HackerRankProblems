package algorithms;

public class CRC16 {
    public CRC16() {
    }

    public static int CRC16_CCITT(byte[] buffer) {
        int wCRCin = 0;
        int wCPoly = '萈';
        byte[] var3 = buffer;
        int var4 = buffer.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            byte b = var3[var5];
            wCRCin ^= b & 255;

            for(int j = 0; j < 8; ++j) {
                if ((wCRCin & 1) != 0) {
                    wCRCin >>= 1;
                    wCRCin ^= wCPoly;
                } else {
                    wCRCin >>= 1;
                }
            }
        }

        return wCRCin ^= 0;
    }

    public static int CRC16_CCITT_FALSE(byte[] buffer) {
        int wCRCin = 65535;
        int wCPoly = 4129;
        byte[] var3 = buffer;
        int var4 = buffer.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            byte b = var3[var5];

            for(int i = 0; i < 8; ++i) {
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

    public static int CRC16_XMODEM(byte[] buffer) {
        int wCRCin = 0;
        int wCPoly = 4129;
        byte[] var3 = buffer;
        int var4 = buffer.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            byte b = var3[var5];

            for(int i = 0; i < 8; ++i) {
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

    public static int CRC16_X25(byte[] buffer) {
        int wCRCin = 65535;
        int wCPoly = '萈';
        byte[] var3 = buffer;
        int var4 = buffer.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            byte b = var3[var5];
            wCRCin ^= b & 255;

            for(int j = 0; j < 8; ++j) {
                if ((wCRCin & 1) != 0) {
                    wCRCin >>= 1;
                    wCRCin ^= wCPoly;
                } else {
                    wCRCin >>= 1;
                }
            }
        }

        return wCRCin ^= 65535;
    }

    public static int CRC16_MODBUS(byte[] buffer) {
        int wCRCin = 65535;
        int POLYNOMIAL = 'ꀁ';
        byte[] var3 = buffer;
        int var4 = buffer.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            byte b = var3[var5];
            wCRCin ^= b & 255;

            for(int j = 0; j < 8; ++j) {
                if ((wCRCin & 1) != 0) {
                    wCRCin >>= 1;
                    wCRCin ^= POLYNOMIAL;
                } else {
                    wCRCin >>= 1;
                }
            }
        }

        return wCRCin ^= 0;
    }

    public static int CRC16_IBM(byte[] buffer) {
        int wCRCin = 0;
        int wCPoly = 'ꀁ';
        byte[] var3 = buffer;
        int var4 = buffer.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            byte b = var3[var5];
            wCRCin ^= b & 255;

            for(int j = 0; j < 8; ++j) {
                if ((wCRCin & 1) != 0) {
                    wCRCin >>= 1;
                    wCRCin ^= wCPoly;
                } else {
                    wCRCin >>= 1;
                }
            }
        }

        return wCRCin ^= 0;
    }

    public static int CRC16_MAXIM(byte[] buffer) {
        int wCRCin = 0;
        int wCPoly = 'ꀁ';
        byte[] var3 = buffer;
        int var4 = buffer.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            byte b = var3[var5];
            wCRCin ^= b & 255;

            for(int j = 0; j < 8; ++j) {
                if ((wCRCin & 1) != 0) {
                    wCRCin >>= 1;
                    wCRCin ^= wCPoly;
                } else {
                    wCRCin >>= 1;
                }
            }
        }

        return wCRCin ^= 65535;
    }

    public static int CRC16_USB(byte[] buffer) {
        int wCRCin = 65535;
        int wCPoly = 'ꀁ';
        byte[] var3 = buffer;
        int var4 = buffer.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            byte b = var3[var5];
            wCRCin ^= b & 255;

            for(int j = 0; j < 8; ++j) {
                if ((wCRCin & 1) != 0) {
                    wCRCin >>= 1;
                    wCRCin ^= wCPoly;
                } else {
                    wCRCin >>= 1;
                }
            }
        }

        return wCRCin ^= 65535;
    }

    public static int CRC16_DNP(byte[] buffer) {
        int wCRCin = 0;
        int wCPoly = 'ꚼ';
        byte[] var3 = buffer;
        int var4 = buffer.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            byte b = var3[var5];
            wCRCin ^= b & 255;

            for(int j = 0; j < 8; ++j) {
                if ((wCRCin & 1) != 0) {
                    wCRCin >>= 1;
                    wCRCin ^= wCPoly;
                } else {
                    wCRCin >>= 1;
                }
            }
        }

        return wCRCin ^= 65535;
    }

    public static int CRC16_BYPASS(byte[] buffer) {
        int wCRCin = 0;
        int wCPoly = '者';
        byte[] var3 = buffer;
        int var4 = buffer.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            byte b = var3[var5];

            for(int i = 0; i < 8; ++i) {
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
}
