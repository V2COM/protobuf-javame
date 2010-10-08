package net.jarlehansen.proto2javame.protobuf.integration.tempfiles.javame;
// Generated by proto2javame, Fri Oct 08 19:28:48 CEST 2010.

import java.io.IOException;
import java.io.InputStream;
import net.jarlehansen.protobuf.javame.UninitializedMessageException;
import net.jarlehansen.protobuf.javame.input.InputReader;
import net.jarlehansen.protobuf.javame.input.DelimitedInputStream;
import net.jarlehansen.protobuf.javame.input.DelimitedSizeUtil;
import net.jarlehansen.protobuf.javame.ComputeSizeUtil;
import net.jarlehansen.protobuf.javame.output.OutputWriter;
import net.jarlehansen.protobuf.javame.AbstractOutputWriter;
import net.jarlehansen.protobuf.javame.input.taghandler.UnknownTagHandler;
import net.jarlehansen.protobuf.javame.input.taghandler.DefaultUnknownTagHandlerImpl;

public final class ExampleObjectNestedListJavaMe extends AbstractOutputWriter {
	private static UnknownTagHandler unknownTagHandler = DefaultUnknownTagHandlerImpl.newInstance();

	private final int id;
	private static final int fieldNumberId = 1;

	private final java.util.Vector persons;
	private static final int fieldNumberPersons = 2;


	public static Builder newBuilder() {
		return new Builder();
	}

	private ExampleObjectNestedListJavaMe(final Builder builder) {
		if (builder.hasId ) {
			this.id = builder.id;
			this.persons = builder.persons;
		} else {
			throw new UninitializedMessageException("Not all required fields were included (false = not included in message), " + 
				" id:" + builder.hasId + "");
		}
	}

	public static class Builder {
		private int id;
		private boolean hasId = false;

		private java.util.Vector persons = new java.util.Vector();
		private boolean hasPersons = false;


		private Builder() {
		}

		public Builder setId(final int id) {
			this.id = id;
			this.hasId = true;
			return this;
		}

		public Builder setPersons(final java.util.Vector persons) {
			if(!hasPersons) {
				hasPersons = true;
			}
			this.persons = persons;
			return this;
		}


		public Builder addElementPersons(final Person element) {
			if(!hasPersons) {
				hasPersons = true;
			}
			persons.addElement(element);
			return this;
		}

		public ExampleObjectNestedListJavaMe build() {
			return new ExampleObjectNestedListJavaMe(this);
		}
	}

	public int getId() {
		return id;
	}

	public java.util.Vector getPersons() {
		return persons;
	}

	public String toString() {
		final String TAB = "   ";
		String retValue = "";
		retValue += this.getClass().getName() + "(";
		retValue += "id = " + this.id + TAB;
		retValue += "persons = " + this.persons + TAB;
		retValue += ")";

		return retValue;
	}

	// Override
	public int computeSize() {
		int totalSize = 0;
		totalSize += ComputeSizeUtil.computeIntSize(fieldNumberId, id);
		totalSize += computeNestedMessageSize();

		return totalSize;
	}

	private int computeNestedMessageSize() {
		int messageSize = 0;
		messageSize += ComputeSizeUtil.computeListSize(fieldNumberPersons, net.jarlehansen.protobuf.javame.SupportedDataTypes.DATA_TYPE_CUSTOM, persons);

		return messageSize;
	}

	// Override
	public void writeFields(final OutputWriter writer) throws IOException {
		writer.writeInt(fieldNumberId, id);
		writer.writeList(fieldNumberPersons, net.jarlehansen.protobuf.javame.SupportedDataTypes.DATA_TYPE_CUSTOM, persons);
		writer.writeData();
	}

	static ExampleObjectNestedListJavaMe parseFields(final InputReader reader) throws IOException {
		int nextFieldNumber = getNextFieldNumber(reader);
		final ExampleObjectNestedListJavaMe.Builder builder = ExampleObjectNestedListJavaMe.newBuilder();

		while (nextFieldNumber > 0) {
			if(!populateBuilderWithField(reader, builder, nextFieldNumber)) {
				reader.getPreviousTagDataTypeAndReadContent();
			}
			nextFieldNumber = getNextFieldNumber(reader);
		}

		return builder.build();
	}
	static int getNextFieldNumber(final InputReader reader) throws IOException {
		return reader.getNextFieldNumber();
	}

	static boolean populateBuilderWithField(final InputReader reader, final Builder builder, final int fieldNumber) throws IOException {
		boolean fieldFound = true;
		switch (fieldNumber) {
			case fieldNumberId:
				builder.setId(reader.readInt(fieldNumber));
				break;
			case fieldNumberPersons:
				reader.readMessageStart();
				Person.Builder builderPersons = Person.newBuilder();

				boolean boolPerson = true;
				int nestedFieldPerson = -1;
				while(boolPerson) {
					nestedFieldPerson = getNextFieldNumber(reader);
					boolPerson = Person.populateBuilderWithField(reader, builderPersons, nestedFieldPerson);
				}

				builder.addElementPersons(builderPersons.build());
				populateBuilderWithField(reader, builder, nestedFieldPerson);
				break;
		default:
			fieldFound = false;
		}
		return fieldFound;
	}

	public static void setUnknownTagHandler(final UnknownTagHandler unknownTagHandler) {
		ExampleObjectNestedListJavaMe.unknownTagHandler = unknownTagHandler;
	}

	public static ExampleObjectNestedListJavaMe parseFrom(final byte[] data) throws IOException {
		return parseFields(new InputReader(data, unknownTagHandler));
	}

	public static ExampleObjectNestedListJavaMe parseFrom(final InputStream inputStream) throws IOException {
		return parseFields(new InputReader(inputStream, unknownTagHandler));
	}

	public static ExampleObjectNestedListJavaMe parseDelimitedFrom(final InputStream inputStream) throws IOException {
		final int limit = DelimitedSizeUtil.readDelimitedSize(inputStream);
		return parseFields(new InputReader(new DelimitedInputStream(inputStream, limit), unknownTagHandler));
	}
}