package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "LoaiMatHang")
public class LoaiMatHang {
	@Id
	private String maloai;
	private String tenloai;
	
	public String getMaloai() {
		return maloai;
	}
	
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	
	public String getTenloai() {
		return tenloai;
	}
	
	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}
	
	public LoaiMatHang(String maloai, String tenloai) {
		super();
		this.maloai = maloai;
		this.tenloai = tenloai;
	}
	
	public LoaiMatHang() {
		super();
	}
}
