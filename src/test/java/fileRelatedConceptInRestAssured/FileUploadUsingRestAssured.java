package fileRelatedConceptInRestAssured;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FileUploadUsingRestAssured {

	File file = new File("C:/Users/ankittolambiya/Downloads/sample_Image.png");

    Response response = RestAssured
            .given()
            .multiPart("file", file, "multipart/form-data")
            .post("https://qa-api-v2.ilendingdirect.com/document-service/lenders/Bl/document-types/468f3bbb-8983-4f7c-b05e-926211ce505e/documents/")
            .thenReturn();
    

   // System.out.println(response.prettyPrint());
}
