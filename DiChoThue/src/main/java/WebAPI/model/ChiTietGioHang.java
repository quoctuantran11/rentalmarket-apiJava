package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ChiTietGioHang")
public class ChiTietGioHang {
	@Id
	private String ma_chi_tiet_gio_hang;
	private String ma_gio_hang;
	private String ma_mat_hang;
	private int so_luong;
	
	public void setMa_chi_tiet_gio_hang(String ma_chi_tiet_gio_hang) {
		this.ma_chi_tiet_gio_hang = ma_chi_tiet_gio_hang;
	}
	
	public String getMa_chi_tiet_gio_hang() {
		return ma_chi_tiet_gio_hang;
	}
	
	public void setMa_gio_hang(String ma_gio_hang) {
		this.ma_gio_hang = ma_gio_hang;
	}
	
	public String getMa_gio_hang() {
		return ma_gio_hang;
	}
	
	
	public String getMa_mat_hang() {
		return ma_mat_hang;
	}
	
	public void setMa_mat_hang(String ma_mat_hang) {
		this.ma_mat_hang = ma_mat_hang;
	}
	
	public int getSo_luong() {
		return so_luong;
	}
	
	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}
	
	public ChiTietGioHang(String ma_chi_tiet_gio_hang, String ma_gio_hang, String ma_mat_hang, int so_luong) {
		super();
		this.ma_chi_tiet_gio_hang = ma_chi_tiet_gio_hang;
		this.ma_gio_hang = ma_gio_hang;
		this.ma_mat_hang = ma_mat_hang;
		this.so_luong = so_luong;
	}
	
	public ChiTietGioHang() {
		super();
	}
}
