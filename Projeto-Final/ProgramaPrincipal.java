import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import com.mysql.cj.api.mysqla.result.Resultset;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;


public class ProgramaPrincipal{
   public static void main (String [] args)throws SQLException{
   
           try {
            Connection conn = ConexaoBD.obtemConexao();
   
   			conn.setAutoCommit(false);
   		
   					}catch (Exception e) {
   			e.printStackTrace();
         
					}
               
               
        new TelaLogin();
        //new TelaPrincipal();
      
   }
}