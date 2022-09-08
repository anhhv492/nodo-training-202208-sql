import { Component} from '@angular/core';
import {Author, authors} from '../authors.model';
@Component({
  selector: 'app-day8-list',
  templateUrl:'../day8/list.html'
})
export class Day8ComponentList  {
  authors = authors;
  currentAuthor=authors[0];
  onSelected(selected:Author){
    this.currentAuthor = selected;
  }
  onDeleted(id:number){
    this.authors = this.authors.filter(author=>{
      return author.id!==id;
    })
    // if(this.currentAuthor.id===id){
    //   this.currentAuthor = this.authors[0];
    // }
  }
}
