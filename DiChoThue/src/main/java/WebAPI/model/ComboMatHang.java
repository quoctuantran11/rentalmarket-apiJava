package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ComboMatHang")
public class ComboMatHang {
	@Id
	private String macombo;
	private String ten_combo;
	private int so_luong_ton;
	private int khoi_luong;
	private int gia_ban;
	private String ma_cua_hang;
	private String hinh_anh;
	
	public String getMacombo() {
		return macombo;
	}
	
	public void setMacombo(String macombo) {
		this.macombo = macombo;
	}
	
	public String getTencombo() {
		return ten_combo;
	}
	
	public void setTen(String tencombo) {
		this.ten_combo = tencombo;
	}
	
	public int getSoluongton() {
		return so_luong_ton;
	}
	
	public void setSoluongton(int soluongton) {
		this.so_luong_ton = soluongton;
	}
	
	public int getKhoiluong() {
		return khoi_luong;
	}
	
	public void setKhoiluong(int khoiluong) {
		this.khoi_luong = khoiluong;
	}
	
	public int getGia() {
		return gia_ban;
	}
	
	public void setGia(int gia) {
		this.gia_ban = gia;
	}
	
	public String getMach() {
		return ma_cua_hang;
	}
	
	public void setMach(String mach) {
		this.ma_cua_hang = mach;
	}
	
	public String getHinhanh() {
		return hinh_anh;
	}
	
	public void setHinhanh(String hinhanh) {
		this.hinh_anh = hinhanh;
	}
	
	public ComboMatHang(String macombo, String tencombo, int soluongton, int khoiluong, int gia,
			String mach, String hinhanh) {
		super();
		this.macombo = macombo;
		this.ten_combo = tencombo;
		this.so_luong_ton = soluongton;
		this.khoi_luong = khoiluong;
		this.gia_ban = gia;
		this.ma_cua_hang = mach;
		this.hinh_anh = hinhanh;
	}
	
	public ComboMatHang() {
		super();
	}
}
