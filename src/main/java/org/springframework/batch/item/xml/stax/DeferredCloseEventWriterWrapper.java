package org.springframework.batch.item.xml.stax;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

public class DeferredCloseEventWriterWrapper extends AbstractEventWriterWrapper {

	private boolean close = false;

	public DeferredCloseEventWriterWrapper(final XMLEventWriter wrappedEventWriter) {
		super(wrappedEventWriter);
	}

	public void setClose(boolean close) {

		this.close  = close;
	}

	@Override
	public void close() throws XMLStreamException {

		if (close) {
			super.close();
		}
	}
}
