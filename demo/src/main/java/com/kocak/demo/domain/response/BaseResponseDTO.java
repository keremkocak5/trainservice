package com.kocak.demo.domain.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class BaseResponseDTO implements Serializable {

    private boolean success;
    private String errorCode;
    private String errorMessage;
}
