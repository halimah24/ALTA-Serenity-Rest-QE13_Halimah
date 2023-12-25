package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.awt.*;
import java.io.File;

public class RegisterUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //scenario valid
    @Given("Post registration user with json {string}")
    public void postRegistrationUser(String json) {
        File jsonRegister = new File(Constants.REQ_BODY + json);
        reqresAPI.setPostRegistration(jsonRegister);
    }
    @When("Send request registration post registration user")
    public void sendRequestRegistrationUser() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER);
    }

    @And("Validate json schema {string}")
    public void validateJsonSchemaString(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA + json);
    }

    //scenario invalid

    @Given("Post registration with json {string}")
    public void postRegistrationWithJson(String json) {
        File jsonRegistrationInvalid = new File(Constants.REQ_BODY+json);
        reqresAPI.postRegistrationInvalid(jsonRegistrationInvalid);
    }

}
