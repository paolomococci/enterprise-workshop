import '@vaadin/vaadin-split-layout';
import { customElement, html, LitElement } from 'lit-element';

@customElement('position-detail-view')
export class PositionDetailView extends LitElement {
  createRenderRoot() {
    return this;
  }
  render() {
    return html`<vaadin-split-layout class="w-full h-full"></vaadin-split-layout>`;
  }
}
