import '@vaadin/vaadin-button';
import '@vaadin/vaadin-text-field';
import '@vaadin/vaadin-text-field/vaadin-number-field';
import '@vaadin/vaadin-form-layout';
import '@vaadin/vaadin-ordered-layout/vaadin-horizontal-layout';
import { customElement, html, LitElement } from 'lit-element';

@customElement('invoice-form-view')
export class InvoiceFormView extends LitElement {
  createRenderRoot() {
    return this;
  }
  render() {
    return html`<h3>invoice</h3>
      <vaadin-form-layout style="width: 100%;">
        <vaadin-text-field
          label="invoice code"
          id="invoiceCode"
          pattern="[0-9]{0,12}" prevent-invalid-input
          helper-text="it accepts only twelve digits from zero to nine">
        </vaadin-text-field></br>
        <vaadin-number-field
          label="total"
          id="total"
          value="0.0">
        </vaadin-number-field>
      </vaadin-form-layout>
      <vaadin-horizontal-layout
        style="margin-top: var(--lumo-space-m); margin-bottom: var(--lumo-space-l);"
        theme="spacing">
        <vaadin-button theme="primary" id="save">save</vaadin-button>
        <vaadin-button id="cancel">cancel</vaadin-button>
      </vaadin-horizontal-layout>`;
  }
}
