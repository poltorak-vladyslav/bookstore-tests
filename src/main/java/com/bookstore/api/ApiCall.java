package com.bookstore.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.List;
import java.util.Map;

import static com.bookstore.configuration.ConfigurationManager.getConfiguration;
import static io.restassured.RestAssured.given;

public class ApiCall {

    private final RequestSpecBuilder requestSpecBuilder;
    private final Method method;
    private final String path;
    private int expectedStatusCode;

    public ApiCall(Method method, String path) {
        this.requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri(getConfiguration().baseUri())
                .setBasePath(getConfiguration().basePath())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addFilters(List.of(
                        new RequestLoggingFilter(),
                        new ResponseLoggingFilter(),
                        new AllureRestAssured()
                ));
        this.method = method;
        this.path = path;
        this.expectedStatusCode = HttpStatus.SC_OK;
    }

    public <T> ApiCall withBody(T body) {
        this.requestSpecBuilder.setBody(body);
        return this;
    }

    public ApiCall withPathParams(Map<String, String> pathParams) {
        this.requestSpecBuilder.addPathParams(pathParams);
        return this;
    }

    public ApiCall withExpectedStatusCode(int expectedStatusCode) {
        this.expectedStatusCode = expectedStatusCode;
        return this;
    }

    public Response execute() {
        return given(requestSpecBuilder.build())
                .request(method, path)
                .then()
                .statusCode(expectedStatusCode)
                .extract()
                .response();
    }
}
