package com.buezman.springtransactiondemo.flutterWaveTest;

import com.buezman.springtransactiondemo.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DbInit {

    private final BankRepository bankRepository;

    @Value("${FLW_SECRET_KEY}")
    private String AUTHORIZATION;

//    @PostConstruct
//    public void getBanks() {
//
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        headers.add("Authorization", "Bearer "+ AUTHORIZATION);
//
//        HttpEntity<FlwBankResponse> request = new  HttpEntity<>(null, headers);
//
//        String BANKS_API_URL = "https://api.flutterwave.com/v3/banks";
//        FlwBankResponse flwBankResponse = restTemplate.exchange(
//                BANKS_API_URL +"/NG",
//                HttpMethod.GET,
//                request,
//                FlwBankResponse.class).getBody();
//
//        List<FlwBank> flwBankListanks = flwBankResponse.getData();
//
//        List<Bank> banks = new ArrayList<>();
//
//        for (FlwBank each : flwBankListanks) {
//            Bank newBank = Bank.builder()
//                    .bankCode(each.getCode())
//                    .bankName(each.getName())
//                    .build();
//            banks.add(newBank);
//        }
//
//        bankRepository.saveAll(banks);
//    }
}
