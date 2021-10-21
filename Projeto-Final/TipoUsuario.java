public class TipoUsuario{
   //atributos
   private int idTipo;
   public String tituloTipo;
   
   //construtor
   public TipoUsuario(){}
   public TipoUsuario(int idT, String tt){
      idTipo = idT;
      tituloTipo = tt;
   }
   
   //metodo de acesso
   public int getIdTipo(){
      return idTipo;
   }
   public String getTituloTipo(){
      return tituloTipo;
   }
   
   //metodo modificadores
   public void setIdTipo(int idT){
      idTipo = idT;
   }
   public void setTituloTipo(String tt){
      tituloTipo = tt;
   }
}