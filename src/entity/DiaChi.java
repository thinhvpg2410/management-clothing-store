package entity;

public class DiaChi {
    private String quocGia;
    private String thanhPho;
    private String quan;
    private String phuong;
    private String tenDuong;

    public DiaChi() {
    }

    public DiaChi(String quocGia, String thanhPho, String quan, String phuong, String tenDuong) {
        this.quocGia = quocGia;
        this.thanhPho = thanhPho;
        this.quan = quan;
        this.phuong = phuong;
        this.tenDuong = tenDuong;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public String getPhuong() {
        return phuong;
    }

    public void setPhuong(String phuong) {
        this.phuong = phuong;
    }

    public String getTenDuong() {
        return tenDuong;
    }

    public void setTenDuong(String tenDuong) {
        this.tenDuong = tenDuong;
    }

    @Override
    public String toString() {
        return "DiaChi{" +
                "quocGia='" + quocGia + '\'' +
                ", thanhPho='" + thanhPho + '\'' +
                ", quan='" + quan + '\'' +
                ", phuong='" + phuong + '\'' +
                ", tenDuong='" + tenDuong + '\'' +
                '}';
    }
}
