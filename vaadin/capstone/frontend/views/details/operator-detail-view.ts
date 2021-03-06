import '@vaadin/vaadin-split-layout';
import '@vaadin/vaadin-grid';
import '@vaadin/vaadin-form-layout';
import '@vaadin/vaadin-ordered-layout/vaadin-horizontal-layout';
import '@vaadin/vaadin-text-field';
import '@vaadin/vaadin-text-field/vaadin-email-field';
import '@vaadin/vaadin-button';
import { customElement, html, LitElement } from 'lit-element';

@customElement('operator-detail-view')
export class OperatorDetailView extends LitElement {
  createRenderRoot() {
    return this;
  }
  render() {
    return html`<vaadin-split-layout class="w-full h-full">
      <div class="flex-grow w-full" id="grid-wrapper">
        <vaadin-grid id="grid"></vaadin-grid>
      </div>
      <div class="flex flex-col" style="width: 400px;">
        <div class="p-l flex-grow">
          <vaadin-form-layout>
            <vaadin-text-field label="name" id="name"></vaadin-text-field>
            <vaadin-text-field label="surname" id="surname"></vaadin-text-field>
            <vaadin-date-picker label="birthday" id="dateOfBirth"></vaadin-date-picker>
            <vaadin-text-field id="phoneNumber" label="phone number"></vaadin-text-field>
            <vaadin-text-field label="contributory identifier" id="contributoryIdentifier"></vaadin-text-field>
            <vaadin-email-field id="email" label="email"></vaadin-email-field>
            <vaadin-text-field id="role" label="role"></vaadin-text-field>
          </vaadin-form-layout>
        </div>
        <vaadin-horizontal-layout class="w-full flex-wrap bg-contrast-5 py-s px-l" theme="spacing">
          <vaadin-button theme="primary" id="save">save</vaadin-button>
          <vaadin-button theme="tertiary" slot="" id="cancel">cancel</vaadin-button>
        </vaadin-horizontal-layout>
      </div>
    </vaadin-split-layout>`;
  }
}
