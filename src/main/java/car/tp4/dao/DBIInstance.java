package car.tp4.dao;

import org.skife.jdbi.v2.DBI;
import org.sqlite.SQLiteDataSource;

public class DBIInstance {
	public static DBI instance;
	static {
		SQLiteDataSource ds = new SQLiteDataSource();
		ds.setUrl("jdbc:sqlite:"+System.getProperty("java.io.tmpdir")+System.getProperty("file.separator")+"books.db");
		instance = new DBI(ds);
		System.out.println("Database created : " + System.getProperty("java.io.tmpdir")+System.getProperty("file.separator")+"books.db");
		BookDAO bookDAO = instance.open(BookDAO.class);
		bookDAO.createTable();
    }
}
