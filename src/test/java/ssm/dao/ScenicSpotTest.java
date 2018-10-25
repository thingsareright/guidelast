package ssm.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.dto.SearchScenicSpotInfo;
import ssm.dto.VoiceExplainInfo;
import ssm.entity.ScenicSpot;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class ScenicSpotTest {

    @Autowired
    private ScenicSpotDao scenicSpotDao;

    @Test
    public void findARecordTest(){
        List<ScenicSpot> scenicSpots = scenicSpotDao.findARecord();
        for (ScenicSpot scenicSpot :
                scenicSpots) {
            System.out.println(scenicSpot);
        }
    }

    @Test
    public void findMainInterfaceScenicSpotInfoTest() {
        List<ScenicSpot> scenicSpots = scenicSpotDao.findMostNearScenicSpot(12.3f, 12.4f);
        for (ScenicSpot scenicSpot :
                scenicSpots) {
            System.out.println(scenicSpot);
        }
    }

    @Test
    public void findVoiceExplainInfoByLocationTest() {
        VoiceExplainInfo voiceExplainInfo = scenicSpotDao.findVoiceExplainInfoByLocation(12.3f, 12.4f);
        System.out.println(voiceExplainInfo);
    }

    @Test
    public void findVoiceHelperDistinguishTest() {
        System.out.println(scenicSpotDao.findVoiceHelperDistinguish("图书"));
    }

    @Test
    public void findScenicSpotIntroduceInfoTest() {
        System.out.println(scenicSpotDao.findScenicSpotIntroduceInfo(1));
    }

    @Test
    public void searchScenicSpotByNameTest() {
        List<SearchScenicSpotInfo> searchScenicSpotInfos = scenicSpotDao.searchScenicSpotByName("书",0,10);
        for (SearchScenicSpotInfo searchScenicSpotInfo :
                searchScenicSpotInfos) {
            System.out.println(searchScenicSpotInfo);
        }
    }

    @Test
    public void searchScenicSpotRandomTest() {
        List<SearchScenicSpotInfo> searchScenicSpotInfos = scenicSpotDao.searchScenicSpotRandom();
        for (SearchScenicSpotInfo searchScenicSpotInfo :
                searchScenicSpotInfos) {
            System.out.println(searchScenicSpotInfo);
        }
    }

    @Test
    public void searchScenicSpotsByAreaTest() {
        List<SearchScenicSpotInfo> searchScenicSpotInfos = scenicSpotDao.searchScenicSpotsByArea(1,0,30);
        for (SearchScenicSpotInfo searchScenicSpotInfo :
                searchScenicSpotInfos) {
            System.out.println(searchScenicSpotInfo);
        }
    }

    @Test
    public void getHotMapPointsDaoTest() {
        System.out.println(scenicSpotDao.getHotMapPointsDao(10));
    }
}
