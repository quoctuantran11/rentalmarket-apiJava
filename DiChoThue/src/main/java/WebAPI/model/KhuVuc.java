package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "KhuVuc")
public class KhuVuc {
	@Id
	private String id;
	private String phan_vung;
	private String ten_khu_vuc;
	
	
	public String getID() {
		return id;
	}
	
	public void setID(String ID) {
		this.id = ID;
	}
	
	public String getPhan_vung() {
		return phan_vung;
	}
	
	public void setPhan_vung(String phan_vung) {
		this.phan_vung = phan_vung;
	}
	
	public String getTen_khu_vuc() {
		return ten_khu_vuc;
	}
	
	public void setTen_khu_vuc(String ten_khu_vuc) {
		this.ten_khu_vuc = ten_khu_vuc;
	}
	
	
	public KhuVuc(String id, String phan_vung, String ten_khu_vuc) {
		super();
		this.id = id;
		this.phan_vung = phan_vung;
		this.ten_khu_vuc = ten_khu_vuc;
	}
	
	public KhuVuc() {
		super();
	}
}
