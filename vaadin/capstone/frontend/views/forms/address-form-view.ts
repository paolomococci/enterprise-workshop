import '@vaadin/vaadin-button';
import '@vaadin/vaadin-text-field';
import '@vaadin/vaadin-form-layout';
import '@vaadin/vaadin-ordered-layout/vaadin-horizontal-layout';
import { customElement, html, LitElement } from 'lit-element';

@customElement('address-form-view')
export class AddressFormView extends LitElement {
  createRenderRoot() {
    return this;
  }
  render() {
    return html`<h3>address</h3>
      <vaadin-form-layout style="width: 100%;">
        <vaadin-text-field label="street address" id="streetAddress" colspan="2"></vaadin-text-field>
        <vaadin-text-field label="postal code" id="postalCode" pattern="[0-9]{0,6}" prevent-invalid-input></vaadin-text-field>
        <vaadin-text-field label="city" id="city"></vaadin-text-field>
        <vaadin-text-field label="state" id="state"></vaadin-text-field>
        <vaadin-text-field label="country" id="country"></vaadin-text-field>
      </vaadin-form-layout>
      <vaadin-horizontal-layout
        style="margin-top: var(--lumo-space-m); margin-bottom: var(--lumo-space-l);"
        theme="spacing">
        <vaadin-button theme="primary" id="save">save</vaadin-button>
        <vaadin-button id="cancel">cancel</vaadin-button>
      </vaadin-horizontal-layout>`;
  }
}
