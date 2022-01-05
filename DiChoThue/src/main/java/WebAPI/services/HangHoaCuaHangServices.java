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
import WebAPI.repository.ComboMatHangRepository;
import WebAPI.repository.CuaHangRepository;
import WebAPI.repository.DonHangRepository;
import WebAPI.repository.KhachHangRepository;
import WebAPI.repository.MatHangRepository;

@Service("HangHoaCuaHang")
public class HangHoaCuaHangServices {
	
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
		return cuahangrepo.findById(id);
	}
	
	public Optional<CuaHang> LayTenCuaHang(String id)
	{
		return cuahangrepo.getTenCuaHang(id);
	}
	
	public List<ComboMatHang> LayTatCaCombo()
	{
		return comborepo.findAll();
	}
	
	public String TenKhachHang(String id)
	{
		return khachhangrepo.getTenKhachHang(id);
	}
	
	public List<DonHang> DanhSachGiaoHang(String id)
	{
		return donhangrepo.LichSuGiaoHang(id);
	}
}
