package at.mauexe.steyrerbackend.domain;

import at.mauexe.steyrerbackend.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface INewsRepository extends JpaRepository<News, Long> {
    public Set<News> findByPostedAtIsLessThan(Date date);
    @Query("select n from News n")
    public List<News> getNewsList();

}
