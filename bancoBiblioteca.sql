create database biblioteca
use biblioteca

create table cliente(
codCliente int auto_increment not null,
nome varchar(100),
logradouro varchar(100),
endereco varchar(100),
numero varchar(100),
bairro varchar(100),
cep varchar(100),
complemento varchar(100),
telefone varchar(100),
celular varchar(100),
constraint cliente_pkCodCliente primary key(codCliente)
)


create table bibliotecaria(
codBibliotecaria int auto_increment not null,
nome varchar(100),
codSupervisor int not null,
constraint bibliotecaria_pkCodBibliotecaria primary key(codBibliotecaria),
constraint bibliotecaria_fkCodSupervisor foreign key(codSupervisor) references bibliotecaria(codBibliotecaria)
)



create table estante(
codEstante int auto_increment not null,
codBibliotecaria int not null,
corredor varchar(100),
prateleira varchar(100),
constraint estante_pkCodEstante primary key(codEstante),
constraint estante_fkCodBibliotecaria foreign key(codBibliotecaria) references bibliotecaria(codBibliotecaria)
) 

create table livro(
codLivro int auto_increment not null,
nome varchar(100),
edicao int,
ano int,
constraint livro_pkCodLivro primary key(codLivro)
)

create table autor(
codAutor int auto_increment not null,
nome varchar(100),
constraint autor_pkCodAutor primary key(codAutor)
)


create table editora(
codEditora int auto_increment not null,
nomeEditora varchar(100),
cnpjEditora varchar(100),
razaoSocial varchar(100),
constraint editora_pkCodEditora primary key(codEditora)
)

create table livroEditora(
codLivro int not null,
codEditora int not null,
constraint livroEditora_pkCodLivro_pkCodEditora primary key(codLivro,codEditora),
constraint livroEditora_fkCodLivro foreign key(codLivro) references livro(codLivro),
constraint livroEditora_fkCodEditora foreign key(codEditora) references editora(codEditora)
)

create table livroAutor(
codLivro int not null,
codAutor int not null,
constraint livroAutor_pkCodLivro_pkCodAutor primary key(codLivro,codAutor),
constraint livroAutor_fkCodLivro foreign key(codLivro) references livro(codLivro),
constraint livroAutor_fkCodAutor foreign key(codAutor) references autor(codAutor)
)


create table exemplar(
codExemplar int auto_increment not null,
codLivro int not null,
codEstante int not null,
codEditora int not null,
constraint exemplar_pkCodExemplar primary key (codExemplar),
constraint exemplar_fkCodLivro_fkCodEditora foreign key (codLivro,codEditora) references livroeditora(codLivro,codEditora),
constraint exemplar_fkCodEstante foreign key (codEstante) references estante(codEstante)
)

create table emprestimo(
codExemplar int not null,
codCliente int not null,
dataEmprestimo date not null,
dataDevolucaoPrevista date not null,
dataDevolucaoReal date not null,
constraint emprestimo_pkCodExemplar_pkCodCliente primary key(codExemplar,codCliente),
constraint emprestimo_fkCodExemplar foreign key (codExemplar) references exemplar(codExemplar),
constraint emprestimo_fkCodCliente foreign key (codCliente) references cliente(codCliente),
constraint emprestimo_ckDataDevolucaoPrevista_DataEmprestimo check(dataDevolucaoPrevista>dataEmprestimo),
constraint emprestimo_ckDataDevolucaoReal_DataEmprestimo check(dataDevolucaoReal>dataEmprestimo),
constraint emprestimo_ckDataDevolucaoReal_DataDevolucaoPrevista check(dataDevolucaoReal>=dataDevolucaoPrevista)
)


delimiter $$
create procedure insereEmprestimo(codExemplar int,codCliente int,dataEmprestimo varchar(100),devolucaoPrevista varchar(100),devolucaoReal varchar(100))
begin
	insert into emprestimo values(codExemplar,codCliente,str_to_date(dataEmprestimo,'%d/%m/%Y'),str_to_date(devolucaoPrevista,'%d/%m/%Y'),str_to_date(devolucaoReal,'%d/%m/%Y'));
end $$
delimiter ;


delimiter $$
create procedure atualizaEmprestimo(codExemplar1 int,codCliente1 int,dataEmprestimo1 varchar(100),devolucaoPrevista1 varchar(100),devolucaoReal1 varchar(100))
begin
	update emprestimo set dataEmprestimo=str_to_date(dataEmprestimo1,'%d/%m/%Y'),dataDevolucaoPrevista=str_to_date(devolucaoPrevista1,'%d/%m/%Y'),dataDevolucaoReal=str_to_date(devolucaoReal1,'%d/%m/%Y') where codExemplar=codExemplar1 and codCliente=codCliente1;
end $$
delimiter ;



create view listaEmprestimo as
select codExemplar,codCliente,
concat(substring(dataEmprestimo,9,2),'/',substring(dataEmprestimo,6,2),'/',substring(dataEmprestimo,1,4))as dataEmprestimo,
concat(substring(dataDevolucaoPrevista,9,2),'/',substring(dataDevolucaoPrevista,6,2),'/',substring(dataDevolucaoPrevista,1,4))as dataDevolucaoPrevista,
concat(substring(dataDevolucaoReal,9,2),'/',substring(dataDevolucaoReal,6,2),'/',substring(dataDevolucaoReal,1,4))as dataDevolucaoReal  
from emprestimo;


create view listaexemplar as
select livroeditora.codLivro,livro.nome,livro.edicao,livro.ano,livroeditora.codEditora,editora.nomeEditora from livro inner join livroeditora
on livroeditora.codLivro=livro.codLivro inner join editora
on livroeditora.codEditora=editora.codEditora where livroeditora.codLivro=1 and livroeditora.codEditora=2;


create view listaexemplar2 as
select exemplar.codExemplar,livro.nome as titulo ,livro.edicao,livro.ano,editora.nomeEditora as Editora,autor.nome as Autor from exemplar 
inner join editora on editora.codEditora=exemplar.codEditora
inner join livro on exemplar.codLivro=livro.codLivro 
inner join livroautor on livroautor.codLivro=livro.codLivro
inner join autor on autor.codAutor=livroautor.codAutor 
order by exemplar.codExemplar;




select * from exemplar