import { Pipe, PipeTransform } from "@angular/core";


@Pipe({ name: 'titlecase2', standalone: true })
export class TitleCase2Pipe implements PipeTransform {
  transform(value: string): string {
    if (!value) return '';
    return value
      .split(/\s+/)
      .map(w => w.charAt(0).toUpperCase() + w.slice(1).toLowerCase())
      .join(' ');
  }
}