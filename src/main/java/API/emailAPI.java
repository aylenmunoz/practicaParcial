package API;

import Sale.Orden;
import User.User;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

public class emailAPI {

    public static void emailSend(Orden orden, User user) throws IOException {
        Email from = new Email("micaaylenapi@gmail.com");
        Email to = new Email(user.getEmail());
        String subject = "Order Number: #" + orden.getOrdenNumber().toString();
        Content content = new Content("text/html", orden.emailOrder());

        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("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");
        Request request = new Request();

        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());
        try {
            Response response = sg.api(request);

            System.out.println(response.getStatusCode());
            System.out.println(response.getHeaders());
            System.out.println(response.getBody());
        } catch (IOException ex){
            throw ex;
        }
    }
    //api key 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
}

