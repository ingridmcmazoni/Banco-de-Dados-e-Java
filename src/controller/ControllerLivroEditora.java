package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoLivro;
import dao.DaoLivroEditora;
import entidades.Editora;
import entidades.Livro;
import entidades.LivroEditora;

/**
 * Servlet implementation class ControllerLivroEditora
 */
@WebServlet("/ControllerLivroEditora")
public class ControllerLivroEditora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLivroEditora() {
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
				
				Editora e=new Editora();
				String editora=String.valueOf(request.getParameter("editora").charAt(0));
				e.setCodEditora(Integer.parseInt(editora));
				
				LivroEditora la=new LivroEditora();
				la.setEditora(e);
				la.setLivro(l);
				
				DaoLivroEditora daoLivro=new DaoLivroEditora();
				
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
				RequestDispatcher rd = request.getRequestDispatcher("./LivroEditora.jsp");
				rd.include( request, response );
			}
			
				
		}
		else if(btn.equalsIgnoreCase("Atualizar")){
			
			
			try{
				
				Livro l=new Livro();
				String livro=String.valueOf(request.getParameter("codLivro").charAt(0));
				l.setCodLivro(Integer.parseInt(livro));
				
				
				Editora e=new Editora();
				String editora=String.valueOf(request.getParameter("editora").charAt(0));
				e.setCodEditora(Integer.parseInt(editora));
				
				LivroEditora la=new LivroEditora();
				la.setEditora(e);
				la.setLivro(l);
				
				DaoLivroEditora daoLivro=new DaoLivroEditora();
				
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
				RequestDispatcher rd = request.getRequestDispatcher("./LivroEditora.jsp");
				rd.include( request, response );
			}
			
			
			
			
				
			}
			else if(btn.equalsIgnoreCase("Excluir")){
				
				
					try{
						Livro l=new Livro();
						String livro=String.valueOf(request.getParameter("codLivro").charAt(0));
						l.setCodLivro(Integer.parseInt(livro));
						
						
						Editora e=new Editora();
						String editora=String.valueOf(request.getParameter("editora").charAt(0));
						e.setCodEditora(Integer.parseInt(editora));
						
						LivroEditora la=new LivroEditora();
						la.setEditora(e);
						la.setLivro(l);
						
						DaoLivroEditora daoLivro=new DaoLivroEditora();
									
						
						
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
						RequestDispatcher rd = request.getRequestDispatcher("./LivroEditora.jsp");
						rd.include( request, response );
					}
				
				
					
				}
				else if(btn.equalsIgnoreCase("Pesquisar")){
					
					
					try{
						LivroEditora p2;
						
						Livro l=new Livro();
						String livro=String.valueOf(request.getParameter("codLivro").charAt(0));
						l.setCodLivro(Integer.parseInt(livro));
						
						
						Editora e=new Editora();
						String editora=String.valueOf(request.getParameter("editora").charAt(0));
						e.setCodEditora(Integer.parseInt(editora));
						
						LivroEditora la=new LivroEditora();
						la.setEditora(e);
						la.setLivro(l);
						
						
						DaoLivroEditora daoLivro=new DaoLivroEditora();
						
					
						if((p2=daoLivro.consultaLivro(la))!=null){
					
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
						RequestDispatcher rd = request.getRequestDispatcher("./LivroEditora.jsp");
						rd.include( request, response );
					}
					
					
					
				}
	}

	
	
	
	}


