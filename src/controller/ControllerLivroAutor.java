package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import entidades.*;

/**
 * Servlet implementation class ControllerLivroAutor
 */
@WebServlet("/ControllerLivroAutor")
public class ControllerLivroAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLivroAutor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn=request.getParameter("cmd");
		
		if(btn.equalsIgnoreCase("Inserir")){
			
			
			try{
				
				Livro l=new Livro();
				String livro=String.valueOf(request.getParameter("codLivro").charAt(0));
				l.setCodLivro(Integer.parseInt(livro));
				
				Autor a=new Autor();
				String autor=String.valueOf(request.getParameter("autor").charAt(0));
				a.setCodAutor(Integer.parseInt(autor));
				
				LivroAutor la=new LivroAutor();
				la.setAutor(a);
				la.setLivro(l);
				
				DaoLivroAutor daoLivro=new DaoLivroAutor();
				
				daoLivro.insereLivro1(la);
				request.setAttribute("Mensagem", "O livro foi cadastrado na editora com sucesso !");
							
			}
			catch(SQLException erro){
				request.setAttribute("Mensagem", erro.getMessage());
				erro.printStackTrace();
				
			
			}
			catch(NumberFormatException erro){
				request.setAttribute("Mensagem", erro.getMessage());
				erro.printStackTrace();
			}
			catch(NullPointerException erro){
				request.setAttribute("Mensagem", erro.getMessage());
				erro.printStackTrace();
			}
			finally{
				RequestDispatcher rd = request.getRequestDispatcher("./LivroAutor.jsp");
				rd.include( request, response );
			}
			
			
				
		}
		else if(btn.equalsIgnoreCase("Atualizar")){
			
			
			try{
				Livro l=new Livro();
				l.setCodLivro(Integer.parseInt(request.getParameter("codLivro")));
				
				Autor a=new Autor();
				String autor=String.valueOf(request.getParameter("autor").charAt(0));
				a.setCodAutor(Integer.parseInt(autor));
				
				LivroAutor la=new LivroAutor();
				la.setAutor(a);
				la.setLivro(l);
				
				DaoLivroAutor daoLivro=new DaoLivroAutor();
							
				daoLivro.atualizaLivro1(la);
				request.setAttribute("Mensagem", "O livro foi atualizado na editora com sucesso !");
				request.setAttribute("ListaLivros",daoLivro.consultaListaLivro());
				
			}
			catch(SQLException erro){
				request.setAttribute("Mensagem", erro.getMessage());
				erro.printStackTrace();

			}
			catch(NumberFormatException erro){
				request.setAttribute("Mensagem", erro.getMessage());
				erro.printStackTrace();
			}
			finally{
				RequestDispatcher rd = request.getRequestDispatcher("./LivroAutor.jsp");
				rd.include( request, response );
			}
			
			
			
			
				
			}
			else if(btn.equalsIgnoreCase("Excluir")){
				
							
				
					try{
						Livro l=new Livro();
						String livro=String.valueOf(request.getParameter("codLivro").charAt(0));
						l.setCodLivro(Integer.parseInt(livro));
						
						Autor a=new Autor();
						String autor=String.valueOf(request.getParameter("autor").charAt(0));
						a.setCodAutor(Integer.parseInt(autor));
						
						LivroAutor la=new LivroAutor();
						la.setAutor(a);
						la.setLivro(l);
						
						DaoLivroAutor daoLivro=new DaoLivroAutor();
						
						
						daoLivro.excluiLivro(la);
						request.setAttribute("Mensagem", "O livro foi removido da editora com sucesso !");
						request.setAttribute("ListaLivros",daoLivro.consultaListaLivro());
						
					}	
					catch(SQLException erro){
						request.setAttribute("Mensagem", erro.getMessage());
						erro.printStackTrace();

					}
					catch(NumberFormatException erro){
						request.setAttribute("Mensagem", erro.getMessage());
						erro.printStackTrace();
					}
					finally{
						RequestDispatcher rd = request.getRequestDispatcher("./LivroAutor.jsp");
						rd.include( request, response );
					}	
				
				
					
				}
				else if(btn.equalsIgnoreCase("Pesquisar")){
					
					
					try{
						Livro p=new Livro();
						Livro p2;
						p.setCodLivro(Integer.parseInt(request.getParameter("codLivro")));
					
						DaoLivro daoLivro=new DaoLivro();
					
						if((p2=daoLivro.consultaLivro(p))!=null){
					
							request.setAttribute("Livro", p2);
							request.setAttribute("Mensagem", "O livro foi pesquisado com sucesso !");
							
							
						}
						else{
							request.setAttribute("Mensagem", "O livro não foi encontrado !");
							
						}
					
					}
					catch(SQLException erro){
						erro.printStackTrace();
						request.setAttribute("Mensagem", erro.getMessage());

					}
					catch(NumberFormatException erro){
						request.setAttribute("Mensagem", erro.getMessage());
						erro.printStackTrace();
					}
					finally{
						RequestDispatcher rd = request.getRequestDispatcher("./LivroAutor.jsp");
						rd.include( request, response );
					}
					
					
					
				}
	}

}
