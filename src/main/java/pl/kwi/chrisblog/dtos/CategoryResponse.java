package pl.kwi.chrisblog.dtos;

import java.util.List;

import pl.kwi.chrisblog.db.entities.CategoryEntity;

public record CategoryResponse(List<CategoryEntity> categories) {}
