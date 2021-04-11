package com.example.jappractice.repository;

import com.example.jappractice.entity.StockInfo;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<StockInfo, Long> {
}
