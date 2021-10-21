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

public class CadastroNotaFiscal extends JFrame  implements ActionListener{


      private JTextField dataField;
      private JTextField idEmField;
      private JTextField taxaField;
      private JTextField enderecoEField;
      private JTextField tempoField;
      JButton botaoVoltar = new JButton("Voltar");
      JButton botaoGerar = new JButton("Cadastrar Nota");
      
      public CadastroNotaFiscal(){
      
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
      
      JLabel dataLabel = new JLabel("Data da Compra");
      dataField = new JTextField(60);
      
      
      JLabel idEmLabel = new JLabel("Id Empresa");
      idEmField = new JTextField("1",60); 
      
      JLabel taxaLabel = new JLabel("Valor da Taxa de Entrega");
      taxaField = new JTextField(60);
      
      JLabel enderecoELabel = new JLabel("Endereço de Entrega");
      enderecoEField = new JTextField(60);
      
      
      JLabel tempoLabel = new JLabel("Tempo de Entrega? (Em dias Uteis)");
      tempoField = new JTextField(60); 
      
     
      panelCadastro.add(dataLabel);
      panelCadastro.add(dataField);
      panelCadastro.add(idEmLabel);
      panelCadastro.add(idEmField);
      panelCadastro.add(enderecoELabel);
      panelCadastro.add(enderecoEField);
      panelCadastro.add(taxaLabel);
      panelCadastro.add(taxaField); 
      panelCadastro.add(tempoLabel);
      panelCadastro.add(tempoField);
      
      
      
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
         NotaFiscal notaFiscal = new NotaFiscal();
         notaFiscal.setDataCompra(dataField.getText());
         notaFiscal.setIdEmpresa(Integer.parseInt(idEmField.getText()));
         notaFiscal.setTaxa(Double.parseDouble(taxaField.getText()));
         notaFiscal.setEnderecoEntrega(enderecoEField.getText());
         notaFiscal.setTempoEntrega(Integer.parseInt(tempoField.getText()));
         notaFiscal.inserir(notaFiscal);
         JOptionPane.showMessageDialog(null, "Nota Criada com Sucesso!" , "Nota Fiscal", JOptionPane.PLAIN_MESSAGE);
         dataField.setText("");
         taxaField.setText("");
         enderecoEField.setText("");
         tempoField.setText("");
      } else if(event.getSource() == botaoVoltar){
            new TelaPrincipal();
            dispose();
         }
      }
    }




