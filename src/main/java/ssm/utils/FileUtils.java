package ssm.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 仅仅用于方便填充数据库
 */
public class FileUtils {
    public static List<File> getFileList(String strPath) {
        File dir = new File(strPath);
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
        List<File> filelist = new ArrayList<File>();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) { // 判断是文件还是文件夹
                    getFileList(files[i].getAbsolutePath()); // 获取文件绝对路径
                } else if (fileName.endsWith("jpeg")) { // TODO 这一点很关键，用于规定添加哪种后缀名的图片
                    String strFileName = files[i].getAbsolutePath();
                    System.out.println("---" + strFileName);
                    filelist.add(files[i]);
                } else {
                    continue;
                }
            }
        }
        return filelist;
    }

    public static void main(String[] args) {
        List<File> files = getFileList("C:\\Users\\DELL\\Pictures\\picture");
        for (File file :
                files) {
            System.out.println(file.getName());
        }
    }

}
