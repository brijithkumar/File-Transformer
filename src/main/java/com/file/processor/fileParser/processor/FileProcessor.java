package com.file.processor.fileParser.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FileProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		String input=exchange.getIn().getBody(String.class);
		String[] inputArray= input.replaceAll("^\"|\"$", "").split(",");
		int sum=0;
		for(String s : inputArray) {
			sum = sum + Integer.parseInt(s);
		}
		exchange.getIn().setBody(sum, String.class);
	}

}
