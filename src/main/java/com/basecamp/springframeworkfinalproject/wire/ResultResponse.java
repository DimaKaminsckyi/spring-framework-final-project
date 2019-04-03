package com.basecamp.springframeworkfinalproject.wire;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class ResultResponse {

    private UUID uuid;
    private String result;
}
