/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.backupkueche.backupmonitor.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The scheduler class which checks if the remote host is available and sends
 * the jms message to the host.
 * 
 * @author jens-na
 */
public class BackupMonitorScheduler implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(
            BackupMonitorScheduler.class);

    @Override
    public void run() {
        // is host reachable
        // send jms message to server
    }
}
