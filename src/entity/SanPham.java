package entity;

import java.time.LocalDate;

public class SanPham {
	private String maSP;
	private String tenSP;
	private String donViTinh;
	private double giaNhap;
	private double giaBan;
	private LocalDate ngayNhap;
	private int soLuongTon;
	private String trangThai;
	private String mauSac;
	private String kichThuoc;
	private double thueVAT;
	private NhaCungCap maNCC;
	private KhuyenMai maKM;
	private String thuongHieu;
	
	
	public SanPham() {
		super();
	}

	public SanPham(String maSP) {
		super();
		this.maSP = maSP;
	}

	public SanPham(String maSP, String tenSP, String donViTinh, double giaNhap, LocalDate ngayNhap,
			int soLuongTon, String trangThai, String mauSac, String kichThuoc, double thueVAT, NhaCungCap maNCC,
			KhuyenMai maKM, String thuongHieu) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.donViTinh = donViTinh;
		this.giaNhap = giaNhap;
		this.giaBan = giaNhap + giaNhap*0.2;
		this.ngayNhap = ngayNhap;
		this.soLuongTon = soLuongTon;
		this.trangThai = trangThai;
		this.mauSac = mauSac;
		this.kichThuoc = kichThuoc;
		this.thueVAT = thueVAT;
		this.maNCC = maNCC;
		this.maKM = maKM;
		this.thuongHieu = thuongHieu;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public LocalDate getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(LocalDate ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public String isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	public String getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

	public double getThueVAT() {
		return thueVAT;
	}

	public void setThueVAT(double thueVAT) {
		this.thueVAT = thueVAT;
	}

	public NhaCungCap getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(NhaCungCap maNCC) {
		this.maNCC = maNCC;
	}

	public KhuyenMai getMaKM() {
		return maKM;
	}

	public void setMaKM(KhuyenMai maKM) {
		this.maKM = maKM;
	}

	public String getThuongHieu() {
		return thuongHieu;
	}

	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}

	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", donViTinh=" + donViTinh + ", giaNhap=" + giaNhap
				+ ", giaBan=" + giaBan + ", ngayNhap=" + ngayNhap + ", soLuongTon=" + soLuongTon + ", trangThai="
				+ trangThai + ", mauSac=" + mauSac + ", kichThuoc=" + kichThuoc + ", thueVAT=" + thueVAT + ", maNCC="
				+ maNCC + ", maKM=" + maKM + ", thuongHieu=" + thuongHieu + "]";
	}
	
	
}
