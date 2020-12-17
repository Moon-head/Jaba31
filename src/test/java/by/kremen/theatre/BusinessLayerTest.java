package by.kremen.theatre;

import by.kremen.theatre.service.MailSender;
import org.junit.Assert;
import org.junit.Test;

import javax.mail.MessagingException;

public class BusinessLayerTest {

    @Test
    public void SendEmail() throws MessagingException {
        MailSender ms = new MailSender();
        boolean test = ms.Send("test-title", "test-content", "kremen.den@gmail.com");
        Assert.assertTrue(test);
    }
}
