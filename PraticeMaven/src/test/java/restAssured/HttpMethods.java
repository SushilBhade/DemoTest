package restAssured;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HttpMethods {
@Test
public void getMethod() {
	Response resp=
			//given
			RestAssured.given()
			//when
			.when()
			.get("https://jsonplaceholder.typicode.com/posts/1");
	//then
	System.out.println("response body: "+resp.body().asPrettyString());
	System.out.println("response status code: "+resp.statusCode());
	System.out.println("**************header:"+resp.header("Date")+" **********");
	System.out.println("response header: "+resp.headers());
	System.out.println("**************");
	Headers head=resp.headers();
			List<Header> hd=head.asList();
			for(Header h:hd) {
				System.out.println(h.getName()+" "+h.getValue());
			}
			
}

@Test
public void postMethod() {
	Map<String,String> header= new HashMap<String, String>();
	header.put("Content-type","application/json");
	header.put("charset","UTF-8");
	
	
	Response resp= (Response) RestAssured.given()
							.body("{\r\n"
									+ "    \"title\": \"foo\",\r\n"
									+ "    \"body\": \"bar\",\r\n"
									+ "    \"userId\": \"1\",\r\n"
									+ "    \"id\": 101\r\n"
									+ "}")
							.header("Content-type","application/json")
							.header("charset","UTF-8")
	.headers(header)
	.when()
	.post("https://jsonplaceholder.typicode.com/posts");
	System.out.println("resp body: "+resp.body().asPrettyString());
	System.out.println("resp statuscode:"+resp.statusCode());
	System.out.println("Header: "+resp.header("Date"));
	
}


@Test
public void putMethod() {
	//given
 Response resp=(Response) RestAssured.given()
		 .body("{\r\n"
		 		+ "    id: 1,\r\n"
		 		+ "    title: 'foo',\r\n"
		 		+ "    body: 'bar',\r\n"
		 		+ "    userId: 1,\r\n"
		 		+ "  }")
		 		.header("Content-type","application/json")
		 		.header("castset","UTF-8")
		 		.when()
		 		.put("https://jsonplaceholder.typicode.com/posts/1");
 //then
 System.out.println("response body:"+resp.body().asPrettyString());
 System.out.println("Response Headers:"+resp.headers() );
 System.out.println("Status code: "+resp.statusCode());
 System.out.println("Status code: "+resp.statusLine());
		 		System.out.println("*****"+resp.getTime()+"********");
}

@Test
public void patchMethod() {
	//given
	Response resp=(Response)RestAssured.given()
							.body("{\r\n"
									+ "    title: 'foo',\r\n"
									+ "  }")	
							.header("Content-type","application/json")
							.header("charset","UTF-8")
							//when
							.when()
							.patch("https://jsonplaceholder.typicode.com/posts/1");
							//then
	System.out.println("*************Patch method***********");
	System.out.println("Response body:"+resp.body().asPrettyString());
	System.out.println("Response Headers: "+resp.header("Date"));
	System.out.println("StatusCode:"+resp.statusCode());
	System.out.println("********************");
		
}
@Test
public void queryParamTest() {
	Response resp=
			//given
			(Response)RestAssured.given()
										.param("userId", "1")
										.param("postId","1")
									//when	
										.when()
										.get("https://jsonplaceholder.typicode.com/posts");
	//then
	System.out.println("Response Bpdy: "+resp.body().asPrettyString());
	System.out.println("Statuscode:"+resp.statusCode());
	Assert.assertEquals(resp.statusCode(), 300);
}

}
