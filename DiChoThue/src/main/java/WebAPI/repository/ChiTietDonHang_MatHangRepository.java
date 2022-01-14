package WebAPI.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import WebAPI.model.ChiTietDonHang_MatHang;



public interface ChiTietDonHang_MatHangRepository extends MongoRepository<ChiTietDonHang_MatHang, String>{
	
	@Query(value="{}")
	List<ChiTietDonHang_MatHang> TatCaCTDH_MH();
	

	@Query(value="{ma_mat_hang: ?0}")
	List<ChiTietDonHang_MatHang> DanhSachMatHangTheoMaMatHang(String ma_mat_hang);

}
