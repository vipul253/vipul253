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
    return this.http.get<User[]>('http://localhost:8080/demo/all');
  }

  addUsers(name: string, email: string): string {
    const formData = new URLSearchParams(); // For x-www-form-urlencoded
    formData.set('name', name);
    formData.set('email', email);

    const headers = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded'
    });

    this.http.post('http://localhost:8080/demo/add', formData.toString(), { headers }).subscribe({
      next: (data) => {
        console.log('User added successfully:', data);
        return 'Success';
      },
      error: (err) => {
        console.error('Error adding user:', err);
        return 'Error';
      }
    });
    return 'Request Sent';
  }
}
