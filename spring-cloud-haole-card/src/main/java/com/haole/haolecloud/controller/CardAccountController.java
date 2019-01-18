package com.haole.haolecloud.controller;

import com.haole.haolecloud.constant.CardType;
import com.haole.haolecloud.dto.CardAccount;
import com.haole.haolecloud.service.CardAccountService;
import com.haole.haolecloud.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @author shengjunzhao
 * @date 2019/1/17
 */
@RestController
@RequestMapping("/cardAccount")
public class CardAccountController {

    private static final Logger log = LoggerFactory.getLogger(CardAccountController.class);
    @Autowired
    private CardAccountService cardAccountService;
    @Autowired
    private CardService cardService;

    @GetMapping("/add")
    public CardAccount addCardAccount(String userNo, String accountNo, String cardNetNo, String cardNo, Integer cardType,
                                      String bindPlateNumber) {
        CardType ct = CardType.getCardTypeByCode(cardType);
        LocalDateTime localDateTime = LocalDateTime.now();
        Date cardSignedDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        LocalDateTime nextYear = localDateTime.with(TemporalAdjusters.firstDayOfNextYear());
        Date cardExpiredDate = Date.from(nextYear.atZone(ZoneId.systemDefault()).toInstant());
        CardAccount cardAccount = cardAccountService.addCardAccount(userNo, accountNo, cardNetNo, cardNo, ct, cardSignedDate,
                cardExpiredDate, bindPlateNumber);
        cardService.bindCard2user(cardNetNo, cardNo, userNo, accountNo);
        return cardAccount;
    }

}
