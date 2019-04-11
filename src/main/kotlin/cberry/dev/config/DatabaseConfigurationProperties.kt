package cberry.dev.config

import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("database")
@Suppress("unused")
class DatabaseConfigurationProperties : DatabaseConfiguration {

    override fun getMaxEntity(): Int = max

    var max: Int = 10
}