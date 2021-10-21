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

public class ListarNota extends JFrame{
      
      private JTable tabela;
      private DefaultTableModel modelo = new DefaultTableModel();
      private JScrollPane barraRolagem;
      
      public ListarNota (){
      
      super("Natuterra Drinks");
      setIcon();
      criarMenu();
      
      //setLayout(null);
      //Adicionar Colunas
      modelo.addColumn("IdNota");
      modelo.addColumn("Data Compra");
      modelo.addColumn("Endereço de Entrega");
      modelo.addColumn("Tempo de Entrega");
      
      
      
      modelo = conection();
      
      tabela = new JTable(modelo);
      tabela.getColumnModel().getColumn(0).setPreferredWidth(9);
      tabela.getColumnModel().getColumn(1).setPreferredWidth(30);
      tabela.getColumnModel().getColumn(2).setPreferredWidth(14);
      tabela.getColumnModel().getColumn(3).setPreferredWidth(14);
      
      
      
      barraRolagem = new JScrollPane(tabela);
      barraRolagem.setBounds(18, 90, 950, 150);
      add(barraRolagem);
   

      JPanel panelTitulo = new JPanel();
      panelTitulo.setLayout(new FlowLayout());
      //DECLARANDO O Titulo e a Fonte que irá aparecer
      JLabel titulo = new JLabel ("Lista de Notas Fiscais");
      titulo.setFont(new Font("Verdana", Font.PLAIN, 20));
      panelTitulo.add(titulo);
      add(panelTitulo, BorderLayout.NORTH);
      setSize(1000, 550);
      setLocationRelativeTo(null);
      setVisible(true);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      }
       private void criarMenu(){
     JMenu menuProduto = new JMenu("Menu");
     
     //Menu Para Voltar
     SairAction sairAction = new SairAction();
     JMenuItem menuItemNovo = new JMenuItem ("Sair");
     menuItemNovo.addActionListener(sairAction);
     menuProduto.add(menuItemNovo);
     
     //Menu sobre a Empresa
      JMenu menuAjuda = new JMenu("Informações");
      
      SobreAction sobreAction = new SobreAction();
      JMenuItem menuItemSobre = new JMenuItem("Sobre nós...");
      menuItemSobre.addActionListener(sobreAction);
      menuAjuda.add(menuItemSobre);
      
      //Adicionando a Barra de Menu
      JMenuBar barra = new JMenuBar();
      setJMenuBar(barra);
      barra.add(menuProduto);
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
         String sqlSelect = "SELECT * FROM NotaFiscal";

         PreparedStatement stm = conn.prepareStatement(sqlSelect);
         ResultSet rs = stm.executeQuery();
                 
         while (rs.next()) {
         
            modelo.addRow(new Object[]{+rs.getInt("IdNota"), rs.getString("DataCompra"), rs.getString("EnderecoEntrega"), rs.getString("TempoEntrega")
                   
            });         
         }
                  
      } catch (Exception e){
         System.out.println (e.getMessage());
         e.printStackTrace();
      } /*finally {
         ConexaoBD.closeConnection(conn);
      }*/
      
     return modelo;
   }
   
  /*public void actionPerformed(ActionEvent event){
      if(event.getSource() == botaoVoltar){
         new TelaPrincipal();
            dispose();
      }
   }/*/

      
      
      
}