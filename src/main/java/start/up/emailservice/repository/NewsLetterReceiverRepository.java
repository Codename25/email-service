package start.up.emailservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import start.up.emailservice.model.NewsLetterReceiver;

import java.util.Optional;

public interface NewsLetterReceiverRepository extends JpaRepository<NewsLetterReceiver, Long> {
    Optional<NewsLetterReceiver> findByEmail(String email);
}
