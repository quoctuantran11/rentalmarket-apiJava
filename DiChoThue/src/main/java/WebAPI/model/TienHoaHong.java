package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "TienHoaHong")
public class TienHoaHong {
	@Id
	private String id;
	private String ma_cua_hang;
	private String thang_nam;
	private int tien_hoa_hong;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMa_cua_hang() {
		return ma_cua_hang;
	}

	public void setMa_cua_hang(String ma_cua_hang) {
		this.ma_cua_hang = ma_cua_hang;
	}

	public String getThang_nam() {
		return thang_nam;
	}

	public void setThang_nam(String thang_nam) {
		this.thang_nam = thang_nam;
	}


	public int getTien_hoa_hong() {
		return tien_hoa_hong;
	}

	public void setTien_hoa_hong(int tien_hoa_hong) {
		this.tien_hoa_hong = tien_hoa_hong;
	}

	public TienHoaHong(String id, String ma_cua_hang, String thang_nam, int ten_hoa_hong) {
		super();
		this.id = id;
		this.ma_cua_hang = ma_cua_hang;
		this.thang_nam = thang_nam;

		this.tien_hoa_hong = ten_hoa_hong;
	}

	public TienHoaHong() {
		super();
	}
}
