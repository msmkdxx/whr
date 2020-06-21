package com.csj.cn.whr.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/1518:49
 */
@Component
public class MailUtils {
    @Autowired
    private JavaMailSender sender;
    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送带附件的邮件
     *
     * @param to
     * @param subject
     * @param content
     * @param filePath
     * @return
     */
    public boolean sendAttachmentsMail(String to, String subject, String content, String filePath,String fileName) {
        MimeMessage message = sender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            //接收者邮箱
            helper.setTo(to);
            //标题
            helper.setSubject(subject);
            //内容
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
//            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);

            sender.send(message);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
