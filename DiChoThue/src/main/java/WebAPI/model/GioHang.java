package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "GioHang")
public class GioHang {
	@Id
	private String id;
	private String ma_khach_hang;

	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getMa_khach_hang() {
		return ma_khach_hang;
	}
	
	public void setMa_khach_hang(String ma_khach_hang) {
		this.ma_khach_hang = ma_khach_hang;
	}
	
	
	public GioHang(String id, int so_luong, String ma_mat_hang, String ma_khach_hang) {
		super();
		this.id = id;
		this.ma_khach_hang = ma_khach_hang;
	}
	
	public GioHang() {
		super();
	}
}
