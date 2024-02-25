package pl.kwi.chrisblog.dtos;

import pl.kwi.chrisblog.enums.SortingEnum;

public record ArticleRequest(Long categoryId, Long tagId, int page, SortingEnum sorting, String searchText) {}
