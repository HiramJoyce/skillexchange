package com.skill.exchange.service.impl;

import com.skill.exchange.dao.TradeMapper;
import com.skill.exchange.domain.Trade;
import com.skill.exchange.domain.TradeExample;
import com.skill.exchange.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradeMapper tradeMapper;

    @Override
    public List<Trade> getAllTrades() {
        return tradeMapper.selectByExample(new TradeExample());
    }

    @Override
    public int deleteTradeById(Integer id) {
        return tradeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Trade getTradeById(Integer id) {
        return tradeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Trade> getAllTradesByFromStudentId(Integer studentId) {
        TradeExample tradeExample = new TradeExample();
        TradeExample.Criteria criteria = tradeExample.createCriteria();
        criteria.andFromStudentIdEqualTo(studentId);
        return tradeMapper.selectByExample(tradeExample);
    }

    @Override
    public List<Trade> getAllTradesByToStudentId(Integer studentId) {
        TradeExample tradeExample = new TradeExample();
        TradeExample.Criteria criteria = tradeExample.createCriteria();
        criteria.andToStudentIdEqualTo(studentId);
        return tradeMapper.selectByExample(tradeExample);
    }

    @Override
    public int createTrade(Trade trade) {
        return tradeMapper.insert(trade);
    }

    @Override
    public int agreeTrade(Integer id) {
        Trade trade = tradeMapper.selectByPrimaryKey(id);
        trade.setState(1);
        return tradeMapper.updateByPrimaryKey(trade);
    }

    @Override
    public List<Trade> getMostPopularSkill() {
        return tradeMapper.selectMostPopularSkills();
    }
}
