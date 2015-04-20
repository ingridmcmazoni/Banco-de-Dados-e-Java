<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="javax.swing.JOptionPane,entidades.*,controller.ControllerEmprestimo,controller.ControllerCliente,javax.servlet.ServletContext,java.util.*" %>          
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
	Emprestimo e=(Emprestimo)request.getAttribute("Emprestimo");
	
	 if (e == null) {
			e = new Emprestimo();
			
	} 

	
	if(mensagem!=null){%>
	
	<h1><%=mensagem %></h1>
	<script>alert('<%=mensagem%>');</script>
		
	<%}%>
<br>
<form action="./ControllerEmprestimo" method="post">
<table align="center">
	<tr><td colspan="2">Código Exemplar</td><td colspan="2"><input type="text" name="codExemplar" value="<%=e.getCodExemplar() %>"></td></tr>
	<tr>
		<td colspan="2">Cliente</td>
		<td colspan="2">
			<% 	
				ControllerCliente ca=new ControllerCliente();
				List<Cliente> listaCliente=ca.carregaLista();%>
					
			<select name="cliente">
					<% for(Cliente c:listaCliente){  
						
						if(e.getC()!=null&&e.getC().getCodCliente()==c.getCodCliente()){
					%>
						<option selected><%=c.getCodCliente()+"-"+c.getNome()%></option>
					 		
					<%	}
						else{%>
					
						<option><%=c.getCodCliente()+"-"+c.getNome()%></option>
						
						<%} 
					}%>
			</select>			
			
		</td>
	</tr>
	<tr><td colspan="2">data Empréstimo</td><td colspan="2"><input type="text" name="dataEmprestimo" value="<%=e.getDataEmprestimo() %>"></td></tr>
	<tr><td colspan="2">data Devolução Prevista</td><td colspan="2"><input type="text" name="devolucaoPrevista" value="<%=e.getDataDevolucaoPrevista() %>"></td></tr>
	<tr><td colspan="2">data Devolução Real</td><td colspan="2"><input type="text" name="devolucaoReal" value="<%=e.getDataDevolucaoReal() %>"></td></tr>
	
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
ControllerEmprestimo daoEmprestimo=new ControllerEmprestimo(); 

List<Emprestimo> emprestimo = (List<Emprestimo>) daoEmprestimo.carregaLista(); //request.getAttribute("ListaBibliotecarias");
		
		if (emprestimo!= null && emprestimo.size() > 0)  {%>
		<table border="1" align="center">
			<tr>
				<td>Codigo Exemplar   </td>
				<td>Codigo Cliente     </td>
				<td>Data Emprestimo</td>
				<td>Data Devolução Prevista</td>
				<td>Data Devolução Real</td>
				<td>Açôes   </td>
				
			</tr>
			<% for (Emprestimo a : emprestimo) { %> 
				<tr>
					<td><%=a.getCodExemplar() %></td>
					<td><%=a.getC().getCodCliente() %></td>
					<td><%=a.getDataEmprestimo() %></td>
					<td><%=a.getDataDevolucaoPrevista() %></td>
					<td><%=a.getDataDevolucaoReal() %></td>
					<td>
						<a href="./ControllerEmprestimo?cmd=Excluir&codExemplar=<%=a.getCodExemplar() %>&codCliente=<%=a.getC().getCodCliente() %>">Remover</a>
						<a href="./ControllerEmprestimo?cmd=Atualizar&codExemplar=<%=a.getCodExemplar() %>&codCliente=<%=a.getC().getCodCliente() %>">Editar</a>
					</td>
				</tr>
			<% } %>
		</table>
	<%}%>





</body>
</html>