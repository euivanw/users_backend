package dev.ivanwilhelm.users.usecase.shared;

import dev.ivanwilhelm.users.shared.CoreException;
import dev.ivanwilhelm.users.shared.Either;

public interface Usecase<I, O, E extends CoreException> {
    Either<E, O> execute(I input) throws CoreException;
}
