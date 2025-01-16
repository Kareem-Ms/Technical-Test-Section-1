package org.pages;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.utils.ApiActions;
import org.utils.PropertiesManager;

public class GetPlaceAPI {

    public static final String BASE_URL = PropertiesManager.getProperty("GetPlaceURlPath");

    ApiActions apiActions;

    public GetPlaceAPI(ApiActions apiActions) {
        this.apiActions = apiActions;
    }

    @Step("Get place with Country Abbreviation: [{countryAbbreviation}] and Postal Code: [{postalCode}]")
    public Response getPlace(String countryAbbreviation, String postalCode, int statusCode) {
        String requestUrl = BASE_URL + countryAbbreviation + "/" + postalCode;
        return apiActions.performRequest("GET", requestUrl, statusCode, null, null, null, null, null);
    }


}
