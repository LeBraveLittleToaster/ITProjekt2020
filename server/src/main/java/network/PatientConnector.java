package network;

import com.google.gson.Gson;
import core.Core;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patient/projekts")
public class PatientConnector extends HttpServlet {

  private static final Gson gson = new Gson();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String userID;
    if(req.getHeader("token") != null && (userID = Core.getInstance().checkTokenAndGetUserID(req.getHeader("token"))) != null){
      resp.getWriter().write(gson.toJson(Core.getInstance().handleGetPatientProjekts(userID)));
    }
  }
}
