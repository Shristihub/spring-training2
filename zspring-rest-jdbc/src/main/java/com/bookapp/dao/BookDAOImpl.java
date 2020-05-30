package com.bookapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bookapp.models.Book;

// c->s->dao->jdbctemplate

@Repository
public class BookDAOImpl implements BookDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void addBook(Book book) {
		String sql = "insert into NewBook values(?,?,?,?)";
		Object[] bookArray = { book.getBookid(), book.getTitle(), book.getAuthor(), book.getCategory() };
		jdbcTemplate.update(sql, bookArray);
	}

	@Override
	public Book getById(int bookid) {
		String sql = "select * from newbook where bookid=?";
		//Object[] bookArray = {bookid};
		Book nbook = jdbcTemplate.queryForObject(sql, (rs,num)->{
			Book book = new Book();
			book.setBookid(rs.getInt("bookid"));
			book.setAuthor(rs.getString("author"));
			book.setCategory(rs.getString("category"));
			book.setTitle(rs.getString(2));
			return book;
		}, bookid);
		return nbook;
	}

	@Override
	public List<Book> getAll() {
		String sql = "select * from newbook";
		List<Book> bookList = jdbcTemplate.query(sql, new RowMapper<Book>() {

			public Book mapRow( ResultSet rs, int args) throws SQLException {
				Book book = new Book();
				int bookid = rs.getInt("bookid");
				book.setBookid(bookid);
				book.setAuthor(rs.getString("author"));
				book.setCategory(rs.getString("category"));
				book.setTitle(rs.getString(2));
				return book;
		}
			
		});
		return bookList;
	}

	@Override
	public List<Book> getBooksByAuthor(String author) {
		String sql = "select * from newbook where author=?";
		Object[] bookArray= {author};
		List<Book> bookList = jdbcTemplate.query(sql, bookArray,
		(rs, num)->{
				Book book = new Book();
				int bookid = rs.getInt("bookid");
				book.setBookid(bookid);
				book.setAuthor(rs.getString("author"));
				book.setCategory(rs.getString("category"));
				book.setTitle(rs.getString(2));
				return book;
			});
		return bookList;
	}

	@Override
	public List<Book> getBooksByCategory(String category) {
		String sql = "select * from newbook where category=?";
		Object[] arr = {category};
		List<Book> bookList = jdbcTemplate.query(sql, arr,
		(rs, num)->{
				Book book = new Book();
				int bookid = rs.getInt("bookid");
				book.setBookid(bookid);
				book.setAuthor(rs.getString("author"));
				book.setCategory(rs.getString("category"));
				book.setTitle(rs.getString(2));
				return book;
			});
		return bookList;
	}

	@Override
	public void updateBook(Integer bookid, String category) {
		String sql = " update NewBook set category=? where bookid=?";
		Object[] bookArray = { category, bookid };
		jdbcTemplate.update(sql, bookArray);
	}

	@Override
	public void deleteBook(Integer bookid) {
		String sql = " delete from NewBook where bookid=?";
		jdbcTemplate.update(sql, bookid);
	}

}
