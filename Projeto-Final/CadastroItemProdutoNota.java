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

public class CadastroItemProdutoNota extends JFrame  implements ActionListener{


      private JTextField idPField;
      private JTextField idNField;
      private JTextField quantidadeField;
      private JTextField idUField;
      JButton botaoVoltar = new JButton("Voltar");
      JButton botaoGerar = new JButton("Gerar");
      
      public CadastroItemProdutoNota(){
      
      super ("Natuterra Drinks");
      setIcon();
      JPanel panelTitulo = new JPanel();
      panelTitulo.setLayout(new FlowLayout());
      
      
      
     
      
      //DECLARANDO O Titulo e a Fonte que irá aparecer
      JLabel titulo = new JLabel ("Geração de Nota Fiscal");
      titulo.setFont(new Font("Verdana", Font.PLAIN, 20));
      
      panelTitulo.add(titulo);
      
      JPanel panelCadastro = new JPanel();
      panelCadastro.setLayout(new FlowLayout());
            
      JLabel idPLabel = new JLabel("Id do Produto Comprado");
      idPField = new JTextField(60); 
      
      JLabel idNLabel = new JLabel("Id da Nota Fiscal");
      idNField = new JTextField(60); 
      
      JLabel quantidadeLabel = new JLabel("Quantidade de Produtos Comprados");
      quantidadeField = new JTextField(60);
      
      JLabel idULabel = new JLabel("Id do Usuario que Fez a Compra");
      idUField = new JTextField(60);
      
      panelCadastro.add(idNLabel);
      panelCadastro.add(idNField);
      panelCadastro.add(idPLabel);
      panelCadastro.add(idPField);
      panelCadastro.add(quantidadeLabel);
      panelCadastro.add(quantidadeField);
      panelCadastro.add(idULabel);
      panelCadastro.add(idUField);
      
      
      
      
      JPanel panelBotoes = new JPanel();
      panelBotoes.setLayout(new FlowLayout());
      
      
      
      botaoGerar.addActionListener(this);     
      botaoVoltar.addActionListener(this);
      
      
      panelBotoes.add(botaoGerar);
      panelBotoes.add(botaoVoltar);
      
      add(panelTitulo, BorderLayout.NORTH);
      add(panelCadastro, BorderLayout.CENTER);
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
      if(event.getSource() == botaoGerar){
         ItemProdutoNota itemProdutoNota = new ItemProdutoNota();
         itemProdutoNota.setIdNota(Integer.parseInt(idNField.getText()));
         itemProdutoNota.setIdProduto(Integer.parseInt(idPField.getText()));         
         itemProdutoNota.setQuantidadeProduto(Integer.parseInt(quantidadeField.getText()));
         itemProdutoNota.setIdUsuario(Integer.parseInt(idUField.getText()));
         itemProdutoNota.inserir(itemProdutoNota);
         JOptionPane.showMessageDialog(null, "Itens Cadastrados com Sucesso!", "Nota Fiscal", JOptionPane.PLAIN_MESSAGE);
         idPField.setText("");
         quantidadeField.setText("");
      } else if(event.getSource() == botaoVoltar){
            new TelaPrincipal();
            dispose();
         }
      }
    }




