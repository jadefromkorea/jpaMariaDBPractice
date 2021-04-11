package com.example.jappractice.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class StockInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 순위 **/
    private int rank;
    /** 종목번호 **/
    private String stockNo;
    /** 종목명 **/
    private String stockNm;
    /** 현재가 **/
    private int currPrice;
    /** 상승 or 하락 or 보합 **/
    private String upDown;
    /** 전일대비가격차이 **/
    private int pricePreDay;
    /** 등락률 **/
    private String upDownLatio;
    /** 거래량 **/
    private int volume;
    /** 거래대금(백만) **/
    private int transactionPrice;
    /** 시가총액(억) **/
    private int marketCap;

}
