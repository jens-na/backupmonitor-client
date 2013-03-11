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
    
    private ConfigHosts hosts;
    private ConfigDevice device;
    private ConfigUser user;

    public Configuration(ConfigHosts hosts, ConfigDevice device, ConfigUser user) {
        this.hosts = hosts;
        this.device = device;
        this.user = user;
    }
    
    public ConfigHosts getHosts() {
        return hosts;
    }

    public ConfigDevice getDevice() {
        return device;
    }

    public ConfigUser getUser() {
        return user;
    }   
    
}
