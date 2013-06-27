package org.springframework.batch.item.xml.stax;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

public class DeferredCloseEventWriterWrapper extends AbstractEventWriterWrapper {

	public DeferredCloseEventWriterWrapper(final XMLEventWriter wrappedEventWriter) {
		super(wrappedEventWriter);
	}

	@Override
	public void close() throws XMLStreamException {

		// No-op.
	}

	public void deferredClose() throws XMLStreamException {

		super.close();
	}
}
