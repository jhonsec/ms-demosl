package com.tdp.ms.demo.expose;

import java.util.HashMap;
import java.util.Map;

import com.tdp.genesis.core.constants.HttpHeadersKey;
import com.tdp.ms.demo.model.DemoRequest;
import com.tdp.ms.demo.model.DemoResponse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@SpringBootTest
@AutoConfigureWebTestClient(timeout = "20000")
public class DemoControllerTest {

    @Autowired
    private WebTestClient webClient;

    private static Map<String, DemoResponse> demoResponseMap = new HashMap<>();
    private static Map<String, DemoRequest> demoRequestMap = new HashMap<>();

    @BeforeAll
    public static void setup() {
        demoResponseMap.put("get", new DemoResponse("Hello world!"));
        demoResponseMap.put("post", new DemoResponse("User created!"));
        demoRequestMap.put("post", new DemoRequest("User"));
        demoRequestMap.put("empty", new DemoRequest(""));
    }

    @Test
    public void indexGetTest() {
        webClient.get()
            .uri("/demo/v1/greeting")
            .accept(MediaType.APPLICATION_JSON)
            .header(HttpHeadersKey.UNICA_SERVICE_ID,"550e8400-e29b-41d4-a716-446655440000")
            .header(HttpHeadersKey.UNICA_APPLICATION,"genesis")
            .header(HttpHeadersKey.UNICA_PID,"550e8400-e29b-41d4-a716-446655440000")
            .header(HttpHeadersKey.UNICA_USER,"genesis")
            .header("ClientId","12122322")
            .exchange()
            .expectStatus().isOk()
            .expectBody(DemoResponse.class)
            .isEqualTo(demoResponseMap.get("get"));
    }

    @Test
    public void indexPostTest() {
        webClient.post()
            .uri("/demo/v1/greeting")
            .accept(MediaType.APPLICATION_JSON)
            .header(HttpHeadersKey.UNICA_SERVICE_ID,"550e8400-e29b-41d4-a716-446655440000")
            .header(HttpHeadersKey.UNICA_APPLICATION,"genesis")
            .header(HttpHeadersKey.UNICA_PID,"550e8400-e29b-41d4-a716-446655440000")
            .header(HttpHeadersKey.UNICA_USER,"genesis")
            .body(BodyInserters.fromValue(demoRequestMap.get("post")))
            .exchange()
            .expectStatus().isEqualTo(HttpStatus.CREATED)
            .expectBody(DemoResponse.class)
            .isEqualTo(demoResponseMap.get("post"));
    }

}
