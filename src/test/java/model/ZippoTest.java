package model;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ZippoTest {
    @Test
    public void test() {

        given()
                // Preparation procedures : (token, send body, parameters)


                .when()
                // Endpoint (url), method


                .then()
                // Assertion, test, data operations

        ;
    }

    @Test
    public void statusCodeTest() {

        given()


                .when()
                .get("http://api.zippopotam.us/us/90210")


                .then()
                .log().body()    // Returning body json data, log().all()
                .statusCode(200) // Is return code 200 ?
        ;
    }

    @Test
    public void contentTypeTest() {

        given()


                .when()
                .get("http://api.zippopotam.us/us/90210")


                .then()
                .log().body()    // Returning body json data, log().all()
                .statusCode(200) // Is return code 200?
                .contentType(ContentType.JSON) // Is the returned result JSON?
        ;
    }

    @Test
    public void checkCountryInResponseBody() {

        given()


                .when()
                .get("http://api.zippopotam.us/us/90210")


                .then()
                .log().body()    // Returning body json data, log().all()
                .statusCode(200) // Is return code 200?
                .body("country",equalTo("United States")) // Is body's country variable equal to "United States"?
        ;
    }

    @Test
    public void checkStateInResponseBody() {

        given()


                .when()
                .get("http://api.zippopotam.us/us/90210")


                .then()
                .log().body()    // Returning body json data, log().all()
                .statusCode(200) // Is return code 200?
                .body("places[0].state",equalTo("California")) // Is body's country variable equal to "United States"?
        ;
    }

    @Test
    public void checkHasItem() {

        given()


                .when()
                .get("http://api.zippopotam.us/tr/01000")


                .then()
               .log().body()    // Returning body json data, log().all()
                .statusCode(200) // Is return code 200?
                .body("places.'place name'",hasItem("Dörtağaç Köyü")) // Is there a "Dörtağaç Köyü" in the place names?
        ;
    }

    @Test
    public void bodyArrayHasSizeTest() {

        given()


                .when()
                .get("http://api.zippopotam.us/us/90210")


                .then()
                .log().body()    // Returning body json data, log().all()
                .statusCode(200) // Is return code 200?
                .body("places",hasSize(1))
        ;
    }


    @Test
    public void combinigTest() {

        given()


                .when()
                .get("http://api.zippopotam.us/us/90210")


                .then()
                .log().body()    // Returning body json data, log().all()
                .statusCode(200) // Is return code 200?
                .body("places",hasSize(1)) // Is size "1" ?
                .body("places.state",hasItem("California")) // Does the list in the given path have this item?
                .body("places[0].'place name'",equalTo("Beverly Hills")) // Is the value in the given path equal to this?
        ;
    }

    @Test
    public void pathParamTest() {

        given()
                .pathParam("country","us")
                .pathParam("zipCode",90210)
                .log().uri()


                .when()
                .get("http://api.zippopotam.us/{country}/{zipCode}")


                .then()
                //.log().body()    // Returning body json data, log().all()
                .statusCode(200) // Is return code 200?
        ;
    }

}