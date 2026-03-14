import { Directive, Input, HostBinding, HostListener } from '@angular/core';

//a simple directive to highlight on hover
@Directive({
  selector: '[highLight]',
})
export class HighlightDirective {
  @Input('highLight') highlightColor = 'lightyellow';

  //@HostBinding: Binds the element's style.backgroundColor and transition properties from directive fields.
  //@HostListener: Reacts to mouseenter/mouseleave to set/clear the background color.
  @HostBinding('style.transition') transition = 'background-color 150ms ease-in-out';
  @HostBinding('style.backgroundColor') bg = '';

  @HostListener('mouseenter') onEnter() {
    this.bg = this.highlightColor;
  }
  @HostListener('mouseleave') onLeave() {
    this.bg = '';
  }
}
