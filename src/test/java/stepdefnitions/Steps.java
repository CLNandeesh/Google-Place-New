package stepdefnitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import resources.APIResource;
import resources.DataBuild;
import setup.BaseClass;
import utilities.ReqResSpecUtil;
import utilities.ValidationUtils;

import static org.hamcrest.Matchers.*;

import java.io.FileNotFoundException;

import org.testng.Assert;

import static io.restassured.RestAssured.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Steps extends BaseClass {

	//ADD PLACE
	@Given("I have Add Place Payload with name as {string}")
	public void i_have_add_place_payload_with_name_as(String name) throws FileNotFoundException {

		// RestAssured.baseURI="https://rahulshettyacademy.com";

		requestSpecification = given().spec(ReqResSpecUtil.requestSpecBuilder()).body(DataBuild.addPlacePayload(name));

	}
	
	
	//GET PLACE
	@Given("I have  Place ID")
	public void i_have_place_id() throws FileNotFoundException {
	   
		requestSpecification=given().queryParam("key","qaclick123").log().all().queryParam("place_id",place_id);
	}


	/*
	 * @When("I hit the resource {string} with HTTP {string} method") public void
	 * i_hit_the_resource_with_http_method(String resource, String httpMethod) {
	 * 
	 * APIResource resourceAPI = APIResource.valueOf(resource);
	 * 
	 * if (httpMethod.equalsIgnoreCase("POST")) { response =
	 * requestSpecification.when().post(resourceAPI.getResource()); } else if
	 * (httpMethod.equalsIgnoreCase("GET")) { response =
	 * requestSpecification.when().get("" + resource + ""); }
	 * 
	 * else if (httpMethod.equalsIgnoreCase("DELETE")) { response =
	 * requestSpecification.when().delete("" + resource + ""); }
	 * 
	 * // System.out.println(response.asString());
	 * 
	 * }
	 */

	@When("I hit {string} with HTTP {string} method")
	public void i_hit_with_http_method(String resource, String httpMethod) {

		APIResource resourceAPI = APIResource.valueOf(resource);

		if (httpMethod.equalsIgnoreCase("POST")) {
			response = requestSpecification.when().post(resourceAPI.getResource());
		} else if (httpMethod.equalsIgnoreCase("GET")) {
			response = requestSpecification.when().log().all().get(resourceAPI.getResource());
		}

		else if (httpMethod.equalsIgnoreCase("DELETE")) {
			response = requestSpecification.when().delete(resourceAPI.getResource());
		} else if (httpMethod.equalsIgnoreCase("PUT")) {
			response = requestSpecification.when().put(resourceAPI.getResource());
		}
		
		place_id=ValidationUtils.getValueFoKey(response.asString(),"place_id");
	}

	@Then("I get status code as {string}")
	public void i_get_status_code_as(String statusCode) {

		int code = Integer.parseInt(statusCode);
		// System.out.println(response.statusCode());

		// response.then().spec(ReqResSpecUtil.responseSpecBuilder());
		// Assert.assertEquals(code, response.statusCode());
		response.then().assertThat().statusCode(code);

		// System.out.println(response.then().extract().response().asString());
	}

	@And("key {string} in response is the value {string}")
	public void key_in_response_is_the_value(String key, String value) {

		// System.out.println(ValidationUtils.getValueFoKey(response.asString(), key));
		Assert.assertEquals(value, ValidationUtils.getValueFoKey(response.asString(), key));
	}

}
