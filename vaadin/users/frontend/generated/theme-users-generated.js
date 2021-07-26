import 'construct-style-sheets-polyfill';
import { DomModule } from "@polymer/polymer/lib/elements/dom-module";
import { stylesFromTemplate } from "@polymer/polymer/lib/utils/style-gather";
import "@polymer/polymer/lib/elements/custom-style.js";
import { css, unsafeCSS, registerStyles } from '@vaadin/vaadin-themable-mixin/register-styles';

const createLinkReferences = (css, target) => {
  const importMatcher = /(?:@media\s(.+?))?(?:\s{)?\@import\surl\((.+?)\);(?:})?/g;
  
  var match;
  var styleCss = css;

  while((match = importMatcher.exec(css)) !== null) {
    styleCss = styleCss.replace(match[0], "");
    const link = document.createElement('link');
    link.rel = 'stylesheet';
    link.href = match[2];
    if (match[1]) {
      link.media = match[1];
    }
    if (target === document) {
      document.head.appendChild(link);
    } else {
      target.appendChild(link);
    }
  };
  return styleCss;
};

export const injectGlobalCss = (css, target, first) => {
  
  const sheet = new CSSStyleSheet();
  sheet.replaceSync(createLinkReferences(css,target));
  if (first) {
    target.adoptedStyleSheets = [sheet, ...target.adoptedStyleSheets];
  } else {
    target.adoptedStyleSheets = [...target.adoptedStyleSheets, sheet];
  }
};

const addCssBlock = function (block, before = false) {
  const tpl = document.createElement("template");
  tpl.innerHTML = block;
  document.head[before ? "insertBefore" : "appendChild"](
    tpl.content,
    document.head.firstChild
  );
};

const addStyleInclude = (module, target) => {
  addCssBlock(`<custom-style><style include="${module}"></style></custom-style>`, true);
};

const getStyleModule = (id) => {
  const template = DomModule.import(id, "template");
  const cssText =
    template &&
    stylesFromTemplate(template, "")
      .map((style) => style.textContent)
      .join(" ");
  return cssText;
};
import stylesCss from 'themes/users/styles.css';
import '@vaadin/vaadin-lumo-styles/typography.js';
import '@vaadin/vaadin-lumo-styles/color.js';
import '@vaadin/vaadin-lumo-styles/spacing.js';
import '@vaadin/vaadin-lumo-styles/badge.js';
import '@vaadin/vaadin-lumo-styles/utility.js';
import vaadinButtonCss from 'themes/users/components/vaadin-button.css';
import vaadinPasswordFieldCss from 'themes/users/components/vaadin-password-field.css';
import vaadinTextAreaCss from 'themes/users/components/vaadin-text-area.css';
import vaadinTextFieldCss from 'themes/users/components/vaadin-text-field.css';

window.Vaadin = window.Vaadin || {};
window.Vaadin['_vaadintheme_users_globalCss'] = window.Vaadin['_vaadintheme_users_globalCss'] || [];
export const applyTheme = (target) => {
  
  const injectGlobal = (window.Vaadin['_vaadintheme_users_globalCss'].length === 0) || (!window.Vaadin['_vaadintheme_users_globalCss'].includes(target) && target !== document);
  if (injectGlobal) {
    injectGlobalCss(stylesCss.toString(), target);
    
    window.Vaadin['_vaadintheme_users_globalCss'].push(target);
  }
  if (!document['_vaadintheme_users_componentCss']) {
    registerStyles(
      'vaadin-button',
      css`
        ${unsafeCSS(vaadinButtonCss.toString())}
      `
    );
    registerStyles(
      'vaadin-password-field',
      css`
        ${unsafeCSS(vaadinPasswordFieldCss.toString())}
      `
    );
    registerStyles(
      'vaadin-text-area',
      css`
        ${unsafeCSS(vaadinTextAreaCss.toString())}
      `
    );
    registerStyles(
      'vaadin-text-field',
      css`
        ${unsafeCSS(vaadinTextFieldCss.toString())}
      `
    );
    
    document['_vaadintheme_users_componentCss'] = true;
  }
const shadowRoot = (target instanceof ShadowRoot);
if (shadowRoot) {
injectGlobalCss(getStyleModule("lumo-typography"), target, true);
injectGlobalCss(getStyleModule("lumo-color"), target, true);
injectGlobalCss(getStyleModule("lumo-spacing"), target, true);
injectGlobalCss(getStyleModule("lumo-badge"), target, true);
injectGlobalCss(getStyleModule("lumo-utility"), target, true);
} else if (!document['_vaadinthemelumoimports_']) {
addStyleInclude("lumo-typography", target);
addStyleInclude("lumo-color", target);
addStyleInclude("lumo-spacing", target);
addStyleInclude("lumo-badge", target);
addStyleInclude("lumo-utility", target);
document['_vaadinthemelumoimports_'] = true;
}

}
