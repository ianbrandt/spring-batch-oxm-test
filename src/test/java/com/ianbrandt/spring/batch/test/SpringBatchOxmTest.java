package com.ianbrandt.spring.batch.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SpringBatchOxmTest {

	@Resource
	private StaxEventItemWriter<TestModelObject> itemWriter;

	private List<TestModelObject> testModelObjects;

	private static final TestModelObject TEST_MODEL_OBJECT_1 = new TestModelObject(1, "Test 1");

	private static final TestModelObject TEST_MODEL_OBJECT_2 = new TestModelObject(2, "Test 2");

	@Before
	public void setUp() {

		testModelObjects = new ArrayList<TestModelObject>();
	}

	@Test
	public void testOneObject() throws Exception {

		testModelObjects.add(TEST_MODEL_OBJECT_1);

		writeItems();
	}

	@Test
	public void testTwoObjects() throws Exception {

		testModelObjects.add(TEST_MODEL_OBJECT_1);
		testModelObjects.add(TEST_MODEL_OBJECT_2);

		writeItems();
	}

	private void writeItems() throws Exception {

		itemWriter.open(new ExecutionContext());
		itemWriter.write(testModelObjects);
		itemWriter.close();
	}
}
