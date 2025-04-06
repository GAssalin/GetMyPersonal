@echo off
echo Gerando o .jar do projeto...
call mvnw.cmd clean package -DskipTests

echo.
echo Subindo containers com Docker Compose...
docker-compose up --build
