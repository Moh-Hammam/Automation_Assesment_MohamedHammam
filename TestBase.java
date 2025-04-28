package base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
}
