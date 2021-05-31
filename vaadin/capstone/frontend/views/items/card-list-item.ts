import { customElement, html, LitElement } from 'lit-element';

@customElement('card-list-item')
export class CardListItem extends LitElement {
  createRenderRoot() {
    return this;
  }
  render() {
    return html`<div>todo</div>`;
  }
}
