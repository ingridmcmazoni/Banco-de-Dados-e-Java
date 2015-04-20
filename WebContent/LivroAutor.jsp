<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="javax.swing.JOptionPane,entidades.*,controller.ControllerAutor,controller.ControllerLivro,javax.servlet.ServletContext,java.util.*" %>         
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
<% String mensagem=(String)request.getAttribute("Mensagem");
	LivroAutor l=(LivroAutor)request.getAttribute("LivroAutor");
	
	 if (l == null) {
			l = new LivroAutor();
			
	} 

	
	if(mensagem!=null){%>
	
	<h1><%=mensagem %></h1>
	<script>alert('<%=mensagem%>');</script>
		
	<%}%>
<br>

<form action="./ControllerLivroAutor" method="post">
	<table align="center" style="width: 392px; ">
	<tr><td colspan="4" align="center">Cadastrar Autores do Livro</td></tr>
	<tr>
		<td colspan="2">Livro</td>
		<td colspan=2>
			<% 	
				ControllerLivro ce=new ControllerLivro();
				List<Livro> listaEditora=ce.carregaLista();%>
					
			<select name="codLivro">
					<% for(Livro e:listaEditora){  %>
							
					 	<option><%=e.getCodLivro()+"-"+e.getTitulo()+" "+e.getEdicao()+ "° "+ e.getAno() %></option>
					 		
					<%}%>
			</select>
		</td>			
	</tr>
	<tr>
		<td colspan="2">Autor</td>
		<td colspan="2">
		
			<% 	
				ControllerAutor ca=new ControllerAutor();
				List<Autor> listaAutor=ca.carregaLista();%>
					
			<select name="autor">
					<% for(Autor e:listaAutor){  %>
							
					 	<option><%=e.getCodAutor()+"-"+e.getNome()%></option>
					 		
					<%}%>
			</select>			
			
		</td>
	</tr>
		
	<tr>
		<td colspan=2 align="center"><input type="submit" name="cmd" value="Inserir"></td>
		<td colspan=2 align="center"><input type="submit" name="cmd" value="Excluir"></td>
		
	</tr>
</table>
</form>
<br>
<div align="center"><a href="./Livro.jsp">Voltar</a></div>


</body>
</html>