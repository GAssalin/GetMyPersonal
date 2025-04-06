# Gera o .jar do projeto
build:
	./mvnw clean package -DskipTests

# Sobe os containers com Docker
up: build
	docker-compose up --build

# Derruba os containers
down:
	docker-compose down

# Mostra os logs do backend
logs:
	docker logs -f getmypersonal-api
