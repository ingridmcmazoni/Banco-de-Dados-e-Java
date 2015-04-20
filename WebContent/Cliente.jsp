<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="javax.swing.JOptionPane,entidades.*,controller.*,javax.servlet.ServletContext,java.util.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body{font-family:comic sans ms;color:white;background-color:black}
#tabs28{position:relative;display:block;height:42px;font-size:16px;font-weight:bolder;background:DarkViolet; repeat-x ;top ;left;font-family:Arial,Verdana,Helvitica,sans-serif;text-transform:uppercase;}
#tabs28 ul{margin:0px;padding:0;list-style-type:none;width:auto;}
#tabs28 ul li{display:block;float:left;margin:0 1px 0 0;}
#tabs28 ul li a{display:block;float:left;color:#FBDAFA;text-decoration:none;padding:14px 22px 0 22px;height:28px;}
#tabs28 ul li a:hover,#tabs28 ul li a.current{color:#fff;background:DarkViolet; no-repeat; top; center;}
td{margin:10cm}
a:link{color:#FF99FF}
a:visited{color:#FFCCCC}
a:hover{color:#99FF99}
a:active{color:#FF99FF}
</style>
<body >
<div id="tabs28">
	<ul>
	<li><a href="Editora.jsp" title="Editora">Editora</a></li>
	<li><a href="Livro.jsp" title="Livros">Livros</a></li>
	<li><a href="Autor.jsp" title="Autor">Autor</a></li>
	<li><a href="Exemplar.jsp" title="Autor">Exemplar</a></li>
	<li><a href="Estante.jsp" title="Estante">Estante</a></li>
	<li><a href="Bibliotecaria.jsp" title="Bibliotecaria" class="current">Bibliotecaria</a></li>
	<li><a href="Cliente.jsp" title="Cliente">Cliente</a></li>
	<li><a href="Emprestimo.jsp" title="Cliente">Emprestimo</a></li>
	</ul>
</div>	

<br>
	<% String mensagem=(String)request.getAttribute("Mensagem");
	Cliente c=(Cliente)request.getAttribute("Cliente");
	
	 if (c == null) {
			c = new Cliente();
			
	} 

	
	if(mensagem!=null){%>
	
	<h1><%=mensagem %></h1>
	<script>alert('<%=mensagem%>');</script>
		
	<%}%>

<br>
<form action="./controllerCliente" method="post">
<table align="center">
	<tr><td colspan="2">Código Cliente</td><td colspan="2"><input type="text" name="codigo" value="<%=c.getCodCliente()%>"></td></tr>
	<tr><td colspan="2">Nome</td><td colspan="2"><input type="text" name="nome" value="<%=c.getNome()%>"></td></tr>
	<tr><td colspan="2">Logradouro</td><td colspan="2"><input type="text" name="logradouro" value="<%=c.getLogradouro()%>"></td></tr>
	<tr><td colspan="2">Endereço</td><td colspan="2"><input type="text" name="endereco" value="<%=c.getEndereco()%>"></td></tr>
	<tr><td colspan="2">Numero</td><td colspan="2"><input type="text" name="numero" value="<%=c.getNumero()%>"></td></tr>
	<tr><td colspan="2">Bairro</td><td colspan="2"><input type="text" name="bairro" value="<%=c.getBairro()%>"></td></tr>
	<tr><td colspan="2">Cep</td><td colspan="2"><input type="text" name="cep" value="<%=c.getCep()%>"></td></tr>
	<tr><td colspan="2">Complemento</td><td colspan="2"><input type="text" name="complemento" value="<%=c.getComplemento()%>"></td></tr>
	<tr><td colspan="2">Telefone</td><td colspan="2"><input type="text" name="telefone" value="<%=c.getTelefone()%>"></td></tr>
	<tr><td colspan="2">Celular</td><td colspan="2"><input type="text" name="celular" value="<%=c.getCelular()%>"></td></tr>
	<tr>
		<td><input type="submit" name="cmd" value="Inserir"></td>
		<td><input type="submit" name="cmd" value="Atualizar"></td>
		<td><input type="submit" name="cmd" value="Excluir"></td>
		<td><input type="submit" name="cmd" value="Pesquisar"></td>
	</tr>
</table>
</form>
<br>



<% 
ControllerCliente daoCli=new ControllerCliente(); 

List<Cliente> clientes = (List<Cliente>) daoCli.carregaLista(); //request.getAttribute("ListaClientes");
		
		if (clientes!= null && clientes.size() > 0)  {%>
		<table border="1" align="center">
			<tr>
				<td>Codigo    </td>
				<td>Nome      </td>
				<td>Logradouro</td>
				<td>Endereco </td>
				<td>Numero   </td>
				<td>Bairro   </td>
				<td>Cep      </td>
				<td>Complemento</td>
				<td>Telefone</td>
				<td>Celular</td>
				<td>Ações</td>
			</tr>
			<% for (Cliente a : clientes) { %> 
				<tr>
					<td><%=a.getCodCliente()%></td>
					<td><%=a.getNome()%></td>
					<td><%=a.getLogradouro()%></td>
					<td><%=a.getEndereco()%></td>
					<td><%=a.getNumero()%></td>
					<td><%=a.getBairro()%></td>
					<td><%=a.getCep()%></td>
					<td><%=a.getComplemento()%></td>
					<td><%=a.getTelefone()%></td>
					<td><%=a.getCelular()%></td>
					<td>
						<a href="./controllerCliente?cmd=Excluir&codigo=<%=a.getCodCliente()%>">Remover</a>
						<a href="./controllerCliente?cmd=Atualizar&codigo=<%=a.getCodCliente()%>">Editar</a>
					</td>
				</tr>
			<% } %>
		</table>
	<%}%>

	
	
</body>
</html>