import { HttpClient, HttpHeaders } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { User } from '../model/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Firstservice {

  http = inject(HttpClient);

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>('http://localhost:8080/demo/getAll');
  }

  addUsers(name: string, email: string) {
    const formData = new URLSearchParams(); // For x-www-form-urlencoded
    formData.set('name', name);
    formData.set('email', email);

    const headers = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded'
    });

    this.http.post('http://localhost:8080/demo/add', formData.toString(), { headers }).subscribe({
      next: (data) => {
        console.log('User added successfully:', data);
        alert('User added successfully');
      },
      error: (err) => {
        console.error('Error adding user:', err);
        alert('Error adding user');
      }
    });
  }

  modifyUser(id: string, name: string, email: string) {
    const formData = new URLSearchParams();
    formData.set('id', id);
    formData.set('name', name);
    formData.set('email', email);

    const headers = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded'
    });

    this.http.put('http://localhost:8080/demo/modify', formData.toString(), { headers }).subscribe({
      next: (data) => {
        console.log('User modified successfully:', data);
        alert('User modified successfully');
      },
      error: (err) => {
        console.error('Error modifying user:', err);
        alert('Error modifying user');
      }
    });
  }

  deleteUser(id: number) {

    this.http.delete(`http://localhost:8080/demo/delete/${id}`).subscribe({
      next: (data) => {
        console.log('User deleted successfully:', data);
        alert('User deleted successfully');
      },
      error: (err) => {
        console.error('Error deleting user:', err);
        alert('Error deleting user');
      }
    });
  }
}