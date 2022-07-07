package com.buezman.springtransactiondemo.controller;

import com.buezman.springtransactiondemo.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class BankController {

    private final BankService bankService;

    @GetMapping("get-bankName")
    public String getBankName(@RequestParam("code") String code) {
        return bankService.getBankByCode(code);
    }
}
