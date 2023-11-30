package fr.bz.sdbm.bean;

import fr.bz.sdbm.metier.Article;
import lombok.*;

@Getter
@Setter
public class ArticleSearchBean {
 private Article article;

    public ArticleSearchBean(Article article) {
        this.article = article;
    }
}
