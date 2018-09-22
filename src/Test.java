import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Context ct = new InitialContext();
			ct.lookup("");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
