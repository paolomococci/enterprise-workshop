import '@vaadin/vaadin-button';
import '@vaadin/vaadin-text-field';
import '@vaadin/vaadin-form-layout';
import '@vaadin/vaadin-ordered-layout/vaadin-horizontal-layout';
import { customElement, html, LitElement } from 'lit-element';

@customElement('search-view')
export class SearchView extends LitElement {
  createRenderRoot() {
    return this;
  }
  render() {
    return html`<h3>search</h3>
      <vaadin-form-layout style="width: 100%;">
        <vaadin-text-field
          label="text to search for"
          id="textToSearchFor"
          colspan="3"
          pattern="[a-zA-Z0-9]{0,20}"
          prevent-invalid-input>
        </vaadin-text-field>
      </vaadin-form-layout>
      <vaadin-horizontal-layout
        style="margin-top: var(--lumo-space-m); margin-bottom: var(--lumo-space-l);"
        theme="spacing">
        <vaadin-button theme="primary" id="quest">quest</vaadin-button>
      </vaadin-horizontal-layout>`;
  }
}
