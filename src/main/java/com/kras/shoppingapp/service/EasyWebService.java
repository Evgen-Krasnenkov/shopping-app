package com.kras.shoppingapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EasyWebService {
    @Value("${my.private}")
    public String value;

    public String getValue() {
        return value;
    }


}
