package pack1;

import java.util.ArrayList;

public class Author {

	int authorId;
	String name, surname;
	
	ArrayList<Book> books = new ArrayList<Book>();

	public Author(int authorId, String name, String surname) {
		this.authorId = authorId;
		this.name = name;
		this.surname = surname;
	}
	
	public void addBook(Book b) {
		this.books.add(b);
	}
}
