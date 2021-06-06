import '@vaadin/vaadin-button';
import '@vaadin/vaadin-text-field';
import '@vaadin/vaadin-form-layout';
import '@vaadin/vaadin-ordered-layout/vaadin-horizontal-layout';
import { customElement, html, LitElement } from 'lit-element';

@customElement('component-form-view')
export class ComponentFormView extends LitElement {
  createRenderRoot() {
    return this;
  }
  render() {
    return html`<h3>component</h3>
      <vaadin-form-layout style="width: 100%;">
        <vaadin-text-field
          label="component code"
          id="componentCode"
          pattern="[0-9]{0,12}" prevent-invalid-input
          helper-text="it accepts only twelve digits from zero to nine">
          <iron-icon slot="prefix" icon="vaadin:list-ol"></iron-icon>
        </vaadin-text-field></br>
        <vaadin-text-field
          label="amount"
          id="amount"
          helper-text="max 9999"
          pattern="[0-9]{0,4}" prevent-invalid-input
          has-controls>
          <iron-icon slot="prefix" icon="vaadin:abacus"></iron-icon>
          <div slot="suffix">pieces</div>
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
