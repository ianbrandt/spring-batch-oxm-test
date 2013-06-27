package com.ianbrandt.spring.batch.test;

import java.io.Writer;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;

import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.batch.item.xml.stax.DeferredCloseEventWriterWrapper;

public class SpringOxmWorkaroundStaxEventItemWriter<T> extends StaxEventItemWriter<T> {

	private DeferredCloseEventWriterWrapper deferredCloseEventWriterWrapper;

	@Override
	protected XMLEventWriter createXmlEventWriter(final XMLOutputFactory outputFactory, final Writer writer)
			throws XMLStreamException {

		final XMLEventWriter xmlEventWriter = super.createXmlEventWriter(outputFactory, writer);

		deferredCloseEventWriterWrapper = new DeferredCloseEventWriterWrapper(xmlEventWriter);

		return deferredCloseEventWriterWrapper;
	}

	@Override
	public void close() {

		if (deferredCloseEventWriterWrapper != null) {
			deferredCloseEventWriterWrapper.setClose(true);
		}

		super.close();
	}
}
