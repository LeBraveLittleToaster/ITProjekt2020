package core;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Initializer implements ServletContextListener {

  static Logger logger = Logger.getLogger(Initializer.class.getName());

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    logger.log(Level.INFO, "Hello logger");
    Core.getInstance();
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    logger.log(Level.INFO, "Bye bye logger");
  }
}
