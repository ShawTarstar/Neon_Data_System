package com.taxing.tliaswebmanagement;

import com.taxing.tliaswebmanagement.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestMail {
    @Autowired
    private MailService mailService;

    @Test
    public void testSend() {
        mailService.sendSimpleMail(
                "56128639@qq.com",
                "测试邮件标题",
                "你好！这是一封来自 Spring Boot 的测试邮件。"
        );
    }

}
