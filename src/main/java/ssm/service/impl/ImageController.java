package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.dao.PictureDao;

import java.awt.*;
import java.io.File;
import java.util.List;

import static ssm.utils.FileUtils.getFileList;

/**
 * 仅用于数据库的填充
 */
@Controller
public class ImageController {

    @Autowired
    PictureDao pictureDao;

    @RequestMapping("/insertImage")
    @ResponseBody
    public String insertImage() {
        List<File> files = getFileList("C:\\Users\\DELL\\Pictures\\picture");
        for (File file :
                files) {
            pictureDao.insertPictureUrl(file.getName());
        }
        return "1";
    }
}
