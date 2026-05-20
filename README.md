# 💰 Gerenciador de Despesas Pessoais

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-green?style=for-the-badge)

Este projeto é uma aplicação desenvolvida em Java com o objetivo de auxiliar os usuários no controle de suas finanças individuais, promovendo conscientização e saúde financeira. 

Projeto desenvolvido para a disciplina de **Programação 2**, lecionada pelo Professor Anderson Cavalcanti na **Unidade Acadêmica de Belo Jardim (UABJ) - UFRPE**.

## 👥 Equipe Desenvolvedora
* Aldo Filho
* Gabriel Victor
* Iohannan
* Iuri Bezerra
* Lucas Maia

## 🚀 Funcionalidades Atuais (Entrega 2)
Nesta segunda entrega (Estrutura Principal e Encapsulamento), o sistema é capaz de realizar operações de CRUD em memória utilizando `ArrayList`:
- [x] **Adicionar** transações (Receitas e Despesas).
- [x] **Listar** histórico de transações com formatação de data.
- [x] **Editar** transações existentes (atualizando o saldo dinamicamente).
- [x] **Remover** transações registradas.
- [x] Atualização de **Saldo em Tempo Real** do Usuário.

## 🏗️ Estrutura e Encapsulamento
Seguindo os princípios de Programação Orientada a Objetos:
1. **Atributos Privados:** Todos os atributos das classes (`Usuario`, `Transacao`, `MetaOrcamento`) estão definidos como `private`.
2. **Métodos de Negócio Inteligentes:** Getters e Setters foram implementados de forma consciente. Por exemplo, atributos como `saldoAtual` e `valorConsumido` não possuem *setters* públicos, sendo modificados exclusivamente por métodos de negócio (`adicionarReceita`, `deduzirDespesa`, `atualizarGasto`) para proteger a integridade dos dados.
