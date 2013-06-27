package com.ianbrandt.spring.batch.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SpringBatchOxmWorkaroundTest extends SpringBatchOxmTest {

	// Same as the base test, except with a different itemWriter as defined via this test's context.
}
