import axiosClient from './axiosClient';

const UserServices = {
    async getUsers() {
        try {
            const response = await axiosClient.get( process.env.REACT_APP_API_URL+ '/users');
            return response.data;
        } catch (error) {
            throw error;
        }
    },
    async getUser(id) {
        try {
            const response = await axiosClient.get(`/users/${id}`);
            return response.data;
        } catch (error) {
            throw error;
        }
    },
    async createUser(data) {
        try {
            const response = await axiosClient.post('/users', data);
            return response.data;
        } catch (error) {
            throw error;
        }
    },
    async updateUser(id, data) {
        try {
            const response = await axiosClient.put(`/users/${id}`, data);
            return response.data;
        } catch (error) {
            throw error;
        }
    },
    async deleteUser(id) {
        try {
            const response = await axiosClient.delete(`/users/${id}`);
            return response.data;
        } catch (error) {
            throw error;
        }
    }
};

export default UserServices;