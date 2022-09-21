import { Component, OnInit } from '@angular/core';
import { interval } from 'rxjs';

@Component({
  selector: 'app-day18',
  templateUrl: './day18.component.html',
  styleUrls: ['./day18.component.scss']
})
export class Day18Component {
  currentDate = new Date();
  users = [{
    name:'vietanhvs',
    age:20
  },
  {
    name:'manh chung',
    age:25
  },
  {
    name:'minh quyet',
    age:12
  },
  {
    name:'huan rosi',
    age:33
  },
  {
    name:'tien bry',
    age:42
  }]
  addr={
    address1:'thon 3',
    address2:'vinh phuc',
    city:'vsn',
    state:'state',
    zip:'12345',
    country:'US'
  }
  formatAddress(address: { address1: string; address2: string; city: string; state: string; zip: string; country: string; }) {
    console.log('address',address);
    return address.address1 +", "+
    address.address2 +", "+
    address.city +", "+
    address.state +", "+
    address.zip +", "+
    address.country
  }
  time=0;
  interval =interval(1000);
  // ngOnInit(): void {
  //   this.interval$.subscribe(val=>{
  //     this.time=val;
  //   })
  // }
  addUser(){
    // this.users= [...this.users,{
    //   name:'new user',
    //   age:20
    // }]
    this.users.push({
      name:'new user',
      age:20
    })
  }
}
