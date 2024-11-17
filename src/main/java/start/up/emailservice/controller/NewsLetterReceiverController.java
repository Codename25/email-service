package start.up.emailservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import start.up.emailservice.dto.NewsLetterReceiverReqDto;
import start.up.emailservice.model.NewsLetterReceiver;
import start.up.emailservice.service.BuildEmailService;
import start.up.emailservice.service.NewsLetterReceiverService;
import start.up.emailservice.service.mapper.NewsLetterDtoMapper;

@RestController
@AllArgsConstructor
@RequestMapping("/api/email/newsletter")
public class NewsLetterReceiverController {
    private final NewsLetterDtoMapper newsLetterDtoMapper;
    private final NewsLetterReceiverService newsLetterReceiverService;

    @PostMapping
    public ResponseEntity<?> addNewsLetterReceiver(@RequestBody NewsLetterReceiverReqDto dto) {
        NewsLetterReceiver model = newsLetterDtoMapper.toModel(dto);
        NewsLetterReceiver add = newsLetterReceiverService.add(model);

        return ResponseEntity
                .status(201)
                .build();
    }
}
