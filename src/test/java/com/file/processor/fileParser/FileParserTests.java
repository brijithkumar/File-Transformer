package com.file.processor.fileParser;

import java.io.File;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.file.processor.fileParser.router.FileRouter;

public class FileParserTests extends CamelTestSupport{
	
	protected RouteBuilder createRouteBuilder() throws Exception {
		return new FileRouter();
	}
	
	@Test
	public void testFileParser() throws Exception {
		template.sendBodyAndHeader("file:input", "2,3,5,6", Exchange.FILE_NAME, "fileadd.csv");
		Thread.sleep(2000);
		File target = new File("output/fileadd.done");
		String content = context.getTypeConverter().convertTo(String.class,target);
		assertEquals("16", content);
		
	}

}
