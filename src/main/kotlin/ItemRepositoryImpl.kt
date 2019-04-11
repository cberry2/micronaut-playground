package cberry.dev

import cberry.dev.domain.Item
import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession
import io.micronaut.runtime.ApplicationConfiguration
import io.micronaut.spring.tx.annotation.Transactional
import java.util.*
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.validation.constraints.NotBlank

@Singleton
open class ItemRepositoryImpl(
    @param:CurrentSession @field:PersistenceContext
    private val entityManager: EntityManager,
    private val applicationConfiguration: ApplicationConfiguration
) : ItemRepository {

    @Transactional
    override fun findById(id: Long?): Optional<Item> =
        Optional.ofNullable(
            entityManager.find(Item::class.java, id)
        )

    @Transactional
    override fun save(@NotBlank title: String, body: String): Item {
        val item = Item(title = title, body = body)
        entityManager.persist(item)
        return item
    }

    @Transactional
    override fun deleteById(id: Long) =
        findById(id).ifPresent { entityManager.remove(it) }

    @Transactional
    override fun update(id: Long, name: String): Int {
        TODO("not implemented")
    }
}