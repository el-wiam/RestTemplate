import axios from 'axios';

const BASE_URL = 'http://localhost:8888'; 
// Clients API
export const getClients = () => axios.get(`${BASE_URL}/SERVICE-CLIENT/clients`);
export const getClientById = (id) => axios.get(`${BASE_URL}/SERVICE-CLIENT/clients/${id}`);
export const addClient = (client) => axios.post(`${BASE_URL}/SERVICE-CLIENT/clients`, client);
export const updateClient = (id, client) =>
    axios.put(`${BASE_URL}/SERVICE-CLIENT/clients/${id}`, client);
export const deleteClient = (id) => axios.delete(`${BASE_URL}/SERVICE-CLIENT/clients/${id}`);

// Voitures API
export const getVoitures = () => axios.get(`${BASE_URL}/SERVICE-VOITURE/voitures`);
export const getVoitureById = (id) => axios.get(`${BASE_URL}/SERVICE-VOITURE/voitures/${id}`);
export const getVoituresByClientId = (clientId) =>
    axios.get(`${BASE_URL}/SERVICE-VOITURE/voitures/search/findVoituresByClient_id?clientId=${clientId}`); // Updated to use BASE_URL
export const addVoiture = (clientId, voiture) => {
    const url = clientId
        ? `${BASE_URL}/SERVICE-VOITURE/voitures?clientId=${clientId}`
        : `${BASE_URL}/SERVICE-VOITURE/voitures`;
    return axios.post(url, voiture);

};

export const deleteVoiture = (id) => axios.delete(`${BASE_URL}/SERVICE-VOITURE/voitures/${id}`);
export const updateVoiture = (id, voiture) =>
    axios.put(`${BASE_URL}/SERVICE-VOITURE/voitures/${id}`, voiture);
