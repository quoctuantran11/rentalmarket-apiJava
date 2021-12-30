package WebAPI.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import WebAPI.model.ComboMatHang;
import WebAPI.model.CuaHang;
import WebAPI.model.MatHang;
import WebAPI.services.HangHoaCuaHangServices;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/api/hanghoa")
public class HangHoaCuaHangController {
	
	@Autowired
	HangHoaCuaHangServices hanghoaCuaHang;
	
	//Show
	@GetMapping()
	public ResponseEntity<List<Map<String, Object>>> XemTatCaHang()
	{
		try {
			List<Map<String, Object>> itemlst = new ArrayList<Map<String, Object>>();
		
			List<MatHang> mathanglst = hanghoaCuaHang.LayTatCaHang();
			mathanglst.forEach(mathang -> {
				Map<String, Object> item = new HashMap();
				item.put("HangHoa", mathang);
				Optional<CuaHang> cuahang = hanghoaCuaHang.LayTenCuaHang(mathang.getMach());
				item.put("CuaHang", cuahang);
				
				itemlst.add(item);
			});
			return new ResponseEntity<>(itemlst, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/combo")
	public ResponseEntity<List<Map<String, Object>>> XemTatCaCombo()
	{
		try {
			List<Map<String, Object>> itemlst = new ArrayList<Map<String, Object>>();
		
			List<ComboMatHang> combolst = hanghoaCuaHang.LayTatCaCombo();
			combolst.forEach(combo -> {
				Map<String, Object> item = new HashMap();
				item.put("Combo", combo);
				Optional<CuaHang> tencuahang = hanghoaCuaHang.LayTenCuaHang(combo.getMach());
				item.put("CuaHang", tencuahang);
				
				itemlst.add(item);
			});
			return new ResponseEntity<>(itemlst, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
