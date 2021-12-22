package WebAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import WebAPI.model.LoaiMatHang;

public interface LoaiMatHangRepository extends MongoRepository<LoaiMatHang, String> {
	//CRUD
}
