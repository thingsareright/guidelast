package ssm.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.entity.Picture;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class PictureDaoTest {

    @Autowired
    private PictureDao pictureDao;

    @Test
    public void findARecordTest(){
        List<Picture> pictures = pictureDao.findARecord();
        for (Picture picture :
                pictures) {
            System.out.println(picture);
        }
    }
}
