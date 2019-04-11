package cberry.dev.config

import javax.validation.constraints.NotNull

interface DatabaseConfiguration {
    /**
     * Max number of entities persistable in app database
     */
    @NotNull fun getMaxEntity(): Int
}