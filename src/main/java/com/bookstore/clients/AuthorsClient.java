package com.bookstore.clients;

import com.bookstore.api.ApiCall;
import com.bookstore.models.AuthorModel;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static io.restassured.http.Method.DELETE;
import static io.restassured.http.Method.GET;
import static io.restassured.http.Method.POST;
import static io.restassured.http.Method.PUT;
import static org.apache.http.HttpStatus.SC_OK;

public class AuthorsClient {

    public static List<AuthorModel> fetchAuthors() {
        Response response = new ApiCall(GET, "/v1/Authors")
                .execute();
        return response.jsonPath().getList(".", AuthorModel.class);
    }

    public static AuthorModel fetchAuthor(String id) {
        return fetchAuthor(id, SC_OK, AuthorModel.class);
    }

    public static <T> T fetchAuthor(String id, int expectedStatusCode, Class<T> responseType) {
        Response response = new ApiCall(GET, "/v1/Authors/{id}")
                .withExpectedStatusCode(expectedStatusCode)
                .withPathParams(Map.of("id", id))
                .execute();
        return response.as(responseType);
    }

    public static AuthorModel createAuthor(AuthorModel author) {
        Response response = new ApiCall(POST, "/v1/Authors")
                .withBody(author)
                .execute();
        return response.as(AuthorModel.class);
    }

    public static AuthorModel updateAuthor(String id, AuthorModel author) {
        Response response = new ApiCall(PUT, "/v1/Authors/{id}")
                .withPathParams(Map.of("id", id))
                .withBody(author)
                .execute();
        return response.as(AuthorModel.class);
    }

    public static String deleteAuthor(String id) {
        Response response = new ApiCall(DELETE, "/v1/Authors/{id}")
                .withPathParams(Map.of("id", id))
                .execute();
        return response.asString();
    }
}
