package org.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.pages.GetPlaceAPI;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.utils.ApiActions;
import org.utils.JsonFileManager;

import static org.utils.ApiActions.getResponseJsonValue;

@Epic("Regression Tests")
@Feature("Places APIs tests")
public class PlacesTests {

    private GetPlaceAPI getPlaceAPI;
    String testDataMainPath = "src\\test\\java\\org\\testData";

    @Test(description = "Verify getting a place with valid country Abbreviation and postal code related to that country")
    @Severity(SeverityLevel.CRITICAL)
    public void getPlaceValidCountryAbbrPostal() {
        JsonFileManager jsonFileManager = new JsonFileManager(testDataMainPath+"\\ValidCountryAbbrPostalTestData.json");

        Response response = getPlaceAPI.getPlace(jsonFileManager.getTestData("\"country abbreviation\"")
                , jsonFileManager.getTestData("\"post code\"")
                , jsonFileManager.getTestDataAsInt("expectedStatusCode"));

        String actualCountryName = getResponseJsonValue(response, "country");
        String ExpectedCountryName = jsonFileManager.getTestData("country");
        String actualPlaceName = getResponseJsonValue(response, "places[0].\"place name\"");
        String ExpectedPlaceName = jsonFileManager.getTestData("places[0].\"place name\"");

        Assert.assertEquals(actualCountryName, ExpectedCountryName);
        Assert.assertEquals(actualPlaceName, ExpectedPlaceName);
    }

    @Test(description = "Verify getting a place with valid country Abbreviation and postal code not related to that country")
    @Severity(SeverityLevel.NORMAL)
    public void getPlaceInvalidCountryMismatchPostal() {
        JsonFileManager jsonFileManager = new JsonFileManager(testDataMainPath+"\\InvalidCountryMismatchPostalTestData.json");

        Response response = getPlaceAPI.getPlace(jsonFileManager.getTestData("\"country abbreviation\"")
                , jsonFileManager.getTestData("\"post code\"")
                , jsonFileManager.getTestDataAsInt("expectedStatusCode"));


        Assert.assertEquals(getResponseJsonValue(response, ""), "[:]");
    }

    @Test(description = "Verify getting a place with Invalid country Abbreviation and postal code")
    @Severity(SeverityLevel.NORMAL)
    public void getPlaceInvalidCountryPostal() {
        JsonFileManager jsonFileManager = new JsonFileManager(testDataMainPath+"\\InvalidCountryPostalTestData.json");

        Response response = getPlaceAPI.getPlace(jsonFileManager.getTestData("\"country abbreviation\"")
                , jsonFileManager.getTestData("\"post code\"")
                , jsonFileManager.getTestDataAsInt("expectedStatusCode"));

        Assert.assertEquals(getResponseJsonValue(response, ""), "[:]");
    }

    @Test(description = "Verify getting a place with valid country Name and postal code related to that country")
    @Severity(SeverityLevel.NORMAL)
    public void getPlaceValidCountryNamePostal() {
        JsonFileManager jsonFileManager = new JsonFileManager(testDataMainPath+"\\ValidCountryNamePostalTestData.json");

        Response response = getPlaceAPI.getPlace(jsonFileManager.getTestData("\"country abbreviation\"")
                , jsonFileManager.getTestData("\"post code\"")
                , jsonFileManager.getTestDataAsInt("expectedStatusCode"));

        Assert.assertEquals(getResponseJsonValue(response, ""), "[:]");
    }

    @BeforeClass
    public void setUp() {
        ApiActions apiObject = new ApiActions();
        getPlaceAPI = new GetPlaceAPI(apiObject);
    }

}
