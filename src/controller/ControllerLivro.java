package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoLivro;
import dao.DaoLivro;
import entidades.Livro;
import entidades.Livro;

/**
 * Servlet implementation class ControllerLivro
 */
@WebServlet("/ControllerLivro")
public class ControllerLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLivro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn=request.getParameter("cmd");
		
		if(btn.equalsIgnoreCase("Excluir")){
				
				
					try{
						Livro p=new Livro();
						p.setCodLivro(Integer.parseInt(request.getParameter("codLivro")));
						DaoLivro daoLivro=new DaoLivro();
						
						
						daoLivro.excluiLivro(p);
						request.setAttribute("Mensagem", "O livro foi removido com sucesso !");
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
						RequestDispatcher rd = request.getRequestDispatcher("./Livro.jsp");
						rd.include( request, response );
					}
			}else if(btn.equalsIgnoreCase("Atualizar")){
					
					
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
						RequestDispatcher rd = request.getRequestDispatcher("./Livro.jsp");
						rd.include( request, response );
					}
					
					
					
				}
				
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn=request.getParameter("cmd");
		
		if(btn.equalsIgnoreCase("Inserir")){
			
			
			try{
				Livro p=new Livro();
				p.setCodLivro(Integer.parseInt(request.getParameter("codLivro")));
				p.setTitulo(request.getParameter("nome"));
				p.setEdicao(Integer.parseInt(request.getParameter("edicao")));
				p.setAno(Integer.parseInt(request.getParameter("ano")));
				
				DaoLivro daoLivro=new DaoLivro();
				
				daoLivro.insereLivro1(p);
				request.setAttribute("Mensagem", "O livro foi adicionado com sucesso !");
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
				RequestDispatcher rd = request.getRequestDispatcher("./Livro.jsp");
				rd.include( request, response );
			}
			
			
				
		}
		else if(btn.equalsIgnoreCase("Atualizar")){
			
			
			try{
				
				Livro p=new Livro();
				
				p.setCodLivro(Integer.parseInt(request.getParameter("codLivro")));
				p.setTitulo(request.getParameter("nome"));
				p.setEdicao(Integer.parseInt(request.getParameter("edicao")));
				p.setAno(Integer.parseInt(request.getParameter("ano")));
				
				DaoLivro daoLivro=new DaoLivro();
				
				daoLivro.atualizaLivro1(p);
				request.setAttribute("Mensagem", "O livro foi atualizado com sucesso !");
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
				RequestDispatcher rd = request.getRequestDispatcher("./Livro.jsp");
				rd.include( request, response );
			}
			
			
			
			
				
			}
			else if(btn.equalsIgnoreCase("Excluir")){
				
					try{
						Livro p=new Livro();
						p.setCodLivro(Integer.parseInt(request.getParameter("codLivro")));
						DaoLivro daoLivro=new DaoLivro();
						
						
						daoLivro.excluiLivro(p);
						request.setAttribute("Mensagem", "O livro foi removido com sucesso !");
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
						RequestDispatcher rd = request.getRequestDispatcher("./Livro.jsp");
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
						RequestDispatcher rd = request.getRequestDispatcher("./Livro.jsp");
						rd.include( request, response );
					}
					
					
				}
		}
		
	
	public List<Livro> carregaLista(){
		DaoLivro daoCli=new DaoLivro();
		
		try {
			return daoCli.consultaListaLivro();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
		
	}


