package model;

import java.io.Serializable;
import java.util.Random;

public class TextbookBag implements Serializable{
	
	private static final long serialVersionUID = -8468260522869417484L;
	private static Textbook[] textbookArray;
	private static int nElems;
	
	private Random rand = new Random();
	
	public TextbookBag(int maxSize) {
		textbookArray = new Textbook[maxSize];
		nElems = 0;
	}
	
	
	
	public  void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(textbookArray[i]);
		}
	}
	public void insert(Textbook textbook) {
		textbookArray[nElems++] = textbook;
	}
	public Textbook deleteByISBN(String isbn) {
			int i = 0;
			for(i =0; i < nElems; i++) {
				if(textbookArray[i].getIsbn().equals(isbn)) {
					break;
				}
			}
			
			if( i == nElems ) { // not exist
				return null;
			} else { // found
				Textbook temp = textbookArray[i];
				for(int j = i; j < nElems-1; j++) {
					textbookArray[j] = textbookArray[j+1]; 
				}
				nElems--;
				return temp;
			}
		}
	
	public  Textbook findByISBN(String isbn) {
		for (int i = 0; i < nElems; i++) {
			if (textbookArray[i].getIsbn().equals(isbn)) {
				return textbookArray[i];
			}
		}
		return null;
	}
	
	public Textbook emitTextbook() {
		return textbookArray[rand.nextInt(nElems)];
	}
}
