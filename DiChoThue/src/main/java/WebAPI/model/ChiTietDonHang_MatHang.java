package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ChiTietDonHangMatHang")
public class ChiTietDonHang_MatHang {
	@Id
	private String id;
	private String madh;
	private String mamh;
	private int soluong;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getMadh() {
		return madh;
	}
	
	public void setMacombo(String madh) {
		this.madh = madh;
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
	
	public ChiTietDonHang_MatHang(String madh, String mamh, int soluong) {
		super();
		this.madh = madh;
		this.mamh = mamh;
		this.soluong = soluong;
	}
	
	public ChiTietDonHang_MatHang() {
		super();
	}
}
