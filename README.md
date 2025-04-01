# Básico JPA

O JPA é como uma interface que apresenta um conjunto de regras para utilizar o mapeamento por ORM.
Permite que a conexão com o banco de dados seja mais abstrata, ainda com a possibilidade do uso do padrão DAO.

Já o hibernate é uma tecnologia que implementa as regras necessáarias para a conexão com o meu banco de dados.
A partir dos dois, é possível implementar um sistema básico de CRUD, ou regras em cima do banco de dados.

Contudo, em uma DATABASE já existente, o JPA não possui controle direto sobre as CONSTRAINTS das tabelas do banco.
Permitindo que o acesso seja feito somente via manual, ou via persistence.
