package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ChiTietDonHangMatHang")
public class ChiTietDonHang_MatHang {
	@Id
	private String id;
	private String ma_don_hang;
	private int so_luong;
	private String ma_mat_hang;
	
	public String getID() {
		return id;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public String getMa_don_hang() {
		return ma_don_hang;
	}
	
	public void setMa_don_hang(String madh) {
		this.ma_don_hang = madh;
	}
	
	public String getMa_mat_hang() {
		return ma_mat_hang;
	}
	
	public void setMa_mat_hang(String mamh) {
		this.ma_mat_hang = mamh;
	}
	
	public int getSo_luong() {
		return so_luong;
	}
	
	public void setSo_luong(int soluong) {
		this.so_luong = soluong;
	}
	
	public ChiTietDonHang_MatHang(String id, String madh, String mamh, int soluong) {
		super();
		this.id = id;
		this.ma_don_hang = madh;
		this.ma_mat_hang = mamh;
		this.so_luong = soluong;
	}
	
	public ChiTietDonHang_MatHang() {
		super();
	}
}
