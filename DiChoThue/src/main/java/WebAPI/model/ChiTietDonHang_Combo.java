package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ChiTietDonHang_Combo")
public class ChiTietDonHang_Combo {
	@Id
	private String madh;
	@Id
	private String macombo;
	private int soluong;
	
	public String getMacombo() {
		return macombo;
	}
	
	public void setMacombo(String macombo) {
		this.macombo = macombo;
	}
	
	public String getMadh() {
		return madh;
	}
	
	public void setMadh(String madh) {
		this.madh = madh;
	}
	
	public int getSoluong() {
		return soluong;
	}
	
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
	public ChiTietDonHang_Combo(String macombo, String madh, int soluong) {
		super();
		this.macombo = macombo;
		this.madh = madh;
		this.soluong = soluong;
	}
	
	public ChiTietDonHang_Combo() {
		super();
	}
}
