package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ChiTietCombo")
public class ChiTietCombo {
	@Id
	private String ma;
	private String ma_combo;
	private String ma_mat_hang;
	private int so_luong;
	
	public String getMa() {
		return ma;
	}
	
	public void setMa(String ma) {
		this.ma = ma;
	}
	
	public String getMacombo() {
		return ma_combo;
	}
	
	public void setMacombo(String macombo) {
		this.ma_combo = macombo;
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
	
	public ChiTietCombo(String ma, String macombo, String mamh, int soluong) {
		super();
		this.ma = ma;
		this.ma_combo = macombo;
		this.ma_mat_hang = mamh;
		this.so_luong = soluong;
	}
	
	public ChiTietCombo() {
		super();
	}
}
