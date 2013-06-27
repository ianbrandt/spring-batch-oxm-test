package com.ianbrandt.spring.batch.test;

import java.io.Writer;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;

import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.batch.item.xml.stax.NoCloseEventWriterWrapper;

public class SpringOxmWorkaroundStaxEventItemWriter<T> extends StaxEventItemWriter<T> {

	@Override
	protected XMLEventWriter createXmlEventWriter(final XMLOutputFactory outputFactory, final Writer writer)
			throws XMLStreamException {

		final XMLEventWriter xmlEventWriter = super.createXmlEventWriter(outputFactory, writer);

		return new NoCloseEventWriterWrapper(xmlEventWriter);
	}
}
