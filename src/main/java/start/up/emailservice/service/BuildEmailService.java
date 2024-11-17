package start.up.emailservice.service;

import start.up.emailservice.dto.internal.ConfirmationTokenReqDto;
import start.up.emailservice.model.NewsLetterEmail;

public interface BuildEmailService {
    void sendEmailForEmailConfirmationToken(ConfirmationTokenReqDto dto);

    void sendPasswordResetEmail(ConfirmationTokenReqDto dto);

    void sendNewsLetterReceiverToAll(NewsLetterEmail email);
}
