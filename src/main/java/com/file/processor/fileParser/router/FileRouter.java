package com.file.processor.fileParser.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.file.processor.fileParser.processor.FileProcessor;

@Component
public class FileRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:input?noop=true").
		process(new FileProcessor())
		.to("file:output?fileName=fileadd.done");
	}

}
