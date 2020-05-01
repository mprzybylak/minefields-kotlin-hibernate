package com.mprzybylak.minefields.minefields.kotlinhibernate.test

import org.hibernate.validator.constraints.Length
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Size

@Entity
class TestEntity(
        @Id @GeneratedValue val id: Long = 0,
        @get:Size(min=1) val text: String = ""
) {
    override fun toString(): String {
        return "$id=$text, "
    }
}