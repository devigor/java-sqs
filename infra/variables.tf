variable "aws_region" {
  description = "Região da AWS"
  type        = string
  default     = "us-east-1"
}

variable "aws_access_key" {
  description = "Chave de acesso da AWS"
  type        = string
}

variable "aws_secret_key" {
  description = "Chave secreta da AWS"
  type        = string
}

variable "sqs_endpoint" {
  description = "Endpoint do serviço SQS"
  type        = string
}

variable "apigateway_endpoint" {
  description = "Endpoint do serviço API Gateway"
  type        = string
}

variable "skip_credentials" {
  description = "Pular credenciais"
  type        = string
  default     = true
}

variable "skip_requesting" {
  description = "Pular request"
  type        = string
  default     = true
}

variable "queue_name" {
  description = "Nome da fila SQS"
  type        = string
}

