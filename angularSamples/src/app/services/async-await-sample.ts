import { HttpClient } from '@angular/common/http';
import { firstValueFrom } from 'rxjs'; // Use firstValueFrom
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataServiceSample {
  constructor(private http: HttpClient) {}

  // This function is async and returns a Promise implicitly
  async getApiData(url: string): Promise<any> {
    const data$ = this.http.get(url);
    // Convert observable to promise and await its result
    const data = await firstValueFrom(data$);
    return data;
  }
}