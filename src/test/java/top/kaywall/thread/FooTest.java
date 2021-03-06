package top.kaywall.thread;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @desc
 * @author Kaiqiang Ai
 * @addTime 2021/11/06 03:44:22
 */


public class FooTest {


    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Set up before class");
    }

    @Before
    public void setUp() throws Exception {
//        System.out.println("Set up");
    }

    @Test
    public void testMathPow() {
//        System.out.println("Test Math.pow");
        Assert.assertEquals(4.0, Math.pow(2.0, 2.0), 0.0);
    }

    @Test
    public void testMathMin() throws InterruptedException {
        System.out.println("Test Foo");
        final Foo foo = new Foo();
        new Thread(new Runnable() {
            public void run() {
                try {
                    foo.third(new ThirdThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(new Runnable() {
            public void run() {
                try {
                    foo.second(new SecondThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(new Runnable() {
            public void run() {
                try {
                    foo.first(new FirstThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    // 期望此方法抛出NullPointerException异常
    @Test(expected = NullPointerException.class)
    public void testException() {
//        System.out.println("Test exception");
        Object obj = null;
        obj.toString();
    }

    // 忽略此测试方法
    @Ignore
    @Test
    public void testMathMax() {
        Assert.fail("没有实现");
    }


    // 使用“假设”来忽略测试方法
    @Test
    public void testAssume(){
//        System.out.println("Test assume");
        // 当假设失败时，则会停止运行，但这并不会意味测试方法失败。
        Assume.assumeTrue(false);
        Assert.fail("没有实现");
    }

    @After
    public void tearDown() throws Exception {
//        System.out.println("Tear down");
    }

    @AfterClass
    public static void tearDownAfterClass() {
//        System.out.println("Tear down After class");
    }


    private static class FirstThread implements Runnable{

        public void run() {
            System.out.println("first");
        }
    }

    private static class SecondThread implements Runnable{

        public void run() {
            System.out.println("Second");
        }
    }

    private static class ThirdThread implements Runnable{
        public void run() {
            System.out.println("third");
        }
    }

}
