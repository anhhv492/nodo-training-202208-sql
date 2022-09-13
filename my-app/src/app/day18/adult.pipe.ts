import { Pipe, PipeTransform } from "@angular/core";

@Pipe({
  name:'adult',
  pure:false
})
export class AdultPipe implements PipeTransform {
  transform(value: any[]){
    console.log('adult pipe')
    return value.filter(v=>v.age>=18);
  }
}
