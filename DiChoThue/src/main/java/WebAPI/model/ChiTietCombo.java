package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ChiTietCombo")
public class ChiTietCombo {
	@Id
	private String macombo;
	private String mamh;
	private int soluong;
	
	public String getMacombo() {
		return macombo;
	}
	
	public void setMacombo(String macombo) {
		this.macombo = macombo;
	}
	
	public String getMamh() {
		return mamh;
	}
	
	public void setMamh(String mamh) {
		this.mamh = mamh;
	}
	
	public int getSoluong() {
		return soluong;
	}
	
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
	public ChiTietCombo(String macombo, String mamh, int soluong) {
		super();
		this.macombo = macombo;
		this.mamh = mamh;
		this.soluong = soluong;
	}
	
	public ChiTietCombo() {
		super();
	}
}
