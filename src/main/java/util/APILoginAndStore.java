package util;



import java.util.ArrayList;
import java.util.HashMap;


import com.google.common.net.MediaType;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;



public class APILoginAndStore{
	public Variables v;
	public Variables isAPICall; 

	public APILoginAndStore() {
		v=new Variables();
	}

	public Variables jsonLogin(String strtEmailID, String strPassword,String strLoginURL,String strListURL){

		//String srtBaseURI="http://198.58.98.34:4350/api/user/login";
		String srtBaseURI=strLoginURL;
		//String strLoginBody="{\"email\":\"pradip@zaptechsolutions.com\",\"pass\": \"pradip123#\"}";
		String strLoginBody="{\"email\":\""+strtEmailID+"\",\"pass\": \""+strPassword+"\"}";
		Response res=postwithURL(srtBaseURI,strLoginBody);
		int intStatusCode=res.getStatusCode();
		if(intStatusCode!=200) {

			return v;
		}
		HashMap<?,?> apik=res.jsonPath().get("data");
		String body = res.getBody().asString();
		System.out.println(apik.containsKey("token"));
		System.out.println(apik.get("token"));
		System.out.println(body);

		String strContentType=res.getContentType();


		if(intStatusCode==200 &&strContentType.contains(""+MediaType.JSON_UTF_8)) {
			//String strBaseURI4LiveApp="http://198.58.98.34:4350/api/publish/list";

			String strBaseURI4LiveApp=strListURL;

			Response resLiveApp=postAuthenticaion(strBaseURI4LiveApp,apik.get("token").toString());
			System.out.println("Try"+resLiveApp.getBody().asString());


			//  Base
			v.type=resLiveApp.jsonPath().get("data.type").toString().replace("[", "").replace("]", "");
			v.setUser_id(resLiveApp.jsonPath().get("data.user_id").toString().replace("[", "").replace("]", ""));
			v.setId(resLiveApp.jsonPath().get("data.id").toString().replace("[", "").replace("]", ""));


			System.out.println("Type: "+v.type.replace("[", "").replace("]", ""));
			System.out.println("User ID: "+v.user_id.replace("[", "").replace("]", ""));
			System.out.println("ID: "+v.id.replace("[", "").replace("]", ""));


			// Step 1

			// App Name
			v.setApplication_name(resLiveApp.jsonPath().get("data.publish_data.step1.application_name").toString().replace("[", "").replace("]", ""));

			// App Type
			v.setApplication_type(resLiveApp.jsonPath().get("data.publish_data.step1.application_type").toString().replace("[", "").replace("]", ""));

			// App Website URL
			v.setApplication_website(resLiveApp.jsonPath().get("data.publish_data.step1.application_website").toString().replace("[", "").replace("]", ""));

			// App Email Address
			v.setApplication_email_address(resLiveApp.jsonPath().get("data.publish_data.step1.application_email_address").toString().replace("[", "").replace("]", ""));

			// App Phone screens
			v.setApplication_phone_screens(resLiveApp.jsonPath().get("data.publish_data.step1.application_phone_screens").toString().split(","));

			// App Privacy Policy
			v.setApplication_privacy_policy(resLiveApp.jsonPath().get("data.publish_data.step1.application_privacy_policy").toString().replace("[", "").replace("]", ""));

			// App Short Description
			v.setApplication_short_description(resLiveApp.jsonPath().get("data.publish_data.step1.application_short_description").toString().replace("[", "").replace("]", ""));

			// App Full Description
			v.setApplication_full_description(resLiveApp.jsonPath().get("data.publish_data.step1.application_full_description").toString().replace("[", "").replace("]", ""));

			// App Icon
			v.setApplication_icon(resLiveApp.jsonPath().get("data.publish_data.step1.application_icon").toString().replace("[", "").replace("]", ""));

			// App Phone Number
			v.setApplication_phone(resLiveApp.jsonPath().get("data.publish_data.step1.application_phone").toString().replace("[", "").replace("]", ""));

			// App Category
			v.setApplication_category(resLiveApp.jsonPath().get("data.publish_data.step1.application_category").toString().replace("[", "").replace("]", ""));

			// App Banner
			v.setApplication_banner(resLiveApp.jsonPath().get("data.publish_data.step1.application_banner").toString().replace("[", "").replace("]", ""));



			System.out.println("App Name: "+v.application_name.replace("[", "").replace("]", ""));
			System.out.println("Application_website: "+v.application_website.replace("[", "").replace("]", ""));
			System.out.println("Application_phone_screens: "+v.application_phone_screens[0].replace("[", "").replace("]", ""));
			System.out.println("Application_email_address: "+v.application_email_address.replace("[", "").replace("]", ""));
			System.out.println("Application_privacy_policy: "+v.application_privacy_policy.replace("[", "").replace("]", ""));
			System.out.println("Application_short_description: "+v.application_short_description.replace("[", "").replace("]", ""));
			System.out.println("Application_full_description: "+v.application_full_description.replace("[", "").replace("]", ""));
			System.out.println("Application_icon: "+v.application_icon.replace("[", "").replace("]", ""));



			return v;
			//System.out.println("App Name: "+v.application_name.replace("[", "").replace("]", ""));

			//			String[] arr=hashStep1.get(0).toString().split(",");
			//			for(int i=0;i<arr.length;i++) {
			//				System.out.println("Step 1: "+arr[i]);
			//			}
		}
		else return v;



	}

	//@Test(expectedExceptions=ElementNotVisibleException.class)
	public Response postwithURL(String baseURI,String strLoginBody) {
		Response response=null;
		RestAssured.baseURI =baseURI;

		response = RestAssured.given()
				.contentType("application/json").
				body(strLoginBody).
				when().
				post("");

		return response;
	}
	public Response postAuthenticaion(String baseURI1,String strHeader) {
		Response response=null;
		RestAssured.baseURI =baseURI1;

		response = RestAssured.given().header("Authorization",strHeader)
				.contentType("application/json").

				when().
				post("");
		System.out.println(response.getHeaders());
		return response;
	}
	public void test2() {
		System.out.println("I am in test2 test method and it will fail.");
	}
}
