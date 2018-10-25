package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.ScenicAreaDao;
import ssm.dto.ScenicAreaNameIntroPictureUrlInfo;
import ssm.service.ScenicAreaRelatedService;

@Service
public class ScenicAreaRelatedServiceImpl implements ScenicAreaRelatedService {

    @Autowired
    ScenicAreaDao scenicAreaDao;

    @Override
    public ScenicAreaNameIntroPictureUrlInfo findScenicAreaNameIntroPictureUrlInfoById(int scenicAreaId) {
        return scenicAreaDao.findScenicAreaById(scenicAreaId);
    }
}
