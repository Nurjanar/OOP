class PostNotFoundException(
    message: String = "Пост с данным Id не найден!"
) : RuntimeException(message)