package com.buezman.springtransactiondemo.flutterWaveTest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class FlwBank {
    @JsonProperty("id")
    private int id;

    @JsonProperty("code")
    private String code;

    @JsonProperty("name")
    private String name;
}
