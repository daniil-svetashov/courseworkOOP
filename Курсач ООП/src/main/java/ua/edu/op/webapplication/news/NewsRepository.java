package ua.edu.op.webapplication.news;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface NewsRepository extends JpaRepository<News,Long> {
    public List<News> findAllByOrderByNewsIdDesc();
}