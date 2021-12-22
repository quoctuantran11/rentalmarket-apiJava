package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MatHang")
public class MatHang {
	@Id
	private String mamh;
	private String ten;
	private String xuatxu;
	private int soluongton;
	private float khoiluong;
	private int gia;
	private String maloai;
	private String mach;
	
	public String getMamh() {
		return mamh;
	}
	
	public void setMamh(String mamh) {
		this.mamh = mamh;
	}
	
	public String getTen() {
		return ten;
	}
	
	public void setTen(String ten) {
		this.ten = ten;
	}
	
	public String getXuatxu() {
		return xuatxu;
	}
	
	public void setXuatxu(String xuatxu) {
		this.xuatxu = xuatxu;
	}
	
	public int getSoluongton() {
		return soluongton;
	}
	
	public void setSoluongton(int soluongton) {
		this.soluongton = soluongton;
	}
	
	public float getKhoiluong() {
		return khoiluong;
	}
	
	public void setKhoiluong(float khoiluong) {
		this.khoiluong = khoiluong;
	}
	
	public int getGia() {
		return gia;
	}
	
	public void setGia(int gia) {
		this.gia = gia;
	}
	
	public String getMaloai() {
		return maloai;
	}
	
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	
	public String getMach() {
		return mach;
	}
	
	public void setMach(String mach) {
		this.mach = mach;
	}
	
	public MatHang(String mamh, String ten, String xuatxu, int soluongton, float khoiluong, int gia, String maloai, String mach) {
		super();
		this.mamh = mamh;
		this.ten = ten;
		this.xuatxu = xuatxu;
		this.soluongton = soluongton;
		this.khoiluong = khoiluong;
		this.gia = gia;
		this.maloai = maloai;
		this.mach = mach;
	}
	
	public MatHang() {
		super();
	}
}
