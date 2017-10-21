package br.com.Devell.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ConnectionFactoryTest.class, LivroCRUDTest.class })
public class AllTests {

}
