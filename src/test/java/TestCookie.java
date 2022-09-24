import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCookie {
    @Test

        public void checkCookie(){

        Response response = RestAssured
                    .get("https://playground.learnqa.ru/api/homework_cookie")
                    .andReturn();

        Map<String,String> cookie = response.getCookies();
        assertTrue(cookie.containsKey("HomeWork"), "Response doesn't have 'HomeWork' cookie");
        assertTrue(cookie.containsValue("hw_value"), "Response doesn't have 'hw_value' value");
        }
}
