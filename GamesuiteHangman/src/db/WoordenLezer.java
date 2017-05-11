package db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import domain.exceptions.DatabaseException;

public class WoordenLezer {
	private ArrayList<String> woordenlijst;
	private File file;
	private volatile static WoordenLezer uniqueInstance;
	private String bestandsNaam;
	
	private WoordenLezer(String bestandsNaam) {
		this.setBestandsNaam(bestandsNaam);
		file = new File("hangman.txt");
		this.woordenlijst = new ArrayList<>();
		open();
	}
	
	public void setBestandsNaam(String bestandsNaam) {
		this.bestandsNaam = bestandsNaam;
	}

	public static WoordenLezer getInstance() {
		if(uniqueInstance == null) {
			synchronized (WoordenLezer.class) {
				if(uniqueInstance == null) {
					uniqueInstance = new WoordenLezer("hangMan1");
				}
			}
		}
		return uniqueInstance;
	}

	public ArrayList<String> getAlleWoorden() {
		return this.woordenlijst;
	}
	
	public String getWoord(int id) throws DatabaseException {
		if (id < 0 || id >= this.woordenlijst.size()) {
			throw new DatabaseException("ongeldige id");
		}
		return this.woordenlijst.get(id);
	}

	public void addWoord(String woord) throws DatabaseException  {
		if (woord == null && this.woordenlijst.contains(woord.trim())) {
			throw new DatabaseException("woord zit al in de woordenlijst");
		}
		
		this.woordenlijst.add(woord);
	}

	public void open() {
		try {
			Scanner scanner = new Scanner(file);
			Scanner line = null;
			
			while(scanner.hasNext()) {
				line = new Scanner(scanner.nextLine());
				String woord = line.next();
								
				this.addWoord(woord);						
			}
			if(scanner != null) {
				scanner.close();
			}
			if(line != null) {
				line.close();
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			PrintWriter emptyFile = new PrintWriter(file);
			emptyFile.close();
			
			PrintWriter writer = new PrintWriter(file);
			
			for(String woord : this.getAlleWoorden()) {
				String line = woord;
				writer.println(line);
			}
			if(writer != null) {
				writer.close();
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
