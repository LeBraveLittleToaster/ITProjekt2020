package network;

import com.google.gson.Gson;
import core.Core;
import datatypes.dbtypes.User;
import datatypes.nettypes.SimpleUserResponse;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.RoutingHandler;
import io.undertow.util.HeaderMap;
import io.undertow.util.HttpString;

import javax.security.auth.login.Configuration;

public class Networker {

  private static final String QUERY_PARAM_TOKEN = "token";
  private static final String HEADER_USERNAME = "username";
  private static final String HEADER_PASSWORD = "password";
  private static int PORT = 8080;
  private final Core _core;
  private Undertow _server;
  private Gson _gson;

  private final HttpHandler ROUTES = new RoutingHandler()
      .get("/login", this::handleLoginRequest);

  public Networker(Core core) {
    this._core = core;
    this._gson = new Gson();
  }

  public void createAndStartServer() {
    _server = Undertow.builder()
        .addHttpListener(PORT, "localhost", ROUTES).build();
    _server.start();
  }

  private void handleLoginRequest(HttpServerExchange exchange){
    exchange.getResponseHeaders().put(new HttpString("Access-Control-Allow-Origin"), "*");
    exchange.getResponseHeaders().put(new HttpString("Access-Control-Allow-Headers"), "origin, content-type, accept, authorization, auth-token, username, password");
    exchange.getResponseHeaders().put(new HttpString("Access-Control-Allow-Credentials"), "true");
    exchange.getResponseHeaders().put(new HttpString("Access-Control-Allow-Methods"), "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    exchange.getResponseHeaders().put(new HttpString("Access-Control-Max-Age"), "1209600");
    SimpleUserResponse rsp = new SimpleUserResponse(false);
    if(exchange.getRequestHeaders().contains(HEADER_USERNAME)
        && exchange.getRequestHeaders().contains(HEADER_PASSWORD)){
      String uname = exchange.getRequestHeaders().get(HEADER_USERNAME).getFirst();
      String pwhash = exchange.getRequestHeaders().get(HEADER_PASSWORD).getFirst();
      rsp = _core.handleLogin(uname, pwhash);
    }
    exchange.getResponseSender().send(_gson.toJson(rsp));
  }

  private static void setupResponseHeaders(final HttpServerExchange exchange) {
    final HeaderMap headerMap = exchange.getResponseHeaders();
    headerMap.add(new HttpString("Access-Control-Allow-Origin"), "*");
  }
}
