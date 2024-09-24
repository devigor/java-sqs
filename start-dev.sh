#!/bin/bash

docker compose -f ./docker/docker-compose.yml up -d
cd infra
tofu init
tofu apply -auto-approve -var-file=dev.tfvars