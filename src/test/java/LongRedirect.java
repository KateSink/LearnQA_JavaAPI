import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


public class LongRedirect {

    @Test
    public void findUrl(){
        int i =0 ;
        String url = "https://playground.learnqa.ru/api/long_redirect";
        while (true){
           Response response = RestAssured
                   .given()
                   .redirects()
                   .follow(false)
                   .when()
                   .get(url)
                   .andReturn();
           int statusCode = response.getStatusCode();
           url = response.getHeader("location");
           if (statusCode == 200) {break;}
           System.out.println(url);
           i ++; }
        System.out.println(" Количество редиректов " + i);
    }
}


