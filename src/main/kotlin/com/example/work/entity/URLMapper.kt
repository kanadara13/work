package com.example.work.entity

import com.example.work.domain.URLMapperDto
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "URL_MAPPER")
class URLMapperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L

    @Column(name = "CODE")
    var code: String = ""

    @Column(name = "URL")
    var url : String = ""

    @Column(name="CREATED_AT")
    var createdAt : LocalDateTime = LocalDateTime.now()

    @Column(name="COUNT")
    var count : Int = 0

    fun toDto() : URLMapperDto {
        return URLMapperDto().also {
            it.id = this.id
            it.code = this.code
            it.url = this.url
            it.createdAt = this.createdAt
            it.count = this.count
        }
    }
}
