package com.bookstore.clients;

import com.bookstore.api.ApiCall;
import com.bookstore.models.AuthorModel;
import io.restassured.http.Method;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class AuthorsClient {

    public static List<AuthorModel> getAuthors() {
        Response response = new ApiCall(Method.GET, "/v1/Authors")
                .execute();
        return response.jsonPath().getList(".", AuthorModel.class);
    }

    public static AuthorModel getAuthor(String id) {
        Response response = new ApiCall(Method.GET, "/v1/Authors/{id}")
                .withPathParams(Map.of("id", id))
                .execute();
        return response.as(AuthorModel.class);
    }
}
