package com.bankapp.controller;

import com.bankapp.model.Bank;
import com.bankapp.model.IfscRequest;
import com.bankapp.model.NameRequest;
import com.bankapp.service.BankSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bank")
public class BankAppController {

    private Logger logger = LoggerFactory.getLogger(BankAppController.class);

    @Inject
    private BankSearchService bankSearchService;

    @PostMapping("/ifsc")
    public List<Bank> getBankByIFSC(@RequestBody IfscRequest ifsc) {
        return bankSearchService.getBankByIFSC(ifsc.getIfsc());
    }

    @PostMapping("/name")
    public List<Bank> getBankByName(@RequestBody NameRequest nameRequest) {
        return bankSearchService.getBankByName(nameRequest);
    }

    @GetMapping("/all-banks")
    public List<Bank> getAllBankDetails() {
        logger.info("Getting all bank details");
        return bankSearchService.getAllBankDetails();
    }
}
