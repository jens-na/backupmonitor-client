/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.backupkueche.backupmonitor.client;

import de.backupkueche.backupmonitor.client.config.Configuration;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnectionFactory;
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
                
                try {
                    if(send()) {
                        System.exit(0);
                    }
                }
                catch(JMSException e) {
                    e.printStackTrace();
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
    private boolean send() throws JMSException {
        // Create a ConnectionFactory
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                configuration.getJms().getAddress());

        // Create a Connection
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // Create a Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Create the destination (Topic or Queue)
        Destination destination = session.createQueue("input");
        
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        List<String> list = configuration.getDevice().getFiles();
        
        for(String file : list) {
            BytesMessage bytesMessage = session.createBytesMessage();
            
            // read file and send bytesmessage
        }

        return true;
    }
}
