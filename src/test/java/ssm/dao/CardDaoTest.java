package ssm.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.entity.Card;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class CardDaoTest {

    @Autowired
    private CardDao cardDao;

    @Test
    public void findARecordTest() {
        List<Card> cards = cardDao.findAllRecord();
        for (Card card :
                cards) {
            System.out.println(card);
        }
    }
}
