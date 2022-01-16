package WebAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebAPI.model.ChiTietDonHang_MatHang;
import WebAPI.model.ChiTietGioHang;
import WebAPI.model.ComboMatHang;
import WebAPI.model.CuaHang;
import WebAPI.model.DonHang;
import WebAPI.model.GioHang;
import WebAPI.model.KhachHang;
import WebAPI.model.KhuVuc;
import WebAPI.model.MatHang;
import WebAPI.model.NhanVien;
import WebAPI.model.TienHoaHong;
import WebAPI.repository.ChiTietDonHang_MatHangRepository;
import WebAPI.repository.ChiTietGioHangRepository;
import WebAPI.repository.ComboMatHangRepository;
import WebAPI.repository.CuaHangRepository;
import WebAPI.repository.DonHangRepository;
import WebAPI.repository.GioHangRepository;
import WebAPI.repository.KhachHangRepository;
import WebAPI.repository.KhuVucRepository;
import WebAPI.repository.MatHangRepository;
import WebAPI.repository.NhanVienRepository;
import WebAPI.repository.TienHoaHongRepository;

@Service("AllData")
public class AllDataServices {
	@Autowired
	MatHangRepository mathangrepo;
	
	@Autowired
	CuaHangRepository cuahangrepo;
	
	@Autowired
	ComboMatHangRepository comborepo;
	
	@Autowired
	KhachHangRepository khachhangrepo;
	
	@Autowired
	DonHangRepository donhangrepo;
	
	@Autowired
	NhanVienRepository shipperrepo;
	
	@Autowired
	GioHangRepository giohangrepo;
	
	@Autowired
	ChiTietGioHangRepository ctgiorepo;
	
	@Autowired
	ChiTietDonHang_MatHangRepository chitietdonhang_mathangrepo;
	
	@Autowired
	KhuVucRepository khuvucrepo;
	
	@Autowired
	TienHoaHongRepository tienhoahongrepo;
	
	public List<MatHang> LayTatCaHang()
	{
		return mathangrepo.findAll();
	}
	
	public List<MatHang> TimTatCaHang(String name)
	{
		return mathangrepo.TimTheoTen(name);
	}
	
	public Optional<CuaHang> LayCuaHang(String id)
	{
		return cuahangrepo.getCuaHang(id);
	}
	
	public List<ComboMatHang> LayTatCaCombo()
	{
		return comborepo.findAll();
	}
	
	public Optional<KhachHang> TenKhachHang(String id)
	{
		return khachhangrepo.getTenKhachHang(id);
	}
	
	public Optional<NhanVien> TenShipper(String id)
	{
		return shipperrepo.getTenShippper(id);
	}
	
	public MatHang TenMatHang(String id)
	{
		return mathangrepo.getTenMatHang(id);
	}
	
	public ComboMatHang TenCombo(String id)
	{
		return comborepo.getTenCombo(id);
	}
	
	public List<DonHang> DanhSachGiaoHang(String id)
	{
		return donhangrepo.LichSuGiaoHang(id);
	}
	
	public List<DonHang> DanhSachMuaHang(String id)
	{
		return donhangrepo.LichSuMuaHang(id);
	}
	
	public List<DonHang> TatCaDonHang()
	{
		return donhangrepo.findAll();
	}
	
	public List<KhachHang> TaiKhoanKH()
	{
		return khachhangrepo.TimTatCaTaiKhoan();
	}
	
	public List<NhanVien> TaiKhoanNV()
	{
		return shipperrepo.TatCaTaiKhoan();
	}
	
	public List<CuaHang> TaiKhoanCH()
	{
		return cuahangrepo.DanhSachTaiKhoan();
	}
	
	public GioHang LayGioHang(String id)
	{
		return giohangrepo.TimTheoIDKhach(id);
	}
	
	public List<ChiTietGioHang> ChiTietGio(String id)
	{
		return ctgiorepo.TimTheoID(id);
	}
	
	public ChiTietGioHang ChonHangHoa(String id, int soluong, String mahang, String macombo, String magio)
	{
		ChiTietGioHang _chitiet = ctgiorepo.save(new ChiTietGioHang(id, soluong, mahang, macombo, magio));
		
		return _chitiet;
	}
	
	public KhuVuc LayKhuVucTheoID(String id) 
	{
		return khuvucrepo.KhuVucTheoID(id);
	}
	
	public List<KhuVuc> DanhSachToanBoKhuVuc() {
		return khuvucrepo.findAll();
	}
	
	public List<NhanVien> ThongTinTatCaShipper() 
	{
		return shipperrepo.findAll();
	}
	
	public List<NhanVien> LayNhanVienTheoMaKhuVuc(String makhuvuc)
	{
		return shipperrepo.LayNhanVienTheoMaKhuVuc(makhuvuc);
	}
	
	public List<CuaHang> DanhSachCuaHangTheoKhuVuc(String makhuvuc) {
		return cuahangrepo.DanhSachCuaHangTheoKhuVuc(makhuvuc);
	}
	
	public List<ChiTietDonHang_MatHang> TatCaCTDH_MH() 
	{
		return chitietdonhang_mathangrepo.findAll();
	}
	
	public List<KhachHang> TimKhachHangTheoMaKhuVuc(String makhuvuc) {
		return khachhangrepo.TimKhachHangTheoMaKhuVuc(makhuvuc);
	}
	
	public List<ChiTietDonHang_MatHang> DanhSachMatHangTheoMaMatHang(String mamh) {
		return chitietdonhang_mathangrepo.DanhSachMatHangTheoMaMatHang(mamh);
	}
	
	public List<TienHoaHong> TinhTHHTheoThangNam(String thang_nam) {
		return tienhoahongrepo.TinhTHHTheoThangNam(thang_nam);
	}
	

}
