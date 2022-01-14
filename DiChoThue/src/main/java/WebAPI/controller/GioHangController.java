package WebAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import WebAPI.model.GioHang;
import WebAPI.repository.GioHangRepository;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/api/giohang")
public class GioHangController {
	
	@Autowired
	GioHangRepository repo;
	
	@PostMapping("/tao")
	public ResponseEntity<GioHang> TaoGioHang(@RequestBody GioHang giohang) {
		try {
				GioHang _giohang = repo.save(new GioHang(giohang.getId(), giohang.getMa_khach_hang()));
				return new ResponseEntity<>(_giohang, HttpStatus.CREATED);
			}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
