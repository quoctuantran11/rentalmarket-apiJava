package WebAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebAPI.model.ComboMatHang;
import WebAPI.model.CuaHang;
import WebAPI.model.MatHang;
import WebAPI.repository.ComboMatHangRepository;
import WebAPI.repository.CuaHangRepository;
import WebAPI.repository.MatHangRepository;

@Service("HangHoaCuaHang")
public class HangHoaCuaHangServices {
	
	@Autowired
	MatHangRepository mathangrepo;
	
	@Autowired
	CuaHangRepository cuahangrepo;
	
	@Autowired
	ComboMatHangRepository comborepo;
	
	public List<MatHang> LayTatCaHang()
	{
		return mathangrepo.findAll();
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
}
