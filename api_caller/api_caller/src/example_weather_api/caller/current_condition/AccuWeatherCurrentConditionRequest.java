package example_weather_api.caller.current_condition;

public class AccuWeatherCurrentConditionRequest {
  private final String apiKey;
  private final String locationKey;
  private final String language;

  public AccuWeatherCurrentConditionRequest(String apiKey,
                                            String locationKey,
                                            String language) {
    this.apiKey = apiKey;
    this.locationKey = locationKey;
    this.language = language;
  }

  public String getApiKey() {
    return apiKey;
  }

  public String getLocationKey() {
    return locationKey;
  }

  public String getLanguage() {
    return language;
  }
}
