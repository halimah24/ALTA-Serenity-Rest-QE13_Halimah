package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class ModifyDataStepDef {
    @Steps
    ReqresAPI reqresAPI;
    // scenario patch
    @Given("Modify name and job with json {string} and id parameter {int}")
    public void modifyUser(String json, int id) {
        File jsonModifyData = new File(Constants.REQ_BODY+json);
        reqresAPI.modifyUser(jsonModifyData, id);
    }
    @When("Send request name and job modify")
    public void sendRequestNameAndJobModify() {
        SerenityRest.when().patch(ReqresAPI.PATCH_USER);
    }

    @And("Validate modify json schema {string}")
    public void validateModifyJsonSchema(String arg0) {
    }
}
