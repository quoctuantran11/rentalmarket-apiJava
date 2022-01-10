package WebAPI.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import WebAPI.model.GioHang;


public interface GioHangRepository extends MongoRepository<GioHang, String> {

	@Query(value="{id:?0}}", fields="{'so_luong' : 1,"
			+ "'ma_mat_hang' : 1, 'ma_khach_hang' : 1}")
	List<GioHang> TimTheoID(String name);
	
	@Query(value="{}", fields="{'so_luong' : 1,"
			+ "'ma_mat_hang' : 1, 'ma_khach_hang' : 1}")
	List<GioHang> XemTatCaGioHang();
	
}
