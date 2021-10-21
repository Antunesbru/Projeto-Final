import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.cj.api.mysqla.result.Resultset;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscal{
   public int idNota;
   private String dataCompra;
   private int idEmpresa;
   public double taxa;
   public String enderecoEntrega;
   public int tempoEntrega;

   
   //Contrutor
   
   public NotaFiscal(){}
   public NotaFiscal(int idNota, String dataCompra, int idEmpresa, double taxa, String enderecoEntrega, int tempoEntrega){
      this.idNota = idNota;
      this.dataCompra = dataCompra;
      this.idEmpresa = idEmpresa;
      this.taxa = taxa;
      this.enderecoEntrega = enderecoEntrega;
      this.tempoEntrega = tempoEntrega;   
   }
   
   public int getIdNota(){
      return idNota;
   }
   public String getDataCompra(){
      return dataCompra;
   }
   public int getIdEmpresa(){
      return idEmpresa;
   }
   public double getTaxa(){
      return taxa;
   }
   
   public String getEnderecoEntrega(){
      return enderecoEntrega;
   }
   
   public int getTempoEntrega(){
      return tempoEntrega;
   }
   
   public void setIdNota(int idNota){
      this.idNota = idNota;
   }
   public void setDataCompra(String dataCompra){
      this.dataCompra = dataCompra;
   }
   public void setIdEmpresa(int idEmpresa){
      this.idEmpresa = idEmpresa; 
   }
   public void setTaxa(double taxa){
      this.taxa = taxa;
   }
   
   public void setEnderecoEntrega(String enderecoEntrega){
      this.enderecoEntrega = enderecoEntrega;
   }
   
   public void setTempoEntrega(int tempoEntrega){
      this.tempoEntrega = tempoEntrega;
   }

   
    public void inserir(NotaFiscal novaNotaFiscal){

    	   try {
         
         
         Connection conn = ConexaoBD.obtemConexao();
         conn.setAutoCommit(true);
         
         String sqlInsert = "insert into NotaFiscal (IdNota, DataCompra, IdEmpresa, Taxa, EnderecoEntrega, TempoEntrega)"
				+ "values(?, ?, ?, ?, ?, ?)";

      
         PreparedStatement stm = conn.prepareStatement(sqlInsert);
		   stm.setInt(1, novaNotaFiscal.getIdNota());
			stm.setString(2, novaNotaFiscal.getDataCompra());
         stm.setInt(3, novaNotaFiscal.getIdEmpresa());
         stm.setDouble(4, novaNotaFiscal.getTaxa());
			stm.setString(5, novaNotaFiscal.getEnderecoEntrega());
         stm.setInt(6, novaNotaFiscal.getTempoEntrega());
         
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
  
   public void excluir(int idNota){
		String sqlDelete = "delete from NotaFiscal where idNota = ?";
		   try {
            Connection conn = ConexaoBD.obtemConexao();

            PreparedStatement stm = conn.prepareStatement(sqlDelete);
			   stm.setInt(1, getIdNota());
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
   
  /* public void listarNotas(){
      try{
         Connection conn = ConexaoBD.obtemConexao();
         //1 especificar o comando sql
         String sql = " SELECT  NotaFiscal.IdNota, NotaFiscal.IdEntrega, NotaFiscal.DataCompra, NotaFiscal.IdEmpresa, NotaFiscal.IdUsuario, Produto.NomeProduto, Produto.Valor, Produto.Peso, Entrega.EnderecoEntrega, Entrega.Taxa, Entrega.TempoEntrega, Natuterra.NomeEmpresa, Natuterra.Cnpj, Natuterra.Endereco, Natuterra.RazaoSocial,  Usuario.NomeUsuario, Usuario.Cpf "
         +" FROM NotaFiscal "
         +" INNER JOIN Produto  ON NotaFiscal.IdProduto = Produto.IdProduto"
         +" INNER JOIN Entrega  ON NotaFiscal.IdEntrega = Entrega.IdEntrega"
         +" INNER JOIN Natuterra  ON NotaFiscal.IdEmpresa = Natuterra.IdEmpresa"
         +" INNER JOIN Usuario  ON Usuario.IdUsuario = Usuario.IdUsuario";
         
                 //2 pré compilar o comando SQL
         PreparedStatement ps = conn.prepareStatement(sql); 
         //3 configurar os valores que estão faltando (placeholders)
         
         //4 executar o comando
         //System.out.println(ps);
         ResultSet rs = ps.executeQuery();
         while(rs.next()){
            idNota = rs.getInt("IdNota");
            idProduto = rs.getInt ("IdProduto");
            idEntrega = rs.getInt("IdEntrega");
            dataCompra = rs.getString ("DataCompra");
            idEmpresa = rs.getInt("IdEmpresa");
            idUsuario = rs.getInt("IdUsuario");
            
            Produto produto = new Produto();
            produto.nomeProduto = rs.getString("NomeProduto");
            produto.valor = rs.getDouble("Valor");
            produto.peso = rs.getDouble("Peso");
            
            
            Entrega entrega = new Entrega();
            entrega.enderecoEntrega = rs.getString("EnderecoEntrega");
            entrega.taxa = rs.getDouble("Taxa");
            entrega.tempoEntrega = rs.getInt("TempoEntrega");
            double valorFinal = produto.valor + entrega.taxa;
            
            Natuterra natuterra = new Natuterra();
            natuterra.nomeEmpresa = rs.getString("NomeEmpresa");
            natuterra.cnpj = rs.getString("Cnpj");
            natuterra.endereco = rs.getString("endereco");
            natuterra.razaoSocial = rs.getString("RazaoSocial");
            
            Usuario usuario = new Usuario ();
            usuario.nomeUsuario = rs.getString("NomeUsuario");
            usuario.cpf = rs.getString("Cpf");
            
            String aux = "Identificação da Nota: " + idNota;
            aux += "\nNome da Empresa: " +  natuterra.nomeEmpresa;
            aux += "\nCnpj da Empresa: " +  natuterra.cnpj;
            aux += "\nEndereço da Empresa: " +  natuterra.endereco;
            aux += "\nRazão Social: " +  natuterra.razaoSocial;
            aux += "\nDestinatário: " + usuario.nomeUsuario;
            aux += "\nCPF do Cliente: " + usuario.cpf;
            aux += "\nNome do Produto Para ser Entregue: " +  produto.nomeProduto;
            aux += "\nPeso do Produto que será Entregue: " +produto.peso+ "g";
            aux += "\nValor do Produto que será Entregue:R$ " +  produto.valor;
            aux += "\nTaxa de Entrega:R$ " + entrega.taxa;
            aux += "\nEndereço de Entrega: " +  entrega.enderecoEntrega ;
            aux += "\nTempo de Entrega: " +entrega.tempoEntrega+ " Dias Uteis" ;
            aux += "\nValor Total do Pedido:R$ " +valorFinal;
            JOptionPane.showMessageDialog (null, aux);
            //System.out.println (aux);
         }
      }
      catch (Exception e){
         System.out.println (e.getMessage());
         e.printStackTrace();
      }
    }*/
   
	
   


}