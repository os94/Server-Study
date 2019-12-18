package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class CommentControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("이미 Article이 있는 상황에서, Comment 저장")
    void save_comment_when_article_exist() {
        CommentDto commentDto = new CommentDto("ex-content");

        webTestClient.post().uri("/articles/1/comments")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(commentDto), CommentDto.class)
                .exchange()
                .expectStatus().isOk();
    }
}
