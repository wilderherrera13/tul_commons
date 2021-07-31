package com.tul.sales.hunters.model.abstracts

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.support.Repositories
import org.springframework.web.context.WebApplicationContext

abstract class TuLCodeSetter {
    @Autowired
    private lateinit var appContext: WebApplicationContext

    var repositories: Repositories? = null

    fun setTulCode(entity: BaseModel) {
        repositories = Repositories(appContext)
        entity.tulCode = entity.getTulCode(
            (
                repositories!!.getRepositoryFor(entity.javaClass)
                    .get() as JpaRepository<*, *>
                ).count()
        )
    }
}
