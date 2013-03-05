/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.backupkueche.backupmonitor.client.config;

/**
 *
 * @author jens
 */
public class Configuration {
    
    private ConfigJms jms;
    private ConfigDevice device;
    private ConfigUser user;

    public Configuration(ConfigJms jms, ConfigDevice device, ConfigUser user) {
        this.jms = jms;
        this.device = device;
        this.user = user;
    }
    
    public ConfigJms getJms() {
        return jms;
    }

    public ConfigDevice getDevice() {
        return device;
    }

    public ConfigUser getUser() {
        return user;
    }   
    
}
