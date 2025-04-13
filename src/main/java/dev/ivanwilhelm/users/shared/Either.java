package dev.ivanwilhelm.users.shared;

import lombok.Getter;

public abstract class Either<L, R> {
    public static <L, R> Either<L, R> right(R value) {
        return new Right<>(value);
    }

    public static <L, R> Either<L, R> left(L value) {
        return new Left<>(value);
    }

    public abstract boolean isRight();

    public abstract boolean isLeft();

    @Getter
    public static final class Left<L, R> extends Either<L, R> {
        private final L value;

        public Left(L value) {
            this.value = value;
        }

        @Override
        public boolean isRight() {
            return false;
        }

        @Override
        public boolean isLeft() {
            return true;
        }
    }

    @Getter
    public static final class Right<L, R> extends Either<L, R> {
        private final R value;

        public Right(R value) {
            this.value = value;
        }

        @Override
        public boolean isRight() {
            return true;
        }

        @Override
        public boolean isLeft() {
            return false;
        }
    }
}
