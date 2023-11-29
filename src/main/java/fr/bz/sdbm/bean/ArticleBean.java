package fr.bz.sdbm.bean;

import fr.bz.sdbm.metier.Article;
import lombok.*;

@Getter
@Setter
public class ArticleBean {
 private Article article;

    public ArticleBean(Article article) {
        this.article = article;
    }
}
