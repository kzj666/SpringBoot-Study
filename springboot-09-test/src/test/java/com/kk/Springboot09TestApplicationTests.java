package com.kk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.swing.text.StyledEditorKit;
import java.io.File;

@SpringBootTest
class Springboot09TestApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        //一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("康梓健=彭于晏");
        mailMessage.setText("湖人总冠军");
        mailMessage.setTo("1950439407@qq.com");
        mailMessage.setFrom("2319680237@qq.com");

        mailSender.send(mailMessage);
    }

    @Test
    void contextLoads2() throws MessagingException {
        //复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        //正文
        helper.setSubject("湖人总冠军");
        helper.setText("<p style='color:red'>RIP,KOBE</p>",true);
        //附件
        helper.addAttachment("1.jpg", new File("C:\\Users\\asus\\Desktop\\1.jpg"));
        helper.addAttachment("2.jpg", new File("C:\\Users\\asus\\Desktop\\2.jpg"));
        //发送
        helper.setTo("1950439407@qq.com");
        helper.setFrom("2319680237@qq.com");

        mailSender.send(mimeMessage);

    }


    //封装成一个工具类
    /**
     *
     * @param html
     * @param subject
     * @param text
     * @throws MessagingException
     * @Author kzj
     */
    public void sendMail(Boolean html, String subject, String text) throws MessagingException {
        //复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, html);
        //正文
        helper.setSubject(subject);
        helper.setText(text,true);
        //附件
        helper.addAttachment("1.jpg", new File("C:\\Users\\asus\\Desktop\\1.jpg"));
        helper.addAttachment("2.jpg", new File("C:\\Users\\asus\\Desktop\\2.jpg"));
        //发送
        helper.setTo("1950439407@qq.com");
        helper.setFrom("2319680237@qq.com");

        mailSender.send(mimeMessage);
    }

}
