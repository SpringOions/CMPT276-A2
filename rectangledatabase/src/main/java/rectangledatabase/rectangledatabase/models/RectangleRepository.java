package rectangledatabase.rectangledatabase.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RectangleRepository extends JpaRepository<Rectangle,Integer> {
    List<Rectangle> findByHeight(int height);
    List<Rectangle> findByrid(int rid);


}
