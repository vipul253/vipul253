import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FileUploadService {
  private apiUrl = 'http://localhost:8080/upload';
  // Replace with your backend API URL

  constructor(private http: HttpClient) {}

  uploadFile(file: File): Observable<any> {
    const formData: FormData = new FormData();
    // 'fileKey' should match the name the API expects for the file
    formData.append('file', file, file.name);

    // Send the FormData object in the body of the POST request
    return this.http.post(this.apiUrl, formData);
  }
}
