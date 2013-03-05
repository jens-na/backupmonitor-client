/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.backupkueche.backupmonitor.client;

import de.backupkueche.backupmonitor.client.config.Configuration;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The scheduler class which checks if the remote host is available and sends
 * the jms message to the host.
 * 
 * @author jens-na
 */
public class BackupMonitorScheduler implements Runnable {

    private Configuration configuration;
    
    public BackupMonitorScheduler(Configuration configuration) {
        this.configuration = configuration;
    }
    
    private static final Logger log = LoggerFactory.getLogger(
            BackupMonitorScheduler.class);

    @Override
    public void run() {
        try {
            String jmsAddr = configuration.getJms().getAddress();
            InetAddress addr = InetAddress.getByName(jmsAddr);
            
            if(addr.isReachable(1000)) {
                System.out.println("host reachable");
                
                if(send()) {
                    System.exit(0);
                }  
            }
            else {
                System.out.println("cannot establish connection");
            }
            
        } catch (UnknownHostException ex) {
            //log.debug("host is not reachable at the moment.");
            System.out.println("cannot establish connection");
        } catch (IOException ex) {
            //log.error("I/O Error");
            System.out.println("cannot establish connection");
        }
        
        
    }
    
    /**
     * Sends the necessary data to the server.
     */
    private boolean send() {
        return true;
    }
}
