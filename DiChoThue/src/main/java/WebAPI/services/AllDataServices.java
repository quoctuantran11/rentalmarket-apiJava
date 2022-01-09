package WebAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebAPI.model.ComboMatHang;
import WebAPI.model.CuaHang;
import WebAPI.model.DonHang;
import WebAPI.model.KhachHang;
import WebAPI.model.MatHang;
import WebAPI.model.NhanVien;
import WebAPI.repository.ComboMatHangRepository;
import WebAPI.repository.CuaHangRepository;
import WebAPI.repository.DonHangRepository;
import WebAPI.repository.KhachHangRepository;
import WebAPI.repository.MatHangRepository;
import WebAPI.repository.NhanVienRepository;

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
}
