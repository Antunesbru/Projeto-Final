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
 
public class ListarUsuarios extends JFrame{
	
   private JTable tabela;
   private DefaultTableModel modelo = new DefaultTableModel();
   private JScrollPane barraRolagem;
     
   public ListarUsuarios()
   {
      super("Natuterra Drinks");
	   setIcon();
      //setLayout(null);
      criarMenu();
      TipoUsuario tipo = new TipoUsuario();
      //Adicionar Colunas
      modelo.addColumn("Id U");
      modelo.addColumn("Nome Usuario");
      modelo.addColumn("Email");
     // modelo.addColumn("Senha");
      modelo.addColumn("CPF");
      modelo.addColumn("Endereço");
     // modelo.addColumn("Id Tipo");
      modelo.addColumn("Tipo de Usuário");
            

      modelo = conection();
      
      tabela = new JTable(modelo);
      tabela.getColumnModel().getColumn(0).setPreferredWidth(2);
      tabela.getColumnModel().getColumn(1).setPreferredWidth(34);
      tabela.getColumnModel().getColumn(2).setPreferredWidth(14);
     // tabela.getColumnModel().getColumn(3).setPreferredWidth(14);
      tabela.getColumnModel().getColumn(3).setPreferredWidth(25);
      tabela.getColumnModel().getColumn(4).setPreferredWidth(16);
      //tabela.getColumnModel().getColumn(5).setPreferredWidth(2);
      tabela.getColumnModel().getColumn(5).setPreferredWidth(34);
      
      barraRolagem = new JScrollPane(tabela);
      barraRolagem.setBounds(25, 150, 800, 150);
      add(barraRolagem);
      
      JPanel panelTitulo = new JPanel();
      panelTitulo.setLayout(new FlowLayout());
      //DECLARANDO O Titulo e a Fonte que irá aparecer
      JLabel titulo = new JLabel ("Lista de Usuários");
      titulo.setFont(new Font("Verdana", Font.PLAIN, 20));
      panelTitulo.add(titulo);
      add(panelTitulo, BorderLayout.NORTH);
      setSize(850, 550);
      setLocationRelativeTo(null);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);

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
         String sqlSelect =" SELECT  Usuario.IdUsuario, Usuario.NomeUsuario, Usuario.Email, Usuario.CPF, Usuario.Endereco, TipoUsuario.TituloTipo "
         +" FROM Usuario "
         +" INNER JOIN TipoUsuario  ON Usuario.IdTipo = TipoUsuario.IdTipo";
         PreparedStatement stm = conn.prepareStatement(sqlSelect);
          ResultSet rs = stm.executeQuery();
                 
         while (rs.next()) {
         
            modelo.addRow(new Object[]{+rs.getInt("IdUsuario"), rs.getString("NomeUsuario"), rs.getString("Email") /*rs.getString("Senha")*/, rs.getString("CPF"),
               rs.getString("Endereco"), /*+rs.getInt ("idTipo")*/ rs.getString("TituloTipo")
             
            });         
         }
                  
      } catch (SQLException ex) {
         System.out.println(ex);
      } /*finally {
         ConexaoBD.closeConnection(conn);
      }*/
      
     return modelo;
   }

   
}