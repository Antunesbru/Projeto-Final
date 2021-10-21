import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;

public class TelaPrincipal extends JFrame implements ActionListener {
   private JLabel texto;
   private JLabel texto1;
   private JLabel texto2;
   private JButton botaoCadastrarP;
   private JButton botaoExcluirP;
   private JButton botaoAtualizarP;
   private JButton botaoListarP;
   private JLabel texto3;
   private JButton botaoCadastrarU;
   private JButton botaoExcluirU;
   private JButton botaoAtualizarU;
   private JButton botaoListarU;
   private JLabel texto4;
   private JButton botaoCadastrarE;
   private JButton botaoExcluirE;
   private JButton botaoAtualizarE;
   private JButton botaoListarE;
   private JLabel texto5;
   private JButton botaoCadastrarN;
   private JButton botaoCadastrarI;
   private JButton botaoExcluirI;
   private JButton botaoListarN;
   private JButton botaoListarI;
   
   
   
   
   public TelaPrincipal () {
      super ("Natuterra Drinks");
      setIcon();
      criarMenu();
      
      
      setLayout(null);
      
      texto = new JLabel("Natuterra Drinks");
      texto.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 20));
      texto.setBounds(285, 10, 170, 30);
      add(texto);
      texto1 = new JLabel("Bem vindo ! A Tela Principal");
      texto1.setFont(new Font("times new roman", Font.PLAIN, 15));
      texto1.setBounds(270, 30, 180, 40);
      add(texto1);
      
      texto2 = new JLabel("Produto");
      texto2.setFont(new Font("times new roman", Font.PLAIN, 17));
      texto2.setBounds(310, 55, 180, 40);
      add(texto2);
      botaoCadastrarP = new JButton("Cadastrar");
      botaoExcluirP = new JButton("Excluir");
      botaoAtualizarP = new JButton("Atualizar");
      botaoListarP = new JButton("Listar");
      
      texto3 = new JLabel("Usuários");
      texto3.setFont(new Font("times new roman", Font.PLAIN, 17));
      texto3.setBounds(310, 140, 220, 40);
      add(texto3);
      botaoCadastrarU = new JButton("Cadastrar");
      botaoExcluirU = new JButton("Excluir");
      botaoAtualizarU = new JButton("Atualizar");
      botaoListarU = new JButton("Listar");
      
      texto5 = new JLabel("Nota Fiscal");
      texto5.setFont(new Font("times new roman", Font.PLAIN, 17));
      texto5.setBounds(300, 225, 220, 40);
      add(texto5);
      botaoCadastrarN = new JButton("Gerar");
      botaoCadastrarI = new JButton("Add Itens");
      botaoExcluirI = new JButton("Excluir");
      botaoListarN = new JButton("Listar");
      botaoListarI = new JButton("Nota Gerada");

      
      Container caixa = getContentPane();
      //caixa.setLayout(new FlowLayout());
      
      //TITULOS
      caixa.add(texto);
      caixa.add(texto1);
      //FUNÇOES PRODUTO
      caixa.add(texto2);
      caixa.add(botaoCadastrarP);
      caixa.add(botaoExcluirP);
      caixa.add(botaoAtualizarP);
      caixa.add(botaoListarP);
      //FUNÇOES USUÁRIO
      caixa.add(texto3);
      caixa.add(botaoCadastrarU);
      caixa.add(botaoExcluirU);
      caixa.add(botaoAtualizarU);
      caixa.add(botaoListarU);

      //FUNÇOES Nota Fiscal
      caixa.add(texto5);
      caixa.add(botaoCadastrarN);
      caixa.add(botaoCadastrarI);
      caixa.add(botaoExcluirI);
      caixa.add(botaoListarN);
      caixa.add(botaoListarI);
      
      
      //Botões Produtos
      botaoExcluirP.setBounds(215, 100, 110, 35);
      add(botaoExcluirP);
      botaoCadastrarP.setBounds(70, 100, 110, 35);
      add(botaoCadastrarP);
      botaoAtualizarP.setBounds(355, 100, 110, 35);
      add(botaoAtualizarP);
      botaoListarP.setBounds(500, 100, 110, 35);
      add(botaoListarP);
      botaoCadastrarP.addActionListener(this);
      botaoExcluirP.addActionListener(this);
      botaoAtualizarP.addActionListener(this);
      botaoListarP.addActionListener(this);
      
      //Botões Usuário
      botaoExcluirU.setBounds(215, 185, 110, 35);
      add(botaoExcluirU);
      botaoCadastrarU.setBounds(70, 185, 110, 35);
      add(botaoCadastrarU);
      botaoAtualizarU.setBounds(355, 185, 110, 35);
      add(botaoAtualizarU);
      botaoListarU.setBounds(500, 185, 110, 35);
      add(botaoListarU);
      botaoCadastrarU.addActionListener(this);
      botaoExcluirU.addActionListener(this);
      botaoAtualizarU.addActionListener(this);
      botaoListarU.addActionListener(this);
      
      /*Botões Entrega
      botaoExcluirE.setBounds(215, 270, 110, 35);
      add(botaoExcluirE);
      botaoCadastrarE.setBounds(70, 270, 110, 35);
      add(botaoCadastrarE);
      botaoAtualizarE.setBounds(355, 270, 110, 35);
      add(botaoAtualizarE);
      botaoListarE.setBounds(500, 270, 110, 35);
      add(botaoListarE);
      botaoCadastrarE.addActionListener(this);
      botaoExcluirE.addActionListener(this);
      botaoAtualizarE.addActionListener(this);
      botaoListarE.addActionListener(this);*/
      
      //Botões Nota Fiscal
      botaoCadastrarN.setBounds(70, 270, 110, 35);
      add(botaoCadastrarN);
      botaoCadastrarI.setBounds(215, 270, 110, 35);
      add(botaoCadastrarI);
      botaoExcluirI.setBounds(355, 270, 110, 35);
      add(botaoExcluirI);
      botaoListarN.setBounds(500, 270, 110, 35);
      add(botaoListarN);
      botaoListarI.setBounds(285, 335, 110, 35);
      add(botaoListarI);
      botaoCadastrarN.addActionListener(this);
      botaoCadastrarI.addActionListener(this);
      botaoExcluirI.addActionListener(this);
      botaoListarN.addActionListener(this);
      botaoListarI.addActionListener(this);


      setSize(700, 500);
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
      new TelaLogin();
      setVisible(false);
      dispose();
     }
    }
   
   //Trocando o icone do Java
   private void setIcon(){
      setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images.png")));
   }
   
    public void actionPerformed(ActionEvent e){
         if(e.getSource() == botaoCadastrarP){
            new CadastroProduto();
            setVisible(false);
            dispose();
         } if(e.getSource() == botaoExcluirP){
            new ExcluirProduto();
            setVisible(false);
            dispose();
          }if(e.getSource() == botaoAtualizarP){
            new AtualizarProduto();
            setVisible(false);
            dispose();
          }if(e.getSource() == botaoListarP){
            new ListarProduto();
            setVisible(false);
            dispose();
            }if(e.getSource() == botaoCadastrarU){
            new CadastroUsuario();
            setVisible(false);
            dispose();
          }if(e.getSource() == botaoExcluirU){
            new ExcluirUsuario();
            setVisible(false);
            dispose();
          }if(e.getSource() == botaoAtualizarU){
            new AtualizarUsuario();
            setVisible(false);
            dispose();
          }if(e.getSource() == botaoListarU){
            new ListarUsuarios();
            setVisible(false);
            dispose();
          }if(e.getSource() == botaoCadastrarN){
            new CadastroNotaFiscal();
            setVisible(false);
            dispose();
          }if(e.getSource() == botaoCadastrarI){
            new CadastroItemProdutoNota();
            setVisible(false);
            dispose();
          }if(e.getSource() == botaoExcluirI){
            new ExcluirNotaFiscal();
            setVisible(false);
            dispose();
          }if(e.getSource() == botaoListarI){
            new TelaNotaGerada();
            setVisible(false);
            dispose();
          }if(e.getSource() == botaoListarN){
            new ListarNota();
            setVisible(false);
            dispose();
          }
      }
 }

