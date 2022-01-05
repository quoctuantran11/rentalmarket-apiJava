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

import WebAPI.model.ChiTietCombo;
import WebAPI.repository.ChiTietComboRepository;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/api/chitiet")
public class ChiTietComboController {
	
	@Autowired
	ChiTietComboRepository repo;
	
	@PostMapping("/them")
	public ResponseEntity<ChiTietCombo>ThemChiTiet(@RequestBody ChiTietCombo chitiet) {
		try {
			ChiTietCombo _chitiet = repo.save(new ChiTietCombo(chitiet.getMa(), chitiet.getMacombo(),
					chitiet.getMamh(), chitiet.getSoluong()));

			return new ResponseEntity<>(_chitiet, HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/sua/{id}")
	public ResponseEntity<ChiTietCombo> CapNhatChiTiet(@PathVariable("id") String id, @RequestBody ChiTietCombo
	chitiet) {
		Optional<ChiTietCombo> chitietData = repo.findById(id);
		if (chitietData.isPresent()) {
			ChiTietCombo _chitiet = chitietData.get();
			_chitiet.setMacombo(chitiet.getMacombo());
			_chitiet.setMamh(chitiet.getMamh());
			_chitiet.setSoluong(chitiet.getSoluong());
			return new ResponseEntity<>(repo.save(_chitiet), HttpStatus.OK);
		} 
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/xoa/{id}")
	public ResponseEntity<HttpStatus> XoaMotChiTietCombo(@PathVariable("id") String id) {
		try {
			repo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/xoatatca")
	public ResponseEntity<HttpStatus> XoaTatCaChiTietCombo() {
		try {
			repo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping()
	public ResponseEntity<List<ChiTietCombo>> XemTatCaChiTietCombo() {
		try {
			List<ChiTietCombo> combolst = new ArrayList<ChiTietCombo>();
			repo.findAll().forEach(combolst::add);
			if (combolst.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(combolst, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
