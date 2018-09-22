package ssm.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.dto.MainInterfaceScenicSpotInfo;
import ssm.dto.SearchScenicSpotInfo;
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

    @Test
    public void requestScenicSpotIntroduceInfoTest() {
        System.out.println(mapRelatedService.requestScenicSpotIntroduceInfo(1));
    }

    @Test
    public void searchScenicSpotRandomTest() {
        List<SearchScenicSpotInfo> searchScenicSpotInfos = mapRelatedService.searchScenicSpotRandom();
        for (SearchScenicSpotInfo searchScenicSpotInfo :
                searchScenicSpotInfos) {
            System.out.println(searchScenicSpotInfo);
        }
    }

}
