package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "NhanVien")
public class NhanVien {
	@Id
	private String id;
	private String sdt;
	private String cccd;
	private String dia_chi;
	private String ngay_sinh;
	private String gioi_tinh;
	private String nhiem_vu;
	private String trang_thai_tiem_chung;
	private String password;
	private String username;
	private String khu_vuc_giao_hang;
	private String ten_nhan_vien;
	
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
	
	public String getNhiemvu() {
		return nhiem_vu;
	}
	
	public void setNhiemvu(String nhiemvu) {
		this.nhiem_vu = nhiemvu;
	}
	
	public String getTrangthaitiemchung() {
		return trang_thai_tiem_chung;
	}
	
	public void setTrangthaitiemchung(String trangthaitiemchung) {
		this.trang_thai_tiem_chung = trangthaitiemchung;
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
	
	public String getKhuvucgiaohang() {
		return khu_vuc_giao_hang;
	}
	
	public void setKhuvucgiaohang(String khu_vuc) {
		this.khu_vuc_giao_hang = khu_vuc;
	}
	
	public String getTen() {
		return ten_nhan_vien;
	}
	
	public void setTen(String ten_nhan_vien) {
		this.ten_nhan_vien = ten_nhan_vien;
	}
	
	public NhanVien(String id, String sdt, String cccd, String dia_chi, String ngay_sinh, String gioi_tinh,
	String nhiemvu, String trangthaitiemchung, String password, String username, String khu_vuc,
	String ten_nhan_vien) {
		super();
		this.id = id;
		this.sdt = sdt;
		this.cccd = cccd;
		this.dia_chi = dia_chi;
		this.ngay_sinh = ngay_sinh;
		this.gioi_tinh = gioi_tinh;
		this.nhiem_vu = nhiemvu;
		this.trang_thai_tiem_chung = trangthaitiemchung;
		this.username = username;
		this.password = password;
		this.khu_vuc_giao_hang = khu_vuc;
		this.ten_nhan_vien = ten_nhan_vien;
	}
	
	public NhanVien() {
		super();
	}
}
