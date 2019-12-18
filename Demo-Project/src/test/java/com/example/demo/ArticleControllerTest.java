package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class ArticleControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("Article과 Comments 리스트를 한번에 저장")
    void save_article_with_comments() {
        ArticleDto articleDto = new ArticleDto("title", Arrays.asList("111", "222", "333"));

        webTestClient.post().uri("/articles")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(articleDto), ArticleDto.class)
                .exchange()
                .expectStatus().isOk();
    }
}
