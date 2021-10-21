import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import javax.swing.JOptionPane;
import com.mysql.cj.api.mysqla.result.Resultset;

public class Produto{
   //atributos
   public int idProduto;
   public String nomeProduto;
   public double valor;
   private int quantidade;
   private String validade;
   
   //metodo construtor
   public Produto (){}
   public Produto (int id, String n, double v, int q, String val){
      idProduto = id;
      nomeProduto = n;
      valor = v;
      quantidade = q;
      validade = val;   
   }
   
   public Produto(int id){
      idProduto = id;
   }
   
   //metodo de acesso
   public int getIdProduto(){
      return idProduto;
   }
   public String getNomeProduto(){
      return nomeProduto;
   }
   public double getValor(){
      return valor;
   }
   public int getQuantidade(){
      return quantidade;
   }
   public String getValidade(){
      return validade;
   } 
   
   
   //metodo modificador
   public void setIdProduto(int id){
      idProduto = id;
   }
   public void setNomeProduto(String n){
      nomeProduto = n;
   }
   public void setValor(double v){
      valor = v;
   }
   public void setQuantidade(int q){
      quantidade = q;
   }
   public void setValidade(String val){
      validade = val;
   }
   
   public void imprimirDados() { 
   	System.out.println("Id: "+idProduto+"\nNome: "+nomeProduto+"\nValor: "+valor+"\nQuantidade: "+quantidade+"\nValidade: "+validade); 	
                }
                
    public void inserir(Produto produtoNovo){

    	   try {
         Connection conn = ConexaoBD.obtemConexao();
         String sqlInsert = "insert into Produto (idProduto, nomeProduto, valor, quantidade, validade)"
				+ "values(?, ?, ?, ?, ?)";
         PreparedStatement stm = conn.prepareStatement(sqlInsert);
         stm.setInt(1, produtoNovo.getIdProduto());
         stm.setString(2, produtoNovo.getNomeProduto());
			stm.setDouble(3, produtoNovo.getValor());
			stm.setInt(4, produtoNovo.getQuantidade());
         stm.setString(5, produtoNovo.getValidade());
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
      public void excluir(int idProduto){
		String sqlDelete = "delete from Produto where idProduto = ?";
		   try {
            Connection conn = ConexaoBD.obtemConexao();

            PreparedStatement stm = conn.prepareStatement(sqlDelete);
			   stm.setInt(1, getIdProduto());
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
   
   public void atualizar( Produto produtoAtualizado)
	{
		String sqlUpdate = "update Produto set NomeProduto = ?, Valor = ?, Quantidade = ?, Validade = ? where IdProduto = ?";
		try {
         Connection conn = ConexaoBD.obtemConexao();

         PreparedStatement stm = conn.prepareStatement(sqlUpdate);
         stm.setString(1, produtoAtualizado.getNomeProduto());
			stm.setDouble(2, produtoAtualizado.getValor());
			stm.setInt(3, produtoAtualizado.getQuantidade());
         stm.setString(4, produtoAtualizado.getValidade());
         stm.setInt(5, produtoAtualizado.getIdProduto());


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
   
  /* public void listarProdutos (){
      try{
         Connection conn = ConexaoBD.obtemConexao();
         //1 especificar o comando sql
         String sql = "SELECT * FROM Produto";
         //2 pré compilar o comando SQL
         PreparedStatement ps = conn.prepareStatement(sql); 
         //3 configurar os valores que estão faltando (placeholders)
         
         //4 executar o comando
         ResultSet rs = ps.executeQuery();
         while(rs.next()){
            idProduto = rs.getInt("IdProduto");
            nomeProduto = rs.getString ("NomeProduto");
            valor = rs.getDouble("Valor");
            quantidade = rs.getInt ("Quantidade");
            peso = rs.getDouble("Peso");
            validade = rs.getString ("Validade");

            String aux = "idProduto: " + idProduto;
            aux += "\nNome Produto: " + nomeProduto;
            aux += "\nvalor:R$ " +  valor ;
            aux += "\nquantidade: " +  quantidade;
            aux += "\npeso: " +  peso + "gramas" ;
            aux += "\nvalidade: " +  validade;
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