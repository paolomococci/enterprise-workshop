import '@vaadin/vaadin-button';
import '@vaadin/vaadin-text-field';
import { customElement, html, LitElement } from 'lit-element';

@customElement('hello-view')
export class HelloView extends LitElement {
  createRenderRoot() {
    return this;
  }
  render() {
    return html`<div class="hello-view"><vaadin-text-field id="name" label="type your name"></vaadin-text-field>
      <vaadin-button id="helloOnClick">hello</vaadin-button><div>`;
  }
}
