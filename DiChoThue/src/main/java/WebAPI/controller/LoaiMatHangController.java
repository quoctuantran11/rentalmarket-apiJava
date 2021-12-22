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

import WebAPI.model.LoaiMatHang;
import WebAPI.repository.LoaiMatHangRepository;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/api/loaihang")
public class LoaiMatHangController {
	
	@Autowired
	LoaiMatHangRepository repo;
	
	@PostMapping("/them")
	public ResponseEntity<LoaiMatHang>ThemLoaiMatHang(@RequestBody LoaiMatHang loaihang) {
		try {
			LoaiMatHang _loaihang = repo.save(new LoaiMatHang(loaihang.getMaloai(), loaihang.getTenloai()));

			return new ResponseEntity<>(_loaihang, HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*@PutMapping("/sua/{id}")
	public ResponseEntity<MatHang> CapNhatCuaHang(@PathVariable("id") String id, @RequestBody CuaHang
	cuahang) {
		Optional<CuaHang> cuahangData = repo.findById(id);
		if (cuahangData.isPresent()) {
			CuaHang _cuahang = cuahangData.get();
			_cuahang.setTench(cuahang.getTench());
			_cuahang.setSdt(cuahang.getSdt());
			_cuahang.setDiachi(cuahang.getDiachi());
			_cuahang.setMakv(cuahang.getMakv());
			_cuahang.setMadt(cuahang.getMadt());
			return new ResponseEntity<>(repo.save(_cuahang), HttpStatus.OK);
		} 
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}*/
	
	@DeleteMapping("/xoa/{id}")
	public ResponseEntity<HttpStatus> XoaMotLoaiMatHang(@PathVariable("id") String id) {
		try {
			repo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/xoatatca")
	public ResponseEntity<HttpStatus> XoaTatCaLoaiMatHang() {
		try {
			repo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping()
	public ResponseEntity<List<LoaiMatHang>> XemTatCaLoaiMatHang() {
		try {
			List<LoaiMatHang> loaihanglst = new ArrayList<LoaiMatHang>();
			repo.findAll().forEach(loaihanglst::add);
			if (loaihanglst.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(loaihanglst, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
