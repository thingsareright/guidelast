package ssm.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.dto.MainInterfaceScenicSpotInfo;
import ssm.service.impl.MapRelatedServiceImpl;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class MapRelatedServiceImplTest {

    @Autowired
    private MapRelatedServiceImpl mapRelatedService;

    @Test
    public void findMainInterfaceScenicSpotInfo(){
        List<MainInterfaceScenicSpotInfo> mainInterfaceScenicSpotInfos = mapRelatedService.findMainInterfaceScenicSpotInfo(11.1f,11.2f);
        for (MainInterfaceScenicSpotInfo mainInterfaceScenicSpotInfo :
                mainInterfaceScenicSpotInfos) {
            System.out.println(mainInterfaceScenicSpotInfo);
        }
    }

}
