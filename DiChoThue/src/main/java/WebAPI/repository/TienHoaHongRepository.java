package WebAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import WebAPI.model.TienHoaHong;

public interface TienHoaHongRepository extends MongoRepository<TienHoaHong, String> {
	
	
	@Query("{thang_nam : ?0}")
	List<TienHoaHong> TinhTHHTheoThangNam(String thang_nam);
	
}
