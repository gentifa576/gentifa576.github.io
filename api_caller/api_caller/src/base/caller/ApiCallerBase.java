package base.caller;

import base.extra.HttpResult;

import java.util.Map;

public abstract class ApiCallerBase<TRequest, TResponse> {
  public abstract TResponse call(TRequest request);
  protected abstract TResponse generateResponse(HttpResult result);
  protected abstract Map<String, String> generateRequest(TRequest request);
  protected abstract String generateUrl(TRequest request);
}
