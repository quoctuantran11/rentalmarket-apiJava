package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ComboMatHang")
public class ComboMatHang {
	@Id
	private String macombo;
	private String tencombo;
	private int soluongton;
	private int khoiluong;
	private int gia;
	private String mach;
	
	public String getMacombo() {
		return macombo;
	}
	
	public void setMacombo(String macombo) {
		this.macombo = macombo;
	}
	
	public String getTencombo() {
		return tencombo;
	}
	
	public void setTen(String tencombo) {
		this.tencombo = tencombo;
	}
	
	public int getSoluongton() {
		return soluongton;
	}
	
	public void setSoluongton(int soluongton) {
		this.soluongton = soluongton;
	}
	
	public int getKhoiluong() {
		return khoiluong;
	}
	
	public void setKhoiluong(int khoiluong) {
		this.khoiluong = khoiluong;
	}
	
	public int getGia() {
		return gia;
	}
	
	public void setGia(int gia) {
		this.gia = gia;
	}
	
	public String getMach() {
		return mach;
	}
	
	public void setMach(String mach) {
		this.mach = mach;
	}
	
	public ComboMatHang(String macombo, String tencombo, int soluongton, int khoiluong, int gia, String mach) {
		super();
		this.macombo = macombo;
		this.tencombo = tencombo;
		this.soluongton = soluongton;
		this.khoiluong = khoiluong;
		this.gia = gia;
		this.mach = mach;
	}
	
	public ComboMatHang() {
		super();
	}
}
