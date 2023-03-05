package assiangroup.services;

import io.restassured.http.Header;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

public class getemployeeService extends BaseService {

    String endPointUrl = "api/v1/employees";
    public List<Header> headers = new ArrayList<Header>();
    public getemployeeService(){
        super("https://dummy.restapiexample.com/");
    }
    public void setHeaders(){
        headers.add(new Header("Accept","application/hal+json"));
        headers.add(new Header("Content-Type","application/jso"));
    }

    public Response getEmployeeData(String endPointUrl){
            return getRequestSpecification().get(endPointUrl);
    }


    public class ResponseBody{

    }

    public class FailedResponseBody{

    }
}