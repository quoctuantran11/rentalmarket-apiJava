package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "KhachHang")
public class KhachHang {
	@Id
	private String id;
	private String sdt;
	private String cccd;
	private String dia_chi;
	private String ngay_sinh;
	private String gioi_tinh;
	private String password;
	private String username;
	private String ma_khu_vuc;
	private String ten_khach_hang;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getSdt() {
		return sdt;
	}
	
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	public String getCccd() {
		return cccd;
	}
	
	public void setCccd(String cccd) {
		this.cccd = cccd;
	}
	
	public String getDiachi() {
		return dia_chi;
	}
	
	public void setDiachi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	
	public String getNgaysinh() {
		return ngay_sinh;
	}
	
	public void setNgaysinh(String ngay_sinh) {
		this.ngay_sinh = ngay_sinh;
	}
	
	public String getGioitinh() {
		return gioi_tinh;
	}
	
	public void setGioitinh(String gioi_tinh) {
		this.gioi_tinh = gioi_tinh;
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
	
	public String getMakhuvuc() {
		return ma_khu_vuc;
	}
	
	public void setMakhuvuc(String ma_khu_vuc) {
		this.ma_khu_vuc = ma_khu_vuc;
	}
	
	public String getTen() {
		return ten_khach_hang;
	}
	
	public void setTen(String ten_khach_hang) {
		this.ten_khach_hang = ten_khach_hang;
	}
	
	public KhachHang(String id, String sdt, String cccd, String dia_chi, String ngay_sinh, String gioi_tinh,
	String password, String username, String ma_khu_vuc, String ten_khach_hang) {
		super();
		this.id = id;
		this.sdt = sdt;
		this.cccd = cccd;
		this.dia_chi = dia_chi;
		this.ngay_sinh = ngay_sinh;
		this.gioi_tinh = gioi_tinh;
		this.username = username;
		this.password = password;
		this.ma_khu_vuc = ma_khu_vuc;
		this.ten_khach_hang = ten_khach_hang;
	}
	
	public KhachHang() {
		super();
	}
}
