package com.example.Capstone.Project.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailSender {
    /*private final String apiKey;


    public EmailSender(@Value("${sendgrid.api}") String apiKey) {
        this.apiKey = apiKey;
    }

    ;

    public void sendRegistrationEmail(UserDTO newUser) throws IOException {
        Email from = new Email("favabest@gmail.com");
        String subject = "Sending with SendGrid is Fun";
        Email to = new Email(newUser.email());
        Content content = new Content("text/plain", "Congratulation "+newUser.name()+" you have new account!!");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();

        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());
        Response response = sg.api(request);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        System.out.println(response.getHeaders());
    }*/
}
