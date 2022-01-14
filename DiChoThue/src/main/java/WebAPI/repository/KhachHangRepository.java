package WebAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import WebAPI.model.KhachHang;

public interface KhachHangRepository extends MongoRepository<KhachHang, String> {

	@Query("{username: ?0}")
	Optional<KhachHang> TimUsername(String username);
	@Query(value="{password: ?0}", fields="{'sdt': 1, 'cccd': 1, 'gioi_tinh': 1, 'ngay_sinh': 1,"
			+ "'ten_khach_hang': 1, 'dia_chi': 1}")
	Optional<KhachHang> TimTaiKhoan(String password);
	
	@Query(value="{}", fields="{'username' : 1}")
	List<KhachHang> TimTatCaTaiKhoan();
	
	@Query(value="{id:?0}", fields="{'ten_khach_hang': 1, '_id': 0}")
	Optional<KhachHang> getTenKhachHang(String makh);
}
