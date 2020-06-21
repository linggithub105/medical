package cn.ling.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Component
public class MailTestComponent {
    @Resource
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromemail;

    //取自Thymeleaf
    @Resource
    TemplateEngine templateEngine;

    /**
     * 发送文本邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    public void sendTextMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to); // 发送对象
        message.setSubject(subject); // 邮件主题
        message.setText(content); // 邮件内容
        message.setFrom(fromemail); // 邮件的发起者
        javaMailSender.send(message);
    }


    //1：直接发送连接
    /**
     * 发送HTMl邮件
     * @param sendtoEmail
     * @throws MessagingException
     */
    public void sendEmailMesssage(String sendtoEmail) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("sendBaBa@163.com");
        //helper.setFrom(fromemail);
        helper.setSubject("你好");
        helper.setCc(fromemail);
        helper.setTo(sendtoEmail);

        helper.setText("<a href='http://localhost:8081/reguser?rid=3&email="+sendtoEmail+"'>李占领测试，进行验证 点击：Thank you for ordering!</a>",true);

        javaMailSender.send(message);

    }


    //2：发送网页模板
    public void sendJudgeMail(Integer id,String md5,String to,String userName) throws MessagingException {
        Context context = new Context();
        context.setVariable("userName", userName);
        context.setVariable("id", id);
        context.setVariable("time",new Date());
        context.setVariable("md5", md5);
        String emailContent = templateEngine.process("emailTemplate", context);
        System.out.println(emailContent);
        this.sendHtmlMail(to, "用户注册", emailContent);
    }
    /**
     * 发送HTMl邮件
     * @param to
     * @param subject
     * @param content
     * @throws MessagingException
     */
    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(fromemail);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        javaMailSender.send(message);
    }

}
