package tech.io.sqs_producer.service;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Service
public class Sqs {

    @Autowired
    SqsAsyncClient sqsAsyncClient;
    @Value("${sqs.queue.url}")
    public String queueUrl;

    public void sendMessage(String messageBody) {
        SendMessageRequest request = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(messageBody)
                .build();

        sqsAsyncClient.sendMessage(request)
                .whenComplete((response, exception) -> {
                    if (exception != null) {
                        System.err.println("Erro ao enviar mensagem: " + exception.getMessage());
                    } else {
                        System.out.println("Mensagem enviada com sucesso, ID: " + response.messageId());
                    }
                });
    }
}
