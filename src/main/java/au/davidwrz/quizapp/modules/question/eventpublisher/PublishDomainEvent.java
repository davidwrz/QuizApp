package au.davidwrz.quizapp.modules.question.eventpublisher;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
class PublishDomainEvent {

    private final WebClient webClient;

    private static final String PUBLISH_EVENT_URL = "http://localhost:8081/api/v1/external/competition/save";

    PublishDomainEvent(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(PUBLISH_EVENT_URL).build();
    }

    @EventListener
    public void domainEvent(DomainEvent domainEvent) {
        publishEvent(domainEvent);
    }

    private void publishEvent(DomainEvent domainEvent) {
        webClient.post()
                .uri(PUBLISH_EVENT_URL)
                .accept(APPLICATION_JSON)
                .header(AUTHORIZATION, String.format("Bearer %s", domainEvent.getJwt()))
                .body(Mono.just(domainEvent), DomainEvent.class)
                .retrieve()
                .toBodilessEntity()
                .subscribe();
    }
}
