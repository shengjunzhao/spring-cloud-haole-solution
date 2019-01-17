package com.haole.haolecloud.service.impl;

import com.haole.haolecloud.constant.CardType;
import com.haole.haolecloud.dto.Card;
import com.haole.haolecloud.service.CardService;
import org.apache.commons.lang.StringUtils;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author shengjunzhao
 * @date 2019/1/17
 */
@Service
public class CardServiceImpl implements CardService {

    private static final Logger log = LoggerFactory.getLogger(CardServiceImpl.class);

    @Autowired
    private CacheManager cacheManager;

    @Override
    public List<Card> findAll() {
        List<Card> cardList = new ArrayList<>();
        Cache<String, Card> cache = getCardCache();
        cache.forEach((entry) -> cardList.add(entry.getValue()));
        return cardList;
    }

    @Override
    public int cardInstore(int num, String owner, CardType cardType) {
        Cache<String, Card> cache = getCardCache();
        Card card;
        for (int i = 0; i < num; i++) {
            card = new Card();
            card.setOwner(owner);
            card.setCardNo(Card.generateUserNo(cardType));
            card.setCardType(cardType);
            cache.put(getCacheKey(owner, card.getCardNo()), card);
        }
        return num;
    }

    @Override
    public Optional<Card> bindCard2user(String owner, String cardNo, String userNo, String accountNo) {
        Optional<Card> optionalCard = Optional.empty();
        Cache<String, Card> cache = getCardCache();
        Card card = cache.get(getCacheKey(owner, cardNo));
        if (null != cache) {
            card.setUserNo(userNo);
            card.setAccountNo(accountNo);
            cache.put(getCacheKey(owner, cardNo), card);
            optionalCard = Optional.of(card);
        }
        return optionalCard;
    }

    @Override
    public List<Card> findUnAssigned() {
        List<Card> cardList = new ArrayList<>();
        Cache<String, Card> cache = getCardCache();
        cache.forEach((entry) -> {
            if (StringUtils.isNotBlank(entry.getValue().getAccountNo())) {
                cardList.add(entry.getValue());
            }
        });
        return cardList;
    }

    private Cache<String, Card> getCardCache() {
        return cacheManager.getCache("card", String.class, Card.class);
    }

    private String getCacheKey(String owner, String cardNo) {
        return owner + "\u003A" + cardNo;
    }
}
