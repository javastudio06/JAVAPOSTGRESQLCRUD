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
            "postgres", "abcde");  /* Veritabanýna kullanýcý adý, þifre ve veritabaný adý kullanýlarak 
            giriþ yapýldý.*/
         System.out.println("Veritabani ile baglanti kuruldu.");

         stmt = c.createStatement(); /* Connection nesnesinin createStatement metodu kullanýlarak
         statement nesnesi oluþturuldu. */
         String sql = "CREATE TABLE OGRENCI " +
                      "(ONO INT PRIMARY KEY   NOT NULL," +
                      " AD   TEXT    NOT NULL, " +
                      " SOYAD    TEXT     NOT NULL, " +
                      " ADRES        CHAR(100) )";
         stmt.executeUpdate(sql); /* statement nesnesinin executeUpdate metodu kullanýlarak sql ifadesi
         çalýþtýrýldý ve böylece bir ogrenci isminde bir tablo oluþturuldu. */
         stmt.close(); /*statement ifadesi kapatýldý.*/
         c.close();    /*statement ifadesi kapatýldý.*/
       } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
       }
       System.out.println("Tablo baþarý ile oluþturuldu.");
     }
}