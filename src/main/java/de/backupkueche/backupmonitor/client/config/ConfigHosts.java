/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.backupkueche.backupmonitor.client.config;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jens-na
 */
public class ConfigHosts {
    
    private List<ConfigHostEntry> entries = new ArrayList<>();

    public List<ConfigHostEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<ConfigHostEntry> entries) {
        this.entries = entries;
    }

    
}
