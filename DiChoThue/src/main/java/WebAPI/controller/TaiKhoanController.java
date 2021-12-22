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

import WebAPI.model.TaiKhoan;
import WebAPI.repository.TaiKhoanRepository;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/api")
public class TaiKhoanController {
	
	@Autowired
	TaiKhoanRepository repo;
	
	//Create
	@PostMapping("/registeraccount")
	public ResponseEntity<TaiKhoan> RegisterAccount(@RequestBody TaiKhoan input) {
		try {
			Optional<TaiKhoan> taikhoanData = repo.TimUsername(input.getUsername());
			if (taikhoanData.isPresent()) {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			else {
				TaiKhoan tk = repo.save(new TaiKhoan(input.gettaikhoanid(), input.getUsername(), input.getPassword(), input.getLoaiTaiKhoan()));
				return new ResponseEntity<>(tk, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Read
	@GetMapping("/accountlist")
	public ResponseEntity<List<TaiKhoan>> AccountList() {
		try {
			List<TaiKhoan> lst = new ArrayList<TaiKhoan>();
			repo.findAll().forEach(lst::add);
		if (lst.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lst, HttpStatus.OK);
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
	
	@PutMapping("/editaccount/{id}")
	public ResponseEntity<TaiKhoan> CapNhatTaiKhoan(@PathVariable("id") String id, @RequestBody TaiKhoan
	taikhoan) {
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
	}
	
	@GetMapping("/login/{username}&{password}")
	public ResponseEntity<Optional<TaiKhoan>> AccountLogin(@PathVariable("username") String username, 
			@PathVariable("password") String password){
		try {
			Optional<TaiKhoan> tk = repo.TimUsername(username);
			if (tk.isPresent()) {
				tk = repo.TimTaiKhoan(password);
				
				if(tk.isPresent()) {
					return new ResponseEntity<>(tk, HttpStatus.OK);
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
