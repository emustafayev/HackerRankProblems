package algorithms;

public class MessageSSPart {
    private String name;
    private byte n = 0;
    private byte ll = 0;
    private byte lh = 0;
    private byte[] data;

    public MessageSSPart(String name, byte n, byte ll, byte lh, byte[] data) {
        this.name = name;
        this.n = n;
        this.ll = ll;
        this.lh = lh;
        this.data = data;
    }

    public MessageSSPart(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getN() {
        return this.n;
    }

    public void setN(byte n) {
        this.n = n;
    }

    public byte getLl() {
        return this.ll;
    }

    public void setLl(byte ll) {
        this.ll = ll;
    }

    public byte getLh() {
        return this.lh;
    }

    public void setLh(byte lh) {
        this.lh = lh;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
