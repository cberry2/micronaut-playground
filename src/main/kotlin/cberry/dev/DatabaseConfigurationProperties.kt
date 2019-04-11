package cberry.dev

import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("database")
class DatabaseConfigurationProperties : DatabaseConfiguration {

    override fun getMaxEntity(): Int = max

    var max: Int = 10
}