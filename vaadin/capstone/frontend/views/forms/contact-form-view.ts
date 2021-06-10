import '@vaadin/vaadin-button';
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
        <vaadin-text-field label="name" id="name"></vaadin-text-field>
        <vaadin-text-field label="surname" id="surname"></vaadin-text-field>
        <vaadin-date-picker label="birthday" id="dateOfBirth"></vaadin-date-picker>
        <vaadin-text-field id="phoneMobileNumber" label="phone mobile number"></vaadin-text-field>
        <vaadin-text-field label="contributory identifier" id="contributoryIdentifier"></vaadin-text-field>
        <vaadin-email-field id="email" label="email"></vaadin-email-field>
        <vaadin-text-field id="profession" label="profession"></vaadin-text-field>
        <vaadin-text-field id="role" label="role"></vaadin-text-field>
      </vaadin-form-layout>
      <vaadin-horizontal-layout
        style="margin-top: var(--lumo-space-m); margin-bottom: var(--lumo-space-l);"
        theme="spacing">
        <vaadin-button theme="primary" id="save">save</vaadin-button>
        <vaadin-button id="cancel">cancel</vaadin-button>
      </vaadin-horizontal-layout>`;
  }
}
