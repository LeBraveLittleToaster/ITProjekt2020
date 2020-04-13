package network;

import com.google.gson.Gson;
import core.Core;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patient/projekts/data")
public class ProjektsConnector extends HttpServlet {

  private static final Gson gson = new Gson();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    System.out.println("Retrieving data");
    String userID;
    String token = req.getHeader("token");
    String projektID = req.getHeader("projektID");
    if(req.getHeader("token") != null
        && (userID = Core.getInstance().checkTokenAndGetUserID(token)) != null
        && projektID != null){
      resp.getWriter().write(gson.toJson(Core.getInstance().handleGetProjektData(projektID, userID)));
    }
  }
}
