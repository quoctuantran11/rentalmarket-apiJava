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

import WebAPI.model.ChiTietDonHang_MatHang;
import WebAPI.model.ChiTietGioHang;
import WebAPI.model.ComboMatHang;
import WebAPI.model.NhanVien;
import WebAPI.model.CuaHang;
import WebAPI.model.DonHang;
import WebAPI.model.GioHang;
import WebAPI.model.KhachHang;
import WebAPI.model.KhuVuc;
import WebAPI.model.MatHang;
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
	
	@GetMapping("/shipper/lichsu/{id}")
	public ResponseEntity<List<Map<String, Object>>> LichSuGiaoHang(@PathVariable("id") String id)
	{
		try {
			List<Map<String, Object>> itemlst = new ArrayList<Map<String, Object>>();
		
			List<DonHang> donhanglst = allData.DanhSachGiaoHang(id);
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
	
	@GetMapping("/khachhang/lichsu/{id}")
	public ResponseEntity<List<Map<String, Object>>> LichSuMuaHang(@PathVariable("id") String id)
	{
		try {
			List<Map<String, Object>> itemlst = new ArrayList<Map<String, Object>>();
		
			List<DonHang> donhanglst = allData.DanhSachMuaHang(id);
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
	
	@GetMapping("/giohang/{id}")
	public ResponseEntity<List<Map<String, Object>>> GioHangTheoID(@PathVariable("id") String id)
	{
		try {
			List<Map<String, Object>> itemlst = new ArrayList<Map<String, Object>>();
			GioHang giohang = allData.LayGioHang(id);
			List<ChiTietGioHang> chitietlst = allData.ChiTietGio(giohang.getId());
			int total = 0;
			chitietlst.forEach(chitiet -> {
				Map<String, Object> item = new HashMap();
				item.put("ChiTiet", chitiet);
				MatHang tenmathang = allData.TenMatHang(chitiet.getMa_mat_hang());
				item.put("MatHang", tenmathang);
				ComboMatHang tencombo = allData.TenCombo(chitiet.getMa_combo());
				item.put("ComboMatHang", tencombo);
				
				itemlst.add(item);
			});
			
			return new ResponseEntity<>(itemlst, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/chonhang/{id}")
	public ResponseEntity<ChiTietGioHang> ChonHang(@PathVariable("id") String id, @RequestBody ChiTietGioHang ctgio)
	{
		try
		{
			GioHang giohangData = allData.LayGioHang(id);
			ChiTietGioHang _ctgio = allData.ChonHangHoa(ctgio.getId(), ctgio.getSo_luong(),
					ctgio.getMa_mat_hang(), ctgio.getMa_combo(), giohangData.getId());
			
			return new ResponseEntity<>(_ctgio, HttpStatus.CREATED);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	int  green , red ,  yellow;
	@GetMapping("/thongkekhuvuckhachhang")
	public ResponseEntity<Map<String, Object>> ThongKeKhuVuc_KhachHang()
	{
		
		try {
			green = 0; red = 0;  yellow =0;
			Map<String, Object> ThongKe = new HashMap();
			List<Map<String, Object>> itemlst = new ArrayList<Map<String, Object>>();
			List<KhuVuc> khuvuclst = allData.DanhSachToanBoKhuVuc();
			khuvuclst.forEach(khuvuc -> {
				
				Map<String, Object> item = new HashMap();
				item.put("KhuVuc", khuvuc);
				List<KhachHang> khachhang = allData.TimKhachHangTheoMaKhuVuc(khuvuc.getID());
				item.put("KhachHang", khachhang);
				String trangthaikhuvuc = khuvuc.getPhan_vung();
				if(trangthaikhuvuc.equals("Xanh")) {
					green = green + khachhang.size();
				}
				else if(trangthaikhuvuc.equals("Do")) {
					red = red + khachhang.size();
				}
				else if(trangthaikhuvuc.equals("Cam")) {
					yellow = yellow + khachhang.size();
				}
				
							
				itemlst.add(item);
			});
			
			
			ThongKe.put("Green", green);
			ThongKe.put("Red", red);
			ThongKe.put("Yellow", yellow);
			
			

			return new ResponseEntity<>(ThongKe, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	@GetMapping("/thongkekhuvucshipper")
	public ResponseEntity<Map<String, Object>> ThongKeKhuVuc_Shipper()
	{
		
		try {
			green = 0; red = 0;  yellow = 0;
			List<Map<String, Object>> itemlst = new ArrayList<Map<String, Object>>();
			List<KhuVuc> khuvuclst = allData.DanhSachToanBoKhuVuc();
			khuvuclst.forEach(khuvuc -> {
				
				Map<String, Object> item = new HashMap();
				item.put("KhuVuc", khuvuc);
				List<NhanVien> shipper = allData.LayNhanVienTheoMaKhuVuc(khuvuc.getID());
				item.put("Shipper", shipper);
				String trangthaikhuvuc = khuvuc.getPhan_vung();
				if(trangthaikhuvuc.equals("Xanh")) {
					green = green + shipper.size();
				}
				else if(trangthaikhuvuc.equals("Do")) {
					red = red + shipper.size();
				}
				else if(trangthaikhuvuc.equals("Cam")) {
					yellow = yellow + shipper.size();
				}
				
							
				itemlst.add(item);
			});
			
			Map<String, Object> item_ThongKe = new HashMap();
			item_ThongKe.put("Green", green);
			item_ThongKe.put("Red", red);
			item_ThongKe.put("Yellow", yellow);
			

			return new ResponseEntity<>(item_ThongKe, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/thongkekhuvuccuahang")
	public ResponseEntity<Map<String, Object>> ThongKeKhuVuc_CuaHang()
	{
		
		try {
			green = 0; red = 0;  yellow = 0;
			List<Map<String, Object>> itemlst = new ArrayList<Map<String, Object>>();
			List<KhuVuc> khuvuclst = allData.DanhSachToanBoKhuVuc();
			khuvuclst.forEach(khuvuc -> {
				
				Map<String, Object> item = new HashMap();
				item.put("KhuVuc", khuvuc);
				List<CuaHang> cuahang = allData.DanhSachCuaHangTheoKhuVuc(khuvuc.getID());
				item.put("CuaHang", cuahang);
				String trangthaikhuvuc = khuvuc.getPhan_vung();
				if(trangthaikhuvuc.equals("Xanh")) {
					green = green + cuahang.size();
				}
				else if(trangthaikhuvuc.equals("Do")) {
					red = red + cuahang.size();
				}
				else if(trangthaikhuvuc.equals("Cam")) {
					yellow = yellow + cuahang.size();
				}
				
							
				itemlst.add(item);
			});
			
			Map<String, Object> item_ThongKe = new HashMap();
			item_ThongKe.put("Green", green);
			item_ThongKe.put("Red", red);
			item_ThongKe.put("Yellow", yellow);
			

			return new ResponseEntity<>(item_ThongKe, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	
	int tongsoluong;
	@GetMapping("/thongkemathangthietyeu")
	public ResponseEntity<List<Map<String, Object>>> ThongKeMatHangThietYeu()
	{
		try {
			List<Map<String, Object>> itemlst_ThongKe = new ArrayList<Map<String, Object>>();
			List<Map<String, Object>> itemlst = new ArrayList<Map<String, Object>>();
			List<MatHang> mathanglst = allData.LayTatCaHang();
			mathanglst.forEach(mathang -> {
				Map<String, Object> item = new HashMap();
				item.put("MatHang", mathang);
				List<ChiTietDonHang_MatHang> chitiet = allData.DanhSachMatHangTheoMaMatHang(mathang.getMamh());
				item.put("ChiTietDonHang_MatHang", chitiet);
				
				tongsoluong = 0;
				chitiet.forEach(ct -> {
					tongsoluong += ct.getSoluong();
				});
				
				Map<String, Object> item_ThongKe = new HashMap();
				item_ThongKe.put(mathang.getTen(), tongsoluong);
				itemlst_ThongKe.add(item_ThongKe);
				
				itemlst.add(item);
			});
			
			return new ResponseEntity<>(itemlst_ThongKe, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
