package com.mprzybylak.minefields.minefields.kotlinhibernate.test

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional


@RestController
class TestController {

    @PersistenceContext
    private val em: EntityManager? = null

    @GetMapping("/store")
    @Transactional
    fun storeEntity(@RequestParam text: String): String {
        em?.persist(TestEntity(text = text))
        return "ok"
    }

    @GetMapping("/load")
    @Transactional
    fun loadEntity(): String {
        return em?.createQuery("Select t from TestEntity t")
                ?.getResultList()
                ?.stream()
                ?.map { it.toString() }
                ?.collect(Collectors.joining("\n")) ?: ""
    }
}