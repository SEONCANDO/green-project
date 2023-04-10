package com.sunny.green.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExchangeVo {

    private int ex_num;

    private int pro_num;

    private String user_id;

    private Timestamp ex_date;

    private String ex_confirm;
}
