package com.sunny.green.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonParamsVo {
    private int page;           // 현재 페이지 번호
    private int recordPerPage;  // 페이지당 출력할 데이터 개수
    private int pageSize;       // 화면 하단에 출력할 페이지 개수
    private String keyword;     // 검색 키워드
    private String searchType;  // 검색 유형
}
