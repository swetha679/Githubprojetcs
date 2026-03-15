import axios from 'axios';

const API_URL = 'http://localhost:8080/api/auth';



export const login = async (username, password) => {
    const response = await axios.post(`${API_URL}/login`, { username, password });
    if (response.data.token) {
        localStorage.setItem('token', response.data.token);
        localStorage.setItem('username', response.data.username);
    }
    return response.data;
};


export const logout = () => {
    localStorage.removeItem('token');
    localStorage.removeItem('username');
};


export const getToken = () => localStorage.getItem('token');



export const getUsername = () => localStorage.getItem('username');


export const isLoggedIn = () => !!localStorage.getItem('token');
