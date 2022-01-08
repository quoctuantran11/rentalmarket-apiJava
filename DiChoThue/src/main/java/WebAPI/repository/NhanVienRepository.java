package WebAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import WebAPI.model.NhanVien;

public interface NhanVienRepository extends MongoRepository<NhanVien, String> {
	
	@Query("{username: ?0}")
	Optional<NhanVien> TimUsername(String username);
	@Query(value="{password: ?0}", fields="{'sdt': 1, 'cccd': 1, 'gioi_tinh': 1, 'ngay_sinh': 1,"
			+ "'ten_nhan_vien': 1, 'dia_chi': 1, 'trang_thai_tiem_chung': 1,"
			+ "'khu_vuc_giao_hang': 1,'id': 0}")
	Optional<NhanVien> TimTaiKhoan(String password);
	
	@Query(value="{}", fields="{'username' : 1}")
	List<NhanVien> TatCaTaiKhoan();
	
	@Query(value="{id: ?0}", fields="{'ten_nhan_vien': 1, 'id': 0}")
	Optional<NhanVien> getTenShippper(String id);
}
