package ssm.utils;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailUtil {

    //email 你要发给谁      //authcode  验证码
    public static void email(String email,Integer authcode)throws Exception {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");//发送邮件协议
        properties.setProperty("mail.smtp.auth", "true");//需要验证
        //properties.setProperty("mail.debug", "true");//设置debug模式 后台输出邮件发送的过程
        Session session = Session.getInstance(properties);
        session.setDebug(true);//debug模式
        //邮件信息
        Message messgae = new MimeMessage(session);
        messgae.setFrom(new InternetAddress("2271366490@qq.com"));//设置发送人
        messgae.setText("你的验证码为："+authcode+"。请注意，验证码有效时间为10分钟！！！");//设置邮件内容
        messgae.setSubject("邮箱验证");//设置邮件主题
        //发送邮件
        Transport tran = session.getTransport();
        //tran.connect("smtp.sina.com", 25, "邮箱账户", "邮箱授权码");//连接到新浪邮箱服务器
        tran.connect("smtp.qq.com",587, "2271366490@qq.com", "lxghjlbyuapbeajf");//连接到QQ邮箱服务器
        tran.sendMessage(messgae, new Address[]{ new InternetAddress(email)});//设置邮件接收人
        tran.close();
    }

    public static void main(String[] args){
        try {
            email("mengleizzu@163.com", Integer.valueOf("666666"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
