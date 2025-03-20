package com.ams.test.sandbox;


import org.junit.*;
import org.junit.rules.ExternalResource;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;

public class JUnit4ClassRuleTest {

    @ClassRule
    public static TemporaryFolder tmpF_stat = new TemporaryFolder();

    @ClassRule
    public static ExternalResource resource= new ExternalResource(){
        @Override
        protected void before() throws Throwable {
            System.out.println("myServer.connect()");
        }
        @Override
        protected void after() {
            System.out.println("myServer.disconnect()");
        }
    };

    @Rule
    public TemporaryFolder tmpF = new TemporaryFolder();


    @BeforeClass
    public static void setUpAllTests() throws IOException {

        //System.out.println(tmpF.getRoot());
        // Не получится так сослаться из-за того, что: Non-static field cannot be referenced from static context

        System.out.println("tmpF_stat: " +tmpF_stat.getRoot());
        tmpF_stat.newFile("myfile_from_classrule.txt");
        // вот так - Ок
    }

    @Test
    public void testUseRule() throws IOException, InterruptedException {

        System.out.println(tmpF.getRoot());
        tmpF.newFile("myfile_from_rule.txt");

        //Thread.sleep(15000);
    }

    @AfterClass
    public static void cleanUp() throws InterruptedException {

        System.out.println("tmpF_stat: " +tmpF_stat.getRoot());
        //Thread.sleep(15000);
        // тут слип использовать, чтоб прочитать путь к темповой папке, бесполезно, не отдается в консоль на этом этапе
        // узнать можно под дебагом
    }


}
