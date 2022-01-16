package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DonHang")
public class DonHang {
	@Id
	private String madh;
	private String tinh_trang;
	private String hinh_thuc_thanh_toan;
	private int tong_tien;
	private String dia_chi;
	private String ngay_dat;
	private String ma_khach_hang;
	private String ma_cua_hang;
	private String ma_shipper;
	
	public String getMadh() {
		return madh;
	}
	
	public void setMadh(String madh) {
		this.madh = madh;
	}
	
	public String getTinhtrangdon() {
		return tinh_trang;
	}
	
	public void setTinhtrangdon(String tinhtrangdon) {
		this.tinh_trang = tinhtrangdon;
	}
	
	public String getHinhthucthanhtoan() {
		return hinh_thuc_thanh_toan;
	}
	
	public void setHinhthucthanhtoan(String hinhthucthanhtoan) {
		this.hinh_thuc_thanh_toan = hinhthucthanhtoan;
	}
	
	public int getTongtien() {
		return tong_tien;
	}
	
	public void setTongtien(int tongtien) {
		this.tong_tien = tongtien;
	}
	
	public String getDiachi() {
		return dia_chi;
	}
	
	public void setDiachi(String diachi) {
		this.dia_chi = diachi;
	}
	
	public String getNgaydat() {
		return ngay_dat;
	}
	
	public void setNgaydat(String ngay) {
		this.ngay_dat = ngay;
	}
	
	public String getMakh() {
		return ma_khach_hang;
	}
	
	public void setMakh(String makh) {
		this.ma_khach_hang = makh;
	}
	
	public String getMach() {
		return ma_cua_hang;
	}
	
	public void setMach(String mach) {
		this.ma_cua_hang = mach;
	}
	
	public String getMashipper() {
		return ma_shipper;
	}
	
	public void setMashipper(String mashipper) {
		this.ma_shipper = mashipper;
	}
	
	public DonHang(String madh, String tinhtrangdon, String hinhthucthanhtoan, int tongtien, 
			String diachi, String ngay, String makh, String mach, String mashipper) {
		super();
		this.madh = madh;
		this.tinh_trang = tinhtrangdon;
		this.hinh_thuc_thanh_toan = hinhthucthanhtoan;
		this.tong_tien = tongtien;
		this.dia_chi = diachi;
		this.ngay_dat = ngay;
		this.ma_khach_hang = makh;
		this.ma_cua_hang = mach;
		this.ma_shipper = mashipper;
	}
	
	public DonHang() {
		super();
	}
}
