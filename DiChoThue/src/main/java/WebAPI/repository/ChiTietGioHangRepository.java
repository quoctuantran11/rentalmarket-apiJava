package WebAPI.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import WebAPI.model.ChiTietGioHang;


public interface ChiTietGioHangRepository extends MongoRepository<ChiTietGioHang, String>{
	
	@Query(value="{ma_gio_hang: ?0}")
	List<ChiTietGioHang> TimTheoMaGioHang(String ma_gio_hang);
	
	

}
