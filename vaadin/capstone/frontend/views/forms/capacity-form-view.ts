import '@vaadin/vaadin-button';
import '@vaadin/vaadin-text-field';
import '@vaadin/vaadin-text-field/vaadin-integer-field';
import '@vaadin/vaadin-form-layout';
import '@vaadin/vaadin-ordered-layout/vaadin-horizontal-layout';
import { customElement, html, LitElement } from 'lit-element';

@customElement('capacity-form-view')
export class AddressFormView extends LitElement {
  createRenderRoot() {
    return this;
  }
  render() {
    return html`<h3>capacity</h3>
      <vaadin-form-layout style="width: 100%;">
        <vaadin-text-field label="code" id="code" pattern="[0-9]{0,6}" prevent-invalid-input colspan="2"></vaadin-text-field>
        <vaadin-integer-field label="useful weight" id="usefulWeight" value="0" min="0"></vaadin-integer-field>
        <vaadin-integer-field label="useful volume" id="usefulVolume" value="0" min="0"></vaadin-integer-field>
      </vaadin-form-layout>
      <vaadin-horizontal-layout
        style="margin-top: var(--lumo-space-m); margin-bottom: var(--lumo-space-l);"
        theme="spacing">
        <vaadin-button theme="primary" id="save">save</vaadin-button>
        <vaadin-button id="cancel">cancel</vaadin-button>
      </vaadin-horizontal-layout>`;
  }
}
