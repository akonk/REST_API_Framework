package com.RestApi.Payload;

import com.RestApi.Pojo.PojoModel;
import com.RestApi.Utils.ConfigManager;
import com.RestApi.constants.EndPoints;
import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.apache.http.HttpStatus;

import java.lang.reflect.Type;
import java.security.Key;
import java.util.List;

public class PayloadHelper {


    private static final String BASE_URL = ConfigManager.getInstance().getString("baseUrl");

    private static final String PORT = ConfigManager.getInstance().getString("port");


    public PayloadHelper(){
        RestAssured.baseURI=BASE_URL;
        RestAssured.port=Integer.parseInt(PORT);
    }

    public  List<PojoModel> getAllUsers(){
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get(EndPoints.GET_ALL_USERS)
                .andReturn();

        Type type = new TypeReference<List<PojoModel>>(){}.getType();

        List<PojoModel> UserList =  response.as(type);
        return UserList;
    }

}
