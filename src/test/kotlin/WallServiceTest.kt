import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class WallServiceTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        WallService.add(
            Post(
                content = "Hello everyone!",
                comments = Comments()
            )
        )
        WallService.add(
            Post(
                content = "What's up?",
                comments = Comments()
            )
        )
        val post = WallService.add(
            Post(
                content = "Let's go to the cinema",
                comments = Comments()
            )
        )
        val result = post.postId
        assertEquals(3, result)
    }

    @Test
    fun updated() {
        WallService.add(
            Post(
                content = "Let's go to the cinema",
                comments = Comments()
            )
        )
        val update = Post(
            1, content = "Updated",
            comments = Comments()
        )
        val result = WallService.update(update)
        assertTrue(result)
    }


    @Test
    fun notUpdated() {
        val update = Post(
            33,
            content = "NotUpdated",
            comments = Comments()
        )

        val result = WallService.update(update)
        assertFalse(result)
    }

    @Test
    fun createComment() {

        WallService.add(
            Post(
                content = "Where you are?",
                comments = Comments()
            )
        )
        val newComment = WallService.createComment(
            1, comment = Comments("in Paris")
        )
        val result = newComment?.text
        assertEquals("in Paris", result)

    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        WallService.add(
            Post(
                content = "Where you are?",
                comments = Comments()
            )
        )
        WallService.createComment(
            5, comment = Comments("in Paris")
        )

    }
}