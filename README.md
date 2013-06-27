A minimal test project for an apparent incompatibility found between Spring OXM 3.2.X and Spring Batch 2.x.

See https://jira.springsource.org/browse/BATCH-2054 for more details.

See [BUILDING](BUILDING.md) and [RUNNING](RUNNING.md) for setup and execution details.

The testOneObject case will pass with Spring OXM 3.1.x and 3.2.x.
The testTwoObjects case will only pass with Spring OXM 3.1.x.  With 3.2.x it fails on the NullPointerExcetion below.

The Spring version may be changed by editing the "spring.version" property in the project's pom.xml file.

```
java.lang.NullPointerException
	at com.ctc.wstx.sw.BufferingXmlWriter.writeStartTagStart(BufferingXmlWriter.java:725)
	at com.ctc.wstx.sw.BaseNsStreamWriter.doWriteStartTag(BaseNsStreamWriter.java:614)
	at com.ctc.wstx.sw.SimpleNsStreamWriter.writeStartOrEmpty(SimpleNsStreamWriter.java:265)
	at com.ctc.wstx.sw.BaseNsStreamWriter.writeStartElement(BaseNsStreamWriter.java:313)
	at org.codehaus.stax2.ri.Stax2EventWriterImpl.add(Stax2EventWriterImpl.java:97)
	at org.springframework.batch.item.xml.stax.NoStartEndDocumentStreamWriter.add(NoStartEndDocumentStreamWriter.java:39)
	at org.springframework.util.xml.XMLEventStreamWriter.writeStartElement(XMLEventStreamWriter.java:195)
	at org.springframework.util.xml.XMLEventStreamWriter.writeStartElement(XMLEventStreamWriter.java:92)
	at org.jibx.runtime.impl.StAXWriter.startTagOpen(StAXWriter.java:151)
	at org.jibx.runtime.impl.MarshallingContext.startTagAttributes(MarshallingContext.java:541)
	at com.ianbrandt.spring.batch.test.JiBX_TestModelObjectTestModelObject_access.marshal()
	at com.ianbrandt.spring.batch.test.TestModelObject.marshal(TestModelObject.java)
	at org.jibx.runtime.impl.MarshallingContext.marshalRoot(MarshallingContext.java:1021)
	at org.jibx.runtime.impl.MarshallingContext.marshalDocument(MarshallingContext.java:1041)
	at org.springframework.oxm.jibx.JibxMarshaller.marshalXmlStreamWriter(JibxMarshaller.java:289)
	at org.springframework.oxm.jibx.JibxMarshaller.marshalXmlEventWriter(JibxMarshaller.java:342)
	at org.springframework.oxm.support.AbstractMarshaller.marshalStaxResult(AbstractMarshaller.java:229)
	at org.springframework.oxm.support.AbstractMarshaller.marshal(AbstractMarshaller.java:96)
	at org.springframework.batch.item.xml.StaxEventItemWriter.write(StaxEventItemWriter.java:715)
	at com.ianbrandt.spring.batch.test.SpringBatchOxmTest.writeItems(SpringBatchOxmTest.java:55)
	at com.ianbrandt.spring.batch.test.SpringBatchOxmTest.testTwoObjects(SpringBatchOxmTest.java:49)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:39)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25)
	at java.lang.reflect.Method.invoke(Method.java:597)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:47)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:44)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)
	at org.springframework.test.context.junit4.statements.RunBeforeTestMethodCallbacks.evaluate(RunBeforeTestMethodCallbacks.java:74)
	at org.springframework.test.context.junit4.statements.RunAfterTestMethodCallbacks.evaluate(RunAfterTestMethodCallbacks.java:83)
	at org.springframework.test.context.junit4.statements.SpringRepeat.evaluate(SpringRepeat.java:72)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:231)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:88)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)
	at org.springframework.test.context.junit4.statements.RunBeforeTestClassCallbacks.evaluate(RunBeforeTestClassCallbacks.java:61)
	at org.springframework.test.context.junit4.statements.RunAfterTestClassCallbacks.evaluate(RunAfterTestClassCallbacks.java:71)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:309)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.run(SpringJUnit4ClassRunner.java:174)
	at org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:50)
	at org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:467)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:683)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:390)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:197)
```
