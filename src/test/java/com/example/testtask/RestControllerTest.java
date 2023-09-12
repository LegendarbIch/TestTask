package com.example.testtask;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.Collections;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void sending_json_to_the_server_with_a_post_method_and_getting_the_result() {
        HttpHeaders header = new HttpHeaders();

        String incomingJson = "{" +
                "               \"string\":\"aaaabbccc\" " +
                "              }";

        header.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> httpEntity = new HttpEntity<>(incomingJson, header);

        ResponseEntity<String> response = testRestTemplate.exchange("/api/parse/onsymbolscount", HttpMethod.POST, httpEntity, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("\"a\":4,\"c\":3,\"b\":2");
    }

}
