import { customElement, html, LitElement } from 'lit-element';

@customElement('about-view')
export class AboutView extends LitElement {
  createRenderRoot() {
    return this;
  }
  render() {
    return html`<div class="about-view">brief description of this demonstrative web application</div>`;
  }
}
