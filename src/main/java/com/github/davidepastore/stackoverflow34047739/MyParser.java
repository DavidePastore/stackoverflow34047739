package com.github.davidepastore.stackoverflow34047739;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Stackoverflow 34047739 question.
 *
 */
public class MyParser {
	
	private File file;
	
	public MyParser(File file){
		this.file = file;
	}
	
	public Elements getMyElements() throws IOException{
		Document document = Jsoup.parse(file, "UTF-8");
		Elements elements = document.select("div.result[jobstatus=applied]");
		return elements;
	}
}
