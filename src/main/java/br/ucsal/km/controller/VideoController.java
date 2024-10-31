package br.ucsal.km.controller;

import br.ucsal.km.model.Video;
import br.ucsal.km.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class VideoController {
    private final VideoService videoService;
    
    @GetMapping("/")
    public String index(Model model, @RequestParam(required = false) String search) {
        model.addAttribute("videos", videoService.searchVideos(search));
        return "index";
    }
    
    @PostMapping("/upload")
    public String uploadVideo(@RequestParam("file") MultipartFile file,
                            @RequestParam("title") String title) throws IOException {
        videoService.saveVideo(file, title);
        return "redirect:/";
    }
    
    @GetMapping("/video/{id}")
    public String viewVideo(@PathVariable Long id, Model model) {
        model.addAttribute("video", videoService.getVideo(id));
        return "video";
    }
    
    @GetMapping("/video/{id}/data")
    @ResponseBody
    public ResponseEntity<byte[]> getVideoData(@PathVariable Long id) {
        Video video = videoService.getVideo(id);
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_TYPE, video.getContentType())
            .body(video.getData());
    }
}
