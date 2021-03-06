/*
 * Copyright 2020 Vitaliy Zarubin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.keygenqt.ormlite.function

import com.keygenqt.ormlite.base.GenFunSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FunSpec
import javax.annotation.processing.ProcessingEnvironment
import javax.lang.model.element.Element

class OrmliteBaseGetConnection : GenFunSpec {
    override fun getName(): String {
        return this.javaClass.simpleName.replace("OrmliteBase", "").decapitalize()
    }

    override fun getElement(): Element? {
        return null
    }

    override fun getProcessingEnvironment(): ProcessingEnvironment? {
        return null
    }

    override fun getFunSpec(): FunSpec {
        return FunSpec.builder(getName())
            .returns(ClassName("com.j256.ormlite.support", "ConnectionSource"))
            .addStatement(StringBuilder("""return connection""").toString())
            .build()
    }
}