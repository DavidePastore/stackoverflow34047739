package com.github.davidepastore.stackoverflow34047739;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Unit test for simple MyParser.
 */
@RunWith(Parameterized.class)
public class MyParserTest  {
	@Parameters
	public static Collection<Object[]> data() {
		Collection<Object[]> collection = new ArrayList<Object[]>();
		collection.add(new Object[]{"/file.html", "My result applied"});
		collection.add(new Object[]{"/file1.html", "My result applied"});
		return collection;
	}
	
	private String filename;
	private String expectedResult;
	
	public MyParserTest(String filename, String expectedResult) {
		this.filename = filename;
		this.expectedResult = expectedResult;
	}

	/**
	 * Find my string test.
	 * 
	 * @throws IOException
	 */
	@Test
	public void testFindMyDivs() throws IOException {
		URL url = this.getClass().getResource(filename);
		File file = new File(url.getFile());
		MyParser parser = new MyParser(file);
		Elements elements = parser.getMyElements();
		assertEquals(expectedResult, elements.text());
	}
}
