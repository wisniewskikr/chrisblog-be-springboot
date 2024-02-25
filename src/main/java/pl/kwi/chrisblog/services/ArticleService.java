package pl.kwi.chrisblog.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pl.kwi.chrisblog.db.entities.ArticleEntity;
import pl.kwi.chrisblog.db.repositories.ArticleRepository;
import pl.kwi.chrisblog.dtos.ArticleRequest;
import pl.kwi.chrisblog.dtos.ArticleResponse;
import pl.kwi.chrisblog.enums.SortingEnum;

@Service
public class ArticleService {

    @Value(value = "${articles.on.page}")
    private int articlesOnPage;

	@Value(value = "${pagination.items.on.page}")
    private int paginationItemsOnPage;

    private ArticleRepository articleRepository;

    
    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    public ArticleResponse findArticlesByHomeCategory(ArticleRequest request) {
        
        Page<ArticleEntity> page = null;
        
        if (isTag(request)) {
            page = getTagPage(request);
        } else if(isSearch(request)) {
			page = getSearchPage(request);
		} else if(isHomeCategory(request)) {
			page = getHomeCategoryPage(request);
		} else {
			page = getOtherCategoriesPage(request);
		}
        
        return null;

    }

    private Page<ArticleEntity> getTagPage(ArticleRequest request) {
		
		Pageable pageable = PageRequest.of(request.page(), articlesOnPage, handleSorting(request.sorting()));
		return articleRepository.findByTagIdAsPage(request.tagId(), pageable);
		
	}

    private Page<ArticleEntity> getSearchPage(ArticleRequest request) {
		
		Pageable pageable = PageRequest.of(request.page(), articlesOnPage, handleSorting(request.sorting()));
		Page<ArticleEntity> page = null;
		if (request.categoryId() == 0) {
			page = articleRepository.findBySearchTextAsPage(request.searchText().toLowerCase(), pageable);
		} else {
			page = articleRepository.findBySearchTextAndCategoryIdAsPage(request.searchText().toLowerCase(), request.categoryId(), pageable);
		}		
		return page;
		
	}

    private Page<ArticleEntity> getHomeCategoryPage(ArticleRequest request) {
		
		Pageable pageable = PageRequest.of(request.page(), articlesOnPage, handleSorting(request.sorting()));
		return articleRepository.findAll(pageable);
		
	}

    private Page<ArticleEntity> getOtherCategoriesPage(ArticleRequest request) {
		
		Pageable pageable = PageRequest.of(request.page(), articlesOnPage, handleSorting(request.sorting()));
		return articleRepository.findByCategoryIdAsPage(request.categoryId(), pageable);
		
	}

    // ***** HELP METHODS ***** //

    private boolean isTag(ArticleRequest request) {		
		return (request.tagId() != null);		
	}

    private boolean isSearch(ArticleRequest request) {		
		return (StringUtils.isNotBlank(request.searchText()));		
	}
	
	private boolean isHomeCategory(ArticleRequest request) {		
		return (request.categoryId() == 0);		
	}    

    private Sort handleSorting(String selectedSorting) {
		
		SortingEnum sortingEnum = SortingEnum.getEnum(selectedSorting);
		
		switch (sortingEnum) {
		case TITLE_INCREASING:
			return Sort.by(Sort.Direction.ASC, "title");
		case TITLE_DECREASING:
			return Sort.by(Sort.Direction.DESC, "title");	
		case DATE_INCREASING:
			return Sort.by(Sort.Direction.ASC, "date");
		case DATE_DECREASING:
			return Sort.by(Sort.Direction.DESC, "date");
		case AUTHOR_INCREASING:
			return Sort.by(Sort.Direction.ASC, "author");
		case AUTHOR_DECREASING:
			return Sort.by(Sort.Direction.DESC, "author");
		default:
			return Sort.by(Sort.Direction.DESC, "title");
		}
		
	}
    
}
