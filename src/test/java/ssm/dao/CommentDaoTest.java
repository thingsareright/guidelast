package ssm.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.entity.Comment;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class CommentDaoTest {

    @Autowired
    CommentDao commentDao;

    @Test
    public void findARecordTest(){
        List<Comment> comments = commentDao.findARecord();
        for (Comment comment :
                comments) {
            System.out.println(comment);
        }
    }
}
