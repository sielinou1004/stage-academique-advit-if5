

import { environment } from 'src/environments/environment';

export const SERVEUR = `${environment.apiUrl}`;
console.log(SERVEUR)
export const EMPLOYERS = SERVEUR + 'employer';
export const LIST_EMPLOYERS = EMPLOYERS + '/read';
export const ADD_EMPLOYER = EMPLOYERS + '/create';
export const UPDATE_EMPLOYER = EMPLOYERS + '/update';
export const DELETE_EMPLOYER = EMPLOYERS + '/delete';
export const READ_EMPLOYER = EMPLOYERS + '/read';
export const READBYID_EMPLOYER = EMPLOYERS + '/read/{id}';


