package com.example.jappractice.controller;

import com.example.jappractice.StockInfoUtil;
import com.example.jappractice.repository.StockRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final StockRepository stockRepository;

    public HomeController(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @RequestMapping("/wellcome")
    public String home() {
        return "Wellcome Home!!!";
    }

    @RequestMapping("/kosp200StokItemInfo")
    public String getKosp200StokItemInfo() {
//        StockInfoUtil stockInfoUtil = new StockInfoUtil(stockRepository);
//
//        for (int i = 1; i <= 20; i++) {
//            stockInfoUtil.setKosp200StokItemInfo(i);
//        }
//
//        stockInfoUtil.printKospi200StockInfoList();

        return "성공";
    }
}
