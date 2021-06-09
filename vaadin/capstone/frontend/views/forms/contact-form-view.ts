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
    return html`<div>todo</div>`;
  }
}
