package car.tp4.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import car.tp4.entity.Book;

public interface BookDAO {

	@SqlUpdate("create table if not exists books (id integer primary key autoincrement, title varchar(100), author varchar(100), year integer, qty integer)")
	void createTable();
	
	@SqlQuery("select id, title, author, year, qty from books where id = :id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Book selectById(@Bind("id") int id);

	@SqlQuery("select id, title, author, year, qty from books")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Book> selectAll();

	@SqlUpdate("insert into books (title, author, year, qty) values (:title, :author, :year, :qty)")
	@GetGeneratedKeys
	int insert(@Bind("title") String title, @Bind("author") String author, @Bind("year") int year, @Bind("qty") int qty);
	
	@SqlUpdate("drop table if exists books")
	void dropTable();
}
