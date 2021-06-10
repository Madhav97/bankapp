package com.bankapp.service;

import com.bankapp.model.Bank;
import com.bankapp.model.NameRequest;
import com.bankapp.repository.BankRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.*;

@Service
public class BankSearchService {

    private Logger logger = LoggerFactory.getLogger(BankSearchService.class);

    @Inject
    private BankRepository bankRepository;

    public List<Bank> getBankByIFSC(String ifsc) {
        logger.info("Getting Bank by IFSC: {}", ifsc);
        return bankRepository.findByIfsc(ifsc);
    }

    public List<Bank> getBankByName(NameRequest nameRequest) {

        List<Bank> bankList = null;
        if(nameRequest.getAddress().equals("") && nameRequest.getCity().equals("") && nameRequest.getDistrict().equals("")) {
            logger.info("Getting Bank by Name: {} and State: {}", nameRequest.getName(), nameRequest.getState());
            bankList = bankRepository.findByNameAndState(nameRequest.getName(), nameRequest.getState());
        } else if(nameRequest.getAddress().equals("") && nameRequest.getCity().equals("") && !nameRequest.getDistrict().equals("")) {
            logger.info("Getting Bank by Name: {}, State: {} and District: {}", nameRequest.getName(), nameRequest.getState(), nameRequest.getDistrict());
            bankList = bankRepository.findByNameAndStateAndDistrict(nameRequest.getName(), nameRequest.getState(), nameRequest.getDistrict());
        } else if(nameRequest.getAddress().equals("") && !nameRequest.getCity().equals("") && nameRequest.getDistrict().equals("")) {
            logger.info("Getting Bank by Name: {}, State: {} and City: {}", nameRequest.getName(), nameRequest.getState(), nameRequest.getCity());
            bankList = bankRepository.findByNameAndStateAndCity(nameRequest.getName(), nameRequest.getState(), nameRequest.getCity());
        } else if(!nameRequest.getAddress().equals("") && nameRequest.getCity().equals("") && nameRequest.getDistrict().equals("")) {
            logger.info("Getting Bank by Name: {}, State: {} and Address: {}", nameRequest.getName(), nameRequest.getState(), nameRequest.getAddress());
            bankList = bankRepository.findByNameAndStateAndAddress(nameRequest.getName(), nameRequest.getState(), nameRequest.getAddress());
        } else if(nameRequest.getAddress().equals("") && !nameRequest.getCity().equals("") && !nameRequest.getDistrict().equals("")) {
            logger.info("Getting Bank by Name: {}, State: {}, City: {} and District: {}", nameRequest.getName(), nameRequest.getState(), nameRequest.getCity(), nameRequest.getDistrict());
            bankList = bankRepository.findByNameAndStateAndCityAndDistrict(nameRequest.getName(), nameRequest.getState(), nameRequest.getCity(), nameRequest.getDistrict());
        } else if(!nameRequest.getAddress().equals("") && !nameRequest.getCity().equals("") && nameRequest.getDistrict().equals("")) {
            logger.info("Getting Bank by Name: {}, State: {}, Address: {} and City: {}", nameRequest.getName(), nameRequest.getState(), nameRequest.getAddress(), nameRequest.getCity());
            bankList = bankRepository.findByNameAndStateAndAddressAndCity(nameRequest.getName(), nameRequest.getState(), nameRequest.getAddress(), nameRequest.getCity());
        } else if(!nameRequest.getAddress().equals("") && nameRequest.getCity().equals("") && !nameRequest.getDistrict().equals("")) {
            logger.info("Getting Bank by Name: {}, State: {}, Address: {} and District: {}", nameRequest.getName(), nameRequest.getState(), nameRequest.getAddress(), nameRequest.getDistrict());
            bankList = bankRepository.findByNameAndStateAndAddressAndDistrict(nameRequest.getName(), nameRequest.getState(), nameRequest.getAddress(), nameRequest.getDistrict());
        } else if(!nameRequest.getAddress().equals("") && !nameRequest.getCity().equals("") && !nameRequest.getDistrict().equals("")) {
            logger.info("Getting Bank by Name: {}, State: {}, Address: {}, City: {} and District: {}", nameRequest.getName(), nameRequest.getState(), nameRequest.getAddress(), nameRequest.getCity(), nameRequest.getDistrict());
            bankList = bankRepository.findByNameAndStateAndAddressAndCityAndDistrict(nameRequest.getName(), nameRequest.getState(), nameRequest.getAddress(), nameRequest.getCity(), nameRequest.getDistrict());
        }
        return bankList;
    }

    public List<Bank> getAllBankDetails() {
        return bankRepository.findAll();
    }
}
