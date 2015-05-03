import java.sql.Connection;
import java.sql.DriverManager;

public class VeritabaninaBaglan {
   public static void main(String args[]) {
      Connection c = null;
      try {
         Class.forName("org.postgresql.Driver"); /* JDBC Driver'a kayýt yapýldý.*/
         c = DriverManager 
            .getConnection("jdbc:postgresql://localhost:5432/OkulVeritabani",
            "postgres", "abcde"); /* Veritabanýna kullanýcý adý, þifre ve veritabaný adý kullanýlarak 
         giriþ yapýldý.*/
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      System.out.println("Veritabani ile baglanti kuruldu.");
   }
}