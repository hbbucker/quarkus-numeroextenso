package br.com.bucker.numextenso;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class TraduzirNumeroControllerTest {

    Integer[] num1 = {0, 4, 13, 45, 3060, 101, 1001, 5483, 99999, -78987};
    String[] ret = {"zero", "quatro", "treze", "quarenta e cinco", "três mil e sessenta",
            "cento e um", "mil e um", "cinco mil e quatrocentos e oitenta e três",
            "noventa e nove mil e novecentos e noventa e nove",
            "menos setenta e oito mil e novecentos e oitenta e sete"};

    @Test
    public void testTraduzirNumero() {

        for (int i = 0; i < num1.length; i++) {
            given().contentType(ContentType.JSON)
                    .when().get("/" + num1[i])
                    .then()
                    .statusCode(200)
                    .body("extenso", is(ret[i]));
        }
    }

}