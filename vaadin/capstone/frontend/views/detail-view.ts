import { customElement, html, LitElement } from 'lit-element';

@customElement('detail-view')
export class DetailView extends LitElement {
  createRenderRoot() {
    return this;
  }
  render() {
    return html`<div>todo</div>`;
  }
}
