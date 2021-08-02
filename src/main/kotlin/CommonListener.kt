package com.tul.sales.hunters.model.abstracts

import com.tul.sales.hunters.model.abstracts.BaseModel
import com.tul.sales.hunters.model.abstracts.TuLCodeSetter
import org.springframework.stereotype.Component
import javax.persistence.PrePersist

@Component("listener.common_listener")
class CommonListener : TuLCodeSetter() {

    @PrePersist
    fun prePersist(baseModel: BaseModel) {
        setTulCode(baseModel)
    }
}
