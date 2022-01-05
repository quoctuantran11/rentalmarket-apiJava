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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import WebAPI.model.ComboMatHang;
import WebAPI.model.CuaHang;
import WebAPI.model.DonHang;
import WebAPI.model.KhachHang;
import WebAPI.model.MatHang;
import WebAPI.services.HangHoaCuaHangServices;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/api")
public class HangHoaCuaHangController {
	
	@Autowired
	HangHoaCuaHangServices hanghoaCuaHang;
	
	//Show
	@GetMapping("/hanghoa")
	public ResponseEntity<List<Map<String, Object>>> XemTatCaHang()
	{
		try {
			List<Map<String, Object>> itemlst = new ArrayList<Map<String, Object>>();
		
			List<MatHang> mathanglst = hanghoaCuaHang.LayTatCaHang();
			mathanglst.forEach(mathang -> {
				Map<String, Object> item = new HashMap();
				item.put("MatHang", mathang);
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
	
	@GetMapping("/hanghoa/{ten}")
	public ResponseEntity<List<Map<String, Object>>> TimTatCaHang(@PathVariable("ten") String ten)
	{
		try {
			List<Map<String, Object>> itemlst = new ArrayList<Map<String, Object>>();
		
			List<MatHang> mathanglst = hanghoaCuaHang.TimTatCaHang(ten);
			mathanglst.forEach(mathang -> {
				Map<String, Object> item = new HashMap();
				item.put("MatHang", mathang);
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
	
	@GetMapping("/combohanghoa")
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
	
	@GetMapping("/shipper/lichsu")
	public ResponseEntity<List<Map<String, Object>>> LichSuGiaoHang()
	{
		try {
			List<Map<String, Object>> itemlst = new ArrayList<Map<String, Object>>();
		
			List<DonHang> donhanglst = hanghoaCuaHang.DanhSachGiaoHang("61c3d5ff0296576ff58de98f");
			donhanglst.forEach(donhang -> {
				Map<String, Object> item = new HashMap();
				item.put("DonHang", donhang);
				String tenkhachhang = hanghoaCuaHang.TenKhachHang(donhang.getMakh());
				item.put("KhachHang", tenkhachhang);
				
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
