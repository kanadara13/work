package com.example.work.repository

import com.example.work.entity.URLMapperEntity
import org.springframework.data.jpa.repository.JpaRepository

interface URLMapperRepository : JpaRepository<URLMapperEntity, Long> {

    fun findByCode(code: String) : URLMapperEntity?
    fun findByUrl(url: String)   : URLMapperEntity?
}