
package utils;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;


/**
 *
 * @author Rashan
 */
public class Logger {

    public static java.util.logging.Logger logger = java.util.logging.Logger.getLogger("pos");

    String url = "/resourse/eye1.png";

    public  Logger() {
        try {
            FileHandler handler = new FileHandler("pos_of_roxeleye.log", true);
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
        } catch (Exception e) {
            logger.log(Level.WARNING, "logger", e);
        }

    }

}
