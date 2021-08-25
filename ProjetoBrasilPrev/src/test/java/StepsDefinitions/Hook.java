package StepsDefinitions;

import BaseTest.VariaveisGlobais;

import static io.restassured.RestAssured.given;

import cucumber.api.java.*;

public class Hook extends VariaveisGlobais {

    private VariaveisGlobais base;

    public Hook(VariaveisGlobais base) {
        this.base = base;
    }

    @Before
    public void InicializeTest() {
        base.request = given().header("Accept", "application/json").header("Content-Type", "application/json");
    }
}
