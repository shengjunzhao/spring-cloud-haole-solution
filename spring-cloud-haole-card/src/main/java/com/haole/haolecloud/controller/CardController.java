package com.haole.haolecloud.controller;

import com.haole.haolecloud.constant.CardType;
import com.haole.haolecloud.dto.Card;
import com.haole.haolecloud.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by shengjunzhao on 2019/1/17.
 */
@RestController
@RequestMapping("/card")
public class CardController {

    private static final Logger log = LoggerFactory.getLogger(CardController.class);

    @Autowired
    private CardService cardService;

    @GetMapping("/list")
    List<Card> list() {
        return cardService.findAll();
    }

    @GetMapping("/instore")
    List<Card> cardInstore(Integer num, Integer cardType) {
        int n = cardService.cardInstore(num, "1101", CardType.getCardTypeByCode(cardType));
        return cardService.findAll();
    }

    @GetMapping("/unassigned")
    List<Card> findUnAssigned() {
        return cardService.findUnAssigned();
    }
}
