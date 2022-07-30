import Keycloak from 'keycloak-js';

// Setup Keycloak instance as needed
// Pass initialization options as required or leave blank to load from 'keycloak.json'
export const keycloak = new Keycloak({
  url: 'http://localhost:8088/auth',
  realm: 'Karbasha',
  clientId: 'karbasha-rescue-frontend',
});