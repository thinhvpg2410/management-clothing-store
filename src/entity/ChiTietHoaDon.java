package entity;

public class ChiTietHoaDon {
private int soLuong;

public ChiTietHoaDon() {
	super();
}

public ChiTietHoaDon(int soLuong) {
	super();
	this.soLuong = soLuong;
}

public int getSoLuong() {
	return soLuong;
}

public void setSoLuong(int soLuong) {
	this.soLuong = soLuong;
}

@Override
public String toString() {
	return "ChiTietHoaDon [soLuong=" + soLuong + "]";
}

}
