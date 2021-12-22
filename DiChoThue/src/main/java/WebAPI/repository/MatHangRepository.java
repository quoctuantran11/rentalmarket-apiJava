package WebAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import WebAPI.model.MatHang;

public interface MatHangRepository extends MongoRepository<MatHang, String> {
	//CRUD
}
