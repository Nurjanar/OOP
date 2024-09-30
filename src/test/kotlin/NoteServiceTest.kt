import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class NoteServiceTest {
    private val service = NoteService

    @Before
    fun clearBeforeTest() {
        service.clear()
    }

    @Test
    fun addNote() {
        val note = Note(
            "Сегодня вебинар в 18:00",
            "Уважаемые коллеги,прошу проявлять активность в вебинаре!",
            comments = Comments()
        )
        val result = service.addNote(note)

        assertEquals(1, result.noteId)
    }

    @Test
    fun createComment() {
        val note = Note(
            "Список покупок",
            "Картофель,морковь",
            comments = Comments()
        )
        service.addNote(note)
        service.createComment(1, "Чеснок еще!")
        val comment = service.createComment(1, "И капуста")
        val result = comment.commentId
        assertEquals(2, result)
    }

    @Test(expected = CommentNotFoundException::class)
    fun getComments() {
        service.getComments(5)
    }

    @Test
    fun deleteComment() {
        val note = Note(
            "Спорт для больной спины.",
            "Пилатес," +
                    "Плавание",
            comments = Comments()
        )
        service.addNote(note)
        service.createComment(1, "Скандинавская ходьба")
        service.createComment(1, "Йога!")
        val result = service.deleteComment(1, 2)
        assertTrue(result)
    }

    @Test
    fun editNote() {
        val note = Note(
            "Как сохранить молодость?",
            "Никак!",
            comments = Comments()
        )
        service.addNote(note)
        val title = "Как сохранить молодость?"
        val text = "Для молодости кожи:" +
                "1.Используем ретиноиды и spf," +
                "2.Держим вес в одном уровне."

        val result = service.editNote(1, title, text)
        assertTrue(result)
    }

    @Test
    fun editComment() {
        val note = Note(
            "Встреча 18:00",
            "Кто придёт?",
            comments = Comments()
        )
        service.addNote(note)
        service.createComment(1, "Я!")
        val result = service.editComment(1, 1, "Я не приду.")
        assertTrue(result)
    }

    @Test
    fun restoreComment() {
        val note = Note(
            "Лиды",
            "Данные найдёте по ссылке-->",
            comments = Comments()
        )
        service.addNote(note)
        service.createComment(1, "Ссылка не открывается")
        service.createComment(1, "Ждём ссылку")
        service.deleteComment(1, 2)
        val result = service.restoreComment(1, 2)
        assertTrue(result)
    }

    @Test
    fun deleteNote() {
        val note = Note(
            "Лиды",
            "Данные найдёте по ссылке-->",
            comments = Comments()
        )
        service.addNote(note)

        val result = service.deleteNote(1)
        assertTrue(result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun read() {
        service.read()
    }

}