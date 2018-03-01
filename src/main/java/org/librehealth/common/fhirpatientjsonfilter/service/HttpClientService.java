package org.librehealth.common.fhirpatientjsonfilter.service;
import com.bazaarvoice.jolt.JsonUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpClientService {

    private static HttpClient client = new DefaultHttpClient();

    /**
     * Retrive resource via REST in json format
     * @param url of resource
     * @return json string representation of resource
     */
    public static String getResource(String url) {
        try {

            HttpGet request = new HttpGet(url);

            // add header
            request.addHeader(HttpHeaders.ACCEPT_CHARSET, "utf-8");
            request.addHeader(HttpHeaders.ACCEPT, "application/fhir+json;q=1.0, application/json+fhir;q=0.9");
            request.addHeader(HttpHeaders.USER_AGENT, "HAPI-FHIR/3.1.0 (FHIR Client; FHIR 3.0.1/DSTU3; apache)");
            request.addHeader(HttpHeaders.CONTENT_TYPE, "application/fhir+json; charset=UTF-8");

            HttpResponse response = client.execute(request);

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            //System.out.println("Resource: \n"+
              //      JsonUtils.toPrettyJsonString(new JSONParser().parse(result.toString())));

            return result.toString();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return null;
    }

}
