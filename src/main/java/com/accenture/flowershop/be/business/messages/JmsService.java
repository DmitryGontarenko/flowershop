package com.accenture.flowershop.be.business.messages;

public interface JmsService {

    /**
     * Установить необходимые параметры для работы с jms
     * connection, session, queue, producer, consumer
     */
    void initialize();

    /**
     * Закрыть соединение connection
     */
    void destroy();

    /**
     * Отправить новое текстовое сообщение в очередь activemq
     * @param text Тело сообщения
     */
    void sentMessage(String text);
}
