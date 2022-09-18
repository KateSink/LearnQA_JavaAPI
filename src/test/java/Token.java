import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Token {
    @Test

    public void testToken() throws InterruptedException {

        JsonPath response = RestAssured
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();
        String token = response.get("token");
        int seconds = response.get("seconds");

        Map<String, String> params = new HashMap<>();
        params.put("token", token);

        JsonPath response2 = RestAssured
                .given()
                .queryParams(params)
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        String status = response2.get("status");
        if (status.equals("Job is NOT ready")) {
            Thread.sleep(seconds * 1000);
            JsonPath response3 = RestAssured
                    .given()
                    .queryParams(params)
                    .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                    .jsonPath();
            status = response3.get("status");
            String result = response3.get("result");
            if (status.equals("Job is ready") & (result == null)) {
                System.out.println("The key 'result' is absent");
            }
            System.out.println(status);
            System.out.println(result);
        } else System.out.println("Status is incorrect");
    }
}




