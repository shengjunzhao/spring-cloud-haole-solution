package com.haole.haolecloud.service;

import com.haole.haolecloud.constant.CardType;
import com.haole.haolecloud.dto.Card;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author shengjunzhao
 * @date 2019/1/17
 */
public interface CardService {

    List<Card> findAll();

    int cardInstore(int num,String owner, CardType cardType);

    Optional<Card> bindCard2user(String owner, String cardNo, String userNo, String accountNo);

    List<Card> findUnAssigned();
}
