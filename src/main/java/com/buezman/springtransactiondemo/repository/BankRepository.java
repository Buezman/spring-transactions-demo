package com.buezman.springtransactiondemo.repository;

import com.buezman.springtransactiondemo.flutterWaveTest.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
