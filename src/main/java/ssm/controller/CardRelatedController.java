package ssm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.entity.Card;
import ssm.service.CardRelatedService;

import java.util.List;

public class CardRelatedController {
    @Autowired
    private CardRelatedService cardRelatedService;

    @RequestMapping(value = "/findAllRecord", method = RequestMethod.GET)
    @ResponseBody
    public List<Card> findAllRecord(){
        return cardRelatedService.findAllRecord();
    }
}
