/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.backupkueche.backupmonitor.client;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import de.backupkueche.backupmonitor.client.config.ConfigHostEntry;
import de.backupkueche.backupmonitor.client.config.Configuration;
import java.io.IOException;
import java.util.logging.Level;
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
        ConfigHostEntry entry = configuration.getHosts().getEntries().get(0);
        
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(entry.getHost());
        factory.setPort(Integer.valueOf(entry.getPort()));
        
        Connection connection = null;
        Channel channel = null;
        
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare();
            
            String message=  "test";
            System.out.println(" [x] Sent '" + message + "'");
            
        } catch (IOException ex) {
            ex.printStackTrace();
            // log
        }
        
        
        
    }

    /**
     * Sends the necessary data to the server.
     */
    private boolean send() {
        
        return true;
    }
}
