import '@vaadin/vaadin-button';
import '@vaadin/vaadin-text-field';
import '@vaadin/vaadin-form-layout';
import '@vaadin/vaadin-ordered-layout/vaadin-horizontal-layout';
import { customElement, html, LitElement } from 'lit-element';

@customElement('carrier-form-view')
export class CarrierFormView extends LitElement {
  createRenderRoot() {
    return this;
  }
  render() {
    return html`<h3>carrier</h3>
      <vaadin-form-layout style="width: 100%;">
        <vaadin-text-field label="carrier name" id="carrierName"></vaadin-text-field></br>
        <vaadin-text-field label="sticker" id="sticker" pattern="[a-z]{0,12}" prevent-invalid-input></vaadin-text-field>
      </vaadin-form-layout>
      <vaadin-horizontal-layout
        style="margin-top: var(--lumo-space-m); margin-bottom: var(--lumo-space-l);"
        theme="spacing">
        <vaadin-button theme="primary" id="save">save</vaadin-button>
        <vaadin-button id="cancel">cancel</vaadin-button>
      </vaadin-horizontal-layout>`;
  }
}
