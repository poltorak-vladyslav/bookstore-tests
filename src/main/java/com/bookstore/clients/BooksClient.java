package com.bookstore.clients;

import com.bookstore.api.ApiCall;
import com.bookstore.models.BookModel;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static io.restassured.http.Method.DELETE;
import static io.restassured.http.Method.GET;
import static io.restassured.http.Method.POST;
import static io.restassured.http.Method.PUT;
import static org.apache.http.HttpStatus.SC_OK;

public class BooksClient {

    public static List<BookModel> fetchBooks() {
        Response response = new ApiCall(GET, "/v1/Books")
                .execute();
        return response.jsonPath().getList(".", BookModel.class);
    }

    public static BookModel fetchBook(String id) {
        return fetchBook(id, SC_OK, BookModel.class);
    }

    public static <T> T fetchBook(String id, int expectedStatusCode, Class<T> responseType) {
        Response response = new ApiCall(GET, "/v1/Books/{id}")
                .withExpectedStatusCode(expectedStatusCode)
                .withPathParams(Map.of("id", id))
                .execute();
        return response.as(responseType);
    }

    public static BookModel createBook(BookModel author) {
        Response response = new ApiCall(POST, "/v1/Books")
                .withBody(author)
                .execute();
        return response.as(BookModel.class);
    }

    public static BookModel updateBook(String id, BookModel author) {
        Response response = new ApiCall(PUT, "/v1/Books/{id}")
                .withPathParams(Map.of("id", id))
                .withBody(author)
                .execute();
        return response.as(BookModel.class);
    }

    public static String deleteBook(String id) {
        Response response = new ApiCall(DELETE, "/v1/Books/{id}")
                .withPathParams(Map.of("id", id))
                .execute();
        return response.asString();
    }
}
