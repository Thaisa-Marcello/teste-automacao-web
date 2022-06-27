# language: pt

Funcionalidade: inserir novo quarto em hotel
  como admin do sistema
  quero adicionar um novo quarto
  para estar disponível aos clientes

  Cenário: inserir novo quarto com sucesso
    Dado que loguei no sistema
    E cliquei em Hotels no menu lateral para expandir
    E cliquei novamente em Hotels para abrir um novo menu
    E cliquei em Rooms
    E cliquei em ADD
    E inseri um hotel
    E inseri o tipo de quarto
    E adicionei um preço
    Quando clicar em Submit
    Então o quarto deve aparecer na lista de quartos disponíveis
