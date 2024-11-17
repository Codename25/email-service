package start.up.emailservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NewsLetterReceiverReqDto {
    @Email
    @NotNull
    private String email;
    private String message;
}
