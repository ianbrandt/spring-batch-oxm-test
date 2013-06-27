package com.ianbrandt.spring.batch.test;

import java.io.Writer;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.batch.item.xml.stax.DeferredCloseEventWriterWrapper;
import org.springframework.core.io.Resource;

public class SpringOxmWorkaroundStaxEventItemWriter<T> extends StaxEventItemWriter<T> {

	private static final Log log = LogFactory.getLog(SpringOxmWorkaroundStaxEventItemWriter.class);

	private DeferredCloseEventWriterWrapper deferredCloseEventWriterWrapper;

	private Resource resource;


	@Override
	public void setResource(final Resource resource) {

		this.resource = resource;

		super.setResource(resource);
	}

	@Override
	protected XMLEventWriter createXmlEventWriter(final XMLOutputFactory outputFactory, final Writer writer)
			throws XMLStreamException {

		final XMLEventWriter xmlEventWriter = super.createXmlEventWriter(outputFactory, writer);

		deferredCloseEventWriterWrapper = new DeferredCloseEventWriterWrapper(xmlEventWriter);

		return deferredCloseEventWriterWrapper;
	}

	@Override
	public void close() {

		super.close();

		if (deferredCloseEventWriterWrapper != null) {

			try {

				deferredCloseEventWriterWrapper.deferredClose();

			} catch (XMLStreamException e) {
				log.error("Unable to close file resource: [" + resource + "] " + e);
			}
		}
	}
}
