import { html, fixture, expect } from '@open-wc/testing';

import { SampleLit } from '../src/SampleLit.js';
import '../src/sample-lit.js';

describe('SampleLit', () => {
  let element: SampleLit;
  beforeEach(async () => {
    element = await fixture(html`<sample-lit></sample-lit>`);
  });

  it('renders a h1', () => {
    const h1 = element.shadowRoot!.querySelector('h1')!;
    expect(h1).to.exist;
    expect(h1.textContent).to.equal('My app');
  });

  it('passes the a11y audit', async () => {
    await expect(element).shadowDom.to.be.accessible();
  });
});
