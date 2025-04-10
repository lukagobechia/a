package ge.ibsu.demo.services;

import ge.ibsu.demo.dto.Paging;
import ge.ibsu.demo.dto.SearchFilm;
import ge.ibsu.demo.dto.projections.FilmInfo;
import ge.ibsu.demo.repositories.FilmRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class FilmService {
    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Page<FilmInfo> searchFilm(SearchFilm searchFilm, Paging paging) {
        String searchText = searchFilm.getSearchText() != null ? "%" + searchFilm.getSearchText() + "%" : "";
        Pageable pageable = PageRequest.of(paging.getPage() - 1, paging.getSize(), Sort.by("id").descending());
        return filmRepository.searchFilms(searchText, pageable);
    }
}
