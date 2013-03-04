/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.backupkueche.backupmonitor.client;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main-Class
 * 
 * @author jens-na
 */
public class BackupMonitorClient {

    private static final Logger log = LoggerFactory.getLogger(
            BackupMonitorClient.class);

    /**
     * main method with the argument array (args).
     * 
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        BackupMonitorScheduler backupScheduler = new BackupMonitorScheduler();
        
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> future = scheduler.scheduleAtFixedRate(backupScheduler,
                1, 10, TimeUnit.SECONDS);
        
    }
}
