#!/bin/bash

echo "Gerando .jar do projeto..."
./mvnw clean package -DskipTests

echo "Subindo containers com Docker Compose..."
docker-compose up --build
