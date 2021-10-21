import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import com.mysql.cj.api.mysqla.result.Resultset;
public class Natuterra{
   //atributos
   public int idEmpresa;
   public String nomeEmpresa;
   public String cnpj;
   public String endereco;
   public String razaoSocial;
   
   //metodo construtor
   public Natuterra (){}
   public Natuterra(int idE, String nom, String cn, String endE, String r){
      idEmpresa = idE;
      nomeEmpresa = nom;
      cnpj = cn;
      endereco = endE;
      razaoSocial = r;
   }
   
   
   //metodo de acesso
   public int getIdEmpresa(){
      return idEmpresa;
   }
   public String getNomeEmpresa(){
      return nomeEmpresa;
   }
   public String getCnpj(){
      return cnpj;
   }
   public String getEndereco(){
      return endereco;
   }
   public String getRazaoSocial(){
      return razaoSocial;
   }
   
   //metodos modificadores
   public void setIdEmpresa(int idE){
      idEmpresa = idE;
   }
   public void setNomeEmpresa(String nom){
      nomeEmpresa = nom;
   }   
   public void setCnpj(String cn){
      cnpj = cn;
   }
   public void setEndereco(String endE){
      endereco = endE;
   }
   public void setRazaoSocial(String r){
      razaoSocial = r;
   }
    public void listarNatuterra(){
      try{
         Connection conn = ConexaoBD.obtemConexao();
         //1 especificar o comando sql
         String sql = "SELECT * FROM Natuterra";
         //2 pré compilar o comando SQL
         PreparedStatement ps = conn.prepareStatement(sql); 
         //3 configurar os valores que estão faltando (placeholders)
         
         //4 executar o comando
         ResultSet rs = ps.executeQuery();
         while(rs.next()){
            idEmpresa = rs.getInt("IdEmpresa");
            nomeEmpresa = rs.getString ("NomeEmpresa");
            cnpj = rs.getString("Cnpj");
            endereco = rs.getString ("Endereco");
            razaoSocial = rs.getString("RazaoSocial");

            String aux = "\nNome da Empresa: " + nomeEmpresa;
            aux += "\nCNPJ: " +  cnpj ;
            aux += "\nRazão Social: " +razaoSocial+ "." ;
            JOptionPane.showMessageDialog (null, aux);
            //System.out.println (aux);
         }
      }
      catch (Exception e){
         System.out.println (e.getMessage());
         e.printStackTrace();
      }
     }


}