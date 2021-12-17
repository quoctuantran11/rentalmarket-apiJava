package WebAPI.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import WebAPI.model.DonHang;

public interface DonHangRepository extends MongoRepository<DonHang, String> {
	//CRUD
	@Query("{makh:?0}")
    List<DonHang>findAllwithId(String id);
}
