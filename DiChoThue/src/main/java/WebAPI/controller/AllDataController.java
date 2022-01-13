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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import WebAPI.model.ComboMatHang;
import WebAPI.model.NhanVien;
import WebAPI.repository.ChiTietComboRepository;
import WebAPI.repository.ChiTietGioHangRepository;
import WebAPI.model.CuaHang;
import WebAPI.model.DoiTac;
import WebAPI.model.DonHang;
import WebAPI.model.GioHang;
import WebAPI.model.KhachHang;
import WebAPI.model.MatHang;
import WebAPI.model.ChiTietCombo;
import WebAPI.model.ChiTietGioHang;
import WebAPI.services.AllDataServices;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/api")
public class AllDataController {

	@Autowired
	AllDataServices allData;
	
	//Show
	@GetMapping("/hanghoa")
	public ResponseEntity<List<Map<String, Object>>> XemTatCaHang()
	{
		try {
			List<Map<String, Object>> itemlst = new ArrayList<Map<String, Object>>();
		
			List<MatHang> mathanglst = allData.LayTatCaHang();
			mathanglst.forEach(mathang -> {
				Map<String, Object> item = new HashMap();
				item.put("MatHang", mathang);
				Optional<CuaHang> cuahang = allData.LayCuaHang(mathang.getMach());
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
		
			List<MatHang> mathanglst = allData.TimTatCaHang(ten);
			mathanglst.forEach(mathang -> {
				Map<String, Object> item = new HashMap();
				item.put("MatHang", mathang);
				Optional<CuaHang> cuahang = allData.LayCuaHang(mathang.getMach());
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
		
			List<ComboMatHang> combolst = allData.LayTatCaCombo();
			combolst.forEach(combo -> {
				Map<String, Object> item = new HashMap();
				item.put("Combo", combo);
				Optional<CuaHang> tencuahang = allData.LayCuaHang(combo.getMach());
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
		
			List<DonHang> donhanglst = allData.DanhSachGiaoHang("61c3d5ff0296576ff58de98f");
			donhanglst.forEach(donhang -> {
				Map<String, Object> item = new HashMap();
				item.put("DonHang", donhang);
				Optional<KhachHang> tenkhachhang = allData.TenKhachHang(donhang.getMakh());
				item.put("KhachHang", tenkhachhang);
				Optional<CuaHang> tencuahang = allData.LayCuaHang(donhang.getMach());
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
	
	@GetMapping("/khachhang/lichsu")
	public ResponseEntity<List<Map<String, Object>>> LichSuMuaHang()
	{
		try {
			List<Map<String, Object>> itemlst = new ArrayList<Map<String, Object>>();
		
			List<DonHang> donhanglst = allData.DanhSachMuaHang("61c3d5ff0296576ff58de98f");
			donhanglst.forEach(donhang -> {
				Map<String, Object> item = new HashMap();
				item.put("DonHang", donhang);
				Optional<NhanVien> tenshipper = allData.TenShipper(donhang.getMashipper());
				item.put("Shipper", tenshipper);
				Optional<CuaHang> tencuahang = allData.LayCuaHang(donhang.getMach());
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
	
	@GetMapping("/quanlytaikhoan")
	public ResponseEntity<Map<String, Object>> QuanLyTaiKhoan()
	{
		try {
			Map<String, Object> item = new HashMap();
			
			List<KhachHang> customerlst = allData.TaiKhoanKH();
			item.put("KhachHang", customerlst);
			List<NhanVien> shipperlst = allData.TaiKhoanNV();
			item.put("Shipper", shipperlst);
			List<CuaHang> storelst = allData.TaiKhoanCH();
			item.put("CuaHang", storelst);
			
			return new ResponseEntity<>(item, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/tatcadon")
	public ResponseEntity<List<Map<String, Object>>> DanhSachDonHang()
	{
		try {
			List<Map<String, Object>> itemlst = new ArrayList<Map<String, Object>>();
			List<DonHang> donhanglst = allData.TatCaDonHang();
			donhanglst.forEach(donhang -> {
				Map<String, Object> item = new HashMap();
				item.put("DonHang", donhang);
				Optional<NhanVien> tenshipper = allData.TenShipper(donhang.getMashipper());
				item.put("Shipper", tenshipper);
				Optional<CuaHang> tencuahang = allData.LayCuaHang(donhang.getMach());
				item.put("CuaHang", tencuahang);
				Optional<KhachHang> tenkhachhang = allData.TenKhachHang(donhang.getMakh());
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
	
	
	
	@Autowired
	ChiTietGioHangRepository giohangrepo;
	@PostMapping("/them/{makh}")
	public ResponseEntity<ChiTietGioHang> ThemSanPhamVaoChiTiet(@PathVariable("makh") String makh, 
			@RequestBody ChiTietGioHang chitiet) {
		try {
			GioHang giohang = allData.MotGioHangTheoMaKH(makh);
			String magh = giohang.getId();

			
			ChiTietGioHang _chitiet = giohangrepo.save(new ChiTietGioHang(chitiet.getMa_chi_tiet_gio_hang(),
					magh, chitiet.getMa_mat_hang(), chitiet.getSo_luong()));

			return new ResponseEntity<>(_chitiet, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
