import { Component, inject } from '@angular/core';
import { Firstservice } from '../../services/firstservice';
import { User } from '../../model/user';

@Component({
  selector: 'app-firstpage',
  imports: [],
  templateUrl: './firstpage.html',
  styleUrl: './firstpage.css'
})
export class Firstpage {
  firstService = inject(Firstservice);
  userList: User[] = [];
  showData() {
    console.log("button clicked");
    this.firstService.getUsers().subscribe({
          next:(data) => {
            this.userList = data;
          },
          error:(err) => {
            console.error('Error fetching data:', err);
          }
        });
  }
}
