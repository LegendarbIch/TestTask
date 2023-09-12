package com.example.testtask;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;
    HttpHeaders header = new HttpHeaders();

    @Test
    public void sending_json_to_the_server_with_a_post_method_and_getting_the_result() {


        String incomingJson = "{" +
                "               \"string\":\"aaaabbccc\" " +
                "              }";

        header.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> httpEntity = new HttpEntity<>(incomingJson, header);

        ResponseEntity<String> response = testRestTemplate.exchange("/api/parse/onsymbolscount", HttpMethod.POST, httpEntity, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("\"a\":4,\"c\":3,\"b\":2");
    }

    @Test
    public void send_an_empty_field_and_get_an_error() {

        String incomingJson = "{" +
                "               \"string\":\"\" " +
                "              }";

        header.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> httpEntity = new HttpEntity<>(incomingJson, header);

        ResponseEntity<String> response = testRestTemplate.exchange("/api/parse/onsymbolscount", HttpMethod.POST, httpEntity, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
