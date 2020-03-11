package com.example.work.repository

import com.example.work.entity.URLMapperEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface URLMapperRepository : JpaRepository<URLMapperEntity, Long>