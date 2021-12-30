package WebAPI.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import WebAPI.model.CuaHang;

public interface CuaHangRepository extends MongoRepository<CuaHang, String> {
	// CRUD
	@Query(value="{mach:?0}", fields="{'ten_cua_hang': 1, '_id': 0}")
	Optional<CuaHang> getTenCuaHang(String mach);
}
