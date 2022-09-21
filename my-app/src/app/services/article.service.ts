import {Injectable} from "@angular/core";
import {Article} from "../day27/article";
import {map, Observable, of, shareReplay} from "rxjs";

@Injectable({
  providedIn:'root'
})
export class ArticleService{
  get articles(){
    return of<Article[]>([
      {title:'title-1',body:'body 1',slug:'title-1'},
      {title:'title-2',body:'body 2',slug:'title-2'},
    ]).pipe(shareReplay(1));
  }
  getArticle(slug:string):Observable<Article>{
    // @ts-ignore
    return this.articles.pipe(map(
      articles => articles.
      find(ar=>ar.slug===slug)));
  }
  constructor() {
  }
}
