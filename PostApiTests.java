package api;

import base.TestBase;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Posts API Testing")
@Feature("CRUD Operations on Posts")
class PostApiTests extends TestBase {

    @Test
    @Story("Create a new Post")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Create a post and verify the response body and status code.")
    void createPostAndAssertResult() {
        String requestBody = """
                {
                    "title": "foo",
                    "body": "bar",
                    "userId": 1
                }
                """;

        given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("title", equalTo("foo"))
                .body("body", equalTo("bar"))
                .body("userId", equalTo(1))
                .body("id", notNullValue());
    }

    @Test
    @Story("Get All Posts")
    @Severity(SeverityLevel.NORMAL)
    @Description("Retrieve all posts and assert total count.")
    void retrieveAllPostsAndAssertTotal() {
        Response response = given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .extract().response();

        int totalPosts = response.jsonPath().getList("$").size();
        assertEquals(100, totalPosts, "Total number of posts should be 100");
    }

    @Test
    @Story("Get Specific Post")
    @Severity(SeverityLevel.NORMAL)
    @Description("Retrieve specific post with id = 20 and assert on the result.")
    void retrieveSpecificPostAndAssertResult() {
        given()
                .when()
                .get("/posts/20")
                .then()
                .statusCode(200)
                .body("id", equalTo(20))
                .body("userId", notNullValue())
                .body("title", not(emptyString()))
                .body("body", not(emptyString()));
    }

    @Test
    @Story("Error Handling")
    @Severity(SeverityLevel.MINOR)
    @Description("Try to retrieve a non-existent post and expect 404.")
    void retrieveNonExistentPost_ShouldReturn404() {
        given()
                .when()
                .get("/posts/9999")
                .then()
                .statusCode(404);
    }

    @Test
    @Story("Error Handling")
    @Severity(SeverityLevel.MINOR)
    @Description("Try to create post with invalid body and validate error behavior.")
    void createPostWithInvalidBody_ShouldReturn201or400() {
        String invalidBody = "{ \"invalidField\": \"value\" }"; // Missing required fields

        given()
                .header("Content-Type", "application/json")
                .body(invalidBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(anyOf(is(201), is(400)));

    }
}
