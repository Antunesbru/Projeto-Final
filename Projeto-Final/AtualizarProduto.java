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

public class AtualizarProduto extends JFrame  implements ActionListener{


      private JTextField idProdutoField;
      private JTextField nomepField;
      private JTextField valorField;
      private JTextField quantidadeField;
      private JTextField validadeField;
      JButton botaoVoltar = new JButton("Voltar");
      JButton botaoSalvar = new JButton("Atualizar");
      
      public AtualizarProduto(){
         super ("Natuterra Drinks");
         setIcon();
         JPanel panelTitulo = new JPanel();
         panelTitulo.setLayout(new FlowLayout());
      
      
      
     
      
      //DECLARANDO O Titulo e a Fonte que irá aparecer
      JLabel titulo = new JLabel ("Atualização de Produto");
      titulo.setFont(new Font("Verdana", Font.PLAIN, 20));
      
      panelTitulo.add(titulo);
      
      JPanel panelAtualizacao = new JPanel();
      panelAtualizacao.setLayout(new FlowLayout());
      
      JLabel idProdutoLabel = new JLabel("Qual o Id do Produto que Deseja Atualizar ");
      idProdutoField = new JTextField(60);
      
      
      JLabel nomepLabel = new JLabel("Qual o Novo Nome do Produto");
      nomepField = new JTextField(60);
   
      JLabel valorLabel = new JLabel("Qual o Novo Valor do Produto");
      valorField = new JTextField(60);
      
      JLabel quantidadeLabel = new JLabel("Qual a Nova Quantidade em Estoque");
      quantidadeField = new JTextField(60);
      
      JLabel validadeLabel = new JLabel("Qual a Nova Validade do Produto");
      validadeField = new JTextField(60); 
      
      
      panelAtualizacao.add(idProdutoLabel);
      panelAtualizacao.add(idProdutoField);
      panelAtualizacao.add(nomepLabel);
      panelAtualizacao.add(nomepField);
      panelAtualizacao.add(valorLabel);
      panelAtualizacao.add(valorField);
      panelAtualizacao.add(quantidadeLabel);
      panelAtualizacao.add(quantidadeField);
      panelAtualizacao.add(validadeLabel);
      panelAtualizacao.add(validadeField);
      
      
      
      JPanel panelBotoes = new JPanel();
      panelBotoes.setLayout(new FlowLayout());
      
      botaoSalvar.addActionListener(this);     
      botaoVoltar.addActionListener(this);
      
      panelBotoes.add(botaoSalvar);
      panelBotoes.add(botaoVoltar);
      
      add(panelTitulo, BorderLayout.NORTH);
      add(panelAtualizacao, BorderLayout.CENTER);
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
            Produto produto = new Produto();
            produto.setIdProduto(Integer.parseInt(idProdutoField.getText()));
            produto.setNomeProduto(nomepField.getText());
            produto.setValor(Double.parseDouble(valorField.getText()));
            produto.setQuantidade(Integer.parseInt(quantidadeField.getText()));
            produto.setValidade(validadeField.getText()); 
            produto.atualizar(produto);
            JOptionPane.showMessageDialog(null, "Atualização Realizada Com Sucesso!", "Atualização", JOptionPane.PLAIN_MESSAGE);
            idProdutoField.setText("");
            nomepField.setText("");
            valorField.setText("");
            quantidadeField.setText("");
            validadeField.setText(""); 
   }else if(event.getSource() == botaoVoltar){
            new TelaPrincipal();
            dispose();
         }
      }

 }
   
