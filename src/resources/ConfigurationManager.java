package resources;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by IntelliJ IDEA.
 * User: Stepanov Dmitriy
 * Date: 4/16/12
 * Time: 8:25 AM
 */
public class ConfigurationManager {
    private static final String BUNDLE_NAME = "resources." + "MessageResources";
    private static ResourceBundle resourceBundle;
    private static ConfigurationManager instance;

    //класс извлекает информацию из файла config.properties
    static {
        resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, new Locale("", ""));
        ConfigurationManager instance = new ConfigurationManager();
    }

    public ConfigurationManager() {
    }

    public static String getProperty(String key) {
        return (String) resourceBundle.getObject(key);
    }
}