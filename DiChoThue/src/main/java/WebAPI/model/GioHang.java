package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "GioHang")
public class GioHang {
	@Id
	private String id;
	private int so_luong;
	private String ma_mat_hang;
	private String ma_khach_hang;
	
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
	
	public String getMa_khach_hang() {
		return ma_khach_hang;
	}
	
	public void setMa_khach_hang(String ma_khach_hang) {
		this.ma_khach_hang = ma_khach_hang;
	}
	
	
	public GioHang(String id, int so_luong, String ma_mat_hang, String ma_khach_hang) {
		super();
		this.id = id;
		this.so_luong = so_luong;
		this.ma_mat_hang = ma_mat_hang;
		this.ma_khach_hang = ma_khach_hang;
	}
	
	public GioHang() {
		super();
	}
}
