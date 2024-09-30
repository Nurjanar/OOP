class PostNotFoundException(
    message: String = "Пост не найден!"
) : RuntimeException(message)

class NoteNotFoundException(
    message: String = "Заметка не найдена!"
) : RuntimeException(message)

class CommentNotFoundException(
    message: String = "Комментарий не найден!"
) : RuntimeException(message)