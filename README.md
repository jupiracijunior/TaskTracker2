## Task Tracker

O Task Tracker 2 é um projeto usado para rastrear e gerenciar suas tarefas. Neste programa, você dispõe de uma interface de linha de comando simples (CLI) para rastrear o que você precisa fazer, o que você fez e o que você está trabalhando atualmente.

Este projeto se adequa aos requisitos de projeto descritos e seção abaixo (vide [roadmap.sh](https://roadmap.sh/projects/task-tracker).

## Requisitos

Aqui estão algumas restrições para orientar a implementação:

- Você pode usar qualquer linguagem de programação para construir este projeto.
- Use argumentos posicionais na linha de comando para aceitar entradas de usuário.
- Use um arquivo JSON para armazenar as tarefas no diretório atual.
- O arquivo JSON deve ser criado se não existir.
- Use o módulo de sistema de arquivos nativo da sua linguagem de programação para interagir com o arquivo JSON.
- Não use bibliotecas ou frameworks externos para construir este projeto.
- Certifique-se de lidar com erros e casos de borda graciosamente.


## Funcionalidades

- [x] Adicionar, atualizar e excluir tarefas
- [x] Marcar uma tarefa como em andamento ou feito
- [x] Listar todas as tarefas
- [x] Listar todas as tarefas que são feitas
- [x] Listar todas as tarefas que não são feitas
- [x] Listar todas as tarefas que estão em andamento

## Informações do projeto

- Feito em Java.
- Usa Picocli
- Dados salvos em JSON.
- Usa Jackson para tratar o JSON.

## Comandos

A lista de comandos e seu uso é dada abaixo:

```shell
# Adding a new task
java tasktracker add "Buy groceries"
# Output: Task added successfully (ID: 1)

# Updating and deleting tasks
java tasktracker update 1 "Buy groceries and cook dinner"
java tasktracker delete 1

# Marking a task as in progress or done
java tasktracker mark-in-progress 1
java tasktracker mark-done 1

# Listing all tasks
java tasktracker list

# Listing tasks by status
java tasktracker list done
java tasktracker list todo
java tasktracker list in-progress
```
