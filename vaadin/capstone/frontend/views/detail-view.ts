import '@vaadin/vaadin-button';
import '@vaadin/vaadin-date-picker';
import '@vaadin/vaadin-date-time-picker';
import '@vaadin/vaadin-form-layout';
import '@vaadin/vaadin-grid';
import '@vaadin/vaadin-grid/vaadin-grid-column';
import '@vaadin/vaadin-ordered-layout/vaadin-horizontal-layout';
import '@vaadin/vaadin-split-layout';
import '@vaadin/vaadin-text-field';
import { customElement, html, LitElement } from 'lit-element';

@customElement('detail-view')
export class DetailView extends LitElement {
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
            <vaadin-text-field label="name" id="name"></vaadin-text-field
            ><vaadin-text-field label="surname" id="surname"></vaadin-text-field
            ><vaadin-text-field label="email" id="email"></vaadin-text-field
            ><vaadin-text-field label="phone" id="phone"></vaadin-text-field
            ><vaadin-date-picker label="date of birth" id="dateOfBirth"></vaadin-date-picker
            ><vaadin-text-field label="occupation" id="occupation"></vaadin-text-field
            ><vaadin-checkbox id="important" style="padding-top: var(--lumo-space-m);">important</vaadin-checkbox>
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
