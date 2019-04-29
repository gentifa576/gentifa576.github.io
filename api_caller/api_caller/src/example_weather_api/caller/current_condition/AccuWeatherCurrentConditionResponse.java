package example_weather_api.caller.current_condition;

public class AccuWeatherCurrentConditionResponse {
  private final int responseCode;
  private final String responseMessage;

  public AccuWeatherCurrentConditionResponse(int responseCode, String responseMessage) {
    this.responseCode = responseCode;
    this.responseMessage = responseMessage;
  }

  public int getResponseCode() {
    return responseCode;
  }

  public String getResponseMessage() {
    return responseMessage;
  }
}
