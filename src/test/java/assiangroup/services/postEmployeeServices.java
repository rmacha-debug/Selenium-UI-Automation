package assiangroup.services;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class postEmployeeServices extends BaseService{

    String endPointUrl = "api/v1/create";
    public List<Header> headers = new ArrayList<Header>();
    public postEmployeeServices(){
        super("https://dummy.restapiexample.com/");
    }
    public HashMap<String,String> setHeaders(){
      HashMap<String,String> headers = new HashMap<String, String>();
        headers.put("Accept","application/hal+json");
        headers.put("Content-Type","application/jso");
        return headers;
    }

    public Response createEmpData(String name, String salary, String age){
        setPost(setHeaders(),new createEmpData(name,salary, age),endPointUrl);
        return getResponse();
    }

    public class createEmpData{
        public String name;
        public String salary;
        public String age;

        public createEmpData(String name,String salary,String age)
        {
            this.name =name;
            this.salary = salary;
            this.age =age;
        }
    }

}
