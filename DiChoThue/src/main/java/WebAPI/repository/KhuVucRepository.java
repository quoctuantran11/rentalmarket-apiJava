package WebAPI.repository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import WebAPI.model.KhuVuc;

public interface KhuVucRepository extends MongoRepository<KhuVuc, String> {
	
	@Query(value="{id: ?0}")
	KhuVuc KhuVucTheoID(String id);
	
	@Query(value="{}")
	List<KhuVuc> DanhSachToanBoKhuVuc();
	
}

