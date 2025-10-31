import { Component, inject } from '@angular/core';
import { Firstservice } from '../../services/firstservice';
import { User } from '../../model/user';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-firstpage',
  imports: [ReactiveFormsModule],
  templateUrl: './firstpage.html',
  styleUrl: './firstpage.css'
})
export class Firstpage {
  firstService = inject(Firstservice);
  userList: User[] = [];
  showData() {
    this.firstService.getUsers().subscribe({
          next:(data) => {
            this.userList = data;
          },
          error:(err) => {
            console.error('Error fetching data:', err);
          }
        });
  }

  modifyForm = new FormGroup({
    id: new FormControl(''),
    name: new FormControl(''),
    email: new FormControl(''),
  }); 

  populateForm(item: User) {
    this.modifyForm.patchValue({
      id: item.id.toString(),
      name: item.name,
      email: item.email
    });
  }
  modifyData() {
    if (this.modifyForm.value.id == '' || this.modifyForm.value.name == '' || this.modifyForm.value.email == '') {
      alert("Please fill all fields");
    } else {
      this.firstService.modifyUser(
        this.modifyForm.value.id!,
        this.modifyForm.value.name!,
        this.modifyForm.value.email!
      );
    }   
  }

  deleteUser(id: number) {
    if (confirm("Are you sure to delete user with ID: " + id)) {
      this.firstService.deleteUser(id);
    }
  }
  
  numericOnly(event:any): boolean { // restrict e,+,-,E characters in  input type number
    const charCode = (event.which) ? event.which : event.keyCode;
    if (charCode == 101 || charCode == 69 || charCode == 45 || charCode == 43) {
      return false;
    }
    return false;

  }

}
