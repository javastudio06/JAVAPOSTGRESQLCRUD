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
        
         System.out.println("Veritabanýna baðlantý baþarý ile saðlandý.");

         stmt = c.createStatement(); /* Connection nesnesinin createStatement metodu kullanýlarak
         statement nesnesi oluþturuldu. */
         String sql = "INSERT INTO OGRENCI (ONO,AD,SOYAD,ADRES) "
               + "VALUES (1, 'Mehmet','Can', 'Ankara');"; /* INSERT ifadesi ile tabloya veri eklenir.*/
         stmt.executeUpdate(sql);

         sql = "INSERT INTO OGRENCI (ONO,AD,SOYAD,ADRES) "
               + "VALUES (2, 'Süleyman', 'Ata', 'Ankara' );";  /* INSERT ifadesi ile tabloya veri eklenir.*/
         stmt.executeUpdate(sql);

         sql = "INSERT INTO OGRENCI (ONO,AD,SOYAD,ADRES) "
               + "VALUES (3, 'Mehmet Ali', 'Altýndað', 'Ankara');";    /* INSERT ifadesi ile tabloya veri eklenir.*/
         stmt.executeUpdate(sql); /*statement nesnesinin executeUpdate metodu ile bir string olan sql ifadesi çalýþtýrýlýr.*/

         stmt.close();
         
         c.close();
      } catch (Exception e) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("Kayýtlar baþarý ile girildi.");
   }
}