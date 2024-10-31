package br.ucsal.km.service;

import br.ucsal.km.model.Comment;
import br.ucsal.km.model.Video;
import br.ucsal.km.repository.CommentRepository;
import br.ucsal.km.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final VideoRepository videoRepository;
    
    public Comment addComment(Long videoId, String content) {
        Video video = videoRepository.findById(videoId)
            .orElseThrow(() -> new RuntimeException("Vídeo não encontrado"));
            
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setCommentDate(LocalDateTime.now());
        comment.setVideo(video);
        
        return commentRepository.save(comment);
    }
}