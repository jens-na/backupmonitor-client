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
public class ConfigDevice {
    
    private String id;
    private List<String> files = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }
}
