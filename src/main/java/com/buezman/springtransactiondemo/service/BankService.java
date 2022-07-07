package com.buezman.springtransactiondemo.service;

import com.buezman.springtransactiondemo.flutterWaveTest.Bank;
import com.buezman.springtransactiondemo.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;

    public String getBankByCode(String code) {
        Bank bank = bankRepository.findBankByBankCode(code);
        if (bank == null) {
            return "Bank not found";
        }
        return bank.getBankName();
    }
}
