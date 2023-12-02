package entity;

import java.util.Objects;

public class NhaCungCap {
    private String maNCC;
    private String ten;
    private String sdt;
    private String email;

    public NhaCungCap() {
    }

    public NhaCungCap(String maNCC, String ten, String sdt, String email) {
        this.maNCC = maNCC;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                ", email='" + email + '\'' +
                '}';
    }
}
