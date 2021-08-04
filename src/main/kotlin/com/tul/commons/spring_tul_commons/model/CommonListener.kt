package com.tul.commons.spring_tul_commons.model

import org.springframework.stereotype.Component
import javax.persistence.PrePersist

@Component("listener.common_listener")
class CommonListener : TuLCodeSetter() {

    @PrePersist
    fun prePersist(baseModel: BaseModel) {
        setTulCode(baseModel)
    }
}
