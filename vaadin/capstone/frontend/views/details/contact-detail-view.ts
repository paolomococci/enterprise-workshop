import '@vaadin/vaadin-split-layout';
import { customElement, html, LitElement } from 'lit-element';

@customElement('contact-detail-view')
export class ContactDetailView extends LitElement {
  createRenderRoot() {
    return this;
  }
  render() {
    return html`<vaadin-split-layout class="w-full h-full"></vaadin-split-layout>`;
  }
}
