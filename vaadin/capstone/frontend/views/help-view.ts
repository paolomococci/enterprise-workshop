import { customElement, html, LitElement } from 'lit-element';

@customElement('help-view')
export class HelpView extends LitElement {
  createRenderRoot() {
    return this;
  }
  render() {
    return html`<section class="help-view">
      <h3>help</h3>
      <ul>
        <li>short help note</li>
        <li>short help note</li>
        <li>short help note</li>
      </ul>
    </section>`;
  }
}
