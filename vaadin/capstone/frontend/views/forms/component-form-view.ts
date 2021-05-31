import { customElement, html, LitElement } from 'lit-element';

@customElement('component-form-view')
export class ComponentFormView extends LitElement {
  createRenderRoot() {
    return this;
  }
  render() {
    return html`<div>todo</div>`;
  }
}
