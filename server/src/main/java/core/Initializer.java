package core;

import org.apache.catalina.filters.CorsFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Initializer implements ServletContextListener {

  static Logger logger = Logger.getLogger(Initializer.class.getName());

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    logger.log(Level.INFO, "Hello logger");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    logger.log(Level.INFO, "Bye bye logger");
  }
}
