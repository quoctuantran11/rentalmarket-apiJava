package WebAPI.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import WebAPI.model.CuaHang;

public interface CuaHangRepository extends MongoRepository<CuaHang, String> {
	// CRUD
    @Query(value="{'tench':?0}", fields="{'tench' : 1, 'diachi' : 1, 'makv' : 1}")
    List<CuaHang> findAllwithName(String name);
}
