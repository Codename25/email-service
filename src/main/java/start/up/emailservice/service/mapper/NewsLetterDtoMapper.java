package start.up.emailservice.service.mapper;

import org.springframework.stereotype.Component;
import start.up.emailservice.dto.NewsLetterReceiverReqDto;
import start.up.emailservice.model.NewsLetterReceiver;

@Component
public class NewsLetterDtoMapper {
    public NewsLetterReceiver toModel(NewsLetterReceiverReqDto dto) {
        NewsLetterReceiver model = new NewsLetterReceiver();
        model.setEmail(dto.getEmail());
        model.setMessage(dto.getMessage());

        return model;
    }
}
