package com.skill.exchange.service;

import com.skill.exchange.domain.Trade;

import java.util.List;

public interface TradeService {
    List<Trade> getAllTrades();

    int deleteTradeById(Integer id);

    Trade getTradeById(Integer id);

    List<Trade> getAllTradesByFromStudentId(Integer studentId);

    List<Trade> getAllTradesByToStudentId(Integer studentId);

    int createTrade(Trade trade);

    int agreeTrade(Integer id);

    List<Trade> getMostPopularSkill();
}
