provider "aws" {
  region                      = var.aws_region
  access_key                  = var.aws_access_key
  secret_key                  = var.aws_secret_key
  skip_credentials_validation = var.skip_credentials
  skip_requesting_account_id  = var.skip_requesting
  endpoints {
    sqs        = var.sqs_endpoint
    apigateway = var.apigateway_endpoint
  }
}

resource "aws_sqs_queue" "spring-queue" {
  name            = var.queue_name
  fifo_queue      = true
  redrive_policy  = jsondecode({
    deadLetterTargetArn = aws_sqs_queue.spring-queue-deadletter.arn
    maxReceiveCount     = 4
  })
}

resource "aws_sqs_queue" "spring-queue-deadletter" {
  name = format("%s-deadletter", var.queue_name)
}

resource "aws_sqs_queue_redrive_allow_policy" "spring-queue-redrive-allow-policy" {
  queue_url = aws_sqs_queue.spring-queue.url

  redrive_allow_policy = jsonencode({
    redrivePermission = "byQueue",
    sourceQueueArns   = [aws_sqs_queue.spring-queue.arn]
  })
}

output "queue_url" {
  value = aws_sqs_queue.spring-queue.url
}

output "queue_deadletter_url" {
  value = aws_sqs_queue.spring-queue-deadletter.url
}