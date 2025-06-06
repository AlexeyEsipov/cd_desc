package ru.checkdev.desc.web;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.checkdev.desc.domain.Topic;
import ru.checkdev.desc.dto.TopicDTO;
import ru.checkdev.desc.dto.TopicLiteDTO;
import ru.checkdev.desc.service.CategoryService;
import ru.checkdev.desc.service.TopicService;

import java.util.List;

@Tag(name = "TopicsControl", description = "Topics REST API")
@RequestMapping("/topics")
@RestController
@AllArgsConstructor
public class TopicsControl {
    private final TopicService topicService;
    private final CategoryService categoryService;

    @GetMapping("/")
    public List<Topic> getAll() {
        return topicService.getAll();
    }

    @GetMapping("/{id}")
    public List<Topic> getByCategory(@PathVariable int id) {
        var topics = topicService.findByCategoryId(id);
        categoryService.updateStatistic(id);
        return topics;
    }

    @GetMapping("/getByCategoryId/{categoryId}")
    public ResponseEntity<List<TopicDTO>> getByCategoryId(@PathVariable int categoryId) {
        return new ResponseEntity<>(topicService
                .getTopicDTOsByCategoryId(categoryId), HttpStatus.OK);
    }

    @GetMapping("/dto/lite")
    public ResponseEntity<List<TopicLiteDTO>> getAllTopicLiteDTO() {
        var topicLiteDtoList = topicService.getAllTopicLiteDTO();
        return ResponseEntity.ok(topicLiteDtoList);
    }
}
