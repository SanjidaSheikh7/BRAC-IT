import { Component } from '@angular/core';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {
  users= [
    {
      "id": 1,
      "name": "John Doe",
      "email": "john@example.com",
      "age": 50
    },
    {
      "id": 2,
      "name": "Jane Smith",
      "email": "jane@example.com",
      "age": 25
    },
    {
      "id": 3,
      "name": "Michael Johnson",
      "email": "michael@example.com",
      "age": 35
    },
    {
      "id": 4,
      "name": "Emily Davis",
      "email": "emily@example.com",
      "age": 28
    }
  ]

  total=this.users.length;

}
