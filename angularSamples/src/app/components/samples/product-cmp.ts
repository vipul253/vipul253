import { Component, OnInit, inject } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
@Component({
  selector: 'product-cmp',
  imports: [RouterLink],
  template: `<h2>Product ID: {{ id }}</h2>
    <a routerLink="/nrouteparam">Back</a>`,
})
export class Product implements OnInit {
  //product/:id: Declares a path parameter named id.
  //ActivatedRoute: Reads id from snapshot.paramMap.get('id') in ngOnInit.
  //Links: routerLink="/product/1" and /product/2 demonstrate parameterized navigation.
  id = '';
  private route = inject(ActivatedRoute);
  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id') ?? '';
  }
}
