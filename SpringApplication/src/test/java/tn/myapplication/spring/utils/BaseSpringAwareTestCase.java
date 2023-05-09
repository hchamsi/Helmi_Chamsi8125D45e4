package tn.myapplication.spring.utils;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest
public abstract class BaseSpringAwareTestCase {


    public BaseSpringAwareTestCase() {
    }


}