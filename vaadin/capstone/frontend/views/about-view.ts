import { customElement, html, LitElement } from 'lit-element';

@customElement('about-view')
export class AboutView extends LitElement {
  createRenderRoot() {
    return this;
  }
  render() {
    return html`<section class="about-view">
      <h3>about</h3>
      brief description of this demonstrative web application
    </section>`;
  }
}
