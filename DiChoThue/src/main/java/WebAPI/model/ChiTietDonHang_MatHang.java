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
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getMadh() {
		return ma_don_hang;
	}
	
	public void setMacombo(String madh) {
		this.ma_don_hang = madh;
	}
	
	public String getMamh() {
		return ma_mat_hang;
	}
	
	public void setMamh(String mamh) {
		this.ma_mat_hang = mamh;
	}
	
	public int getSoluong() {
		return so_luong;
	}
	
	public void setSoluong(int soluong) {
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
