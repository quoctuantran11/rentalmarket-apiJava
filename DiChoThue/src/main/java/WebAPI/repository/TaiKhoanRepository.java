package WebAPI.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import WebAPI.model.TaiKhoan;

public interface TaiKhoanRepository extends MongoRepository<TaiKhoan, String> {

	@Query("{Username: ?0}")
	Optional<TaiKhoan> TimUsername(String name);
	@Query("{Password: ?0}")
	Optional<TaiKhoan> TimTaiKhoan(String pass);

}
