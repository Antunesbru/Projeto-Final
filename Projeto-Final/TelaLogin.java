import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import com.mysql.cj.api.mysqla.result.Resultset;

public class TelaLogin extends JFrame implements ActionListener {
      
      private JTextField emailField;
      private JPasswordField senhaField;
      JButton botaoSalvar = new JButton("Entrar");
      
      
      public TelaLogin(){
      
      super ("Natuterra Drinks");
      setIcon();
      
      
      JPanel panelTitulo = new JPanel();
      panelTitulo.setLayout(new FlowLayout());
      
      
      
     
      
      //DECLARANDO O Titulo e a Fonte que irá aparecer
      JLabel titulo = new JLabel ("Login");
      titulo.setFont(new Font("Verdana", Font.PLAIN, 20));
      
      panelTitulo.add(titulo);
      
      JPanel panelCadastroU = new JPanel();
      panelCadastroU.setLayout(new FlowLayout());
      
      
   
      JLabel emailLabel = new JLabel("Email do Usuário");
      emailField = new JTextField(30);
      
      JLabel senhaLabel = new JLabel("Senha Para Cadastro");
      senhaField = new JPasswordField(30);
      
      
           
      panelCadastroU.add(emailLabel);
      panelCadastroU.add(emailField);
      panelCadastroU.add(senhaLabel);
      panelCadastroU.add(senhaField);
      
      
      
      
      JPanel panelBotoes = new JPanel();
      panelBotoes.setLayout(new FlowLayout());
      
      
      botaoSalvar.addActionListener(this);     
      
      
      
      panelBotoes.add(botaoSalvar);
      
      
      add(panelTitulo, BorderLayout.NORTH);
      add(panelCadastroU, BorderLayout.CENTER);
      add(panelBotoes, BorderLayout.SOUTH);
   

      
      setSize(400, 300);
      setLocationRelativeTo(null);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      }
      
      //Trocando o icone do Java
   private void setIcon(){
      setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images.png")));
   }
   
      
      public void actionPerformed(ActionEvent event){
         Usuario usuario = new Usuario();
         usuario.setEmail(emailField.getText());
         usuario.setSenha(senhaField.getText());
         if(usuario.login(usuario.email, usuario.senha) && (usuario.idTipo == 2) || (usuario.idTipo == 1)){
         new TelaPrincipal();
         dispose();
      

         }else{
           JOptionPane.showMessageDialog(null, "Login ou Senha Inválidos", "Atenção", JOptionPane.PLAIN_MESSAGE);         }
      }
   }
  
         
         
       
      
      /*Usuario usuario = new Usuario();
      String valor = new String(senhaField.getText());
      boolean resposta = usuario.login(emailField.getText().toString(), valor);
      if((usuario.email.equals(senhaField.getText()) && (event.getSource() == botaoSalvar))){
         new TelaPrincipal();
                 dispose();
      }
      /*if ((resposta == true) && (event.getSource() == botaoSalvar) && (usuario.idTipo == 3)) {
            
                 usuario.setEmail(emailField.getText());
                 usuario.setSenha(senhaField.getText());
                 usuario.login(usuario.email, usuario.senha);
                 new TelaPrincipal();
                 dispose();
            } else if((resposta == true) && (event.getSource() == botaoSalvar) && (usuario.idTipo == 3)) {
                
                new TelaPrincipal();
                dispose();
            }/*/
         
      
   /*if(event.getSource() == botaoSalvar){
         usuario.setEmail(emailField.getText());
         usuario.setSenha(senhaField.getText());
         usuario.login(usuario);
         new TelaPrincipal();
         dispose();
         
         
         
         }/*/
      