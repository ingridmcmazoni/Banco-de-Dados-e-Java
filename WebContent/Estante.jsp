<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.swing.JOptionPane,entidades.*,controller.ControllerEstante,controller.ControllerBibliotecaria,javax.servlet.ServletContext,java.util.*" %>          
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
	Estante e=(Estante)request.getAttribute("Estante");
	
	 if (e == null) {
			e = new Estante();
			
	} 

	
	if(mensagem!=null){%>
	
	<h1><%=mensagem %></h1>
	<script>alert('<%=mensagem%>');</script>
		
	<%}%>
<br>

<form action="./ControllerEstante" method="post">
<table align="center">
	<tr><td colspan="2">Código Estante</td><td colspan="2"><input type="text" name="codEstante" value="<%=e.getCodEstante() %>"></td></tr>
	<tr><td colspan="2">Corredor</td><td colspan="2"><input type="text" name="corredor" value="<%=e.getCorredor()%>"></td></tr>
	<tr><td colspan="2">Prateleira</td><td colspan="2"><input type="text" name="prateleira" value="<%=e.getPrateleira()%>"></td></tr>
	<tr>
		<td colspan="2">Bibliotecária Responsável</td>
		<td colspan="2">
			<% ControllerBibliotecaria cb=new ControllerBibliotecaria(); 
			
				List<Bibliotecaria> listaBiblio=cb.carregaLista();%>
					
			<select name="codBibliotecaria">
					<% for(Bibliotecaria b:listaBiblio){  
							if(e.getB()!=null&&e.getB().getCodBibliotecaria()==b.getCodBibliotecaria()){
					%>
								<option selected><%=b.getCodBibliotecaria()+"-"+b.getNome() %></option>
					    	<%}
							else{ %>
					 			<option><%=b.getCodBibliotecaria()+"-"+b.getNome() %></option>
					 		
					    	<%}
						}%>
					
			</select>
		</td>
	</tr>
	<tr>
		<td align="center"><input type="submit" name="cmd" value="Inserir"></td>
		<td align="center"><input type="submit" name="cmd" value="Atualizar"></td>
		<td align="center"><input type="submit" name="cmd" value="Excluir"></td>
		<td align="center"><input type="submit" name="cmd" value="Pesquisar"></td>
	</tr>
</table>
</form>
<br>
<% 
ControllerEstante daoEstante=new ControllerEstante(); 

List<Estante> estante = (List<Estante>) daoEstante.carregaLista(); //request.getAttribute("ListaBibliotecarias");
		
		if (estante!= null && estante.size() > 0)  {%>
		<table border="1" align="center">
			<tr>
				<td>Codigo Estante   </td>
				<td>Corredor      </td>
				<td>Prateleira</td>
				<td>Bibliotecária Responsavel</td>
				<td>Açôes   </td>
				
			</tr>
			<% for (Estante a : estante) { %> 
				<tr>
					<td><%=a.getCodEstante() %></td>
					<td><%=a.getCorredor() %></td>
					<td><%=a.getPrateleira()%></td>
					<td><%=a.getB().getCodBibliotecaria()%></td>
					<td>
						<a href="./ControllerEstante?cmd=Excluir&codEstante=<%=a.getCodEstante() %>">Remover</a>
						<a href="./ControllerEstante?cmd=Atualizar&codEstante=<%=a.getCodEstante() %>">Editar</a>
					</td>
				</tr>
			<% } %>
		</table>
	<%}%>



</body>
</html>