package network;

import com.google.gson.Gson;
import core.Core;
import datatypes.nettypes.SimpleUserResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/login")
public class LoginConnector extends HttpServlet {

  static Logger logger = Logger.getLogger(LoginConnector.class.getName());
  private static final Gson gson = new Gson();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    logger.log(Level.INFO, "Logintry by: " + req.getHeader("username"));
    if(req.getHeader("username") != null && req.getHeader("password") != null){
      resp.getWriter().write(gson.toJson(Core.getInstance().handleLogin(req.getHeader("username"), req.getHeader("password"))));
    }else{
      resp.getWriter().write(gson.toJson(new SimpleUserResponse(false)));
    }

  }

  @Override
  protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("OPTIONS CALL!");
    super.doOptions(req, resp);
  }
}
