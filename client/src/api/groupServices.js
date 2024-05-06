import axiosClient from './axiosClient';

const GroupServices = {
    async getGroups() {
        try {
        const response = await axiosClient.get(process.env.REACT_APP_API_URL+ '/groups');
        console.log(response);
        return response.data;
        } catch (error) {
        throw error;
        }
    },
    async getGroup(id) {
        try {
        const response = await axiosClient.get(`/groups/${id}`);
        return response.data;
        } catch (error) {
        throw error;
        }
    },
    async createGroup(data) {
        try {
        const response = await axiosClient.post('/groups', data);
        return response.data;
        } catch (error) {
        throw error;
        }
    },
    async updateGroup(id, data) {
        try {
        const response = await axiosClient.put(`/groups/${id}`, data);
        return response.data;
        } catch (error) {
        throw error;
        }
    },
    async deleteGroup(id) {
        try {
        const response = await axiosClient.delete(`/groups/${id}`);
        return response.data;
        } catch (error) {
        throw error;
        }
    }
};

export default GroupServices;