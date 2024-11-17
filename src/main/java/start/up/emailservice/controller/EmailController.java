package start.up.emailservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import start.up.emailservice.dto.internal.ConfirmationTokenReqDto;
import start.up.emailservice.service.BuildEmailService;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailController {
    private final BuildEmailService buildEmailService;

    // secured
    @PostMapping("/auth/validation")
    public void sendEmail(@RequestBody ConfirmationTokenReqDto dto) {
        buildEmailService.sendEmailForEmailConfirmationToken(dto);
    }

    @PostMapping("/password/reset")
    public void sendResetPasswordEmail(@RequestBody ConfirmationTokenReqDto dto) {
        buildEmailService.sendPasswordResetEmail(dto);
    }

}
