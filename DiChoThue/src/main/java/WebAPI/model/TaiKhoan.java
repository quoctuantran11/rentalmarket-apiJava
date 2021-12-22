package WebAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "TaiKhoan")
public class TaiKhoan {
	@Id
	private String taikhoanid;
	private String Username;
	private String Password;
	private String LoaiTaiKhoan;
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getLoaiTaiKhoan() {
		return LoaiTaiKhoan;
	}
	public void setLoaiTaiKhoan(String loaiTaiKhoan) {
		LoaiTaiKhoan = loaiTaiKhoan;
	}
	
	public String gettaikhoanid() {
		return taikhoanid;
	}
	
	public void settaikhoanid(String id) {
		taikhoanid = id;
	}
	
	/*boolean TonTaiTaiKhoan(String name) {
		if(this.Username == name) {
			return true;
		}
		else {
			return false;
		}
	}
	
	boolean XacThucTaiKhoan(String name, String pass) {
		if(this.Username == name) {
			if(this.Password == pass) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}*/
	
	public TaiKhoan(String id, String name, String pass, String type) {
		super();
		this.taikhoanid = id;
		this.Username = name;
		this.Password = pass;
		this.LoaiTaiKhoan = type;
	}
	
	public TaiKhoan() {
		super();
	}
}
