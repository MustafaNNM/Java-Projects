package ornek;

import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "bookListBean")
@SessionScoped
public class BookList {

	Collection<Book> books;

	public Collection<Book> getBooks() {

		SampleDB sampleDB = new SampleDB();
		return sampleDB.getAllBooks();
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}
}
