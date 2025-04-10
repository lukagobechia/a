package ge.ibsu.demo.controllers;

import ge.ibsu.demo.dto.RequestData;
import ge.ibsu.demo.dto.SearchFilm;
import ge.ibsu.demo.dto.projections.FilmInfo;
import ge.ibsu.demo.services.FilmService;
import ge.ibsu.demo.util.GeneralUtil;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController()
@RequestMapping("/api/film")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @RequestMapping(value = "/searchFilm", method = RequestMethod.POST, produces = {"application/json"})
    public Page<FilmInfo> searchStaff(@RequestBody RequestData<SearchFilm> rd) throws Exception {
        GeneralUtil.checkRequiredProperties(rd.getData(), Arrays.asList("searchText"));
        return filmService.searchFilm(rd.getData(), rd.getPaging());
    }
}