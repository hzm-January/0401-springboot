package asynchronous.spring;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * UseAsync Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>09/05/2018</pre>
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigurationAsync.class})
public class UseAsyncTest {

    @Autowired
    private UseAsync useAsync;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: showUseAsync()
     */
    @Test
    public void testShowUseAsync() throws Exception {
        useAsync.showUseAsync();
    }

    /**
     * Method: showUseAsyncReturn()
     */
    @Test
    public void testShowUseAsyncReturn() throws Exception {
        useAsync.showUseAsyncReturn();
    }


} 
