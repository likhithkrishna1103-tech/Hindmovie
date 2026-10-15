/* The workflow generates this catalog from the same inputs as the README.
   Hosted pages use raw GitHub JSON; previews use the local generated snapshot. */
(() => {
  'use strict';

  const section = document.getElementById('plugins');
  if (!section) return;
  const grid = document.getElementById('plugin-grid');
  const controls = document.getElementById('plugin-controls');
  const search = document.getElementById('plugin-search');
  const statusFilter = document.getElementById('plugin-status');
  const categoryFilters = document.getElementById('plugin-categories');
  const feedback = document.getElementById('plugin-feedback');
  const resultCount = document.getElementById('plugin-result-count');
  const overview = document.getElementById('plugin-overview');
  const rawEndpoint = 'https://raw.githubusercontent.com/likhithkrishna1103-tech/Hindmovie/main/docs/api/plugins.json';
  const localEndpoint = new URL('./api/plugins.json', document.baseURI).href;
  const preview = ['localhost', '127.0.0.1', '[::1]'].includes(location.hostname) || location.protocol === 'file:';
  const endpoints = preview ? [localEndpoint] : [rawEndpoint, localEndpoint];
  const statusLabels = { working: 'Working', maintenance: 'Maintenance', issues: 'Reported issues', unknown: 'Unknown' };
  const categoryOrder = ['Anime', 'Movies', 'Series', 'Live TV', 'Other'];
  const languages = { en: 'English', hi: 'Hindi', ja: 'Japanese', ta: 'Tamil', te: 'Telugu', ml: 'Malayalam', kn: 'Kannada', bn: 'Bengali', mr: 'Marathi', pa: 'Punjabi', gu: 'Gujarati', ko: 'Korean' };
  let displayNames;
  try { displayNames = new Intl.DisplayNames(['en'], { type: 'language', fallback: 'none' }); } catch { /* Short code fallback below. */ }
  let plugins = [], category = 'all', loading = false;

  function languageName(code) {
    const lower = code.toLowerCase();
    if (languages[lower]) return languages[lower];
    try { return displayNames?.of(lower) || code.toUpperCase(); } catch { return code.toUpperCase(); }
  }
  function element(tag, className, text) {
    const node = document.createElement(tag);
    if (className) node.className = className;
    if (text !== undefined) node.textContent = text;
    return node;
  }
  function icon(kind) {
    const svg = document.createElementNS('http://www.w3.org/2000/svg', 'svg');
    svg.setAttribute('viewBox', '0 0 24 24');
    svg.setAttribute('class', 'icon');
    svg.setAttribute('aria-hidden', 'true');
    if (kind === 'globe') {
      const circle = document.createElementNS(svg.namespaceURI, 'circle');
      circle.setAttribute('cx', '12'); circle.setAttribute('cy', '12'); circle.setAttribute('r', '9');
      const ellipse = document.createElementNS(svg.namespaceURI, 'ellipse');
      ellipse.setAttribute('cx', '12'); ellipse.setAttribute('cy', '12'); ellipse.setAttribute('rx', '4'); ellipse.setAttribute('ry', '9');
      const path = document.createElementNS(svg.namespaceURI, 'path');
      path.setAttribute('d', 'M3 12h18');
      svg.append(circle, ellipse, path);
    } else {
      const path = document.createElementNS(svg.namespaceURI, 'path');
      path.setAttribute('d', 'm7 10 5 5 5-5');
      svg.append(path);
    }
    return svg;
  }
  function badge(state, label) {
    const node = element('span', `plugin-status status-${state}`);
    node.append(element('span', 'plugin-status-dot'), document.createTextNode(label));
    node.firstChild.setAttribute('aria-hidden', 'true');
    return node;
  }
  function validateCatalog(data) {
    if (data?.schemaVersion !== 1 || !Array.isArray(data.plugins) || !Number.isFinite(Date.parse(data.updatedAt))) throw new Error('Invalid catalog');
    const seen = new Set();
    return data.plugins.map((plugin) => {
      if (typeof plugin.id !== 'string' || !plugin.id || seen.has(plugin.id) || typeof plugin.name !== 'string' || !plugin.name.trim()) throw new Error('Invalid plugin');
      if (!['string', 'number'].includes(typeof plugin.version)) throw new Error('Invalid version');
      if (!Array.isArray(plugin.categories) || !Array.isArray(plugin.languages) || ![...plugin.categories, ...plugin.languages].every((v) => typeof v === 'string')) throw new Error('Invalid metadata');
      if (!Object.hasOwn(statusLabels, plugin.status?.state) || typeof plugin.status.note !== 'string') throw new Error('Invalid status');
      seen.add(plugin.id);
      return {
        ...plugin,
        version: String(plugin.version),
        searchText: [plugin.name, ...plugin.categories, ...plugin.languages, ...plugin.languages.map(languageName), statusLabels[plugin.status.state]].join(' ').toLocaleLowerCase(),
      };
    }).sort((a, b) => a.name.localeCompare(b.name, 'en', { sensitivity: 'base' }));
  }
  function pluginCard(plugin) {
    const card = element('article', 'plugin-card');
    card.dataset.plugin = plugin.id;
    card.dataset.state = plugin.status.state;
    const top = element('div', 'plugin-card-top');
    const words = plugin.name.replace(/[^\p{L}\p{N} ]/gu, ' ').trim().split(/\s+/);
    const initials = words.length > 1 ? words[0][0] + words[1][0] : words[0].slice(0, 2);
    const monogram = element('span', 'plugin-monogram', initials.toUpperCase());
    monogram.setAttribute('aria-hidden', 'true');
    top.append(monogram, badge(plugin.status.state, statusLabels[plugin.status.state]));
    const title = element('div', 'plugin-card-title');
    const heading = element('h3', '', plugin.name);
    heading.id = `plugin-${encodeURIComponent(plugin.id)}`;
    card.setAttribute('aria-labelledby', heading.id);
    const version = element('span', 'plugin-version', `v${plugin.version}`);
    version.setAttribute('aria-label', `Version ${plugin.version}`);
    title.append(heading, version);
    const categories = element('p', 'plugin-category', plugin.categories.join(' · '));
    const languageNames = plugin.languages.map(languageName);
    const languageRow = element('div', 'plugin-language-row');
    languageRow.append(icon('globe'));
    if (languageNames.length > 2) {
      const details = element('details', 'plugin-languages');
      const summary = element('summary');
      summary.append(document.createTextNode(`${languageNames.slice(0, 2).join(' · ')} `), element('span', 'language-more', `+${languageNames.length - 2}`), icon('chevron'));
      summary.setAttribute('aria-label', `${languageNames.length} languages. Show all languages for ${plugin.name}`);
      const list = element('ul', 'language-list');
      languageNames.forEach((name) => list.append(element('li', '', name)));
      details.append(summary, list);
      languageRow.append(details);
    } else {
      languageRow.append(element('span', '', languageNames.join(' · ') || 'Not specified'));
    }
    card.append(top, title, categories, languageRow);
    if (plugin.status.note) {
      const details = element('details', `plugin-note note-${plugin.status.state}`);
      const summary = element('summary');
      summary.append(document.createTextNode('Status note'), icon('chevron'));
      details.append(summary, element('p', '', plugin.status.note));
      card.append(details);
    }
    return card;
  }
  function resetFilters() {
    search.value = '';
    statusFilter.value = 'all';
    category = 'all';
    categoryFilters.querySelectorAll('button').forEach((button) => button.setAttribute('aria-pressed', String(button.dataset.category === 'all')));
    render();
    search.focus();
  }
  function render() {
    const query = search.value.trim().toLocaleLowerCase();
    const visible = plugins.filter((plugin) =>
      (category === 'all' || plugin.categories.includes(category)) &&
      (statusFilter.value === 'all' || plugin.status.state === statusFilter.value) &&
      (!query || plugin.searchText.includes(query))
    );
    const fragment = document.createDocumentFragment();
    visible.forEach((plugin) => fragment.append(pluginCard(plugin)));
    grid.replaceChildren(fragment);
    resultCount.textContent = `${visible.length} ${visible.length === 1 ? 'plugin' : 'plugins'}`;
    feedback.hidden = visible.length > 0;
    if (!visible.length) {
      feedback.replaceChildren(element('p', '', plugins.length ? 'No plugins match your filters.' : 'No plugins have been published yet.'));
      if (plugins.length) {
        const reset = element('button', 'directory-text-button', 'Clear filters');
        reset.type = 'button';
        reset.addEventListener('click', resetFilters);
        feedback.append(reset);
      }
    }
  }
  function renderFilters() {
    const categories = [...new Set(plugins.flatMap((plugin) => plugin.categories))].sort((a, b) => {
      const ai = categoryOrder.includes(a) ? categoryOrder.indexOf(a) : 99;
      const bi = categoryOrder.includes(b) ? categoryOrder.indexOf(b) : 99;
      return ai - bi || a.localeCompare(b);
    });
    categoryFilters.replaceChildren();
    for (const value of ['all', ...categories]) {
      const button = element('button', 'category-filter', value === 'all' ? 'All plugins' : value);
      button.type = 'button';
      button.dataset.category = value;
      button.setAttribute('aria-pressed', String(value === category));
      button.setAttribute('aria-controls', 'plugin-grid');
      button.addEventListener('click', () => {
        category = value;
        categoryFilters.querySelectorAll('button').forEach((item) => item.setAttribute('aria-pressed', String(item === button)));
        render();
      });
      categoryFilters.append(button);
    }
  }
  async function requestCatalog(endpoint) {
    const controller = new AbortController();
    const timer = setTimeout(() => controller.abort(), 7000);
    try {
      const response = await fetch(endpoint, { cache: 'no-cache', signal: controller.signal });
      if (!response.ok) throw new Error(`Catalog returned ${response.status}`);
      const data = await response.json();
      return { data, plugins: validateCatalog(data) };
    } finally { clearTimeout(timer); }
  }
  async function load() {
    if (loading) return;
    loading = true;
    grid.setAttribute('aria-busy', 'true');
    feedback.hidden = false;
    feedback.replaceChildren(element('p', '', 'Loading plugins…'));
    try {
      let result;
      for (const endpoint of endpoints) {
        try { result = await requestCatalog(endpoint); break; } catch { /* Try the published snapshot if GitHub is unavailable. */ }
      }
      if (!result) throw new Error('Catalog unavailable');
      plugins = result.plugins;
      const health = document.getElementById('plugin-health');
      health.replaceChildren();
      for (const [state, label] of Object.entries(statusLabels)) {
        const count = plugins.filter((plugin) => plugin.status.state === state).length;
        if (count) health.append(badge(state, `${count} ${label.toLowerCase()}`));
      }
      const date = new Date(result.data.updatedAt);
      const updated = document.getElementById('plugin-updated');
      updated.dateTime = result.data.updatedAt;
      updated.textContent = new Intl.DateTimeFormat('en', { day: 'numeric', month: 'short', year: 'numeric' }).format(date);
      updated.title = date.toLocaleString();
      overview.hidden = false;
      controls.hidden = false;
      renderFilters();
      render();
    } catch {
      overview.hidden = true;
      controls.hidden = true;
      grid.replaceChildren();
      feedback.replaceChildren(element('p', '', 'Plugin status couldn’t be loaded.'));
      const retry = element('button', 'directory-text-button', 'Try again');
      retry.type = 'button'; retry.addEventListener('click', load);
      const link = element('a', 'directory-text-button', 'View on GitHub');
      link.href = 'https://github.com/likhithkrishna1103-tech/Hindmovie#-plugins-status';
      feedback.append(retry, link);
    } finally {
      loading = false;
      grid.setAttribute('aria-busy', 'false');
    }
  }
  controls.addEventListener('submit', (event) => event.preventDefault());
  search.addEventListener('input', render);
  statusFilter.addEventListener('change', render);
  load();
})();
