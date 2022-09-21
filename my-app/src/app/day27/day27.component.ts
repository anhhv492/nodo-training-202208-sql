import { Component, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Article } from './article';
import {ArticleService} from "../services/article.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-day27',
  templateUrl: './day27.component.html',
  styleUrls: ['./day27.component.scss']
})
export class Day27Component implements OnInit {
  articles:Observable<Article[]>| undefined;
  ngOnInit():void{
    this.articles=this.articleService.articles;
  }
  constructor(
    private readonly articleService:ArticleService,
    private readonly router:Router
  ) {}
  onReadMoreClick(slug:string){
    this.router.navigate(['/detail',slug]);
  }
}
