package WebAPI.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import WebAPI.model.GioHang;


public interface GioHangRepository extends MongoRepository<GioHang, String> {

	@Query("{ma_khach_hang:?0}")
	GioHang TimTheoIDKhach(String id);
}
