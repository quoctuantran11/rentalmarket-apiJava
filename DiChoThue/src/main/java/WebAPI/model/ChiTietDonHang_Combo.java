package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ChiTietDonHangCombo")
public class ChiTietDonHang_Combo {
	@Id
	private String id;
	private String ma_don_hang;
	private String ma_combo;
	private int so_luong;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getMacombo() {
		return ma_combo;
	}
	
	public void setMacombo(String macombo) {
		this.ma_combo = macombo;
	}
	
	public String getMadh() {
		return ma_don_hang;
	}
	
	public void setMadh(String madh) {
		this.ma_don_hang = madh;
	}
	
	public int getSoluong() {
		return so_luong;
	}
	
	public void setSoluong(int soluong) {
		this.so_luong = soluong;
	}
	
	public ChiTietDonHang_Combo(String id, String macombo, String madh, int soluong) {
		super();
		this.id = id;
		this.ma_combo = macombo;
		this.ma_don_hang = madh;
		this.so_luong = soluong;
	}
	
	public ChiTietDonHang_Combo() {
		super();
	}
}
