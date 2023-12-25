package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class ReqresAPI {
    public static String GET_LIST_USERS = Constants.BASE_URL + "/api/users?page={page}";
    public static String GET_SINGLE_USERS = Constants.BASE_URL +"/api/users/{page}";
    public static String GET_SINGLE_USERS_NOT_FOUND = Constants.BASE_URL + "//api/users/{page}";
    public static String GET_LIST_RESOURCE = Constants.BASE_URL+"/api/{id}";
    public static String GET_SINGLE_RESOURCE = Constants.BASE_URL+"/api/unknown/{id}";
    public static String POST_CREATE_USER = Constants.BASE_URL+"/api/users";
    public static String UPDATE_USER = Constants.BASE_URL + "/api/users/{id}";
    public static String DELETE_USER = Constants.BASE_URL + "/api/users/{id}";
    public static String POST_LOGIN = Constants.BASE_URL +"/api/login";
    public static String POST_REGISTER = Constants.BASE_URL +"/api/register";
    public static String PATCH_USER = Constants.BASE_URL +"/api/users/{id}";


    @Step("Get list users")
    public void getListUsers(int page) {
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("Post create new user")
    public void postCreateUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Update user")
    public void updateUser(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete user")
    public void deleteUser(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }
    // scenario login
    @Step("Post login user with json")
    public void postLoginUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    // scenario invalid login
    @Step("Post login invalid user with json")
    public void postLoginInvalidUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    //scenario register
    @Step("Post registration user")
    public void setPostRegistration(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    // scenario invalid
    @Step("Post registration invalid user")
    public void postRegistrationInvalid(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

//scenario single user
    @Step("Get single user")
    public void getSingleUser(String page){
        SerenityRest.given().pathParam("page",page);
    }
    // scenario single user not found
    @Step("Get single user not found page and json schema")
    public void getSingleUserNotFound(String page){
        SerenityRest.given().pathParam("page", page);
    }
    //scenario list resource
    @Step("Get list resource user with page")
    public void getListResource(String id){
        SerenityRest.given().pathParam("id", id);
    }

    //scenario single resource
    @Step("Get single resource user with page")
    public void getSingleResource(String id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Modify name and job with json")
    public void modifyUser(File json, int id){
        SerenityRest.given().contentType(ContentType.JSON).body(json).pathParam("id", id);
    }
}


