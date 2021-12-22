package WebAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import WebAPI.model.ComboMatHang;

public interface ComboMatHangRepository extends MongoRepository<ComboMatHang, String> {
	//CRUD
}
