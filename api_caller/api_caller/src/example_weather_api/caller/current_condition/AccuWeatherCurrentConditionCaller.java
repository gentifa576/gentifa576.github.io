package example_weather_api.caller.current_condition;

import base.extra.HttpMethod;
import base.extra.HttpResult;
import example_weather_api.caller.base.AccuWeatherCallerBase;

import java.util.HashMap;
import java.util.Map;

public class AccuWeatherCurrentConditionCaller
    extends AccuWeatherCallerBase<AccuWeatherCurrentConditionRequest, AccuWeatherCurrentConditionResponse> {
  private static String URL = "http://dataservice.accuweather.com/currentconditions/v1/";

  public AccuWeatherCurrentConditionCaller(HttpMethod httpMethod) {
    super(httpMethod);
  }

  @Override
  protected AccuWeatherCurrentConditionResponse generateResponse(HttpResult result) {
    return new AccuWeatherCurrentConditionResponse(result.getResponseCode(), result.getResponseMessage());
  }

  @Override
  protected Map<String, String> generateRequest(AccuWeatherCurrentConditionRequest accuWeatherCurrentConditionRequest) {
    Map<String, String> request = new HashMap<>();
    request.put("apikey", accuWeatherCurrentConditionRequest.getApiKey());
    request.put("language", accuWeatherCurrentConditionRequest.getLanguage());
    request.put("details", "false");
    return null;
  }

  @Override
  protected String generateUrl(AccuWeatherCurrentConditionRequest accuWeatherCurrentConditionRequest) {
    return URL + accuWeatherCurrentConditionRequest.getLocationKey();
  }
}
