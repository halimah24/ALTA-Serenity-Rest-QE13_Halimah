package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class GetSingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;
    //scenario 1
    @Given("Get single user with page {string}")
    public void getSingleUserWithPage(String page) {
        reqresAPI.getSingleUser(page);
    }
    @When("Send request get single user")
    public void sendRequestGetSingleUser(){
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USERS);
    }

    //scenario single not found
    @Given("Get single user not found with page {string}")
    public void getSingleUserNotFoundWithPage (String page){
        reqresAPI.getSingleUserNotFound(page);
    }
    @When("Send request get single not found user")
    public void sendRequestGetSingleNotFound(){
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USERS_NOT_FOUND);
    }

}

