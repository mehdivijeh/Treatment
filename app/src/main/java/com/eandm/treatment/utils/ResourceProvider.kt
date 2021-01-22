package com.eandm.treatment.utils

interface ResourceProvider<InputType : Input, ResourceType : Resource> {

    fun getResource(input: InputType): ResourceType

}