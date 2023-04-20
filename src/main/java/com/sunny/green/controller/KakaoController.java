package com.sunny.green.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequiredArgsConstructor
public class KakaoController {

    @GetMapping("/auth/kakao/callback")
    public @ResponseBody String Callback(String code){
        //데이터를 리턴해주는 컨트롤러
        //post방식으로 key=value 방식으로 데이터를 요청

        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type","authorization_code");
        params.add("client_id","7033be3a22ffb05c2b13405c4f9a65ac");
        params.add("redirect_uri","http://localhost:8080/auth/kakao/callback");
        params.add("code", code);

        HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest
                = new HttpEntity<>(params,headers);

        ResponseEntity<String> response = rt.exchange(
          "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );
        return "카카오 토큰 인증 완료 : 토큰에 대한 요청에 대한 대답 : " + response ;
    }
}
