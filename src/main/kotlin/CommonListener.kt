package com.tul.sales.hunters.model.abstracts

import org.springframework.stereotype.Component
import javax.persistence.PrePersist

@Component("listener.common_listener")
class CommonListener : TuLCodeSetter() {

    @PrePersist
    fun prePersist(baseModel: BaseModel) {
        setTulCode(baseModel)
    }
}
