package start.up.emailservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "newsletter_receiver_not_registered")
public class NewsLetterReceiver {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "newsletter_receiver_not_registered_id_seq")
    @SequenceGenerator(sequenceName = "newsletter_receiver_not_registered_id_seq", name = "newsletter_receiver_not_registered_id_seq", allocationSize = 1)
    private Long id;
    private String email;
    private String message;
}
