package com.example.work.entity

import com.example.work.domain.URLMapperDto
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.`java-time`.datetime

object URLMapperTable : IntIdTable("URL_MAPPER") {
    val code = varchar("CODE",8).uniqueIndex()
    val url = text("URL")
    val createdAt = datetime("CREATED_AT").index()
    val count = integer("COUNT")
}


class URLMapper(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<URLMapper>(URLMapperTable)
    var code by URLMapperTable.code
    var url by URLMapperTable.url
    var createdAt by URLMapperTable.createdAt
    var count by URLMapperTable.count

    fun toDto() : URLMapperDto {
        return URLMapperDto().also {
            it.id = this.id.value
            it.code = this.code
            it.url = this.url
            it.createdAt = this.createdAt
            it.count = this.count
        }
    }
}