package WebAPI.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import WebAPI.model.DonHang;

public interface DonHangRepository extends MongoRepository<DonHang, String> {
	//CRUD
	@Query("{ma_khach_hang: ?0}")
    List<DonHang>LichSuMuaHang(String id);
	
	@Query("{ma_shipper: ?0}")
    List<DonHang>LichSuGiaoHang(String id);
}
