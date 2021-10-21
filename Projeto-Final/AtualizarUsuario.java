import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.Toolkit;

public class AtualizarUsuario extends JFrame  implements ActionListener{


      private JTextField idUField;
      private JTextField nomeUField;
      private JTextField emailField;
      private JTextField senhaField;
      private JTextField cpfField;
      private JTextField enderecoField;
      private JTextField idTipoField;
      JButton botaoVoltar = new JButton("Voltar");
      JButton botaoSalvar = new JButton("Atualizar");
      
      public AtualizarUsuario(){
      
      super ("Natuterra Drinks");
      setIcon();
      JPanel panelTitulo = new JPanel();
      panelTitulo.setLayout(new FlowLayout());
      
      
      
     
      
      //DECLARANDO O Titulo e a Fonte que irá aparecer
      JLabel titulo = new JLabel ("Atualização de Dados do Usuário");
      titulo.setFont(new Font("Verdana", Font.PLAIN, 20));
      
      panelTitulo.add(titulo);
      
      JPanel panelAtualizacaoU = new JPanel();
      panelAtualizacaoU.setLayout(new FlowLayout());
      
      JLabel idULabel = new JLabel("Qual o Id do Usuário");
      idUField = new JTextField(60);
      
      
      JLabel nomeULabel = new JLabel("Nome do Novo Usuário");
      nomeUField = new JTextField(60);
   
      JLabel emailLabel = new JLabel("Novo Email do Usuário");
      emailField = new JTextField(60);
      
      JLabel senhaLabel = new JLabel("Nova Senha Para Cadastro");
      senhaField = new JTextField(60);
      
      
      JLabel cpfLabel = new JLabel("Novo CPF do Usuário");
      cpfField = new JTextField(60); 
      
      JLabel enderecoLabel = new JLabel("Novo Endereço do Usuário");
      enderecoField = new JTextField(60); 
      
      JLabel idTipoLabel = new JLabel("Qual o Tipo de Usuario?\n(Administrador = 1)\n(Funcionário = 2)\n(Cliente = 3)");
      idTipoField = new JTextField(60);
      
      panelAtualizacaoU.add(idULabel);
      panelAtualizacaoU.add(idUField);
      panelAtualizacaoU.add(nomeULabel);
      panelAtualizacaoU.add(nomeUField);
      panelAtualizacaoU.add(emailLabel);
      panelAtualizacaoU.add(emailField);
      panelAtualizacaoU.add(senhaLabel);
      panelAtualizacaoU.add(senhaField);
      panelAtualizacaoU.add(cpfLabel);
      panelAtualizacaoU.add(cpfField);
      panelAtualizacaoU.add(enderecoLabel);
      panelAtualizacaoU.add(enderecoField);
      panelAtualizacaoU.add(idTipoLabel);
      panelAtualizacaoU.add(idTipoField);
      
      
      
      JPanel panelBotoes = new JPanel();
      panelBotoes.setLayout(new FlowLayout());
           
      botaoSalvar.addActionListener(this);     
      botaoVoltar.addActionListener(this);
      
      panelBotoes.add(botaoSalvar);
      panelBotoes.add(botaoVoltar);
      
      add(panelTitulo, BorderLayout.NORTH);
      add(panelAtualizacaoU, BorderLayout.CENTER);
      add(panelBotoes, BorderLayout.SOUTH);
   

      
      setSize(700, 500);
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
      if(event.getSource() == botaoSalvar){
         Usuario usuario = new Usuario();
            usuario.setIdUsuario(Integer.parseInt(idUField.getText()));
            usuario.setNomeUsuario(nomeUField.getText());
            usuario.setEmail(emailField.getText());
            usuario.setSenha(senhaField.getText());
            usuario.setCpf(cpfField.getText());
            usuario.setEndereco(enderecoField.getText());  
            usuario.setIdTipo(Integer.parseInt(idTipoField.getText()));  
            usuario.atualizar(usuario);
            JOptionPane.showMessageDialog(null, "Atualização dos Dados do Usuário Realizada Com Sucesso", "Atualização", JOptionPane.PLAIN_MESSAGE);
            idUField.setText("");
            nomeUField.setText("");
            emailField.setText("");
            senhaField.setText("");
            cpfField.setText("");
            enderecoField.setText("");
            idTipoField.setText("");
         }else if(event.getSource() == botaoVoltar){
               new TelaPrincipal();
               dispose();
            }
      }
}      

