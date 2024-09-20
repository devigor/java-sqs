package tech.io.sqs_producer.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;

import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.*;

class SqsTest {
    @Mock
    private SqsAsyncClient sqsAsyncClient;

    @InjectMocks
    private Sqs sqsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sqsService.queueUrl = "https://sqs.fake-url/queue";  // Simulating @Value injection
    }

    @Test
    void testSendMessageSuccess() {
        // Mocking the response from SQS
        SendMessageResponse mockResponse = SendMessageResponse.builder()
                .messageId("1234")
                .build();
        CompletableFuture<SendMessageResponse> future = CompletableFuture.completedFuture(mockResponse);
        when(sqsAsyncClient.sendMessage(any(SendMessageRequest.class))).thenReturn(future);

        // Executing the service method
        sqsService.sendMessage("Test message");

        // Verifying that sendMessage was called once
        verify(sqsAsyncClient, times(1)).sendMessage(any(SendMessageRequest.class));
    }

    @Test
    void testSendMessageFailure() {
        // Simulating an exception when sending a message
        CompletableFuture<SendMessageResponse> future = new CompletableFuture<>();
        future.completeExceptionally(new RuntimeException("SQS Error"));
        when(sqsAsyncClient.sendMessage(any(SendMessageRequest.class))).thenReturn(future);

        // Executing the service method
        sqsService.sendMessage("Test message");

        // Verifying that sendMessage was called once
        verify(sqsAsyncClient, times(1)).sendMessage(any(SendMessageRequest.class));
    }
}