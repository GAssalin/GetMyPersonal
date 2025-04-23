# GetMyPersonal

## Descrição
O **GetMyPersonal** é um aplicativo voltado para personal trainers e profissionais da área de saúde e bem-estar. Ele permite o gerenciamento de alunos, criação de treinos personalizados e acompanhamento de progresso de forma prática e eficiente.

## Funcionalidades Principais
- **Cadastro de Alunos:** Permite que os personal trainers adicionem e gerenciem perfis de alunos.

## Tecnologias Utilizadas
- **Backend:** Java com Spring Boot 3.4.2
- **Frontend:** *(a definir)*
- **Banco de Dados:** MySQL
- **Autenticação:** *(a definir)*
- **Hospedagem:** *(a definir)*

## Como Executar o Projeto

### Backend

#### ✅ Rodando com Docker (Recomendado para Devs Frontend)
⚠️ Certifique-se de ter o Docker instalado antes de rodar os comandos abaixo.
```bash
# Clone o repositório
git clone https://github.com/seu-usuario/GetMyPersonal.git

# Acesse a pasta do backend
cd GetMyPersonal/dev/back/getmypersonal

# Execute com Make (Linux/macOS/WSL)
make up

# OU execute o script shell (Linux/macOS/WSL)
./run.sh
s
# OU execute o script para Windows (cmd/PowerShell)
run.bat
```

#### ✅ Comandos úteis adicionais:
```bash
make down    # Encerra os containers
make logs    # Exibe os logs da API
```

---

#### ⚙️ Rodando localmente sem Docker (modo manual)
❗ Credenciais devem ser alteradas e protegidas em ambientes reais
```bash
# Configure o banco MySQL localmente:
# DB: getmypersonal | User: root | Password: root

# Execute o projeto com Maven
mvn spring-boot:run
```

### Frontend
> ⚠️ Atualmente o Front encontra-se em etapa de modelo, estudo e análises.
```bash
# Acesse a pasta do frontend
📦 GetMyPersonal
└── 📁 dev
    └── 📁 front
        └── 📁 react
            └── 📁 modelosEEstudos
                └── 📁 {{Escolher o modelo desejado para ser executado e testado}}

# Instale as dependências
└── 📁 react
    | ⚠️ Antes da execução de um projeto react, certifique-se de que o Node.js esteja instalado corretamente.
    | Para isso, basta executar o comando "npm -v", no prompt de comando. Caso esteja tudo certo, será apresentado a versão do Node que está instalado.
    | Caso retorne com a mensagem de não reconhecimento do comando "npm", basta baixar e seguir os passos de instalação do Node.js através do siite oficial: http://nodejs.org/en.
    └── 📁 modelosEEstudos
        └── 📁 {{Escolher o modelo desejado para ser executado e testado}}
            | Abrir o prompt de comando.
            | Executar o comando "npm install".
            └── Caso tenha apresentado a seguinte mensagem de erro: "npm.ps1 não pode ser carregado porque a execução de scripts foi desabilitada neste sistema.", seguir os passos abaixo.
                └── Abra o PowerShell, como Administrador.
                    | Digite o comando: "Set-ExecutionPolicy RemoteSigned -Scope CurrentUser".
                    | Depois pressione S e Enter para confirmar.
                | Agora volta pro seu terminal e repita o comando "npm install".
            └── Caso o Node tenha retornado com algumas vulnerabilidades, seguir os passos abaixo.
                | É possível executar o comando "npm audit fix --force" para resolver, "automaticamente", algumas delas.

# Execute o projeto
> Executar o comando "npm start" para executar o projeto e abri-lo automaticamente pelo Node.js

# Encerrar a execução do projeto
> Executar o comando "Ctrl + C" para finalzar a execução. Caso, necessário confirmação, basta digitar "Y" e teclar "Enter"
```

---

## 📘 Swagger (OpenAPI)
Swagger é um conjunto de ferramentas baseado na OpenAPI Specification, utilizado para projetar, construir, documentar e testar APIs RESTful. Ele gera automaticamente uma interface interativa para explorar todos os endpoints da aplicação, facilitando a compreensão tanto para desenvolvedores quanto para ferramentas externas.

✅ Benefícios:
- Geração automática da documentação da API.
- Interface visual e interativa para testes (Swagger UI).
- Dispensa a necessidade de acessar o código-fonte para entender os recursos disponíveis.
- Útil para integração entre times frontend e backend.

🚀 Como acessar a documentação Swagger desta aplicação?
Com a aplicação em execução (veja seção "Como Executar o Projeto"), acesse um dos links abaixo:
- 👉 http://localhost:8080/swagger-ui.html
- 👉 http://localhost:8080/swagger-ui/index.html

---

## Contribuição
Sinta-se à vontade para contribuir com melhorias ao projeto. Para isso:
```bash
# Faça um fork do repositório
# Crie uma branch para sua feature ou correção
# Envie um pull request para revisão
```

## Licença
*(A definir)*

## Contato
Se precisar de mais informações ou tiver dúvidas, entre em contato pelo e-mail:

- **caiosewa@gmail.com**  
- **fee.zequetti@hotmail.com**  
- **gustavo.assalin@hotmail.com**
