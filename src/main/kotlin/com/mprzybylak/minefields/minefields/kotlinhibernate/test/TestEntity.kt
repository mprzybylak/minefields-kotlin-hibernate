package com.mprzybylak.minefields.minefields.kotlinhibernate.test

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class TestEntity(
        @Id @GeneratedValue val id: Long = 0,
        val text: String = ""
) {
    override fun toString(): String {
        return "$id=$text, "
    }
}