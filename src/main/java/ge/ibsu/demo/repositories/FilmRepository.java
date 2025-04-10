package ge.ibsu.demo.repositories;

import ge.ibsu.demo.dto.projections.FilmInfo;
import ge.ibsu.demo.entities.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository()
public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query("SELECT new ge.ibsu.demo.dto.projections.FilmInfo(f.title, f.releaseYear, c.name) " +
            "FROM Film f " +
            "JOIN FilmCategory fc ON fc.film.id = f.id " +  // Join on FilmCategory, using Film's ID
            "JOIN Category c ON fc.category.id = c.id " +  // Join Category via FilmCategory
            "WHERE LOWER(f.title) LIKE LOWER(CONCAT('%', :searchText, '%'))")
    Page<FilmInfo> searchFilms(@Param("searchText") String searchText, Pageable pageable);
}
