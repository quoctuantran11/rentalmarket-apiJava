package WebAPI.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import WebAPI.model.ChiTietGioHang;

public interface ChiTietGioHangRepository extends MongoRepository<ChiTietGioHang, String> {

	@Query("{ma_gio_hang:?0}")
	List<ChiTietGioHang> TimTheoID(String id);
	
	@Query("{$or: [{'ma_mat_hang': ?0}, {'ma_combo': ?0}]}")
	ChiTietGioHang TimTheoIDHang(String id);
}
