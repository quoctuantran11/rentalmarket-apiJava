package WebAPI.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DoiTac")
public class DoiTac {
	@Id
	private String id;
	private String sdt;
	private String cccd;
	private String dia_chi;
	private String loai_doi_tac;
	private String ten_doi_tac;
	private Date ngay_tham_gia;
	private int so_luong_cua_hang;
	private String trang_thai;
	
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
	
	public String getLoaidoitac() {
		return loai_doi_tac;
	}
	
	public void setLoaidoitac(String loaidoitac) {
		this.loai_doi_tac = loaidoitac;
	}
	
	public String getTendoitac() {
		return ten_doi_tac;
	}
	
	public void setTendoitac(String tendoitac) {
		this.ten_doi_tac = tendoitac;
	}
	
	public Date getNgaythamgia() {
		return ngay_tham_gia;
	}
	
	public void setNgaythamgia(Date ngaythamgia) {
		this.ngay_tham_gia = ngaythamgia;
	}
	
	public int getSoluongcuahang() {
		return so_luong_cua_hang;
	}
	
	public void setSoluongcuahang(int soluong) {
		this.so_luong_cua_hang = soluong;
	}
	
	public String getTrangthai() {
		return trang_thai;
	}
	
	public void setTrangthai(String trangthai) {
		this.trang_thai = trangthai;
	}
	
	public DoiTac(String id, String sdt, String cccd, String dia_chi, String loaidoitac, String tendoitac,
	Date ngaythamgia, int soluong, String trangthai) {
		super();
		this.id = id;
		this.sdt = sdt;
		this.cccd = cccd;
		this.dia_chi = dia_chi;
		this.loai_doi_tac = loaidoitac;
		this.ten_doi_tac = tendoitac;
		this.ngay_tham_gia = ngaythamgia;
		this.so_luong_cua_hang = soluong;
		this.trang_thai = trangthai;
	}
	
	public DoiTac() {
		super();
	}
}
