package uri.tech;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {
    public static String getApiKey() {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("config.properties"));
            return props.getProperty("api.key");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}