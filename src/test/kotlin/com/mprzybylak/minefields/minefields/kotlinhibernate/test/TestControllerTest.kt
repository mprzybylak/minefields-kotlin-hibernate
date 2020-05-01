package com.mprzybylak.minefields.minefields.kotlinhibernate.test

import com.mprzybylak.minefields.minefields.kotlinhibernate.KotlinHibernateApplication
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.annotation.DirtiesContext.ClassMode
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.transaction.TransactionSystemException

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [KotlinHibernateApplication::class])
@WebAppConfiguration
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class TestControllerTest {

    @Autowired
    val ctrl: TestController? = null

    @Test
    fun test() {
        val ret1 = ctrl?.storeEntity("abc")
        val ret2 = ctrl?.loadEntity()
        Assertions.assertEquals("ok", ret1)
        Assertions.assertEquals("1=abc, ", ret2)
    }

    @Test
    fun cannotStoreEmptyText() {
        Assertions.assertThrows(TransactionSystemException::class.java) { ctrl?.storeEntity("") }
    }

}