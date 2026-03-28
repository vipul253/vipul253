import { Component, inject, signal } from '@angular/core';
import { FileUploadService } from '../../services/file-upload-service';
import { CommonModule } from '@angular/common';
import { catchError, finalize, Observable, throwError } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';
@Component({
  selector: 'file-upload-sample',
  imports: [CommonModule], // Add CommonModule to imports
  template: `
    <div class="container">
      <input type="file" id="file" (change)="onFileSelected($event)" />
      <button (click)="onUpload()">Upload</button>
    </div>
    @if (this.loading()) {
      <div class="d-flex justify-content-center">
        <div class="spinner-border" role="status"></div>
      </div>
    }
    <br />
  `,
})
export class FileUploadSample {
  public httpUploadSvc = inject(FileUploadService);
  selectedFile: File | null = null;
  public loading = signal(false);
  onFileSelected(event: any): void {
    const files: FileList | null = event.target.files;
    if (files && files.length > 0) {
      this.selectedFile = files.item(0);
    }
  }

  onUpload(): void {
    if (this.selectedFile) {
      this.loading.set(true);
      this.httpUploadSvc
        .uploadFile(this.selectedFile)
        .pipe(
          catchError(this.handleError),
          finalize(() => this.loading.set(false)),
        )
        .subscribe({
          next: (response) => {
            console.log(response);
          },
          error: (err) => {
            console.log(err);
          },
        });
    } else {
      console.warn('No file selected.');
    }
  }

  private handleError(error: HttpErrorResponse): Observable<never> {
    console.error('An error occurred:', error); // Log the error details
    // Return an observable with a user-facing error message
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }
}
