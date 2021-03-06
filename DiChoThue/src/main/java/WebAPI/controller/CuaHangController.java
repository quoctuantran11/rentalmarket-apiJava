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

import WebAPI.model.CuaHang;
import WebAPI.repository.CuaHangRepository;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/api/cuahang")
public class CuaHangController {
	
	@Autowired
	CuaHangRepository repo;
	
	@PostMapping("/them")
	public ResponseEntity<CuaHang>ThemCuaHang(@RequestBody CuaHang cuahang) {
		try {
			Optional<CuaHang> cuahangData = repo.TimUsername(cuahang.getUsername());
			if(cuahangData.isPresent())
			{
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			else
			{
				CuaHang _cuahang = repo.save(new CuaHang(cuahang.getMach(), cuahang.getTench(),
					cuahang.getSdt(), cuahang.getDiachi(), cuahang.getHinhanh(),
					cuahang.getUsername(), cuahang.getPassword(), cuahang.getMakv(), cuahang.getMadt()));

				return new ResponseEntity<>(_cuahang, HttpStatus.CREATED);
			}
		}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/sua/{id}")
	public ResponseEntity<CuaHang> CapNhatCuaHang(@PathVariable("id") String id, @RequestBody CuaHang
	cuahang) {
		Optional<CuaHang> cuahangData = repo.findById(id);
		if (cuahangData.isPresent()) {
			CuaHang _cuahang = cuahangData.get();
			_cuahang.setTench(cuahang.getTench());
			_cuahang.setSdt(cuahang.getSdt());
			_cuahang.setDiachi(cuahang.getDiachi());
			_cuahang.setHinhanh(cuahang.getHinhanh());
			_cuahang.setUsername(cuahang.getUsername());
			_cuahang.setPassword(cuahang.getPassword());
			_cuahang.setMakv(cuahang.getMakv());
			_cuahang.setMadt(cuahang.getMadt());
			return new ResponseEntity<>(repo.save(_cuahang), HttpStatus.OK);
		} 
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/xoa/{id}")
	public ResponseEntity<HttpStatus> XoaMotCuaHang(@PathVariable("id") String id) {
		try {
			repo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/xoatatca")
	public ResponseEntity<HttpStatus> XoaTatCaCuaHang() {
		try {
			repo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping()
	public ResponseEntity<List<CuaHang>> XemTatCaCuaHang() {
		try {
			List<CuaHang> cuahanglst = new ArrayList<CuaHang>();
			repo.findAll().forEach(cuahanglst::add);
			if (cuahanglst.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(cuahanglst, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<CuaHang>> TimCuaHang(@PathVariable("id") String id) {
		try {
			Optional<CuaHang> cuahangData = repo.findById(id);
			if (cuahangData.isPresent()) {
				return new ResponseEntity<>(cuahangData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/danhsachtaikhoan")
	public ResponseEntity<List<CuaHang>> AccountList() {
		try {
			List<CuaHang> accountlst = new ArrayList<CuaHang>();
			repo.DanhSachTaiKhoan().forEach(accountlst::add);
			if (accountlst.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		
			return new ResponseEntity<>(accountlst, HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/login/{username}&{password}")
	public ResponseEntity<Optional<CuaHang>> AccountLogin(@PathVariable("username") String username, 
			@PathVariable("password") String password){
		try {
			Optional<CuaHang> ch = repo.TimUsername(username);
			if (ch.isPresent()) {
				ch = repo.TimTaiKhoan(password);
				
				if(ch.isPresent()) {
					return new ResponseEntity<>(ch, HttpStatus.OK);
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
