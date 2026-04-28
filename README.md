## Task Tracker

O Task Tracker 2 é um projeto usado para rastrear e gerenciar suas tarefas. Neste programa, você dispõe de uma interface de linha de comando simples (CLI) para rastrear o que você precisa fazer, o que você fez e o que você está trabalhando atualmente.

Este projeto se adequa aos requisitos de projeto descritos e seção abaixo (vide [roadmap.sh](https://roadmap.sh/projects/task-tracker)). Veja este projeto no roadmap.sh [neste link](https://roadmap.sh/projects/task-tracker/solutions?u=648f5324779070ae624a398b).

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
- Dados salvos em JSON.

## Comandos

A lista de comandos e seu uso é dada abaixo:

```shell
# Adiciona uma nova tarefa
java tasktracker add "Comprar mantimentos"
# Saída: Tarefa adicionada com sucesso (ID: 1)

# Atualizando e excluindo tarefas
java tasktracker update 1 "Comprar mantimentos e cozinhar o jantar"
java tasktracker delete 1

# Marcar uma tarefa como em andamento ou concluída
java tasktracker mark-in-progress 1
java tasktracker mark-done 1

# Listando todas as tarefas
java tasktracker list

# Listando tarefas por status
java tasktracker list done
java tasktracker list todo
java tasktracker list in-progress
```
