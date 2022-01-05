package WebAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import WebAPI.model.ChiTietCombo;

public interface ChiTietComboRepository extends MongoRepository<ChiTietCombo, String> {

}
