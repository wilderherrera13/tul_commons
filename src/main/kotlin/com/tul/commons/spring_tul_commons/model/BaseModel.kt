package com.tul.commons.spring_tul_commons.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import javax.persistence.Version

@MappedSuperclass
@EntityListeners(
    value = [
        AuditingEntityListener::class
    ]
)
abstract class BaseModel {

    @Id
    var uuid: UUID ? = UUID.randomUUID()

    var tulCode: String? = null

    @Version
    var version: Long? = null

    @Column(name = "created_at", updatable = false)
    @CreatedDate
    var createdAt: LocalDateTime? = null

    @Column(name = "last_modified_at", updatable = false)
    @LastModifiedDate
    var lastModifiedAt: LocalDateTime? = null

    fun getTulCode(counter: Long): String {
        return this.javaClass.simpleName.substring(0..1).toUpperCase() + "-" + counter.toString()
    }
}
