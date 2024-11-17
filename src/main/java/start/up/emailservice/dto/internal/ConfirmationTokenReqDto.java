package start.up.emailservice.dto.internal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfirmationTokenReqDto {
    private String receiver;
    private String token;
    private Long userId;
}
