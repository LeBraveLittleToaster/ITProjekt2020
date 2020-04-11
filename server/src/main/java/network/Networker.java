package network;

import com.google.gson.Gson;
import core.Core;
import datatypes.dbtypes.Patient;
import datatypes.nettypes.SimplePatientResponse;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.RoutingHandler;

public class Networker {

  private static final String QUERY_PATIENT_ID = "patientID";
  private static int PORT = 8080;
  private final Core _core;
  private Undertow _server;
  private Gson _gson;

  private final HttpHandler ROUTES = new RoutingHandler()
      .get("/patient", this::handlePatientRequest);
      //.post("/patient", this::handlePatientInsert);

  public Networker(Core core) {
    this._core = core;
    this._gson = new Gson();
  }

  public void createAndStartServer() {
    _server = Undertow.builder()
        .addHttpListener(PORT, "localhost", ROUTES).build();
    _server.start();
  }

  private void handlePatientRequest(HttpServerExchange exchange) {
    /*
    int patientID = Integer.parseInt(exchange.getQueryParameters().get(QUERY_PATIENT_ID).getFirst());
    Patient patient = this._core.handlePatientRequestById(patientID);
    if (patient == null) {
      exchange.getResponseSender().send(_gson.toJson(new SimplePatientResponse(false, null)));
    } else {
      exchange.getResponseSender().send(_gson.toJson(new SimplePatientResponse(true, patient)));
    }
    */
  }
}
