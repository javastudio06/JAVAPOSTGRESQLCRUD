import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class UpdateData {
   public static void main( String args[] )
     {
       Connection c = null;
       Statement stmt = null;
       try {
       Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/OkulVeritabani",
            "postgres", "abcde");
       
         System.out.println("Veritaban�na eri�im sa�land�.");
         System.out.println();

         stmt = c.createStatement();
         String sql = "UPDATE OGRENCI set adres = 'Bolu' where ONO=3;"; 
         /* ��renci No'su 3 olan sat�r�n adres k�sm� Bolu olarak g�ncellenir*/
         stmt.executeUpdate(sql);
       

         ResultSet rs = stmt.executeQuery( "SELECT * FROM OGRENCI;" );
         while ( rs.next() ) {
            int ono = rs.getInt("ono");
            String  ad = rs.getString("ad");
            String soyad  = rs.getString("soyad");
            String  adres = rs.getString("adres");
            System.out.println( "�. No = " + ono);
            System.out.println( "Ad = " + ad );
            System.out.println( "Soyad = " + soyad );
            System.out.println( "Adres = " + adres );
            System.out.println();
         }
         rs.close();
         stmt.close();
         c.close();
       } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
       }
       System.out.println("Veri g�ncelleme i�i ba�ar�yla tamamland�.");
     }
}