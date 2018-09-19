package ssm.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.entity.Score;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class ScoreDaoTest {

    @Autowired
    ScoreDao scoreDao;

    @Test
    public void findARecordTest(){
        List<Score> scores = scoreDao.findARecord();
        for (Score score :
            scores ) {
            System.out.println(score);
        }
    }
}
