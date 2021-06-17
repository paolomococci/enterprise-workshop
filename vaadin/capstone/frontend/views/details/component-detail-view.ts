import '@vaadin/vaadin-split-layout';
import '@vaadin/vaadin-grid';
import '@vaadin/vaadin-form-layout';
import '@vaadin/vaadin-ordered-layout/vaadin-horizontal-layout';
import '@vaadin/vaadin-text-field';
import '@vaadin/vaadin-text-field/vaadin-integer-field';
import '@vaadin/vaadin-button';
import { customElement, html, LitElement } from 'lit-element';

@customElement('component-detail-view')
export class ComponentDetailView extends LitElement {
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
            <vaadin-text-field
              label="component code"
              id="componentCode"
              pattern="[0-9]{0,12}" prevent-invalid-input
              helper-text="it accepts only twelve digits from zero to nine">
              <iron-icon slot="prefix" icon="vaadin:list-ol"></iron-icon>
            </vaadin-text-field></br>
            <vaadin-integer-field
              label="amount"
              id="amount"
              helper-text="max 9999"
              value="0"
              min="0"
              max="9999"
              has-controls>
              <iron-icon slot="prefix" icon="vaadin:abacus"></iron-icon>
              <div slot="suffix">pieces</div>
            </vaadin-integer-field>
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
