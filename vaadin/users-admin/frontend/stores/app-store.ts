import { RouterLocation } from '@vaadin/router';
import User from 'Frontend/generated/local/example/users/data/entity/User';
import Role from 'Frontend/generated/local/example/users/data/Role';
import { UserEndpoint } from 'Frontend/generated/UserEndpoint';
import { makeAutoObservable } from 'mobx';

export class AppStore {
  applicationName = 'users-admin';
  // TODO
}
export const appStore = new AppStore();
