import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class SELECTDATA {
   public static void main( String args[] )
     {
       Connection c = null;
       Statement stmt = null;
       try {
       Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/OkulVeritabani",
            "postgres", "abcde");
         System.out.println("Veritaban�na eri�im ba�ar�l� oldu.");
         System.out.println();

         stmt = c.createStatement();
         ResultSet rs = stmt.executeQuery( "SELECT * FROM OGRENCI;" );
         while ( rs.next() ) {
        	
            int ono = rs.getInt("ono");
            String  ad = rs.getString("ad");
            String soyad  = rs.getString("soyad");
            String adres = rs.getString("adres");
            
            
            System.out.println( "�. No = " + ono );
            System.out.println( "Ad = " + ad );
            System.out.println( "Soyad = " + soyad );
            System.out.println("Adres =" + adres);
          
            System.out.println();
         }
         rs.close();
         stmt.close();
         c.close();
       } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
       }
       System.out.println("Veri �ekme i�i ba�ar�yla tamamland�.");
     }
}