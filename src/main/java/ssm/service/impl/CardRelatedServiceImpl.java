package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.CardDao;
import ssm.entity.Card;

import java.util.List;

@Service
public class CardRelatedServiceImpl implements ssm.service.CardRelatedService {
    @Autowired
    CardDao cardDao;

    public List<Card> findAllRecord(){
        return cardDao.findAllRecord();
    };
}
