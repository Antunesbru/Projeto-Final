import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import com.mysql.cj.api.mysqla.result.Resultset;

public class Usuario{
   //Atributos
   public int idUsuario;
   public String nomeUsuario;
   public String email;
   public String senha;
   public String cpf;
   public String endereco;
   public int idTipo;
   
   //metodo construtor
   public Usuario(){}
   public Usuario (int idU, String no, String e, String s, String c, String end, int idT){
      idUsuario = idU;
      nomeUsuario = no;
      email = e;
      senha = s;
      cpf = c;
      endereco = end;
      idTipo = idT;
   }
   
   //metodo de acesso
   public int getIdUsuario(){
      return idUsuario;
   }
   public String getNomeUsuario(){
      return nomeUsuario;
   }
   public String getEmail(){
      return email;
   }
   public String getSenha(){
      return senha;
   }
   public String getCpf(){
      return cpf;
   }
   public String getEndereco(){
      return endereco;
   }
   public int getIdTipo(){
      return idTipo;
   }
   
   
   //metodos modificadores
   public void setIdUsuario(int idU){
      idUsuario = idU;
   }
   public void setNomeUsuario(String no){
      nomeUsuario = no;
   }
   public void setEmail(String e){
      email = e;
   }
   public void setSenha(String s){
      senha = s;
   }
   public void setCpf(String c){
      cpf = c;
   }
   public void setEndereco(String end){
      endereco = end;
   }
   public void setIdTipo(int idT){
      idTipo = idT;
   }
   
   public void imprimirDados() { 
   	System.out.println("Id Usuario: "+idUsuario+"\nNome: "+nomeUsuario+"\nEmail: "+email+"\nCpf: "+cpf+"\nEndereço: "+endereco+"\nTipo de Usuário: "+idTipo); 	
            }
     
  public void inserir(Usuario usuarioNovo){

    	   try {
         Connection conn = ConexaoBD.obtemConexao();
         String sqlInsert = "insert into Usuario (idUsuario, nomeUsuario, email, senha, cpf, endereco, idTipo)"
				+ "values(?, ?, ?, ?, ?, ?, ?)";
         PreparedStatement stm = conn.prepareStatement(sqlInsert);
         stm.setInt(1, usuarioNovo.getIdUsuario());
         stm.setString(2, usuarioNovo.getNomeUsuario());
			stm.setString(3, usuarioNovo.getEmail());
			stm.setString(4, usuarioNovo.getSenha());
         stm.setString(5, usuarioNovo.getCpf());
         stm.setString(6, usuarioNovo.getEndereco());
         stm.setInt(7, usuarioNovo.getIdTipo());
			stm.execute();
         
		}catch (Exception e) {
			e.printStackTrace();
			try
			{
         Connection conn = ConexaoBD.obtemConexao();

			conn.rollback();
			}catch (Exception e1) {
				System.out.print(e1.getStackTrace());
			}
      }
  } 
 public void excluir(String nomeUsuario){
		String sqlDelete = "delete from Usuario where NomeUsuario = ?";
		   try {
            Connection conn = ConexaoBD.obtemConexao();

            PreparedStatement stm = conn.prepareStatement(sqlDelete);
			   stm.setString(1, getNomeUsuario());
			   stm.execute();
           
		   }catch (Exception e) {
			   e.printStackTrace();
			try
			{
          Connection conn = ConexaoBD.obtemConexao();

				conn.rollback();
			}catch (Exception e1) {
				System.out.print(e1.getStackTrace());
			}
		}
	}

	 public void atualizar( Usuario usuarioAtualizado)
	  {
		String sqlUpdate = "update Usuario set NomeUsuario = ?, Email = ?, Senha = ?, CPF = ?, Endereco = ?, IdTipo = ? where IdUsuario = ?";
		try {
         Connection conn = ConexaoBD.obtemConexao();

         PreparedStatement stm = conn.prepareStatement(sqlUpdate);
         stm.setString(1, usuarioAtualizado.getNomeUsuario());
			stm.setString(2, usuarioAtualizado.getEmail());
			stm.setString(3, usuarioAtualizado.getSenha());
         stm.setString(4, usuarioAtualizado.getCpf());
         stm.setString(5, usuarioAtualizado.getEndereco());
         stm.setInt(6, usuarioAtualizado.getIdTipo());
         stm.setInt(7, usuarioAtualizado.getIdUsuario());


			stm.execute();
		}catch (Exception e) {
			e.printStackTrace();
			try
			{
            Connection conn = ConexaoBD.obtemConexao();

				conn.rollback();
			}catch (Exception e1) {
				System.out.print(e1.getStackTrace());
			}
		}
	}



   public void listarUsuarios(){
      try{
         Connection conn = ConexaoBD.obtemConexao();
         //1 especificar o comando sql
         String sql = " SELECT  Usuario.IdUsuario, Usuario.NomeUsuario, Usuario.Email, Usuario.Senha, Usuario.CPF, Usuario.Endereco, Usuario.IdTipo, TipoUsuario.TituloTipo "
         +"FROM Usuario "
         +"INNER JOIN TipoUsuario  ON Usuario.IdTipo = TipoUsuario.IdTipo";;
         //2 pré compilar o comando SQL
         PreparedStatement ps = conn.prepareStatement(sql); 
         //3 configurar os valores que estão faltando (placeholders)
         
         //4 executar o comando
         ResultSet rs = ps.executeQuery();
         while(rs.next()){
            idUsuario = rs.getInt("IdUsuario");
            nomeUsuario = rs.getString ("NomeUsuario");
            email = rs.getString("Email");
            senha = rs.getString ("Senha");
            cpf = rs.getString("Cpf");
            endereco = rs.getString ("Endereco");
            idTipo = rs.getInt ("idTipo");
            TipoUsuario tipo = new TipoUsuario();
            tipo.tituloTipo = rs.getString("TituloTipo");


            String aux = "idUsuario: " + idUsuario;
            aux += "\nNome Usuario: " + nomeUsuario;
            aux += "\nEmail: " +  email ;
            aux += "\nSenha:********** " ;
            aux += "\nCpf: " +  cpf  ;
            aux += "\nEndereço: " +  endereco;
            aux += "\nTitulo do Usuario: " +  tipo.tituloTipo;
            JOptionPane.showMessageDialog (null, aux);
            //System.out.println (aux);
         }
      }
      catch (Exception e){
         System.out.println (e.getMessage());
         e.printStackTrace();
      }
     }

   public boolean login(String email, String senha){
      boolean autenticado = false;
      try{
         Connection conn = ConexaoBD.obtemConexao();
         
         String sql = "SELECT IdUsuario, Email, Senha, IdTipo FROM Usuario WHERE Email = ? and Senha = ?";
         PreparedStatement stm = conn.prepareStatement(sql);
         
			stm.setString(1, getEmail());
			stm.setString(2, getSenha());
         
         ResultSet rs;
         rs = stm.executeQuery();
         
         if(rs.next()){
            idTipo = rs.getInt("IdTipo");
            idUsuario = rs.getInt("IdUsuario");
            autenticado = true;
         }else {
            stm.close();
            return autenticado;
         }
			}catch (Exception e1) {
				System.out.print(e1.getStackTrace());
         
      }
      return autenticado;
   }
}