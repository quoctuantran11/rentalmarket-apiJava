package WebAPI.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import WebAPI.model.KhachHang;
import WebAPI.repository.KhachHangRepository;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/api")
public class KhachHangController {
	
	@Autowired
	KhachHangRepository repo;
	
	//Create
	@PostMapping("/registeraccount")
	public ResponseEntity<KhachHang> RegisterAccount(@RequestBody KhachHang input) {
		try {
			Optional<KhachHang> khachhangData = repo.TimUsername(input.getUsername());
			if (khachhangData.isPresent()) {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			else {
				KhachHang kh = repo.save(new KhachHang(input.getId(), input.getSdt(), input.getCccd(),
						input.getDiachi(), input.getNgaysinh(), input.getGioitinh(),
						input.getUsername(), input.getPassword(), input.getMakhuvuc(), input.getTen()));
				return new ResponseEntity<>(kh, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Read
	@GetMapping("/accountlist")
	public ResponseEntity<List<KhachHang>> AccountList() {
		try {
			List<KhachHang> accountlst = new ArrayList<KhachHang>();
			repo.TimTatCaTaiKhoan().forEach(accountlst::add);
		if (accountlst.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(accountlst, HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/khachhanglist")
	public ResponseEntity<List<KhachHang>> KhachHangList() {
		try {
			List<KhachHang> khachhanglst = new ArrayList<KhachHang>();
			repo.findAll().forEach(khachhanglst::add);
		if (khachhanglst.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(khachhanglst, HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*@GetMapping("/accounttypelist/{type}")
	public ResponseEntity<List<TaiKhoan>> AccountTypeList(@PathVariable("type") String type){
		try {
			List<TaiKhoan> lst = new ArrayList<TaiKhoan>();
			repo.findAll(type).forEach(lst::add);
			
			if (lst.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(lst, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
	
	//Delete
	@DeleteMapping("/deleteallaccounts")
	public ResponseEntity<HttpStatus> DeleteAllAccounts() {
		try {
			repo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*@PutMapping("/editaccount/{id}")
	public ResponseEntity<KhachHang> CapNhatThongTin(@PathVariable("id") String id, @RequestBody KhachHang
	khachhang) {
		Optional<TaiKhoan> taikhoanData = repo.findById(id);
		if (taikhoanData.isPresent()) {
			TaiKhoan _taikhoan = taikhoanData.get();
			_taikhoan.setUsername(taikhoan.getUsername());
			_taikhoan.setPassword(taikhoan.getPassword());
			_taikhoan.setLoaiTaiKhoan(taikhoan.getLoaiTaiKhoan());
			return new ResponseEntity<>(repo.save(_taikhoan), HttpStatus.OK);
		} 
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}*/
	
	@GetMapping("/login/{username}&{password}")
	public ResponseEntity<Optional<KhachHang>> AccountLogin(@PathVariable("username") String username, 
			@PathVariable("password") String password){
		try {
			Optional<KhachHang> kh = repo.TimUsername(username);
			if (kh.isPresent()) {
				kh = repo.TimTaiKhoan(password);
				
				if(kh.isPresent()) {
					return new ResponseEntity<>(kh, HttpStatus.OK);
				}
				else {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
			}
			else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
