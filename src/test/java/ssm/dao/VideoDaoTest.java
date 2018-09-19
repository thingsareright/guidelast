package ssm.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.entity.Video;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class VideoDaoTest {

    @Autowired
    VideoDao videoDao;

    @Test
    public void findARecordTest(){
        List<Video> videos = videoDao.findARecord();
        System.out.println(videos);
        for (Video video:
             videos) {
            System.out.println(video);
        }
    }
}
