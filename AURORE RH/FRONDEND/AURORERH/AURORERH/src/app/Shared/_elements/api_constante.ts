

import { environment } from 'src/environments/environment';

export const SERVEUR = `${environment.apiUrl}`;
export const EMPLOYERS = SERVEUR + 'employer';
export const LIST_EMPLOYERS = EMPLOYERS + '/read';
export const ADD_EMPLOYER = EMPLOYERS + '/create';
export const UPDATE_EMPLOYER = EMPLOYERS + '/update';
export const DELETE_EMPLOYER = EMPLOYERS + '/delete';
export const READ_EMPLOYER = EMPLOYERS + '/read';
export const READBYID_EMPLOYER = EMPLOYERS + '/read';

export const AUTH = SERVEUR + 'auth/login';

export const CONTRATS = SERVEUR + 'contrat';
export const LIST_CONTRATS = CONTRATS + '/read';
export const ADD_CONTRATS = CONTRATS + '/create';
export const UPDATE_CONTRATS = CONTRATS + '/update';
export const DELETE_CONTRATS = CONTRATS + '/delete';
export const READ_CONTRATS = CONTRATS + '/read';
export const READBYID_CONTRATS = CONTRATS + '/read';
