package com.ugurhmz.security.jwt;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class JwtProviderImpl implements  JwtProvider{


    @Value("${app.jwt.secret}")
    private String JWT_SECRET;

}
