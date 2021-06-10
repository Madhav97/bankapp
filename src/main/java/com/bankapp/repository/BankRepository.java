package com.bankapp.repository;

import com.bankapp.model.Bank;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepository extends MongoRepository<Bank, ObjectId> {
    List<Bank> findByIfsc(String ifsc);

    List<Bank> findByNameAndState(String name, String state);

    List<Bank> findByNameAndStateAndDistrict(String name, String state, String district);
    List<Bank> findByNameAndStateAndCity(String name, String state, String city);
    List<Bank> findByNameAndStateAndAddress(String name, String state, String address);

    List<Bank> findByNameAndStateAndCityAndDistrict(String name, String state, String city, String district);
    List<Bank> findByNameAndStateAndAddressAndCity(String name, String state, String address, String city);
    List<Bank> findByNameAndStateAndAddressAndDistrict(String name, String state, String address, String district);

    List<Bank> findByNameAndStateAndAddressAndCityAndDistrict(String name, String state, String address, String city, String district);
}
