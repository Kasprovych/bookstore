package com.bookstore.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private String publisher;
	private String publicationDate;
	private String language;
	private String category;
	private int numberOfPages;
	private String format;
	private int isbn;
	private double shippingWeight;
	private double listPrice;
	private double ourPrice;
	private boolean active = true;

	@Column(columnDefinition = "text")
	private String description;
	private int inStockNumber;
	
	@Transient
	private MultipartFile bookImage;
	
	@OneToMany(mappedBy = "book")
	@JsonIgnore
	private List<BookToCartItem> bookToCartItemList;

	public Book() {
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public String getLanguage() {
		return language;
	}

	public String getCategory() {
		return category;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public String getFormat() {
		return format;
	}

	public int getIsbn() {
		return isbn;
	}

	public double getShippingWeight() {
		return shippingWeight;
	}

	public double getListPrice() {
		return listPrice;
	}

	public double getOurPrice() {
		return ourPrice;
	}

	public boolean isActive() {
		return active;
	}

	public String getDescription() {
		return description;
	}

	public int getInStockNumber() {
		return inStockNumber;
	}

	public MultipartFile getBookImage() {
		return bookImage;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public void setShippingWeight(double shippingWeight) {
		this.shippingWeight = shippingWeight;
	}

	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	public void setOurPrice(double ourPrice) {
		this.ourPrice = ourPrice;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setInStockNumber(int inStockNumber) {
		this.inStockNumber = inStockNumber;
	}

	public void setBookImage(MultipartFile bookImage) {
		this.bookImage = bookImage;
	}

}
