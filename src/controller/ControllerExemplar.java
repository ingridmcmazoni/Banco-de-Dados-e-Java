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

import dao.DaoExemplar;
import dao.DaoLivro;
import entidades.*;


/**
 * Servlet implementation class ControllerExemplar
 */
@WebServlet("/ControllerExemplar")
public class ControllerExemplar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerExemplar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn=request.getParameter("cmd");
		if(btn.equalsIgnoreCase("Atualizar")){
			
			
			try{
				Exemplar p2;
				
				Livro l=new Livro();
				l.setCodLivro(Integer.parseInt(request.getParameter("livro")));
				
				
				Editora e=new Editora();
				e.setCodEditora(Integer.parseInt(request.getParameter("editora")));
			
				Exemplar la=new Exemplar();
				la.setEditora(e);
				la.setLivro(l);
								
				DaoExemplar daoExemplar=new DaoExemplar();
				
			
				if((p2=daoExemplar.consultaExemplar2(la))!=null){
			
					request.setAttribute("Exemplar", p2);
					request.setAttribute("Mensagem", "O exemplar foi pesquisado com sucesso !");
					
					
				}
				else{
					request.setAttribute("Mensagem", "O exemplar não foi encontrado !");
					
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
				RequestDispatcher rd = request.getRequestDispatcher("./Exemplar.jsp");
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
				
				
				Livro l=new Livro();
				String livro=String.valueOf(request.getParameter("livro").charAt(0));
				l.setCodLivro(Integer.parseInt(livro));
				
				Editora e=new Editora();
				String editora=String.valueOf(request.getParameter("editora").charAt(0));
				e.setCodEditora(Integer.parseInt(editora));
				
				Estante et=new Estante();
				String estante=String.valueOf(request.getParameter("estante").charAt(0));
				et.setCodEstante(Integer.parseInt(estante));
				
				
				Exemplar la=new Exemplar();
				la.setCodExemplar(Integer.parseInt(request.getParameter("exemplar")));
				
				la.setEditora(e);
				la.setLivro(l);
				la.setEstante(et);
				
				DaoExemplar daoExemplar=new DaoExemplar();
				
				daoExemplar.insereExemplar1(la);
				request.setAttribute("Mensagem", "O exemplar foi cadastrado na editora com sucesso !");
				
			
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
				RequestDispatcher rd = request.getRequestDispatcher("./Exemplar.jsp");
				rd.include( request, response );
			}
			
				
		}
		else if(btn.equalsIgnoreCase("Atualizar")){
			
			
			try{
				
				Livro l=new Livro();
				String livro=String.valueOf(request.getParameter("livro").charAt(0));
				l.setCodLivro(Integer.parseInt(livro));
				
				
				Editora e=new Editora();
				String editora=String.valueOf(request.getParameter("editora").charAt(0));
				e.setCodEditora(Integer.parseInt(editora));
				
				Estante et=new Estante();
				String estante=String.valueOf(request.getParameter("estante").charAt(0));
				et.setCodEstante(Integer.parseInt(estante));
				
				Exemplar la=new Exemplar();
				la.setCodExemplar(Integer.parseInt(request.getParameter("exemplar")));
				la.setEditora(e);
				la.setLivro(l);
				la.setEstante(et);
				
				DaoExemplar daoExemplar=new DaoExemplar();
				
				daoExemplar.atualizaExemplar1(la);
				request.setAttribute("Mensagem", "O exemplar foi atualizado na editora com sucesso !");
				request.setAttribute("ListaLivros",daoExemplar.consultaListaExemplar());
				
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
				RequestDispatcher rd = request.getRequestDispatcher("./Exemplar.jsp");
				rd.include( request, response );
			}
			
			
			
			
				
			}
			else if(btn.equalsIgnoreCase("Excluir")){
				
				
					try{
						Livro l=new Livro();
						String livro=String.valueOf(request.getParameter("livro").charAt(0));
						l.setCodLivro(Integer.parseInt(livro));
						
						
						Editora e=new Editora();
						String editora=String.valueOf(request.getParameter("editora").charAt(0));
						e.setCodEditora(Integer.parseInt(editora));
						
						Estante et=new Estante();
						String estante=String.valueOf(request.getParameter("estante").charAt(0));
						et.setCodEstante(Integer.parseInt(estante));
						
						Exemplar la=new Exemplar();
						la.setCodExemplar(Integer.parseInt(request.getParameter("exemplar")));
						la.setEditora(e);
						la.setLivro(l);
						la.setEstante(et);
						
						DaoExemplar daoExemplar=new DaoExemplar();
									
						
						
						daoExemplar.excluiExemplar(la);
						request.setAttribute("Mensagem", "O exemplar foi removido da editora com sucesso !");
						request.setAttribute("ListaLivros",daoExemplar.consultaListaExemplar());
						
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
						RequestDispatcher rd = request.getRequestDispatcher("./Exemplar.jsp");
						rd.include( request, response );
					}
				
				
					
				}
				else if(btn.equalsIgnoreCase("Pesquisar")){
					
					
					try{
						Exemplar p2;
						
						Livro l=new Livro();
						String livro=String.valueOf(request.getParameter("livro").charAt(0));
						l.setCodLivro(Integer.parseInt(livro));
						
						
						Editora e=new Editora();
						String editora=String.valueOf(request.getParameter("editora").charAt(0));
						e.setCodEditora(Integer.parseInt(editora));
						
						Estante et=new Estante();
						String estante=String.valueOf(request.getParameter("estante").charAt(0));
						et.setCodEstante(Integer.parseInt(estante));
						
						Exemplar la=new Exemplar();
						la.setCodExemplar(Integer.parseInt(request.getParameter("exemplar")));
						la.setEditora(e);
						la.setLivro(l);
						la.setEstante(et);
						
						DaoExemplar daoExemplar=new DaoExemplar();
						
					
						if((p2=daoExemplar.consultaExemplar(la))!=null){
					
							request.setAttribute("Exemplar", p2);
							request.setAttribute("Mensagem", "O exemplar foi pesquisado com sucesso !");
							
							
						}
						else{
							request.setAttribute("Mensagem", "O exemplar não foi encontrado !");
							
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
						RequestDispatcher rd = request.getRequestDispatcher("./Exemplar.jsp");
						rd.include( request, response );
					}
					
					
					
				}
	}
	
	
	public List<Exemplar> carregaLista(){
		DaoExemplar daoExemplar=new DaoExemplar();
		
		try {
			return daoExemplar.consultaListaExemplar();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
		
	}

	



