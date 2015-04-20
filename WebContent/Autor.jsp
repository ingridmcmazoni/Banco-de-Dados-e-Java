<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.swing.JOptionPane,entidades.*,controller.ControllerAutor,javax.servlet.ServletContext,java.util.*" %>      
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
<body>
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
	Autor c=(Autor)request.getAttribute("Autor");
	
	 if (c == null) {
			c = new Autor();
			
	} 

	
	if(mensagem!=null){%>
	
	<h1><%=mensagem %></h1>
	<script>alert('<%=mensagem%>');</script>
		
	<%}%>

<br>
	<form action="./ControllerAutor" method="post">
<table align="center">
	<tr><td colspan="2">Código Autor</td><td colspan="2"><input type="text" name="codAutor" value="<%=c.getCodAutor()%>"></td></tr>
	<tr><td colspan="2">Nome</td><td colspan="2"><input type="text" name="nome" value="<%=c.getNome()%>"></td></tr>
	
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
ControllerAutor daoAutor=new ControllerAutor(); 

List<Autor> autor = (List<Autor>) daoAutor.carregaLista(); //request.getAttribute("ListaAutors");
		
		if (autor!= null && autor.size() > 0)  {%>
		<table border="1" align="center">
			<tr>
				<td>Codigo    </td>
				<td>Nome      </td>
				<td>Ações      </td>
			</tr>
			<% for (Autor a : autor) { %> 
				<tr>
					<td><%=a.getCodAutor()%></td>
					<td><%=a.getNome()%></td>
					<td>
						<a href="./ControllerAutor?cmd=Excluir&codAutor=<%=a.getCodAutor()%>">Remover</a>
						<a href="./ControllerAutor?cmd=Atualizar&codAutor=<%=a.getCodAutor()%>">Editar</a>
					</td>
				</tr>
			<% } %>
		</table>
	<%}%>

</body>
</html>