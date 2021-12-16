package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CuaHang")
public class CuaHang {
	@Id
	private String mach;
	private String tench;
	private String sdt;
	private String diachi;
	private String makv;
	private String madt;
	
	public String getMach() {
		return mach;
	}
	
	public void setMach(String mach) {
		this.mach = mach;
	}
	
	public String getTench() {
		return tench;
	}
	
	public void setTench(String tench) {
		this.tench = tench;
	}
	
	public String getSdt() {
		return sdt;
	}
	
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	public String getDiachi() {
		return diachi;
	}
	
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
	public String getMakv() {
		return makv;
	}
	
	public void setMakv(String makv) {
		this.makv = makv;
	}
	
	public String getMadt() {
		return madt;
	}
	
	public void setMadt(String madt) {
		this.madt = madt;
	}
	
	public CuaHang(String mach, String tench, String sdt, String diachi, String makv, String madt) {
		super();
		this.mach = mach;
		this.tench = tench;
		this.sdt = sdt;
		this.diachi = diachi;
		this.makv = makv;
		this.madt = madt;
	}
	
	public CuaHang() {
		super();
	}
}
