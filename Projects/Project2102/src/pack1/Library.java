package pack1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Library {
	String output = "";
	ArrayList<Author> authors = new ArrayList<Author>();
	
	public String getString(String message) {
		return JOptionPane.showInputDialog(message);
	}
	
	public int getInt(String message) {
		return Integer.parseInt( JOptionPane.showInputDialog(message) );
	}
	
	
	public void newAuthor() {
		
		Author author = new Author(getInt("Author ID"),
								   getString("Name"),
								   getString("Surname"));
		authors.add(author);
		JOptionPane.showMessageDialog(null, "Author saved!");
	}
	
	
	
	public void newBook(int authorId) {
		
		Book book = new Book(getInt("Book ID"), getString("Book Title"));
		
		for (Author a : authors) {
			if(a.authorId == authorId) {
				a.books.add(book);
				book.setAuthor(a);
			}
		}
		
	}
	
	public void getAuthors() {
		//String output = "";
		/*for (Author a : authors) {
			output += a.authorId+" "+a.name+" "+a.surname+"\n";
			for (Book b : a.books) {
				output += b.bookId+" "+b.title+"\n";
			}
		}
		JOptionPane.showMessageDialog(null, output);*/
		output ="";
		this.authors.forEach(a -> 
			{ output += a.authorId+" "+a.name+" "+a.surname+"\n";
			  a.books.forEach(b -> 
			  {output += b.bookId+" "+b.title+"\n";
			});
		});
		JOptionPane.showMessageDialog(null, output);
	}
	
	public void getAuthor(int authorId) {
		/*String output = "";
		for (Author a : authors) {
			if(a.authorId == authorId) {
				output += a.authorId+" "+a.name+" "+a.surname+"\n";
				for (Book b : a.books) {
					output += b.bookId+" "+b.title+"\n";
				}
			}
		}*/
		
		 this.authors.stream()
					.filter(a -> a.authorId == authorId)
					.findFirst()
					.get()
					.books.forEach(b -> {System.out.println(b.bookId);});;
		
		output="";
		this.authors.stream()
					.filter(a -> a.authorId == authorId)
					.toList().forEach(a -> 
								{ output += a.authorId+" "+a.name+" "+a.surname+"\n"; 
								  a.books.forEach(b -> 
								  	{ output += b.bookId+" "+b.title+"\n";}
								  	);
								  });
		
		JOptionPane.showMessageDialog(null, output);
	}
	
	public void getBooks() {
		
		/*for (Author a : authors) {
			for (Book b : a.books) {
				output += b.bookId+" "+b.title+"\n";
			}
		}
		JOptionPane.showMessageDialog(null, output);*/
		output="";
		this.authors.forEach(asd -> asd.books
										.forEach(b -> 
											{  output+=b.bookId+" "+b.title+"\n";
		}));
		
		
	}
	
	public void getBooks(int authorId) {
		output="";
		/*for (Author a : authors) {
			if(a.authorId==authorId) {
				for (Book b : a.books) {
					output+= output += b.bookId+" "+b.title+"\n";
				}
			}
		}*/
		
		this.authors.stream()
		.filter(a -> a.authorId == authorId)
		.toList().forEach(a -> 
					{ 
					  a.books.forEach(b -> 
					  	{ output += b.bookId+" "+b.title+"\n";}
					  	);
					  });
		
		JOptionPane.showMessageDialog(null, output);
	}
	
	
	
	public static void main(String[] args) {
		
		Library lib = new Library();
		lib.newAuthor();
		lib.newAuthor();
		
		lib.newBook(1);
		lib.newBook(2);
		lib.newBook(2);
		
		lib.getAuthors();
		lib.getAuthor(2);
		lib.getBooks();
		lib.getBooks(2);
		
		
		
	}

}
