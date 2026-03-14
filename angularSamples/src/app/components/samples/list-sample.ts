import { Component, signal, computed } from '@angular/core';
import { CommonModule } from '@angular/common';

type Product = { name: string; price: number };
@Component({
  selector: 'list-sample',
  imports: [CommonModule],
  template: `
    <h3>Basic List with &commat;for</h3>
    <ul>
      @for (item of items(); let i = $index; track item) {
        <li>{{ i + 1 }}. {{ item }}</li>
      } @empty {
        <li>No items</li>
      }
    </ul>
    <button (click)="add()">Add Item</button>
    <button (click)="clear()">Clear</button>
    <button (click)="reset()">Reset</button>

    <h3>Lists with track</h3>
    <ul>
      @for (it of itemMap(); let i = $index; track it.id) {
        <li>{{ i + 1 }}. {{ it.name }} (id: {{ it.id }})</li>
      }
    </ul>
    <button (click)="renameFirst()">Rename first</button>
    <button (click)="shuffle()">Shuffle</button>
    <button (click)="addItem()">Add item</button>

    <h3>Filter & Sort</h3>
    <div style="display:flex;gap:8px;margin-bottom:8px;">
      <label>Search: <input #q (input)="query.set(q.value)" placeholder="Type to filter..." /></label>
      <button (click)="setSort('name')">Sort by Name</button>
      <button (click)="setSort('price')">Sort by Price</button>
      <button (click)="toggleDir()">{{ sortDir() === 1 ? 'Asc' : 'Desc' }}</button>
    </div>

    <table style="width:100%;border-collapse:collapse;">
      <thead>
        <tr>
          <th style="border:1px solid #ddd;padding:8px;background:#f7f7f7;">Name</th>
          <th style="border:1px solid #ddd;padding:8px;background:#f7f7f7;width:140px;">Price</th>
        </tr>
      </thead>
      <tbody>
        @for (p of view(); track p.name) {
          <tr>
            <td style="border:1px solid #ddd;padding:8px;">{{ p.name }}</td>
            <td style="border:1px solid #ddd;padding:8px;">{{ p.price | currency: 'USD' }}</td>
          </tr>
        }
      </tbody>
    </table>
  `,
})
export class ListSample {
  items = signal(['Angular', 'React', 'Vue']);
  //immutable update with ... spread
  add() {
    this.items.update((arr) => [...arr, 'Svelte']);
  }
  clear() {
    this.items.set([]);
  }
  reset() {
    this.items.set(['Angular', 'React', 'Vue']);
  }

  itemMap = signal([
    { id: 1, name: 'Angular' },
    { id: 2, name: 'React' },
    { id: 3, name: 'Vue' },
  ]);
  nextId = 4;

  // track it.id: Provides a stable identity so Angular reuses DOM rows when items shuffle or update,
  // preserving focus and local state.
  // renameFirst(): Updates the first item's name immutably (new object reference) to trigger
  // change detection.
  // shuffle(): Randomizes order to demonstrate DOM reuse with track.
  // add(): Appends a new item with a unique id
  renameFirst() {
    this.itemMap.update((arr) => arr.map((it, i) => (i === 0 ? { ...it, name: it.name + ' *' } : it)));
  }

  shuffle() {
    this.itemMap.update((arr) => {
      const copy = [...arr];
      for (let i = copy.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [copy[i], copy[j]] = [copy[j], copy[i]];
      }
      return copy;
    });
  }

  addItem() {
    this.itemMap.update((arr) => [...arr, { id: this.nextId++, name: 'New ' + Date.now() }]);
  }

  itemList = signal<Product[]>([
    { name: 'Angular', price: 10 },
    { name: 'React', price: 90 },
    { name: 'Vue', price: 70 },
    { name: 'Svelte', price: 60 },
    { name: 'Solid', price: 40 },
    { name: 'Lit', price: 30 },
  ]);

  // computed() view: Derives a filtered/sorted array from signals without mutating the source list.
  // query/sortKey/sortDir: Control the derived view by updating these signals from the UI.
  // @for (p of view(); track p.name): Renders the derived rows; uses a stable key (p.name) for identity
  query = signal('');
  sortKey = signal<'name' | 'price'>('name');
  sortDir = signal<1 | -1>(1); // 1 asc, -1 desc
  view = computed(() => {
    const q = this.query().toLowerCase();
    const dir = this.sortDir();
    const key = this.sortKey();
    return this.itemList()
      .filter((it) => it.name.toLowerCase().includes(q))
      .sort((a, b) => {
        const av: any = (a as any)[key];
        const bv: any = (b as any)[key];
        return av < bv ? -1 * dir : av > bv ? 1 * dir : 0;
      });
  });

  setSort(key: 'name' | 'price') {
    if (this.sortKey() === key) {
      this.toggleDir();
    } else {
      this.sortKey.set(key);
    }
  }

  toggleDir() {
    this.sortDir.set(this.sortDir() === 1 ? -1 : 1);
  }
}
