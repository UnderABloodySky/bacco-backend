package ar.edu.unq.bacco.controller

import ar.edu.unq.bacco.model.Comment
import ar.edu.unq.bacco.model.DTO.CommentDTO
import ar.edu.unq.bacco.service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/comments")
class CommentController(
    private val commentService: CommentService
) {
    @PostMapping
    fun addComment(@RequestBody commentDTO: CommentDTO): ResponseEntity<Comment> {
        val comment = commentService.addComment(commentDTO)
        return ResponseEntity(comment, HttpStatus.CREATED)
    }
}