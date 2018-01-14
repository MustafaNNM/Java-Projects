package ornek;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "bookBean")
@SessionScoped
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String author;
	private String title;
	private String owner = "...";
	private boolean available = true;

	public Book() {
	}

	public Book(long id, String author, String title, String owner,
			boolean available) {
		this.id = id;
		this.author = author;
		this.title = title;
		if (!available)
			this.owner = owner;
		this.available = available;
	}

	// ------------------ Getter, setter metotlarý ---------------------
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setBook(Book book) {
		this.setId(book.getId());
		this.setAuthor(book.getAuthor());
		this.setTitle(book.getTitle());
		this.setOwner(book.getOwner());
		this.setAvailable(book.isAvailable());
	}

	public Book getBook() {

		return new Book(this.getId(), this.getAuthor(), this.getTitle(),
				this.getOwner(), this.isAvailable());
	}

	// ------------ Action listener kullanýlan Metotlar ---------------------
	/**
	 * Sýnýf özelliklerini 'null' ile ilkleme
	 * 
	 * @param event
	 */
	public void initBook(ActionEvent event) {

		// Book nesnesini ilkle
		this.setBook(new Book());
	}

	/**
	 * Bilgileri düzenlenecek kitabý seçme ve bean'e atama
	 * 
	 * @param event
	 */
	public void selectBook(ActionEvent event) {
		SampleDB sampleDB = new SampleDB();

		UIParameter component = (UIParameter) event.getComponent()
				.findComponent("editId");

		long id = Long.parseLong(component.getValue().toString());

		this.setBook(sampleDB.loadBookById(id));
	}

	/**
	 * Yeni bir kitap ya da düzenlenmiþ kitap bilgilerini ekleme
	 * 
	 * @param event
	 */
	public void saveBook(ActionEvent event) {

		SampleDB sampleDB = new SampleDB();

		sampleDB.saveToDB(this.getBook());
	}

	/**
	 * Kitap silme iþlemleri
	 * 
	 * @param event
	 */
	public void deleteBook(ActionEvent event) {

		SampleDB sampleDB = new SampleDB();

		UIParameter component = (UIParameter) event.getComponent()
				.findComponent("deleteId");

		long id = Long.parseLong(component.getValue().toString());

		sampleDB.deleteBookById(id);
	}

	/**
	 * Kitap ödünç alma iþlemleri
	 * 
	 * @param event
	 */
	public void borrowBook(ActionEvent event) {

		SampleDB sampleDB = new SampleDB();

		UIParameter component = (UIParameter) event.getComponent()
				.findComponent("borrowId");

		UIParameter component2 = (UIParameter) event.getComponent()
				.findComponent("user");

		long id = Long.parseLong(component.getValue().toString());
		String user = component2.getValue().toString();

		this.setBook(sampleDB.loadBookById(id));
		this.available = false;
		this.owner = user;
		saveBook(event);
	}
}
