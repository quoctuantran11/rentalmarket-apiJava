package WebAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import WebAPI.model.KhachHang;

public interface KhachHangRepository extends MongoRepository<KhachHang, String> {

	@Query("{username: ?0}")
	Optional<KhachHang> TimUsername(String username);
	@Query("{password: ?0}")
	Optional<KhachHang> TimTaiKhoan(String password);
	
	@Query(value="{}", fields="{'username' : 1, 'password' : 1}")
	List<KhachHang> TimTatCaTaiKhoan();
}
