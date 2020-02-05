package com.caguilera.rockpaperscissors.api;

import com.caguilera.rockpaperscissors.core.Shape;
import com.caguilera.rockpaperscissors.util.BaseWebIntegrationTest;
import com.caguilera.rockpaperscissors.util.WebIntegrationTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@WebIntegrationTest
@DisplayName("RockPaperScissorsController")
class RockPaperScissorsControllerITest extends BaseWebIntegrationTest {


    @Nested
    @DisplayName("POST /rps/play")
    class PlayTurn {


        @Test
        @DisplayName("given valid request must return 200 with game results")
        void validRequest() throws JsonProcessingException {

            given()
                    .contentType(ContentType.JSON)
                    .body(validPlayRequest())
                    .when()
                    .post(getUrl("/play"))
                    .then()
                    .statusCode(200)
                    .body(hasSameContentAs("validPlayRequest.json"));
        }

        private String validPlayRequest() throws JsonProcessingException {
            ObjectMapper objectMapper = new ObjectMapper();

            PlayRequestDto playRequest = new PlayRequestDto();

            playRequest.setGameId(25);
            playRequest.setPlayer1Choice(Shape.PAPER);
            playRequest.setPlayer2Choice(Shape.ROCK);

            return objectMapper.writeValueAsString(playRequest);
        }


    }

}