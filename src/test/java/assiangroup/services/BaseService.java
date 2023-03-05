package assiangroup.services;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BaseService {
    protected RequestSpecification requestSpecification;
    protected String hostname;
    protected Response response;

    public BaseService(){

    }

    public BaseService(String hostname){
        this.hostname = hostname;
    }
    public void setRequestSpecification(String hostname){
        RestAssured.baseURI = this.hostname;
        this.requestSpecification = given();

    }

    public RequestSpecification getRequestSpecification(){
        return  this.requestSpecification;
    }

    public void setPost(HashMap headers, Object object, String endPointUrl){
        this. response = this.requestSpecification.headers(headers).
                body(object, ObjectMapperType.GSON).post(endPointUrl);
    }

    public void get(Headers headers,Object object, String endPointUrl){
        this. response = this.requestSpecification.headers(headers).
                body(object, ObjectMapperType.GSON).get(endPointUrl);
    }

    public Response getResponse(){
        return this.response;
    }
}
