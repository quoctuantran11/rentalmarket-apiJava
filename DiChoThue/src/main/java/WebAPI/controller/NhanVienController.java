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

import WebAPI.model.NhanVien;
import WebAPI.repository.NhanVienRepository;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/api/shipper")
public class NhanVienController {

	@Autowired
	NhanVienRepository repo;
	
	//Create
		@PostMapping("/registeraccount")
		public ResponseEntity<NhanVien> RegisterAccount(@RequestBody NhanVien input) {
			try {
				Optional<NhanVien> shipperData = repo.TimUsername(input.getUsername());
				if (shipperData.isPresent()) {
					return new ResponseEntity<>(HttpStatus.CONFLICT);
				}
				else {
					NhanVien nv = repo.save(new NhanVien(input.getId(), input.getSdt(), input.getCccd(),
							input.getDiachi(), input.getNgaysinh(), input.getGioitinh(), input.getNhiemvu(),
							input.getTrangthaitiemchung(), input.getPassword(), input.getUsername(),
							input.getKhuvucgiaohang(), input.getTen()));
					return new ResponseEntity<>(nv, HttpStatus.CREATED);
				}
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		//Read
		@GetMapping("/accountlist")
		public ResponseEntity<List<NhanVien>> AccountList() {
			try {
				List<NhanVien> accountlst = new ArrayList<NhanVien>();
				repo.TatCaTaiKhoan().forEach(accountlst::add);
				if (accountlst.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
			
				return new ResponseEntity<>(accountlst, HttpStatus.OK);
			} 
			catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@GetMapping("/list")
		public ResponseEntity<List<NhanVien>> ShipperList() {
			try {
				List<NhanVien> shipperlst = new ArrayList<NhanVien>();
				repo.findAll().forEach(shipperlst::add);
			if (shipperlst.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(shipperlst, HttpStatus.OK);
			} 
			catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
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
		
		@DeleteMapping("/xoa/{id}")
		public ResponseEntity<HttpStatus> XoaMotKhachHang(@PathVariable("id") String id) {
			try {
				repo.deleteById(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@PutMapping("/edit/{id}")
		public ResponseEntity<NhanVien> CapNhatThongTin(@PathVariable("id") String id, @RequestBody NhanVien
		nhanvien) {
			Optional<NhanVien> nhanvienData = repo.findById(id);
			if (nhanvienData.isPresent()) {
				NhanVien _nhanvien = nhanvienData.get();
				_nhanvien.setSdt(nhanvien.getSdt());
				_nhanvien.setCccd(nhanvien.getCccd());
				_nhanvien.setDiachi(nhanvien.getDiachi());
				_nhanvien.setNgaysinh(nhanvien.getNgaysinh());
				_nhanvien.setGioitinh(nhanvien.getGioitinh());
				_nhanvien.setNhiemvu(nhanvien.getNhiemvu());
				_nhanvien.setTrangthaitiemchung(nhanvien.getTrangthaitiemchung());
				_nhanvien.setPassword(nhanvien.getPassword());
				_nhanvien.setUsername(nhanvien.getUsername());
				_nhanvien.setKhuvucgiaohang(nhanvien.getKhuvucgiaohang());
				_nhanvien.setTen(nhanvien.getTen());
				return new ResponseEntity<>(repo.save(_nhanvien), HttpStatus.OK);
			} 
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		@GetMapping("/login/{username}&{password}")
		public ResponseEntity<Optional<NhanVien>> AccountLogin(@PathVariable("username") String username, 
				@PathVariable("password") String password){
			try {
				Optional<NhanVien> nv = repo.TimUsername(username);
				if (nv.isPresent()) {
					nv = repo.TimTaiKhoan(password);
					
					if(nv.isPresent()) {
						return new ResponseEntity<>(nv, HttpStatus.OK);
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
