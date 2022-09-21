import {Component, OnInit} from "@angular/core";
import {ActivatedRoute} from "@angular/router";
import {filter, Observable, pluck, switchMap} from "rxjs";
import {Article} from "../day27/article";
import {ArticleService} from "../services/article.service";

@Component({
  selector:'app-article-detail',
  templateUrl:'./article-detail.component.html'
})
export class ArticleDetailComponent implements OnInit{
  article: Observable<Article> | undefined;
  constructor(
    private readonly route: ActivatedRoute,
    private readonly articleService:ArticleService
    ) {
  }
  ngOnInit():void {
    this.article = this.route.params.pipe(
      pluck('slug'),
      switchMap(slug=>this.articleService.getArticle(slug)),
      filter(article=>!!article)
    );
  }
  // ngOnInit():void {
  //   this.route.params.subscribe(console.log);
  //   this.route.paramMap.subscribe(console.log);
  //   console.log(this.route.snapshot.params);
  //   console.log(this.route.snapshot.paramMap);
  // }

}
