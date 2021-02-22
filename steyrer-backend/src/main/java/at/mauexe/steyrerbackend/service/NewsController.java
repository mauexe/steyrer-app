package at.mauexe.steyrerbackend.service;

import at.mauexe.steyrerbackend.domain.INewsRepository;
import at.mauexe.steyrerbackend.model.News;
import at.mauexe.steyrerbackend.model.Response;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/news")
public class NewsController {

    private static Logger log = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private INewsRepository newsRepository;

    @Transactional
    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public List<News> getAllNews() {
        List<News> resource = newsRepository.getNewsList();
        resource.remove(0);
        log.info(String.format("returned list of %d news", resource.size()));
        return resource;
    }

    @Transactional
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public News addNews(@RequestBody @Valid News resource) {
        News newNews = new News(resource.getTitle(),resource.getDescription(),resource.getPostedAt(),resource.getImageLink());

        News addedNews = newsRepository.save(newNews);

        log.info(addedNews.getId().toString());
        return addedNews;
    }

    @Transactional
    @GetMapping(value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public News getOneNews(@PathVariable("id") Long id)
    {
        News resource = newsRepository.getOne(id);
        log.info(String.format("returned news with id %d", resource.getId()));
        return (News) Hibernate.unproxy(resource);
    }

    @Transactional
    @DeleteMapping(value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response deleteOneNews(@PathVariable("id") Long id)
    {
        newsRepository.deleteById(id);
        log.info("deleted news with id " + id);

        return new Response(true);
    }

}
