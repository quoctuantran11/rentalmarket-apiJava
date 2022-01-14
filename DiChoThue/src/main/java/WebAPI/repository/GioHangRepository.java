package WebAPI.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import WebAPI.model.GioHang;


public interface GioHangRepository extends MongoRepository<GioHang, String> {

	@Query(value="{id:?0}")
	List<GioHang> TimTheoID(String name);
	
	@Query(value="{}")
	List<GioHang> XemTatCaGioHang();
	
	@Query(value="{ma_khach_hang: ?0}")
	List<GioHang> TimTheoMaKH(String ma_khach_hang);
	
	@Query(value="{ma_khach_hang: ?0}")
	GioHang MotGHTimTheoMaKH(String ma_khach_hang);
	
	
}
