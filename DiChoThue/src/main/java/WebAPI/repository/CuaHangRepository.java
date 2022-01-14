package WebAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import WebAPI.model.CuaHang;

public interface CuaHangRepository extends MongoRepository<CuaHang, String> {
	// CRUD
	@Query(value="{mach:?0}", fields="{'ten_cua_hang': 1, 'dia_chi': 1, '_id': 0}")
	Optional<CuaHang> getCuaHang(String mach);
	
	@Query("{username: ?0}")
	Optional<CuaHang> TimUsername(String username);
	@Query(value="{password: ?0}", fields="{'sdt': 1, 'ten_cua_hang': 1, 'dia_chi': 1, 'hinh_anh': 1, 'mach': 0}")
	Optional<CuaHang> TimTaiKhoan(String password);
	
	@Query(value="{}", fields="{'username' : 1}")
	List<CuaHang> DanhSachTaiKhoan();
}
