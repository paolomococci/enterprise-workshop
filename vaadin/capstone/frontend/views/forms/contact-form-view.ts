import '@vaadin/vaadin-button';
import '@vaadin/vaadin-combo-box';
import '@vaadin/vaadin-custom-field';
import '@vaadin/vaadin-date-picker';
import '@vaadin/vaadin-form-layout';
import '@vaadin/vaadin-ordered-layout/vaadin-horizontal-layout';
import '@vaadin/vaadin-text-field';
import '@vaadin/vaadin-text-field/vaadin-email-field';
import { customElement, html, LitElement } from 'lit-element';

@customElement('contact-form-view')
export class ContactFormView extends LitElement {
  createRenderRoot() {
    return this;
  }
  render() {
    return html`<h3>contact</h3>
      <vaadin-form-layout style="width: 100%;">
        <vaadin-text-field label="first name" id="firstName"></vaadin-text-field>
        <vaadin-text-field label="last name" id="lastName"></vaadin-text-field>
        <vaadin-date-picker id="birthday" label="birthday"></vaadin-date-picker>
        <vaadin-custom-field id="phoneMobileNumber" label="phone mobile number">
        <div>todo</div>
      </vaadin-form-layout>
      <vaadin-horizontal-layout
        style="margin-top: var(--lumo-space-m); margin-bottom: var(--lumo-space-l);"
        theme="spacing">
        <vaadin-button theme="primary" id="save">save</vaadin-button>
        <vaadin-button id="cancel">cancel</vaadin-button>
      </vaadin-horizontal-layout>`;
  }
}
