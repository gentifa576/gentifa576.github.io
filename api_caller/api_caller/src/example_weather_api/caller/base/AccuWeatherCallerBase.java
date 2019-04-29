package example_weather_api.caller.base;

import base.caller.ApiCallerBase;
import base.extra.HttpClientHandler;
import base.extra.HttpMethod;
import base.extra.HttpResult;

import java.util.Map;

public abstract class AccuWeatherCallerBase<TRequest, TResponse>
    extends ApiCallerBase<TRequest, TResponse> {
  private HttpClientHandler httpClient;

  public AccuWeatherCallerBase(HttpMethod httpMethod) {
    this.httpClient = new HttpClientHandler(httpMethod);
  }

  @Override
  public TResponse call(TRequest request) {
    try {
      Map<String, String> urlParam = generateRequest(request);
      String url = generateUrl(request);
      HttpResult result = httpClient.call(url, null, urlParam);
      return generateResponse(result);
    } catch (Exception e) {
      return null;
    }
  }
}
