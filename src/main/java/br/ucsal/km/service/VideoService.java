package br.ucsal.km.service;

import br.ucsal.km.model.Video;
import br.ucsal.km.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoService {
    private final VideoRepository videoRepository;
    
    public Video saveVideo(MultipartFile file, String title) throws IOException {
        Video video = new Video();
        video.setTitle(title);
        video.setFileName(file.getOriginalFilename());
        video.setContentType(file.getContentType());
        video.setData(file.getBytes());
        video.setUploadDate(LocalDateTime.now());
        return videoRepository.save(video);
    }
    
    public List<Video> searchVideos(String title) {
        if (title == null || title.isEmpty()) {
            return videoRepository.findAll();
        }
        return videoRepository.findByTitleContainingIgnoreCase(title);
    }
    
    public Video getVideo(Long id) {
        return videoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Vídeo não encontrado"));
    }
}
