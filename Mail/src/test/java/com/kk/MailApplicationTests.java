package com.kk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class MailApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    //普通邮件
    @Test
    void contextLoads() {
        //发送邮件
        //收件人
        //内容

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("湖人总冠军");
        message.setText("谁赞同，谁反对");

        message.setFrom("2319680237@qq.com");
        message.setTo("2319680237@qq.com");

        javaMailSender.send(message);
    }

    //复杂邮件
    @Test
    void test() throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        helper.setSubject("湖人总冠军");
        helper.setText("<h1>谁赞同，谁反对</h1>",true);//true是设置使用编码

        //附件
        helper.addAttachment("1.jpg", new File("F:\\IDEA_Project_Location\\狂神\\Mail\\mail\\src\\main\\resources\\1.jpg"));

        helper.setFrom("2319680237@qq.com");
        helper.setTo("2319680237@qq.com");

        javaMailSender.send(mimeMessage);

    }

}
