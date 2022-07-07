package com.buezman.springtransactiondemo.flutterWaveTest;

import com.buezman.springtransactiondemo.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DbInit {

    private final BankRepository bankRepository;

    @Value("${FLW_SECRET_KEY}")
    private String AUTHORIZATION;

    @PostConstruct
    @PreDestroy
    public void getBanks() {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer "+ AUTHORIZATION);

        HttpEntity<FlwBankResponse> request = new  HttpEntity<>(null, headers);

        String BANKS_API_URL = "https://api.flutterwave.com/v3/banks";
        FlwBankResponse flwBankResponse = restTemplate.exchange(
                BANKS_API_URL +"/NG",
                HttpMethod.GET,
                request,
                FlwBankResponse.class).getBody();

        List<FlwBank> flwBankListanks = flwBankResponse.getData();

        List<Bank> banks = new ArrayList<>();

        for (FlwBank each : flwBankListanks) {
            Bank newBank = Bank.builder()
                    .bankCode(each.getCode())
                    .bankName(each.getName())
                    .build();
            banks.add(newBank);
        }

        bankRepository.saveAll(banks);
    }
}
