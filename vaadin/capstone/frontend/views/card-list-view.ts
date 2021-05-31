import { customElement, html, LitElement } from 'lit-element';

@customElement('card-list-view')
export class CardListView extends LitElement {
  createRenderRoot() {
    return this;
  }
  render() {
    return html`<div>todo</div>`;
  }
}
