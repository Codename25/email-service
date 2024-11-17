package start.up.emailservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import start.up.emailservice.model.NewsLetterReceiver;
import start.up.emailservice.repository.NewsLetterReceiverRepository;
import start.up.emailservice.service.NewsLetterReceiverService;

import java.util.Optional;

@Service
@AllArgsConstructor
public class NewsLetterReceiverServiceImpl implements NewsLetterReceiverService {
    private final NewsLetterReceiverRepository newsLetterReceiverRepository;

    @Override
    public NewsLetterReceiver add(NewsLetterReceiver model) {
        Optional<NewsLetterReceiver> byEmail = newsLetterReceiverRepository.findByEmail(model.getEmail());

        if (byEmail.isEmpty()) {
            return newsLetterReceiverRepository.save(model);
        }
        return byEmail.get();
    }
}
