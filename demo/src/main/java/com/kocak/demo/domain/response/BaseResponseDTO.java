package com.kocak.demo.domain.response;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class BaseResponseDTO implements Serializable {

    private String errorCode;
    private boolean success;
}
