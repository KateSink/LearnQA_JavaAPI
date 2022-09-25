import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class TestHeaders {
    @Test

    public void checkHeaders(){

        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/homework_header")
                .andReturn();

        Headers Headers = response.getHeaders();
        assertTrue(Headers.hasHeaderWithName("x-secret-homework-header"), "Response doesn't have 'x-secret-homework-header' Header");
        assertEquals("Some secret value", Headers.getValue("x-secret-homework-header"), "Response doesn't have 'Some secret value' Header's value");
    }
}

