object WallService {
    private var posts = emptyArray<Post>()
    private var lastId: Int = 0
    private var comments = emptyArray<Comments>()

    fun add(post: Post): Post {
        posts += post.copy(
            postId = ++lastId
        )
        return posts.last()
    }

    fun update(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (posts[index].postId == newPost.postId) {
                posts[index] = newPost.copy(
                    comments = posts[index].comments
                )
                return true
            }
        }
        return false
    }

    fun getComments(postId: Int): List<Comments> {
        return comments.filter { it.id == postId }
    }

    fun showPosts() {
        for (post in posts) {
            println(post)
        }
    }

    fun clear() {
        posts = emptyArray()
        lastId = 0
    }

    @Throws(PostNotFoundException::class)
    fun createComment(postId: Int, comment: Comments): Comments? {
        if (postId <= 0 || posts.size < postId) {
            throw PostNotFoundException()
        }
        val newComment = Comments(
            commentId = comments.size + 1,
            id = postId,
            text = comment.text
        )
        for ((index, post) in posts.withIndex()) {
            if (posts[index].postId == postId) {
                comments += newComment
                val result = getComments(postId = post.postId)
                posts[index].comments?.text = result.toString()
            }
        }
        return comments.last()
    }
}