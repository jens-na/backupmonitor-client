/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.backupkueche.backupmonitor.client;

import com.rabbitmq.client.ConnectionFactory;
import de.backupkueche.backupmonitor.client.config.Configuration;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
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

    }

    /**
     * Sends the necessary data to the server.
     */
    private boolean send() {

        return true;
    }
}
