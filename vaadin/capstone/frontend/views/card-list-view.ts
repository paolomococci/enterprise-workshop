import '@vaadin/vaadin-grid';
import { customElement, html, LitElement } from 'lit-element';

@customElement('card-list-view')
export class CardListView extends LitElement {
  createRenderRoot() {
    return this;
  }
  render() {
    return html`<div class="card-list-view"><vaadin-grid id="grid" theme="no-border no-row-borders"> </vaadin-grid></div>`;
  }
}
