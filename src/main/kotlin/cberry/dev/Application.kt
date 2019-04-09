package cberry.dev

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("cberry.dev")
                .mainClass(Application.javaClass)
                .start()
    }
}