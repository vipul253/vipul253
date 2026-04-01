import { Component } from '@angular/core';

@Component({
  selector: 'promise-all-sample',
  template: ` <div class="container"></div> `,
})
export class PromiseAllSample {
  loadDataWithPromises() {
    const promiseOne = this.getDataPromise(1000, 'One');
    const promiseTwo = this.getDataPromise(500, 'Two');

    Promise.all([promiseOne, promiseTwo])
      .then(([resultOne, resultTwo]) => {
        // Destructure the array of results
        console.log(`All promises resolved: ${resultOne}, ${resultTwo}`);
        // Handle your data here
      })
      .catch((error) => {
        console.error('One of the promises failed:', error);
      });
  }

  // Helper function that returns a Promise
  getDataPromise(delay: number, value: string): Promise<string> {
    return new Promise((resolve) => {
      setTimeout(() => {
        resolve(`Promise Resolved: ${value} after ${delay}ms`);
      }, delay);
    });
  }
}
