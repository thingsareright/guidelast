package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.dto.ScenicAreaNameIntroPictureUrlInfo;
import ssm.service.ScenicAreaRelatedService;
import ssm.service.impl.ScenicAreaRelatedServiceImpl;

@Controller
@RequestMapping("/scenicArea")
public class ScenicAreaRelatedController {

    @Autowired
    ScenicAreaRelatedService scenicAreaRelatedService;

    @RequestMapping(value = "/getScenicAreaInfoById", method = RequestMethod.GET)
    @ResponseBody
    public ScenicAreaNameIntroPictureUrlInfo getScenicAreaInfoById(@RequestParam("scenicAreaId") int scenicAreaId) {
        //TODO 为了良好的用户体验，如果此处有异常，那么将会返回郑州大学的数据
        try {
            return scenicAreaRelatedService.findScenicAreaNameIntroPictureUrlInfoById(scenicAreaId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ScenicAreaNameIntroPictureUrlInfo("郑州大学", "郑州大学（Zhengzhou University）简称郑大，位于河南省会郑州，是中华人民共和国教育部与河南省共建的省属高水平大学，位列“211工程”、世界一流大学建设高校（B类）、“一省一校”、“111计划”重点建设高校，是“海外高层次人才引进计划”、“卓越工程师教育培养计划”、“卓越法律人才教育培养计划”、“卓越医生教育培养计划”、“国家建设高水平大学公派研究生项目”、“国家大学生创新性实验计划”入选高校，拥有国家大学科技园，具有自主招生资格。 [1] \n" +
                    "郑州大学医科教育源于1928年的国立第五中山大学，1952年河南医学院独立建院，开启了河南医学高等教育的先河，1984年，定名为河南医科大学；原郑州大学创建于1956年，是新中国创办的第一所综合性大学，1961年，郑州师范学院并入，1991年，黄河大学并入，1992年，河南体育专科学校并入；郑州工业大学成立于1963年，是原化工部直属的重点院校，1973年，河南农业大学粮油工业系并入;2000年7月，原郑州大学、郑州工业大学和河南医科大学三校合并组建新郑州大学。\n" +
                    "截至2018年3月，学校主、南、北、东四个校区共占地5700余亩，开设46个院系、114个本科专业；有24个博士后科研流动站、30个一级学科博士学位授权点、2个博士专业学位授权点，59个一级学科硕士学位授权点、25个硕士专业学位授权点、19个工程硕士领域；6个学科（领域）ESI排名全球前1%；教职工5700余人，专职院士8人 [2]  ；全日制普通本科生5.4万余人、研究生（含非全日制）1.9万余人","http://120.78.213.131:8080/guide_war/picture/xingzhenglou.jpg");
        }
    }
}
