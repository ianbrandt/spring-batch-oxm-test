package org.springframework.batch.item.xml.stax;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

public class NoCloseEventWriterWrapper extends AbstractEventWriterWrapper {

	public NoCloseEventWriterWrapper(final XMLEventWriter wrappedEventWriter) {
		super(wrappedEventWriter);
	}

	@Override
	public void close() throws XMLStreamException {

		// No-op.
	}
}
