package start.up.emailservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import start.up.emailservice.model.NewsLetterEmail;
import start.up.emailservice.service.BuildEmailService;

@RestController
@AllArgsConstructor
public class SendEmailsToNewsLetterReceiversController {
    private final BuildEmailService buildEmailService;

    @PostMapping("/send-email")
    public ResponseEntity<?> sendEmails(@RequestBody NewsLetterEmail newsLetterEmail) {
        buildEmailService.sendNewsLetterReceiverToAll(newsLetterEmail);

        return ResponseEntity.status(200).build();
    }
}
