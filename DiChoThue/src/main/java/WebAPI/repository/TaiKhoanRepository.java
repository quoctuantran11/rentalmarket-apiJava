package WebAPI.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import WebAPI.model.TaiKhoan;

public interface TaiKhoanRepository extends MongoRepository<TaiKhoan, String> {

	//List<TaiKhoan> findAll(String type);

}
