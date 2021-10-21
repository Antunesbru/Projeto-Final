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

public class CadastroProduto extends JFrame  implements ActionListener{


      
      private JTextField nomepField;
      private JTextField valorField;
      private JTextField quantidadeField;
      private JTextField validadeField;
      JButton botaoVoltar = new JButton("Voltar");
      JButton botaoSalvar = new JButton("Cadastrar");
      
      public CadastroProduto(){
      
      super ("Natuterra Drinks");
      setIcon();
      JPanel panelTitulo = new JPanel();
      panelTitulo.setLayout(new FlowLayout());
      
      
      
     
      
      //DECLARANDO O Titulo e a Fonte que irá aparecer
      JLabel titulo = new JLabel ("Cadastro de Produtos");
      titulo.setFont(new Font("Verdana", Font.PLAIN, 20));
      
      panelTitulo.add(titulo);
      
      JPanel panelCadastro = new JPanel();
      panelCadastro.setLayout(new FlowLayout());
      
      JLabel nomeLabel = new JLabel("Nome do Produto");
      nomepField = new JTextField(60);
   
      JLabel valorLabel = new JLabel("Valor do Produto");
      valorField = new JTextField(60);
      
      JLabel quantidadeLabel = new JLabel("Quantidade em Estoque");
      quantidadeField = new JTextField(60);
      
      
      JLabel validadeLabel = new JLabel("Validade do Produto");
      validadeField = new JTextField(60); 
      
      
      panelCadastro.add(nomeLabel);
      panelCadastro.add(nomepField);
      panelCadastro.add(valorLabel);
      panelCadastro.add(valorField);
      panelCadastro.add(quantidadeLabel);
      panelCadastro.add(quantidadeField);
      panelCadastro.add(validadeLabel);
      panelCadastro.add(validadeField);
      
      
      
      JPanel panelBotoes = new JPanel();
      panelBotoes.setLayout(new FlowLayout());
      
      
      
      botaoSalvar.addActionListener(this);     
      botaoVoltar.addActionListener(this);
      
      
      panelBotoes.add(botaoSalvar);
      panelBotoes.add(botaoVoltar);
      
      add(panelTitulo, BorderLayout.NORTH);
      add(panelCadastro, BorderLayout.CENTER);
      add(panelBotoes, BorderLayout.SOUTH);
   

      
      setSize(700, 500);
      setLocationRelativeTo(null);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);;
      }
      
       //Trocando o icone do Java
   private void setIcon(){
      setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images.png")));
   }
      
      public void actionPerformed(ActionEvent event){
      if(event.getSource() == botaoSalvar){
         Produto produto = new Produto();
         produto.setNomeProduto(nomepField.getText());
         produto.setValor(Double.parseDouble(valorField.getText()));
         produto.setQuantidade(Integer.parseInt(quantidadeField.getText()));
         produto.setValidade(validadeField.getText());         
         produto.inserir(produto);
         JOptionPane.showMessageDialog(null, "Cadastro do Produto Realizado Com Sucesso!", "Cadastro", JOptionPane.PLAIN_MESSAGE);
         nomepField.setText("");
         valorField.setText("");
         quantidadeField.setText("");
         validadeField.setText(""); 
      } else if(event.getSource() == botaoVoltar){
            new TelaPrincipal();
            dispose();
         }
      }
    }




