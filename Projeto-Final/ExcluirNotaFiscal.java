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

public class ExcluirNotaFiscal extends JFrame  implements ActionListener{


      private JTextField idIField;
      JButton botaoVoltar = new JButton("Voltar");
      JButton botaoExcluir = new JButton("Excluir");
      
      public ExcluirNotaFiscal(){
      
      super ("Natuterra Drinks");
      setIcon();
      JPanel panelTitulo = new JPanel();
      panelTitulo.setLayout(new FlowLayout());
      
      
      
     
      
      //DECLARANDO O Titulo e a Fonte que irá aparecer
      JLabel titulo = new JLabel ("Exclusão da Nota Fiscal");
      titulo.setFont(new Font("Verdana", Font.PLAIN, 20));
      
      panelTitulo.add(titulo);
      
      JPanel panelExcluirN = new JPanel();
      panelExcluirN.setLayout(new FlowLayout());
      
      
      JLabel idILabel = new JLabel("Qual o Id do Item que deseja Excluir");
      idIField = new JTextField(25);
      
      panelExcluirN.add(idILabel);
      panelExcluirN.add(idIField);      
     
      
      
      
      JPanel panelBotoes = new JPanel();
      panelBotoes.setLayout(new FlowLayout());
      
      
      botaoExcluir.addActionListener(this);     
      botaoVoltar.addActionListener(this);
      
      panelBotoes.add(botaoExcluir);
      panelBotoes.add(botaoVoltar);
      
      add(panelTitulo, BorderLayout.NORTH);
      add(panelExcluirN, BorderLayout.CENTER);
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
      
      public void actionPerformed(ActionEvent event){
      if(event.getSource() == botaoExcluir){
         ItemProdutoNota itemProdutoNota = new ItemProdutoNota();
         itemProdutoNota.setIdItemProdutoNota(Integer.parseInt(idIField.getText()));
         itemProdutoNota.excluir(itemProdutoNota.idItemProdutoNota);               
         JOptionPane.showMessageDialog(null, "Notas Excluida Com Sucesso!", "Exclusão", JOptionPane.PLAIN_MESSAGE);
         idIField.setText("");
   }else if(event.getSource() == botaoVoltar){
            new TelaPrincipal();
            dispose();
         }
      }


    }      

