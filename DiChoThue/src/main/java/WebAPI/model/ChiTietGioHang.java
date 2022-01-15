package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ChiTietGioHang")
public class ChiTietGioHang {
	@Id
	private String id;
	private int so_luong;
	private String ma_mat_hang;
	private String ma_combo;
	private String ma_gio_hang;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getSo_luong() {
		return so_luong;
	}
	
	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}
	
	public String getMa_mat_hang() {
		return ma_mat_hang;
	}
	
	public void setMa_mat_hang(String ma_mat_hang) {
		this.ma_mat_hang = ma_mat_hang;
	}
	
	public String getMa_combo() {
		return ma_combo;
	}
	
	public void setMa_combo(String ma_combo) {
		this.ma_combo = ma_combo;
	}
	
	public String getMa_gio_hang() {
		return ma_gio_hang;
	}
	
	public void setMa_gio_hang(String ma_gio_hang) {
		this.ma_gio_hang = ma_gio_hang;
	}
	
	
	public ChiTietGioHang(String id, int so_luong, String ma_mat_hang, String ma_combo, String ma_gio_hang) {
		super();
		this.id = id;
		this.so_luong = so_luong;
		this.ma_mat_hang = ma_mat_hang;
		this.ma_combo = ma_combo;
		this.ma_gio_hang = ma_gio_hang;
	}
	
	public ChiTietGioHang() {
		super();
	}
}
