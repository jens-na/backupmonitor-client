/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.backupkueche.backupmonitor.client.config;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Configuration file utilities
 *
 * @author jens-na
 */
public class ConfigUtils {

    private static final Logger log = LoggerFactory.getLogger(ConfigUtils.class);
    private static ConfigDevice device = null;
    private static ConfigHosts hosts = null;
    private static ConfigUser user = null;

    private ConfigUtils() {};
    
    /**
     * Returns all the necessary configurations for the client.
     * 
     * @return hosts, device, user configurations stored in a Configuration object.
     */
    public static Configuration getConfiguration() {
        return new Configuration(getConfigJms(), getConfigDevice(), 
                getConfigUser());
    }
    
    private static ConfigDevice getConfigDevice() {
        if(device == null) {
            initDevice();
        }
        return device;
    }

    private static void initDevice() {
        File file;
        File configDir = getConfigDir();
        file = new File(configDir, "device-config.xml");

        try {

            XStream xstream = new XStream();
            xstream.alias("device", ConfigDevice.class);

            device = (ConfigDevice) xstream.fromXML(new FileReader(file));

        } catch (FileNotFoundException ex) {
//            log.error("File '{}' not found.", "device-config.xml");
        }
    }

    private static ConfigUser getConfigUser() {
        if(user == null) {
            initUser();
        }
        return user;
    }

    private static void initUser() {
        File userFile;
        File configDir = getConfigDir();
        userFile = new File(configDir, "user-config.xml");

        try {
            XStream xstream = new XStream();
            xstream.alias("user", ConfigUser.class);

            user = (ConfigUser) xstream.fromXML(new FileReader(userFile));

        } catch (FileNotFoundException ex) {
//            log.error("File '{}' not found.", "user-config.xml");
        }
    }

    private static ConfigHosts getConfigJms() {
        if(hosts == null) {
            initHosts();
        }
        return hosts;
    }

    private static void initHosts() {
        File file;
        File configDir = getConfigDir();
        file = new File(configDir, "hosts-config.xml");

        try {
            XStream xstream = new XStream();
            xstream.alias("hosts", ConfigHosts.class);
            xstream.alias("entry", ConfigHostEntry.class);

            hosts = (ConfigHosts) xstream.fromXML(new FileReader(file));

        } catch (FileNotFoundException ex) {
//            log.error("File hosts-config.xml not found.");
        }
    }

    /**
     * Determines the locataion of the configuration file.
     *
     * @return the configuration file or <code>null</code> if no configuration
     * file could be determined. Probably unsupported OS.
     */
    private static File getConfigDir() {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.indexOf("win") > 0) {
            File curr = new File("");
            return new File(curr.getAbsolutePath(), "conf");
        } else if (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0
                || os.indexOf("aix") > 0) {
            return new File("/etc/backupmonitor");
        }

        return null;
    }
}