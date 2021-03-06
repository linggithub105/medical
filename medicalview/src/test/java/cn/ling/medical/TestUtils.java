package cn.ling.medical;

import cn.ling.medicalview.utils.common.MailTestComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.mail.MessagingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUtils {

    @Resource
    private MailTestComponent mailTestComponent;

    //直接发送连接验证
    //发送html自带模拟板验证
    @Test
    public void sendEmail() throws MessagingException {
        mailTestComponent.sendEmailMesssage("1342694153@qq.com");
    }
}
