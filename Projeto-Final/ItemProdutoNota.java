import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.cj.api.mysqla.result.Resultset;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class ItemProdutoNota{
   public int idItemProdutoNota;
   private int idProduto;
   private int idNota;
   private int quantidadeProduto;
   private int idUsuario;

   
   //Contrutor
   
   public ItemProdutoNota(){}
   public ItemProdutoNota(int idItemProdutoNota, int idProduto, int idNota, int quantidadeProduto, int idUsuario){
      this.idItemProdutoNota = idItemProdutoNota;
      this.idProduto = idProduto;
      this.idNota = idNota;
      this.quantidadeProduto = quantidadeProduto; 
      this.idUsuario = idUsuario;
   }
   
   public int getIdItemProdutoNota(){
      return idItemProdutoNota;
   }
   public int getIdProduto(){
      return idProduto;
   }
   public int getIdNota(){
      return idNota;
   }
   public int getQuantidadeProduto(){
      return quantidadeProduto;
   }
   public int getIdUsuario(){
      return idUsuario;
   }
   public void setIdItemProdutoNota(int idItemProdutoNota){
      this.idItemProdutoNota = idItemProdutoNota;
   }
   public void setIdProduto(int idProduto){
      this.idProduto = idProduto;
   }
   public void setIdNota(int idNota){
       this.idNota = idNota;
   }
   public void setQuantidadeProduto(int quantidadeProduto){
      this.quantidadeProduto = quantidadeProduto;
   }
   public void setIdUsuario(int idUsuario){
      this.idUsuario = idUsuario;
   }
   
    public void inserir(ItemProdutoNota novoItemProdutoNota){

    	   try {
         
         
         Connection conn = ConexaoBD.obtemConexao();
         conn.setAutoCommit(true);
         
         String sqlInsert = "insert into ItemProdutoNota (IdItemProdutoNota, IdNota, IdProduto, QuantidadeProduto, IdUsuario)"
				+ "values(?, ?, ?, ?, ?)";

      
         PreparedStatement stm = conn.prepareStatement(sqlInsert);
		   stm.setInt(1, novoItemProdutoNota.getIdItemProdutoNota());
         stm.setInt(2, novoItemProdutoNota.getIdNota());
			stm.setInt(3, novoItemProdutoNota.getIdProduto());
         stm.setInt(4, novoItemProdutoNota.getQuantidadeProduto());
         stm.setInt(5, novoItemProdutoNota.getIdUsuario());
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
  public void excluir(int idItemProdutoNota){
		String sqlDelete = "delete from ItemProdutoNota where idItemProdutoNota = ?";
		   try {
            Connection conn = ConexaoBD.obtemConexao();

            PreparedStatement stm = conn.prepareStatement(sqlDelete);
			   stm.setInt(1, getIdItemProdutoNota());
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
   
   
 }