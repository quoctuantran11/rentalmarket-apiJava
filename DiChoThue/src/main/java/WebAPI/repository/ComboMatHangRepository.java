package WebAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import WebAPI.model.ComboMatHang;

public interface ComboMatHangRepository extends MongoRepository<ComboMatHang, String> {
	//CRUD
	@Query(value="{macombo: ?0}", fields="{'ten_combo' : 1, 'khoi_luong': 1, 'gia_ban': 1, 'hinh_anh': 1,"
			+ "'macombo': 0}")
	ComboMatHang getTenCombo(String id);
}
