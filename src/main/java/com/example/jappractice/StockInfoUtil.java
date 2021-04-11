package com.example.jappractice;

import com.example.jappractice.entity.StockInfo;
import com.example.jappractice.repository.StockRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class StockInfoUtil {
    private final StockRepository stockRepository;

    public StockInfoUtil(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    /**
     * 코스피 200 종목 정보 가져오기(한번에 10건씩 가져옴)
     * @param num
     */
    public void setKosp200StokItemInfo(int num) {
        Document doc;

        String url = "https://finance.naver.com/sise/entryJongmok.nhn?&page=" + num;
        try {
            doc = Jsoup.connect(url).get();

            int cnt = 0;

            Elements trs = doc.getElementsByTag("tr");
            for (int i=2; i<12; i++) {
                StockInfo stockInfo = new StockInfo();

                String href = trs.get(i).select("td a").first().attr("href");
                String stockNo = href.substring(href.length()-6);

                Elements tds = trs.get(i).getElementsByTag("td");

                cnt++;
                int rank = cnt + 10*(num-1);
//                int rank = i;

                String stockNm = tds.get(0).text();

                Element img = trs.get(i).select("td img").first();
                String upDown = "보합";

                if(img != null)  upDown = img.attr("alt");

                int currPrice = Integer.parseInt(tds.get(1).text().replace(",", ""));

                int pricePreDay = Integer.parseInt(tds.get(2).text().replace(",", ""));
                String upDownLatio = tds.get(3).text();
                int volume = Integer.parseInt(tds.get(4).text().replace(",", ""));
                int transactionPrice = Integer.parseInt(tds.get(5).text().replace(",", ""));
                int marketCap = Integer.parseInt(tds.get(6).text().replace(",", ""));

                stockInfo.setRank(rank);
                stockInfo.setStockNo(stockNo);
                stockInfo.setStockNm(stockNm);
                stockInfo.setCurrPrice(currPrice);
                stockInfo.setUpDown(upDown);
                stockInfo.setPricePreDay(pricePreDay);
                stockInfo.setUpDownLatio(upDownLatio);
                stockInfo.setVolume(volume);
                stockInfo.setTransactionPrice(transactionPrice);
                stockInfo.setMarketCap(marketCap);

                System.out.println(stockInfo.toString());

                stockRepository.save(stockInfo);

//                List<StockInfo> kospi200StockInfoList = (List<StockInfo>) stockRepository.findAll();

//                kospi200StockInfoList.forEach(x -> System.out.println(">>>>> " + x.toString()));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printKospi200StockInfoList() {
        List<StockInfo> kospi200StockInfoList = (List<StockInfo>) stockRepository.findAll();

        kospi200StockInfoList.forEach(x -> System.out.println(">>>>> " + x.toString()));
    }
}
