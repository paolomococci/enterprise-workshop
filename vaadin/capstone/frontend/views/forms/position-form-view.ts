import '@vaadin/vaadin-button';
import '@vaadin/vaadin-text-field';
import '@vaadin/vaadin-text-field/vaadin-integer-field';
import '@vaadin/vaadin-form-layout';
import '@vaadin/vaadin-ordered-layout/vaadin-horizontal-layout';
import { customElement, html, LitElement } from 'lit-element';

@customElement('position-form-view')
export class PositionFormView extends LitElement {
  createRenderRoot() {
    return this;
  }
  render() {
    return html`<h3>position</h3>
      <vaadin-form-layout style="width: 100%;">
        <vaadin-text-field
          label="position label"
          id="positionLabel"
          pattern="[0-9]{0,12}" prevent-invalid-input
          helper-text="it accepts only twelve digits from zero to nine">
          <iron-icon slot="prefix" icon="vaadin:records"></iron-icon>
        </vaadin-text-field></br>
        <vaadin-integer-field
          label="capacity"
          id="capacity"
          helper-text="max 99"
          value="0"
          min="0"
          max="99"
          has-controls>
          <div slot="suffix">capacity</div>
        </vaadin-integer-field>
      </vaadin-form-layout>
      <vaadin-horizontal-layout
        style="margin-top: var(--lumo-space-m); margin-bottom: var(--lumo-space-l);"
        theme="spacing">
        <vaadin-button theme="primary" id="save">save</vaadin-button>
        <vaadin-button id="cancel">cancel</vaadin-button>
      </vaadin-horizontal-layout>`;
  }
}
