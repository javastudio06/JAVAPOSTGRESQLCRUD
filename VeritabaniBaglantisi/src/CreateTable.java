import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class CreateTable {
   public static void main( String args[] )
     {
       Connection c = null;   
       Statement stmt = null;
       try {
         Class.forName("org.postgresql.Driver");  
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/OkulVeritabani",
            "postgres", "abcde");  /* Veritaban�na kullan�c� ad�, �ifre ve veritaban� ad� kullan�larak 
            giri� yap�ld�.*/
         System.out.println("Veritabani ile baglanti kuruldu.");

         stmt = c.createStatement(); /* Connection nesnesinin createStatement metodu kullan�larak
         statement nesnesi olu�turuldu. */
         String sql = "CREATE TABLE OGRENCI " +
                      "(ONO INT PRIMARY KEY   NOT NULL," +
                      " AD   TEXT    NOT NULL, " +
                      " SOYAD    TEXT     NOT NULL, " +
                      " ADRES        CHAR(100) )";
         stmt.executeUpdate(sql); /* statement nesnesinin executeUpdate metodu kullan�larak sql ifadesi
         �al��t�r�ld� ve b�ylece bir ogrenci isminde bir tablo olu�turuldu. */
         stmt.close(); /*statement ifadesi kapat�ld�.*/
         c.close();    /*statement ifadesi kapat�ld�.*/
       } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
       }
       System.out.println("Tablo ba�ar� ile olu�turuldu.");
     }
}