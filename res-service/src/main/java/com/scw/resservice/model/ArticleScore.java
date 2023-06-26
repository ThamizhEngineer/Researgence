package com.scw.resservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="s_article_score")
public class ArticleScore {

	@Id
	private Integer Column1;
	private Integer Journal;
	private Integer Conference;
	private Integer Book;
	private Integer Bookchapter;
	public ArticleScore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArticleScore(Integer column1, Integer journal, Integer conference, Integer book, Integer bookchapter) {
		super();
		Column1 = column1;
		Journal = journal;
		Conference = conference;
		Book = book;
		Bookchapter = bookchapter;
	}
	public Integer getColumn1() {
		return Column1;
	}
	public void setColumn1(Integer column1) {
		Column1 = column1;
	}
	public Integer getJournal() {
		return Journal;
	}
	public void setJournal(Integer journal) {
		Journal = journal;
	}
	public Integer getConference() {
		return Conference;
	}
	public void setConference(Integer conference) {
		Conference = conference;
	}
	public Integer getBook() {
		return Book;
	}
	public void setBook(Integer book) {
		Book = book;
	}
	public Integer getBookchapter() {
		return Bookchapter;
	}
	public void setBookchapter(Integer bookchapter) {
		Bookchapter = bookchapter;
	}
	@Override
	public String toString() {
		return "ArticleScore [Column1=" + Column1 + ", Journal=" + Journal + ", Conference=" + Conference + ", Book="
				+ Book + ", Bookchapter=" + Bookchapter + "]";
	}
	
}
