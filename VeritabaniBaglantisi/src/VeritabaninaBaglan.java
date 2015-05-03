import java.sql.Connection;
import java.sql.DriverManager;

public class VeritabaninaBaglan {
   public static void main(String args[]) {
      Connection c = null;
      try {
         Class.forName("org.postgresql.Driver"); /* JDBC Driver'a kay�t yap�ld�.*/
         c = DriverManager 
            .getConnection("jdbc:postgresql://localhost:5432/OkulVeritabani",
            "postgres", "abcde"); /* Veritaban�na kullan�c� ad�, �ifre ve veritaban� ad� kullan�larak 
         giri� yap�ld�.*/
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      System.out.println("Veritabani ile baglanti kuruldu.");
   }
}