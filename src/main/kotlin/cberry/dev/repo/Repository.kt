package cberry.dev.repo

import cberry.dev.domain.Item
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

interface ItemRepository {

    fun findById(@NotNull id: Long?): Optional<Item>

    fun save(@NotBlank title: String, body: String): Item

    fun deleteById(@NotNull id: Long)

    fun update(@NotNull id: Long, @NotBlank name: String): Int
}