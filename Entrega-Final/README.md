# 🎯 Entrega Final: Gerenciador de Despesas Pessoais

Este diretório contém a **versão definitiva e completa** do projeto Gerenciador de Despesas Pessoais, desenvolvida para a disciplina de **Programação 2** (Professor Anderson Cavalcanti - UFRPE / UABJ).

Nesta etapa, o sistema foi totalmente refatorado para consolidar os conceitos avançados de Programação Orientada a Objetos (POO) exigidos na Entrega 3, além de corrigir e integrar as pendências da etapa anterior.

## 👥 Equipe Desenvolvedora
* Aldo Filho
* Gabriel Victor
* Iohannan
* Iuri Bezerra
* Lucas Maia

---

## 🛠️ Conceitos de POO Aplicados nesta Versão

### 1. Herança (`extends`)
* A classe `Transacao` foi transformada em uma **Superclasse Abstrata** (`abstract class`), servindo como o modelo genérico para qualquer movimentação financeira.
* Foram criadas duas **Subclasses** (classes filhas) que herdam diretamente as propriedades de `Transacao`:
  * `Receita.java`: Especializada em tratar as entradas e somar valores ao saldo.
  * `Despesa.java`: Especializada em tratar as saídas e deduzir valores do saldo.

### 2. Polimorfismo (`@Override`)
* O método `exibirResumo()` foi definido como abstrato na classe mãe e foi **sobrescrito** com comportamentos customizados em `Receita` e `Despesa`.
* Na classe `Main.java`, todas as movimentações são guardadas juntas em um único `ArrayList<Transacao>`. Na hora de listar, o Polimorfismo entra em ação: o Java identifica sozinho o tipo real do objeto e renderiza o formato correto (exibindo as tags visuais 🟢 RECEITA ou 🔴 DESPESA).

### 3. Tratamento de Exceções (`try-catch` / `throw`)
Tornamos a aplicação robusta contra erros de digitação e violações das regras de negócio:
* **`NumberFormatException`:** Capturada nos menus da classe `Main`. Se o usuário digitar letras onde o sistema espera um número, o programa exibe uma mensagem amigável de erro em vez de quebrar (crashar).
* **`IllegalArgumentException`:** Lançada e tratada caso o usuário tente cadastrar uma transação ou uma meta com valores negativos ou zerados.

### 4. Integração Completa de Metas (Correção da Entrega 2)
* **Vínculo de Classes:** A classe `MetaOrcamento` foi 100% integrada ao fluxo da `Main`.
* **Verificação Ativa:** Sempre que uma nova `Despesa` é cadastrada, o método `verificarMetas()` busca se existe uma meta para aquela categoria. Caso o limite seja atingido ou ultrapassado, um **alerta visual automático** é disparado no console para avisar o usuário.

---

## 📂 Organização dos Arquivos neste Diretório

* `Main.java`: Menu interativo do sistema, tratamento global de exceções e controle do CRUD em memória.
* `Usuario.java`: Modela o perfil do usuário e protege a integridade do saldo atual através de encapsulamento.
* `MetaOrcamento.java`: Controla os tetos de gastos estipulados por categoria.
* `Transacao.java`: Superclasse abstrata que unifica os atributos comuns das transações.
* `Receita.java`: Subclasse responsável pelas entradas de saldo.
* `Despesa.java`: Subclasse responsável pelas saídas de saldo.

---
*Data de Entrega: 30 de Junho de 2026*
