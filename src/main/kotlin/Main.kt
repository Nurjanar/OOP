fun main() {

    WallService.add(
        Post(
            1, content = "Hello everyone!",
            comments = Comments("Hello my friend!")
        )
    )

    WallService.add(
        Post(
            2, content = "Who wants to go to the cinema tonight?",
            comments = Comments()
        )
    )

    WallService.update(
        Post(
            2, content = "Interstellar at 20:30",
            comments = Comments("let`s go")
        )
    )

}