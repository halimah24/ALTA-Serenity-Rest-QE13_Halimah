package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class ListResourceStepDef {

        @Steps
        ReqresAPI reqresAPI;

        //scenario list resource

        @Given("Get list resource user with page {}")
        public void getListResource(String id) {
            reqresAPI.getListResource(id);
        }

        @When("Send request get list resource user")
        public void sendRequestGetListResourceUser() {
            SerenityRest.when()
                    .get(ReqresAPI.GET_LIST_RESOURCE);
        }

        @And("Validate get list resource json schema {string}")
        public void validateGetListResourceJsonSchema(String json) {
            File jsonSchema = new File(Constants.JSON_SCHEMA + json);
            SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
        }
}