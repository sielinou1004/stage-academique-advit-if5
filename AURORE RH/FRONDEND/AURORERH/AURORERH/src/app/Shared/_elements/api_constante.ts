

import { environment } from 'src/environments/environment';

export const SERVEUR = `${environment.apiUrl}/`

export const EMPLOYER = SERVEUR + 'employer'
export const ADD_EMPLOYER = EMPLOYER + '/create'
export const UPDATE_EMPLOYER = EMPLOYER + '/update'
export const DELETE_EMPLOYER = EMPLOYER + '/delete'
export const READ_EMPLOYER = EMPLOYER + '/read'
export const READBYID_EMPLOYER = EMPLOYER + '/read/{id}'


