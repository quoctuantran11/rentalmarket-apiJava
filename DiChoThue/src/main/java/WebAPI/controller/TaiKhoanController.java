package WebAPI.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import WebAPI.model.TaiKhoan;
import WebAPI.repository.TaiKhoanRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")

public class TaiKhoanController {
	
	@Autowired
	TaiKhoanRepository repo;
	
	//Create
	@PostMapping("/registeraccount")
	public ResponseEntity<TaiKhoan> RegisterAccount(@RequestBody TaiKhoan input) {
		try {
			TaiKhoan tk = repo.save(new TaiKhoan(input.gettaikhoanid(), input.getUsername(), input.getPassword(), input.getLoaiTaiKhoan()));
			return new ResponseEntity<>(tk, HttpStatus.CREATED);
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
}
