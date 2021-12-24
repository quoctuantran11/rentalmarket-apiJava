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

import WebAPI.model.DonHang;
import WebAPI.repository.DonHangRepository;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/api/donhang")
public class DonHangController {
	
	@Autowired
	DonHangRepository repo;
	
	@PostMapping("/tao")
	public ResponseEntity<DonHang>TaoDonHang(@RequestBody DonHang donhang) {
		try {
			DonHang _donhang = repo.save(new DonHang(donhang.getMadh(), donhang.getTinhtrangdon(),
					donhang.getHinhthucthanhtoan(), donhang.getTongtien(),
					donhang.getDiachi(), donhang.getMakh(), donhang.getMach(), donhang.getMashipper()));

			return new ResponseEntity<>(_donhang, HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/sua/{id}")
	public ResponseEntity<DonHang> CapNhatDonHang(@PathVariable("id") String id, @RequestBody DonHang
	donhang) {
		Optional<DonHang> donhangData = repo.findById(id);
		if (donhangData.isPresent()) {
			DonHang _donhang = donhangData.get();
			_donhang.setTinhtrangdon(donhang.getTinhtrangdon());
			_donhang.setHinhthucthanhtoan(donhang.getHinhthucthanhtoan());
			_donhang.setTongtien(donhang.getTongtien());
			_donhang.setDiachi(donhang.getDiachi());
			_donhang.setMakh(donhang.getMakh());
			_donhang.setMach(donhang.getMach());
			_donhang.setMashipper(donhang.getMashipper());
			return new ResponseEntity<>(repo.save(_donhang), HttpStatus.OK);
		} 
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/xoa/{id}")
	public ResponseEntity<HttpStatus> XoaMotDonHang(@PathVariable("id") String id) {
		try {
			repo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/xoatatca")
	public ResponseEntity<HttpStatus> XoaTatCaDonHang() {
		try {
			repo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping()
	public ResponseEntity<List<DonHang>> XemTatCaDonHang() {
		try {
			List<DonHang> donhanglst = new ArrayList<DonHang>();
			repo.findAll().forEach(donhanglst::add);
			if (donhanglst.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(donhanglst, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/tim/{id}")
	public ResponseEntity<List<DonHang>> TimDonHang(@PathVariable("id") String id) {
		try {
			List<DonHang> donhanglst = new ArrayList<DonHang>();
			repo.findAllwithId(id).forEach(donhanglst::add);
			if (donhanglst.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(donhanglst, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
