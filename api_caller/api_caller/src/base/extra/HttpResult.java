package base.extra;

public class HttpResult {
  private final int responseCode;
  private final String responseMessage;

  public HttpResult(int responseCode, String responseMessage) {
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
