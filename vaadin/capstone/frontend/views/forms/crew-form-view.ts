import '@vaadin/vaadin-button';
import '@vaadin/vaadin-text-field';
import '@vaadin/vaadin-form-layout';
import '@vaadin/vaadin-ordered-layout/vaadin-horizontal-layout';
import { customElement, html, LitElement } from 'lit-element';

@customElement('crew-form-view')
export class CrewFormView extends LitElement {
  createRenderRoot() {
    return this;
  }
  render() {
    return html`<h3>crew</h3>
      <vaadin-form-layout style="width: 100%;">
        <vaadin-text-field
          label="crew code"
          id="crewCode"
          pattern="[0-9]{0,12}" prevent-invalid-input
          helper-text="it accepts only twelve digits from zero to nine">
        </vaadin-text-field></br>
        <vaadin-text-field
          label="crew name"
          id="crewName"
          pattern="[a-zA-Z0-9]{0,12}" prevent-invalid-input
          helper-text="this field only accepts a string of twelve letters or numeric digits">
        </vaadin-text-field>
      </vaadin-form-layout>
      <vaadin-horizontal-layout
        style="margin-top: var(--lumo-space-m); margin-bottom: var(--lumo-space-l);"
        theme="spacing">
        <vaadin-button theme="primary" id="save">save</vaadin-button>
        <vaadin-button id="cancel">cancel</vaadin-button>
      </vaadin-horizontal-layout>`;
  }
}
