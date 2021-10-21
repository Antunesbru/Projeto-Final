USE NatuterraDrinks;

INSERT INTO TipoUsuario(TituloTipo)
values ('Administrador'), ('Funcionario'), ('Cliente');

INSERT INTO Usuario( NomeUsuario, Email, Senha, CPF, Endereco, IdTipo)
values ('Kleber', 'kleberSantos$@gmail.com', 'kleber123', '344.377.109-67', 'Rua japao Dos doido N°51', 2), 
('Artur', 'ArturPiaui@gmail.com', 'Piaui123', '123.456.678-89', 'Rua Saramandaia Dos mortos N°13', 1);

INSERT INTO Natuterra(NomeEmpresa, CNPJ, Endereco, RazaoSocial)
values ('Natuterra Drinks', '26.465.300/0001-30', 'Avenida Joao Paulo Ablas N°900, CEP = 06711250', ' Natuterra Drinks - Comercio Atacadista de Bebidas LTDA');

INSERT INTO Produto(NomeProduto, Valor, Quantidade, Peso, Validade)
values ('Leite vegetal de amendoas', 6.00 , 100, 1.00, '2020-07-24' ), ('Leite vegetal de coco e aveia', 13.00, 100,  1.00, '2020-07-24' );



INSERT INTO NotaFiscal(DataCompra, IdProduto, IdEntrega, IdEmpresa)
values ('2020-06-24', 3, 5, 1);

INSERT INTO ItemProdutoNota(idNota, IdProduto, QuantidadeProduto)
values (1, 1, 52);

SELECT * FROM Usuario;
SELECT * FROM TipoUsuario;
SELECT * FROM Natuterra;
SELECT * FROM Produto;
SELECT * FROM NotaFiscal;
SELECT * FROM ItemProdutoNota;


Delete from Produto
Where IdProduto = 5;

SELECT  NotaFiscal.IdNota, NotaFiscal.IdProduto, NotaFiscal.IdEntrega, NotaFiscal.DataCompra, NotaFiscal.IdEmpresa, NotaFiscal.IdUsuario, Produto.NomeProduto, Produto.Valor, Produto.Peso, Natuterra.NomeEmpresa, Natuterra.Cnpj, Natuterra.Endereco, Natuterra.RazaoSocial,  Usuario.NomeUsuario, Usuario.Cpf 
FROM NotaFiscal 
INNER JOIN Produto  ON NotaFiscal.IdProduto = Produto.IdProduto
INNER JOIN Natuterra  ON NotaFiscal.IdEmpresa = Natuterra.IdEmpresa
INNER JOIN Usuario  ON Usuario.IdUsuario = Usuario.IdUsuario;

SELECT  ItemProdutoNota.QuantidadeProduto, ItemProdutoNota.IdNota, NotaFiscal.DataCompra, NotaFiscal.IdEmpresa, NotaFiscal.IdUsuario, Produto.NomeProduto, Produto.Valor, NotaFiscal.EnderecoEntrega, NotaFiscal.Taxa, NotaFiscal.TempoEntrega, Natuterra.NomeEmpresa, Natuterra.CNPJ, Natuterra.Endereco, Natuterra.RazaoSocial, Usuario.NomeUsuario, Usuario.Cpf 
FROM ItemProdutoNota
INNER JOIN Produto  ON ItemProdutoNota.IdProduto = Produto.IdProduto
INNER JOIN Natuterra  ON Natuterra.IdEmpresa = Natuterra.IdEmpresa
INNER JOIN Usuario  ON Usuario.IdUsuario = Usuario.IdUsuario
inner join NotaFiscal on ItemProdutoNota.idNota = NotaFiscal.IdNota;



SELECT  NotaFiscal.IdNota,  NotaFiscal.DataCompra,  Usuario.NomeUsuario 
FROM NotaFiscal 
INNER JOIN Usuario  ON Usuario.IdUsuario = Usuario.IdUsuario;

SELECT  Usuario.IdUsuario, Usuario.NomeUsuario, Usuario.Email, Usuario.CPF, Usuario.Endereco, TipoUsuario.TituloTipo 
FROM Usuario
INNER JOIN TipoUsuario  ON Usuario.IdTipo = TipoUsuario.IdTipo;



SELECT  ItemProdutoNota.IdNota, ItemProdutoNota.QuantidadeProduto,  NotaFiscal.DataCompra, NotaFiscal.IdUsuario, Produto.NomeProduto, Produto.Valor, NotaFiscal.EnderecoEntrega, NotaFiscal.Taxa, NotaFiscal.TempoEntrega, Natuterra.NomeEmpresa, Natuterra.CNPJ,  Natuterra.RazaoSocial, Usuario.NomeUsuario, Usuario.Cpf
FROM ItemProdutoNota
INNER JOIN Produto  ON ItemProdutoNota.IdProduto = Produto.IdProduto
INNER JOIN Natuterra  ON ItemProdutoNota.IdEmpresa = Natuterra.IdEmpresa
INNER JOIN Usuario  ON ItemProdutoNota.IdUsuario = Usuario.IdUsuario
 inner join NotaFiscal on ItemProdutoNota.idNota = NotaFiscal.IdNota;
