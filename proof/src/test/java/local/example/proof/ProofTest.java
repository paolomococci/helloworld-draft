package local.example.proof;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ProofTest {

    @Test
    public void mainViewEndpointTest() {
        given()
          .when().get("/")
          .then()
             .statusCode(200);
    }
}
