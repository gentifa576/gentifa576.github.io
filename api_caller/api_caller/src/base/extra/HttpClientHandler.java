package base.extra;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

public class HttpClientHandler {
  private final HttpMethod httpMethod;

  public HttpClientHandler(HttpMethod httpMethod) {
    this.httpMethod = httpMethod;
  }

  public HttpResult call(String url, Map<String, String> headers, Map<String, String> urlParam) throws Exception {
    String param = constructUrlParam(urlParam);
    URL urlLink;
    switch (httpMethod) {
      case GET:
        urlLink = new URL(url + "?" + param);
        break;
      case POST:
      default:
        urlLink = new URL(url);
        break;
    }
    HttpURLConnection con = (HttpURLConnection) urlLink.openConnection();
    constructConnection(headers, con);
    switch (httpMethod) {

      case GET:
        break;
      case POST:
      default:
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(param);
        wr.flush();
        wr.close();
        break;
    }
    int responseCode = con.getResponseCode();
    String responseMessage = con.getResponseMessage();
    return new HttpResult(responseCode, responseMessage);
  }

  private String constructUrlParam(Map<String, String> urlParam) {
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<String, String> entry : urlParam.entrySet()) {
      sb
          .append(entry.getKey())
          .append("=")
          .append(entry.getValue())
          .append("&");
    }
    sb.deleteCharAt(sb.length()-1);
    return sb.toString();
  }

  private void constructConnection(Map<String, String> headers, HttpURLConnection con) throws ProtocolException {
    con.setRequestMethod(httpMethod.name());
    if (headers == null) return;
    for (Map.Entry<String, String> entry : headers.entrySet()) {
      con.setRequestProperty(entry.getKey(), entry.getValue());
    }
  }
}
