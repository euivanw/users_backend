package dev.ivanwilhelm.users.infrastructure.database.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface UserTableJpaRepository extends JpaRepository<UserTableEntity, UUID> {
}
