package com.accenture.flowershop.be.business.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jms.*;

@Service("JmsService")
public class JmsServiceImpl implements JmsService {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private ConnectionFactory connectionFactory; // ошибки нет

    @Autowired
    private JmsConsumerMessageListener jmsConsumerMessageListener;

    private Queue outQueue;
    private Queue inQueue;
    private Connection connection;
    private Session session;
    private MessageProducer producer;
    private MessageConsumer consumer;

    @Override
    @PostConstruct
    public void initialize() {
        try {
            outQueue = (Queue)context.getBean("outQueue");
            inQueue = (Queue)context.getBean("inQueue");
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            producer  = session.createProducer(outQueue);
            consumer = session.createConsumer(inQueue);
            consumer.setMessageListener(jmsConsumerMessageListener);
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    @PreDestroy
    public void destroy() {
        if (connection != null) {
            try {
                connection.close();
            } catch (JMSException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void sentMessage(String text) {
        try {
            Message message = session.createTextMessage(text);
            producer.send(message);
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
}
