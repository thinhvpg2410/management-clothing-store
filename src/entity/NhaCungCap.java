package entity;

import java.util.Objects;

public class NhaCungCap {
    private String maNCC;
    private String ten;
    private String sdt;
    private DiaChi diaChi;

    public NhaCungCap() {
    }
    public NhaCungCap(String maNCC) {
    	this.maNCC = maNCC;
    }

    public NhaCungCap(String maNCC, String ten, String sdt, DiaChi diaChi) {
        this.maNCC = maNCC;
        this.ten = ten;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public DiaChi getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NhaCungCap that = (NhaCungCap) o;
        return Objects.equals(maNCC, that.maNCC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maNCC);
    }

    @Override
    public String toString() {
        return "NhaCungCap{" +
                "maNCC='" + maNCC + '\'' +
                ", ten='" + ten + '\'' +
                ", sdt='" + sdt + '\'' +
                ", diaChi=" + diaChi +
                '}';
    }
}
