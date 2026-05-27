# 📖 Tutorial de Execução: Gerenciador de Despesas Pessoais

Este documento detalha o passo a passo para baixar, configurar e executar o projeto **Gerenciador de Despesas Pessoais**, desenvolvido para a disciplina de Programação 2.

---

## 🏗️ 1. Estrutura do Projeto
O sistema foi construído utilizando os princípios de Programação Orientada a Objetos (POO) com encapsulamento. Ele é composto por quatro arquivos principais:

* **`Usuario.java`:** Gerencia os dados do usuário e o saldo, com regras para adicionar receitas e deduzir despesas.
* **`Transacao.java`:** Representa as movimentações financeiras, armazenando data, valor, descrição e categoria.
* **`MetaOrcamento.java`:** Controla os limites de gastos estipulados para evitar endividamento.
* **`Main.java`:** É o coração do sistema. Contém o menu interativo e gerencia o CRUD (Adicionar, Editar, Remover e Listar) usando um `ArrayList`.

---

## ⚙️ 2. Pré-requisitos
Antes de começar, certifique-se de ter instalado em sua máquina:
* **Java Development Kit (JDK):** Versão 8 ou superior (necessário para a biblioteca `java.time.LocalDate`).
* **Uma IDE Java:** VS Code, IntelliJ IDEA ou Eclipse.

---

## 💻 3. Como Baixar o Projeto

Você pode obter o código de duas maneiras:

### Opção A: Via Git Clone (Recomendado)
Ideal para manter o repositório atualizado e conectado ao GitHub.
1. Abra o terminal do seu computador.
2. Navegue até a pasta onde deseja salvar o projeto.
3. Digite o comando abaixo e aperte Enter:
   ```bash
   git clone [https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git](https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git)
