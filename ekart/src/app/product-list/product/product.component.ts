import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {
  @Input()
  userC :{
        id:number,
        name:string,
        email:string,
        age:number 
      };
      
      @Input()
      totalCount:number;
    }
