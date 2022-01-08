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

import WebAPI.model.DoiTac;
import WebAPI.repository.DoiTacRepository;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/api/doitac")
public class DoiTacController {
	
	@Autowired
	DoiTacRepository repo;
	
	//Create
	@PostMapping("/them")
	public ResponseEntity<DoiTac> ThemDoiTac(@RequestBody DoiTac input) {
		try {
			DoiTac dt = repo.save(new DoiTac(input.getId(), input.getSdt(), input.getCccd(),
					input.getDiachi(), input.getLoaidoitac(), input.getTendoitac(),
					input.getNgaythamgia(), input.getSoluongcuahang(), input.getTrangthai()));
			return new ResponseEntity<>(dt, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Read
	@GetMapping()
	public ResponseEntity<List<DoiTac>> DanhSachDoiTac() {
		try {
			List<DoiTac> doitaclst = new ArrayList<DoiTac>();
			repo.findAll().forEach(doitaclst::add);
			if (doitaclst.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(doitaclst, HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Delete
	@DeleteMapping("/xoatatca")
	public ResponseEntity<HttpStatus> DeleteAllAccounts() {
		try {
			repo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/sua/{id}")
	public ResponseEntity<DoiTac> CapNhatThongTin(@PathVariable("id") String id, @RequestBody DoiTac
	doitac) {
		Optional<DoiTac> doitacData = repo.findById(id);
		if (doitacData.isPresent()) {
			DoiTac _doitac = doitacData.get();
			_doitac.setSdt(doitac.getSdt());
			_doitac.setCccd(doitac.getCccd());
			_doitac.setDiachi(doitac.getDiachi());
			_doitac.setLoaidoitac(doitac.getLoaidoitac());
			_doitac.setTendoitac(doitac.getTendoitac());
			_doitac.setNgaythamgia(doitac.getNgaythamgia());
			_doitac.setSoluongcuahang(doitac.getSoluongcuahang());
			_doitac.setTrangthai(doitac.getTrangthai());
			return new ResponseEntity<>(repo.save(_doitac), HttpStatus.OK);
		} 
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
