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

public class ExcluirProduto extends JFrame implements ActionListener  {
    private JTextField idField;
    JButton botaoDeletar = new JButton("Deletar");
    
    JButton botaoVoltar = new JButton("Voltar");
    
    public ExcluirProduto(){
      
      super ("Natuterra Drinks");
      setIcon();
      JPanel panelTitulo = new JPanel();
      panelTitulo.setLayout(new FlowLayout());
      
      
      
     
      
      //DECLARANDO O Titulo e a Fonte que irá aparecer
      JLabel titulo = new JLabel ("Excluir Produtos");
      titulo.setFont(new Font("Verdana", Font.PLAIN, 20));
      
      panelTitulo.add(titulo);
      
      JPanel panelDeletar = new JPanel();
      panelDeletar.setLayout(new FlowLayout());
      
      JLabel idLabel = new JLabel("Qual a Identificação do Produto que deseja Excluir?");
      idField = new JTextField(30);
   
       
      
      
      panelDeletar.add(idLabel);
      panelDeletar.add(idField);
      
      
      
      
      JPanel panelBotoes = new JPanel();
      panelBotoes.setLayout(new FlowLayout());
      
      
      
      botaoDeletar.addActionListener(this);
      
      
      botaoVoltar.addActionListener(this);
     
           
      panelBotoes.add(botaoDeletar);
      panelBotoes.add(botaoVoltar);
      
      add(panelTitulo, BorderLayout.NORTH);
      add(panelDeletar, BorderLayout.CENTER);
      add(panelBotoes, BorderLayout.SOUTH);
   

      
      setSize(400, 200);
      setLocationRelativeTo(null);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      }
      
          //Trocando o icone do Java
       private void setIcon(){
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images.png")));
      }
      
      
      public void actionPerformed(ActionEvent e){
         if(e.getSource() == botaoDeletar){
             Produto produto = new Produto();
             
             produto.setIdProduto(Integer.parseInt(idField.getText()));
             produto.excluir(produto.idProduto);
             JOptionPane.showMessageDialog(null, "Produto Excluido Com Sucesso!", "Exclusão", JOptionPane.PLAIN_MESSAGE);
             idField.setText("");

         }else if(e.getSource() == botaoVoltar){
            new TelaPrincipal();
            dispose();
         }
      }
}