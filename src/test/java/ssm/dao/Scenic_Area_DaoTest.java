package ssm.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.entity.ScenicArea;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class Scenic_Area_DaoTest {

    @Autowired
    ScenicAreaDao scenic_areaDao;

    @Test
    public void findARecordTest() {
        List<ScenicArea> scenic_areas = scenic_areaDao.findARecord();
        for (ScenicArea scenic_area :
                scenic_areas) {
            System.out.println(scenic_area);
        }
    }

    @Test
    public void insertTest(){
        ScenicArea scenicArea = new ScenicArea("郑州大学","123",12.3f,12.3f,12.3f);

        scenic_areaDao.insertScenicAreaRecord(scenicArea);
    }

}
