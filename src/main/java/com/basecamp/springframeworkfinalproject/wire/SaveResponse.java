package com.basecamp.springframeworkfinalproject.wire;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class SaveResponse {

    private UUID id;
    private String response;
}
