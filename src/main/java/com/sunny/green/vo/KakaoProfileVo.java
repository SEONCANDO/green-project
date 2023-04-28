package com.sunny.green.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.annotation.Generated;


@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaoProfileVo {

    public String id;
    public String connectedAt;
    public Kakao_Account Kakao_account;
    public Properties properties;

    public KakaoProfileVo(String id, String connectedAt, Kakao_Account kakao_account, Properties properties) {
        this.id = id;
        this.connectedAt = connectedAt;
        Kakao_account = kakao_account;
        this.properties = properties;
    }

    public KakaoProfileVo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConnectedAt() {
        return connectedAt;
    }

    public void setConnectedAt(String connectedAt) {
        this.connectedAt = connectedAt;
    }

    public Kakao_Account getKakao_account() {
        return Kakao_account;
    }

    public void setKakao_account(Kakao_Account kakao_account) {
        Kakao_account = kakao_account;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Kakao_Account{
        public String email;
        /*
         * public Boolean hasEmail;
         * public Boolean emailNeedsAgreement;
         * public Boolean isEmailValid;
         * public Boolean isEmailVerified;
         * public Boolean hasAgeRange;
         * public Boolean ageRangeNeedsAgreement;
         * public Boolean hasBirthday;
         * public Boolean birthdayNeedsAgreement;
         */

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Kakao_Account(String email) {
            this.email = email;
        }
    };


    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Properties{
        public String nickname;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }

}


