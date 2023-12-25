package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class SingleResourceStepDef {
    @Steps
    ReqresAPI reqresAPI;
    // scenario single resource
    @Given("Get single resource user with id{}")
    public void getSingleResource(String id){
        reqresAPI.getSingleResource(id);
    }
    @When("Send request get single resource user")
    public void sendRequestGetSingleResourceUser(){
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_RESOURCE);
    }

    @And("Validate get single resource json schema {string}")
    public void validateGetSingleResourceJsonSchema(String json) {
    File jsonSchema = new File(Constants.JSON_SCHEMA + json);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
}
    @And("Response body data_id should be {int}")
    public void responseBodyData_idShouldBe(int id) {
        SerenityRest.and().body(ReqresResponses.DATA_ID,equalTo(id));
    }

}
