package WebAPI.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DonHang")
public class DonHang {
	@Id
	private String madh;
	private Date ngaytao;
	private String tinhtrangdon;
	private String hinhthucthanhtoan;
	private int tongtien;
	private String makh;
	private String mach;
	private String mashipper;
	private String manvxl;
	
	public String getMadh() {
		return madh;
	}
	
	public void setMadh(String madh) {
		this.madh = madh;
	}
	
	public Date getNgaytao() {
		return ngaytao;
	}
	
	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}
	
	public String getTinhtrangdon() {
		return tinhtrangdon;
	}
	
	public void setTinhtrangdon(String tinhtrangdon) {
		this.tinhtrangdon = tinhtrangdon;
	}
	
	public String getHinhthucthanhtoan() {
		return hinhthucthanhtoan;
	}
	
	public void setHinhthucthanhtoan(String hinhthucthanhtoan) {
		this.hinhthucthanhtoan = hinhthucthanhtoan;
	}
	
	public int getTongtien() {
		return tongtien;
	}
	
	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}
	
	public String getMakh() {
		return makh;
	}
	
	public void setMakh(String makh) {
		this.makh = makh;
	}
	
	public String getMach() {
		return mach;
	}
	
	public void setMach(String mach) {
		this.mach = mach;
	}
	
	public String getMashipper() {
		return mashipper;
	}
	
	public void setMashipper(String mashipper) {
		this.mashipper = mashipper;
	}
	
	public String getManvxl() {
		return manvxl;
	}
	
	public void setManvxl(String manvxl) {
		this.manvxl = manvxl;
	}
	
	public DonHang(String madh, Date ngaytao, String tinhtrangdon, String hinhthucthanhtoan, int tongtien, 
			String makh, String mach, String mashipper, String manvxl) {
		super();
		this.madh = madh;
		this.ngaytao = ngaytao;
		this.tinhtrangdon = tinhtrangdon;
		this.hinhthucthanhtoan = hinhthucthanhtoan;
		this.tongtien = tongtien;
		this.makh = makh;
		this.mach = mach;
		this.mashipper = mashipper;
		this.manvxl = manvxl;
	}
	
	public DonHang() {
		super();
	}
}
