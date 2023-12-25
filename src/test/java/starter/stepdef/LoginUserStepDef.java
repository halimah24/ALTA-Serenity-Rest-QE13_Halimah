package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class LoginUserStepDef {
    @Steps
    ReqresAPI reqresAPI;
    //scenario valid
    @Given("Post login user with json {string}")
    public void postLoginUserWithJson(String json) {
            File jsonLogin = new File(Constants.REQ_BODY+json);
            reqresAPI.postLoginUser(jsonLogin);
        }
    @When("Send request with login user")
    public void sendRequestWithLogin(){
        SerenityRest.when().post(ReqresAPI.POST_LOGIN);
    }

    @And("Validate login user json schema {string}")
    public void validateLoginUserJsonSchema(String json) {
            File jsonLogin = new File(Constants.JSON_SCHEMA+json);
            reqresAPI.postLoginUser(jsonLogin);
        }
// scenario invalid 2
    @Given("Post login invalid user with json {string}")
    public void postLoginInvalidUserWithJson(String json) {
        File jsonLogin = new File(Constants.REQ_BODY + json);
        reqresAPI.postLoginInvalidUser(jsonLogin);
    }
}



