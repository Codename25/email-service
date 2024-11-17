package start.up.emailservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import start.up.emailservice.dto.internal.ConfirmationTokenReqDto;
import start.up.emailservice.model.NewsLetterEmail;
import start.up.emailservice.model.NewsLetterReceiver;
import start.up.emailservice.repository.NewsLetterReceiverRepository;
import start.up.emailservice.service.BuildEmailService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuildEmailServiceImpl implements BuildEmailService {
    @Value("${domain.frontend}")
    private String DOMAIN_FRONTEND;

    private final JavaMailSender mailSender;
    private final NewsLetterReceiverRepository newsLetterReceiverRepository;

    @Override
    public void sendEmailForEmailConfirmationToken(ConfirmationTokenReqDto dto) {
        String message = DOMAIN_FRONTEND + "/email/verification?token=" + dto.getToken() + "&userId=" + dto.getUserId();
        SimpleMailMessage email = buildMessage(dto.getReceiver(), "Email confirmation", message);

        mailSender.send(email);
    }

    @Override
    public void sendPasswordResetEmail(ConfirmationTokenReqDto dto) {
        String message = DOMAIN_FRONTEND + "/password/reset?token=" + dto.getToken();
        SimpleMailMessage email = buildMessage(dto.getReceiver(), "Reset password", message);

        mailSender.send(email);
    }

    @Override
    public void sendNewsLetterReceiverToAll(NewsLetterEmail email) {
        List<NewsLetterReceiver> all = newsLetterReceiverRepository.findAll();

        all.stream()
                .map(r -> buildMessage(r.getEmail(), email.getTitle(), email.getBody()))
                .forEach(mailSender::send);
    }

    private SimpleMailMessage buildMessage(String receiver, String subject, String message) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(receiver);
        email.setFrom("sviatoslav.pylyp@vistager.com");
        email.setSubject(subject);
        email.setText(message);

        return email;
    }
}
