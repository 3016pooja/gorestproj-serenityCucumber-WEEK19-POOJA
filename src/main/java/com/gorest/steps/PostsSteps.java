package com.gorest.steps;

import com.gorest.constants.Endpoints;
import com.gorest.model.PostsPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PostsSteps {

    @Step("Getting all posts")
    public ValidatableResponse getAllPosts() {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 15205ae80891734995eabfbadcb20828670fb637b77f8326e3e9ad0fe155ad75")
                .when()
                .get(Endpoints.GET_ALL_POST)
                .then();
    }

    @Step
    public ValidatableResponse createPost(int id, int user_id, String title, String body) {
        PostsPojo postsPojo = new PostsPojo();
        postsPojo.setId(id);
        postsPojo.setUser_id(user_id);
        postsPojo.setTitle(title);
        postsPojo.setBody(body);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 15205ae80891734995eabfbadcb20828670fb637b77f8326e3e9ad0fe155ad75")
                .body(postsPojo)
                .when()
                .post(Endpoints.CREATE_POST)
                .then();
    }

    @Step
    public ValidatableResponse getPostByID(int postID) {

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 15205ae80891734995eabfbadcb20828670fb637b77f8326e3e9ad0fe155ad75")
                .pathParam("postID",postID)
                .when()
                .get(Endpoints.GET_POST_BY_ID)
                .then();
    }

    @Step("Update post with title")
    public ValidatableResponse updatePost(int postId, int id, int user_id, String title, String body) {
        PostsPojo postsPojo = new PostsPojo();
        postsPojo.setId(id);
        postsPojo.setUser_id(user_id);
        postsPojo.setTitle(title);
        postsPojo.setBody(body);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 15205ae80891734995eabfbadcb20828670fb637b77f8326e3e9ad0fe155ad75")
                .body(postsPojo)
                .pathParam("postID",postId)
                .when()
                .patch(Endpoints.UPDATE_POST_BY_ID)
                .then();
    }

    @Step
    public ValidatableResponse deletePosts(int userID) {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 15205ae80891734995eabfbadcb20828670fb637b77f8326e3e9ad0fe155ad75")
                .pathParam("userID",userID)
                .when()
                .delete(Endpoints.DELETE_POST_BY_ID)
                .then();
    }
}
