package dev.ivanwilhelm.users.usecase.users.get_all_users;

import dev.ivanwilhelm.users.domain.users.UsersException;
import dev.ivanwilhelm.users.domain.users.UsersRepository;
import dev.ivanwilhelm.users.shared.Either;
import dev.ivanwilhelm.users.usecase.shared.Usecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class GetAllUsersUsecase implements Usecase<GetAllUsersInputDto, GetAllUsersOutputDto, UsersException> {
    private final UsersRepository repository;

    @Override
    public Either<UsersException, GetAllUsersOutputDto> execute(GetAllUsersInputDto input) {
        try {
            final var users = repository.getAllUsers();

            log.info("Fetched {} users", users.size());

            return Either.right(
                    new GetAllUsersOutputDto(
                            users.stream().map(user ->
                                    new GetAllUsersOutputUserDto(
                                            user.id(),
                                            user.firstName(),
                                            user.lastName(),
                                            user.email(),
                                            user.createdAt(),
                                            user.updatedAt()
                                    )
                            ).toList()
                    )
            );
        } catch (UsersException exception) {
            log.error("Error fetching users", exception);
            return Either.left(exception);
        } catch (Exception exception) {
            log.error("Unexpected error fetching users", exception);
            return Either.left(new UsersException("Unexpected error fetching users", exception));
        }
    }
}
