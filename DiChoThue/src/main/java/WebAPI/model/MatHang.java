package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MatHang")
public class MatHang {
	@Id
	private String mamh;
	private String ten_mat_hang;
	private String xuat_xu;
	private int so_luong_ton;
	private float khoi_luong;
	private String hinh_anh;
	private int gia_ban;
	private String loai_mat_hang;
	private String ma_cua_hang;
	
	public String getMamh() {
		return mamh;
	}
	
	public void setMamh(String mamh) {
		this.mamh = mamh;
	}
	
	public String getTen() {
		return ten_mat_hang;
	}
	
	public void setTen(String ten) {
		this.ten_mat_hang = ten;
	}
	
	public String getXuatxu() {
		return xuat_xu;
	}
	
	public void setXuatxu(String xuatxu) {
		this.xuat_xu = xuatxu;
	}
	
	public int getSoluongton() {
		return so_luong_ton;
	}
	
	public void setSoluongton(int soluongton) {
		this.so_luong_ton = soluongton;
	}
	
	public float getKhoiluong() {
		return khoi_luong;
	}
	
	public void setKhoiluong(float khoiluong) {
		this.khoi_luong = khoiluong;
	}
	
	public String getHinhanh() {
		return hinh_anh;
	}
	
	public void setHinhanh(String hinhanh) {
		this.hinh_anh = hinhanh;
	}
	
	public int getGia() {
		return gia_ban;
	}
	
	public void setGia(int gia) {
		this.gia_ban = gia;
	}
	
	public String getLoaimathang() {
		return loai_mat_hang;
	}
	
	public void setLoaimathang(String loai) {
		this.loai_mat_hang = loai;
	}
	
	public String getMach() {
		return ma_cua_hang;
	}
	
	public void setMach(String ma_cua_hang) {
		this.ma_cua_hang = ma_cua_hang;
	}
	
	public MatHang(String mamh, String ten, String xuatxu, int soluongton, float khoiluong, String hinh_anh, int gia, String maloai, String mach) {
		super();
		this.mamh = mamh;
		this.ten_mat_hang = ten;
		this.xuat_xu = xuatxu;
		this.so_luong_ton = soluongton;
		this.khoi_luong = khoiluong;
		this.hinh_anh = hinh_anh;
		this.gia_ban = gia;
		this.loai_mat_hang = maloai;
		this.ma_cua_hang = mach;
	}
	
	public MatHang() {
		super();
	}
}
