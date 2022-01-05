package WebAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import WebAPI.model.DoiTac;

public interface DoiTacRepository extends MongoRepository<DoiTac, String> {
	
}
