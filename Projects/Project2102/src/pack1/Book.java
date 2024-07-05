package pack1;

public class Book {

	int bookId;
	String title;
	
	Author author;

	public Book(int bookId, String title) {
		this.bookId = bookId;
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
}
