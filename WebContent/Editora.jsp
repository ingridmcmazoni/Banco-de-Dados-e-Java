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

<% String mensagem=(String)request.getAttribute("Mensagem");
	Editora e=(Editora)request.getAttribute("Editora");
	
	 if (e == null) {
			e = new Editora();
			
	} 

	
	if(mensagem!=null){%>
	
	<h1><%=mensagem %></h1>
	<script>alert('<%=mensagem%>');</script>
		
	<%}%>
<br>
<form action="./ControllerEditora" method="post">
<table align="center">
	<tr><td colspan="2">Código Editora</td><td colspan="2"><input type="text" name="codEditora" value="<%=e.getCodEditora()%>"></td></tr>
	<tr><td colspan="2">Nome</td><td colspan="2"><input type="text" name="nome" value="<%=e.getNome() %>"></td></tr>
	<tr><td colspan="2">CNPJ</td><td colspan="2"><input type="text" name="cnpj" value="<%=e.getCnpj()%>"></td></tr>
	<tr><td colspan="2">Razao Social</td><td colspan="2"><input type="text" name="razaoSocial" value="<%=e.getRazaoSocial()%>"></td></tr>
	
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
ControllerEditora daoEd=new ControllerEditora(); 

List<Editora> editoras = (List<Editora>) daoEd.carregaLista(); //request.getAttribute("ListaEditoras");
		
		if (editoras!= null && editoras.size() > 0)  {%>
		<table border="1" align="center">
			<tr>
				<td>Codigo    </td>
				<td>Nome      </td>
				<td>CNPJ</td>
				<td>Razão Social </td>
				<td>Ações </td>
			</tr>
			<% for (Editora a : editoras) { %> 
				<tr>
					<td><%=a.getCodEditora()%></td>
					<td><%=a.getNome()%></td>
					<td><%=a.getCnpj()%></td>
					<td><%=a.getRazaoSocial()%></td>
					<td>
						<a href="./ControllerEditora?cmd=Excluir&codEditora=<%=a.getCodEditora()%>">Remover</a>
						<a href="./ControllerEditora?cmd=Atualizar&codEditora=<%=a.getCodEditora()%>">Editar</a>
					</td>
				</tr>
			<% } %>
		</table>
	<%}%>

	


</body>
</html>