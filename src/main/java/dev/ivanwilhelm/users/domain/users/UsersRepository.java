package dev.ivanwilhelm.users.domain.users;

import java.util.List;
import java.util.UUID;

public interface UsersRepository {
    UsersEntity createUser(String firstName, String lastName, String email) throws UsersException;

    UsersEntity updateUser(UUID id, String firstName, String lastName, String email) throws UsersException;

    UsersEntity deleteUser(UUID id) throws UsersException;

    UsersEntity getUserById(UUID id) throws UsersException;

    List<UsersEntity> getAllUsers() throws UsersException;
}
