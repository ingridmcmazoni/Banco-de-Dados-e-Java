<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="javax.swing.JOptionPane,entidades.*,controller.ControllerEstante,controller.ControllerExemplar,controller.ControllerBibliotecaria,javax.servlet.ServletContext,java.util.*" %>          
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
	Exemplar e=(Exemplar)request.getAttribute("Exemplar");
	
	 if (e == null) {
			e = new Exemplar();
			Editora ed=new Editora();
			Estante es=new Estante();
			Livro l=new Livro();
			
			e.setEditora(ed);
			e.setEstante(es);
			e.setLivro(l);
			
	} 

	
	if(mensagem!=null){%>
	
	<h1><%=mensagem %></h1>
	<script>alert('<%=mensagem%>');</script>
		
	<%}%>
<br>
<form action="./ControllerExemplar" method="post">
<table align="center">
	<tr><td colspan="2">Código Exemplar</td><td colspan="2"><input type="text" name="exemplar" value="<%=e.getCodExemplar()%>"></td></tr>
	<tr><td colspan="2">Código Livro</td><td colspan="2"><input type="text" name="livro" value="<%=e.getLivro().getCodLivro() %>"></td></tr>
	<tr>
		<td colspan="2">Código Estante</td>
		<td>
		<% ControllerEstante cb=new ControllerEstante(); 
			
				List<Estante> listaEstante=cb.carregaLista();%>
					
			<select name="estante">
					<% for(Estante b:listaEstante){  
							if(e.getEstante()!=null&&e.getEstante().getCodEstante() ==b.getCodEstante()){
					%>
								<option selected><%=b.getCodEstante()+"-"+b.getCorredor() %></option>
					    	<%}
							else{ %>
					 			<option><%=b.getCodEstante()+"-"+b.getCorredor() %></option>
					 		
					    	<%}
						}%>
					
			</select>
			</td>
	</tr>
	<tr><td colspan="2">Código Editora</td><td colspan="2"><input type="text" name="editora" value="<%=e.getEditora().getCodEditora() %>"></td></tr>
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
ControllerExemplar daoEd=new ControllerExemplar(); 

List<Exemplar> exemplar = (List<Exemplar>) daoEd.carregaLista(); //request.getAttribute("ListaExemplars");
		
		if (exemplar!= null && exemplar.size() > 0)  {%>
		<table border="1" align="center">
			<tr>
				<td>Codigo Livro    </td>
				<td>Nome      </td>
				<td>Edição</td>
				<td>Ano </td>
				<td>Código Editora </td>
				<td>Editora</td>
				<td>Ações </td>
			</tr>
			<% for (Exemplar a : exemplar) { %> 
				<tr>
					<td><%=a.getLivro().getCodLivro() %></td>
					<td><%=a.getLivro().getTitulo() %></td>
					<td><%=a.getLivro().getEdicao() %></td>
					<td><%=a.getLivro().getAno() %></td>
					<td><%=a.getEditora().getCodEditora() %></td>
					<td><%=a.getEditora().getNome() %></td>
					<td>
						<a href="./ControllerExemplar?cmd=Atualizar&livro=<%=a.getLivro().getCodLivro()%>&editora=<%=a.getEditora().getCodEditora()%>">Editar</a>
					</td>
				</tr>
			<% } %>
		</table>
	<%}%>








</body>
</html>