import { customElement, html, LitElement } from 'lit-element';

@customElement('hello-view')
export class HelloView extends LitElement {
  createRenderRoot() {
    return this;
  }
  render() {
    return html`<div>todo</div>`;
  }
}
