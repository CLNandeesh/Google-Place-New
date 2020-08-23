package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import setup.BaseClass;

public class ReqResSpecUtil extends BaseClass {

	public static RequestSpecification reqSpecBuilder;
	public static ResponseSpecification resSpecBuilder;

	public static RequestSpecification requestSpecBuilder() throws FileNotFoundException {

		

		// log=new PrintStream(new File("logger.txt"));

		if (reqSpecBuilder == null) {
			// for logging
			log = new PrintStream(new FileOutputStream("Logging.txt", true));

			reqSpecBuilder = new RequestSpecBuilder().setContentType(ContentType.JSON)

					.addQueryParam("Key", "qaclick123").addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();

		}

		return reqSpecBuilder;
	}

	public static ResponseSpecification responseSpecBuilder() {
		resSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.expectHeader("Server", "Apache/2.4.18 (Ubuntu)").build();

		return resSpecBuilder;
	}

}
