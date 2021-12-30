package WebAPI.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import WebAPI.model.MatHang;

public interface MatHangRepository extends MongoRepository<MatHang, String> {
	//CRUD
	
	@Query(value="{ten_mat_hang:{$regex:?0}}", fields="{'ten_mat_hang' : 1,"
			+ "'khoi_luong' : 1, 'gia_ban' : 1, 'ma_cua_hang' : 1}")
	List<MatHang> TimTheoTen(String name);
	
	@Query(value="{}", fields="{'ten_mat_hang' : 1, 'khoi_luong' : 1,"
			+ "'gia_ban' : 1, 'ma_cua_hang' : 1}")
	List<MatHang> Xem();
}

