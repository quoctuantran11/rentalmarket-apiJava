package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CuaHang")
public class CuaHang {
	@Id
	private String mach;
	private String ten_cua_hang;
	private String sdt;
	private String dia_chi;
	private String hinh_anh;
	private String username;
	private String password;
	private String ma_khu_vuc;
	private String ma_doi_tac;
	
	public String getMach() {
		return mach;
	}
	
	public void setMach(String mach) {
		this.mach = mach;
	}
	
	public String getTench() {
		return ten_cua_hang;
	}
	
	public void setTench(String tench) {
		this.ten_cua_hang = tench;
	}
	
	public String getSdt() {
		return sdt;
	}
	
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	public String getDiachi() {
		return dia_chi;
	}
	
	public void setDiachi(String diachi) {
		this.dia_chi = diachi;
	}
	
	public String getHinhanh() {
		return hinh_anh;
	}
	
	public void setHinhanh(String hinhanh) {
		this.hinh_anh = hinhanh;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMakv() {
		return ma_khu_vuc;
	}
	
	public void setMakv(String makv) {
		this.ma_khu_vuc = makv;
	}
	
	public String getMadt() {
		return ma_doi_tac;
	}
	
	public void setMadt(String madt) {
		this.ma_doi_tac = madt;
	}
	
	public CuaHang(String mach, String tench, String sdt, String diachi,
			String hinhanh, String username, String password, String makv, String madt) {
		super();
		this.mach = mach;
		this.ten_cua_hang = tench;
		this.sdt = sdt;
		this.dia_chi = diachi;
		this.hinh_anh = hinhanh;
		this.username = username;
		this.password = password;
		this.ma_khu_vuc = makv;
		this.ma_doi_tac = madt;
	}
	
	public CuaHang() {
		super();
	}
}
