import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertData {
   public static void main(String args[]) {
      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/OkulVeritabani",
            "postgres", "abcde");
        
         System.out.println("Veritaban�na ba�lant� ba�ar� ile sa�land�.");

         stmt = c.createStatement(); /* Connection nesnesinin createStatement metodu kullan�larak
         statement nesnesi olu�turuldu. */
         String sql = "INSERT INTO OGRENCI (ONO,AD,SOYAD,ADRES) "
               + "VALUES (1, 'Mehmet','Can', 'Ankara');"; /* INSERT ifadesi ile tabloya veri eklenir.*/
         stmt.executeUpdate(sql);

         sql = "INSERT INTO OGRENCI (ONO,AD,SOYAD,ADRES) "
               + "VALUES (2, 'S�leyman', 'Ata', 'Ankara' );";  /* INSERT ifadesi ile tabloya veri eklenir.*/
         stmt.executeUpdate(sql);

         sql = "INSERT INTO OGRENCI (ONO,AD,SOYAD,ADRES) "
               + "VALUES (3, 'Mehmet Ali', 'Alt�nda�', 'Ankara');";    /* INSERT ifadesi ile tabloya veri eklenir.*/
         stmt.executeUpdate(sql); /*statement nesnesinin executeUpdate metodu ile bir string olan sql ifadesi �al��t�r�l�r.*/

         stmt.close();
         
         c.close();
      } catch (Exception e) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("Kay�tlar ba�ar� ile girildi.");
   }
}