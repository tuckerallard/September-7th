package localhost.javaSailRest.employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


/**
 * 
 *
 * Sample class that posts to employee website
 *
 *@author Tucker Allard
 *@since 2016-09-07
 *
 */
public class Get {
	
	/**
     * The URL of the API we want to connect to
     */
	protected static String endpoint = "http://localhost:1337/employee";
	
	/**
     * The character set to use when encoding URL parameters
     */
	protected static String charset = "UTF-8";

	public static void main(String[] args) {

		try {
			
		    //The is of the user
			String userID = "id=13";

			//creates a new URL out of the endpoint, returnType and  queryString
			URL newEmployee = new URL(endpoint + "?" + userID);
			HttpURLConnection connection = (HttpURLConnection) newEmployee.openConnection();
			connection.setRequestMethod("GET");

			//if we did not get a 201 (success) throw an exception
			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
			}

			//read response into buffer
			BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

			//loop of buffer line by line until it return null meaning there are no more lines
			while (br.readLine() != null) {
				//print out each line to the screen
				System.out.println(br.readLine());
			}

			//close connection to API
			connection.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		
	}

}