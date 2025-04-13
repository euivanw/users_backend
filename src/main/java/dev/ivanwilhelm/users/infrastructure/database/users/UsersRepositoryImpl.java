package dev.ivanwilhelm.users.infrastructure.database.users;

import dev.ivanwilhelm.users.domain.users.UserNotFoundException;
import dev.ivanwilhelm.users.domain.users.UsersEntity;
import dev.ivanwilhelm.users.domain.users.UsersException;
import dev.ivanwilhelm.users.domain.users.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Repository
public class UsersRepositoryImpl implements UsersRepository {
    private final UserTableJpaRepository repository;

    @Override
    public UsersEntity createUser(String firstName, String lastName, String email) throws UsersException {
        try {
            final var userToAdd = UserTableEntity.builder()
                    .id(UUID.randomUUID())
                    .firstName(firstName)
                    .lastName(lastName)
                    .email(email)
                    .createdAt(LocalDateTime.now())
                    .build();
            final var userAdded = repository.save(userToAdd);

            return userAdded.toUsersEntity();
        } catch (Exception exception) {
            throw new UsersException("Failed to create user.", exception);
        }
    }

    @Override
    public UsersEntity updateUser(UUID id, String firstName, String lastName, String email) throws UsersException {
        try {
            final var userToUpdate = repository.findById(id)
                    .orElseThrow(() -> new UserNotFoundException(String.format("User with ID [%s] not found.", id)));

            userToUpdate.setFirstName(firstName);
            userToUpdate.setLastName(lastName);
            userToUpdate.setEmail(email);
            userToUpdate.setUpdatedAt(LocalDateTime.now());

            final var updatedUser = repository.save(userToUpdate);

            return updatedUser.toUsersEntity();
        } catch (Exception exception) {
            throw new UsersException(String.format("Failed to update user with ID [%s].", id), exception);
        }
    }

    @Override
    public UsersEntity deleteUser(UUID id) throws UsersException {
        try {
            final var userToDelete = repository.findById(id)
                    .orElseThrow(() -> new UserNotFoundException(String.format("User with ID [%s] not found.", id)));

            repository.delete(userToDelete);

            return userToDelete.toUsersEntity();
        } catch (Exception exception) {
            throw new UsersException(String.format("Failed to delete user with ID [%s].", id), exception);
        }
    }

    @Override
    public UsersEntity getUserById(UUID id) throws UsersException {
        try {
            final var user = repository.findById(id)
                    .orElseThrow(() -> new UserNotFoundException(String.format("User with ID [%s] not found.", id)));

            return user.toUsersEntity();
        } catch (Exception exception) {
            throw new UsersException(String.format("Failed to get user with ID [%s].", id), exception);
        }
    }

    @Override
    public List<UsersEntity> getAllUsers() throws UsersException {
        try {
            final var users = repository.findAll();

            return users.stream()
                    .map(UserTableEntity::toUsersEntity)
                    .toList();
        } catch (Exception exception) {
            throw new UsersException("Failed to get all users.", exception);
        }
    }
}
