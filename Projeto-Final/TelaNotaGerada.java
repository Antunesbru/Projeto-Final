import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.api.mysqla.result.Resultset;

public class TelaNotaGerada extends JFrame {

      private JTable tabela;
   private DefaultTableModel modelo = new DefaultTableModel();
   private JScrollPane barraRolagem;
      
      public TelaNotaGerada (){
      
      super("Natuterra Drinks");
      setIcon();
      criarMenu();

      //Adicionar Colunas
      modelo.addColumn("Id Itens");
      modelo.addColumn("IdNota");
      modelo.addColumn("Quantidade");
      modelo.addColumn("DataCompra");
      modelo.addColumn("NomeProduto");
      modelo.addColumn("Valor");
      modelo.addColumn("EnderecoEntrega");
      modelo.addColumn("Taxa");
      modelo.addColumn("TempoEntrega");
      modelo.addColumn("NomeEmpresa");
      modelo.addColumn("CNPJ");
      modelo.addColumn("RazaoSocial");
      modelo.addColumn("NomeUsuario");
      modelo.addColumn("CPF");
      
      modelo = conection();
      
      tabela = new JTable(modelo);
      tabela.getColumnModel().getColumn(0).setPreferredWidth(9);
      tabela.getColumnModel().getColumn(1).setPreferredWidth(9);
      tabela.getColumnModel().getColumn(2).setPreferredWidth(14);
      tabela.getColumnModel().getColumn(3).setPreferredWidth(14);
      tabela.getColumnModel().getColumn(4).setPreferredWidth(16);
      tabela.getColumnModel().getColumn(5).setPreferredWidth(16);
      tabela.getColumnModel().getColumn(6).setPreferredWidth(9);
      tabela.getColumnModel().getColumn(7).setPreferredWidth(30);
      tabela.getColumnModel().getColumn(8).setPreferredWidth(14);
      tabela.getColumnModel().getColumn(9).setPreferredWidth(30);
      tabela.getColumnModel().getColumn(10).setPreferredWidth(14);
      tabela.getColumnModel().getColumn(11).setPreferredWidth(30);
      tabela.getColumnModel().getColumn(12).setPreferredWidth(14);
      tabela.getColumnModel().getColumn(13).setPreferredWidth(14);
      
      
      
      
      barraRolagem = new JScrollPane(tabela);
      barraRolagem.setBounds(18, 90, 950, 150);
      add(barraRolagem);
      
      
      JPanel panelTitulo = new JPanel();
      panelTitulo.setLayout(new FlowLayout());
      //DECLARANDO O Titulo e a Fonte que irá aparecer
      JLabel titulo = new JLabel ("Lista de Notas Fiscais Completas");
      titulo.setFont(new Font("Verdana", Font.PLAIN, 20));
      panelTitulo.add(titulo);
      add(panelTitulo, BorderLayout.NORTH);
      setSize(1000, 500);
      setLocationRelativeTo(null);
      setVisible(true);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      }
       private void criarMenu(){
     JMenu menuVoltar = new JMenu("Menu");
     
     //Menu Para Voltar
     SairAction sairAction = new SairAction();
     JMenuItem menuItemNovo = new JMenuItem ("Voltar");
     menuItemNovo.addActionListener(sairAction);
     menuVoltar.add(menuItemNovo);
     
     //Menu sobre a Empresa
      JMenu menuAjuda = new JMenu("Informações");
      
      SobreAction sobreAction = new SobreAction();
      JMenuItem menuItemSobre = new JMenuItem("Sobre nós...");
      menuItemSobre.addActionListener(sobreAction);
      menuAjuda.add(menuItemSobre);
      
      //Adicionando a Barra de Menu
      JMenuBar barra = new JMenuBar();
      setJMenuBar(barra);
      barra.add(menuVoltar);
      barra.add(menuAjuda);
     }
     
     //Informaçoes da Empresa
  private class SobreAction implements ActionListener{
   public void actionPerformed(ActionEvent event){
      JOptionPane.showMessageDialog(null, "Natuterra Drinks\nCNPJ:26.465.300/0001-30\nEndereço: Avenida Joao Paulo Ablas N°900, CEP = 06711250\nRazão Social:  Natuterra Drinks - Comercio Atacadista de Bebidas LTDA", "Sobre a Empresa", JOptionPane.PLAIN_MESSAGE);
   }
  
  }
  
  private class SairAction implements ActionListener{
   public void actionPerformed(ActionEvent event){
      new TelaPrincipal();
      setVisible(false);
      dispose();
     }
    }

      
             //Trocando o icone do Java
   private void setIcon(){
      setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images.png")));
   }
   
   
      public DefaultTableModel conection() {
   
      try{
         Connection conn = ConexaoBD.obtemConexao();
         String sqlSelect = " SELECT  ItemProdutoNota.IdItemProdutoNota, ItemProdutoNota.IdNota, ItemProdutoNota.QuantidadeProduto, ItemProdutoNota.IdUsuario,  NotaFiscal.DataCompra, Produto.NomeProduto, Produto.Valor, NotaFiscal.EnderecoEntrega, NotaFiscal.Taxa, NotaFiscal.TempoEntrega, Natuterra.NomeEmpresa, Natuterra.CNPJ,  Natuterra.RazaoSocial, Usuario.NomeUsuario, Usuario.Cpf "
         +" FROM ItemProdutoNota"
         +" INNER JOIN Produto  ON ItemProdutoNota.IdProduto = Produto.IdProduto"
         +" INNER JOIN Natuterra  ON Natuterra.IdEmpresa = Natuterra.IdEmpresa"
         +" INNER JOIN Usuario  ON ItemProdutoNota.IdUsuario = Usuario.IdUsuario"
         +" inner join NotaFiscal on ItemProdutoNota.idNota = NotaFiscal.IdNota";
          
         PreparedStatement stm = conn.prepareStatement(sqlSelect);
         ResultSet rs = stm.executeQuery();
                 
         while (rs.next()) {
         
            modelo.addRow(new Object[]{+rs.getInt("IdItemProdutoNota"), +rs.getInt("IdNota"), +rs.getDouble("QuantidadeProduto"),  rs.getString("DataCompra"), 
            rs.getString("NomeProduto"), +rs.getDouble("Valor"), rs.getString("EnderecoEntrega"), +rs.getDouble("Taxa"),
            +rs.getInt("TempoEntrega"), rs.getString("NomeEmpresa"), rs.getString("CNPJ"), rs.getString("RazaoSocial"), rs.getString("NomeUsuario"),  
             rs.getString("CPF")
             
            });         
         }
                  
      } catch (Exception e){
         System.out.println (e.getMessage());
         e.printStackTrace();
      } /*finally {
         ConexaoBD.closeConnection(conn);
      }/*/
      
     return modelo;
   }
   
  /*public void actionPerformed(ActionEvent event){
      if(event.getSource() == botaoVoltar){
         new TelaPrincipal();
            dispose();
      }
   }/*/

      
      
      
}