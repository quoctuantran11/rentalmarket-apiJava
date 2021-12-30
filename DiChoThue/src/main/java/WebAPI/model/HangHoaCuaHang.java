package WebAPI.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "HangHoaCuaHang")
public class HangHoaCuaHang {
	public CuaHang cua_hang;
	public List<MatHang>ds_mat_hang;
	public List<ComboMatHang>ds_combo;
	public List<ChiTietCombo>ds_chi_tiet_combo;
	
	public CuaHang getCuaHang()
	{
		return cua_hang;
	}
	
	public void setCuaHang(CuaHang cuahang)
	{
		this.cua_hang = cuahang;
	}
	
	public List<MatHang> getDanhsachmathang()
	{
		return ds_mat_hang;
	}
	
	public void setDanhsachMatHang(List<MatHang> dsmathang)
	{
		this.ds_mat_hang = dsmathang;
	}
	
	public List<ComboMatHang> getDsCombo()
	{
		return ds_combo;
	}
	
	public void setDsCombo(List<ComboMatHang> dscombo)
	{
		this.ds_combo = dscombo;
	}
	
	public List<ChiTietCombo> getDsChiTiet()
	{
		return ds_chi_tiet_combo;
	}
	
	public void setDsChiTiet(List<ChiTietCombo> dschitiet)
	{
		this.ds_chi_tiet_combo = dschitiet;
	}
}
