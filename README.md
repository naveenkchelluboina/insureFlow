# **InsureFlow**

### **Overview**
**InsureFlow** is a full-stack web application designed to manage **users, financial accounts, insurance policies**, and their associated transactions. The application provides a centralized platform for managing data efficiently, conducting risk assessments, and generating insights, making it ideal for insurance and financial services.

---

### **Features**
1. **Dashboard**:
   - Provides an overview of total users, accounts, policies, and transactions.
   - Displays recent activities and quick navigation links to other sections.

2. **Users**:
   - Manage users with roles (e.g., Admin, User).
   - Create, read, and fetch individual user details based on email or ID.

3. **Accounts**:
   - Create financial accounts for users.
   - View all accounts or filter accounts by user ID.

4. **Policies**:
   - Manage insurance policies linked to accounts.
   - Perform **risk assessments** based on premium amounts and renewal dates.
   - Fetch policies for specific users or all policies.

5. **Transactions**:
   - Log transactions associated with accounts.
   - Fetch transaction history for specific accounts.

6. **Risk Assessment**:
   - Calculates a **risk score** for insurance policies based on premium amounts and upcoming renewal dates.

---

### **Technologies Used**

#### **Backend**:
- **Spring Boot**: RESTful API development.
- **PostgreSQL**: Relational database for secure and scalable data management.
- **Hibernate**: ORM for database interaction.
- **Maven**: Dependency management and project build tool.
- **Deployed on Railway**: Fast and scalable backend hosting.

#### **Frontend**:
- **React**: Dynamic, component-based UI development.
- **Tailwind CSS**: Modern, responsive design framework.
- **Axios**: API integration and data fetching.
- **To be deployed on Netlify**: Frontend hosting for seamless integration.

#### **Other Tools**:
- **GitHub**: Version control and collaboration.
- **Postman**: API testing and debugging.

---

### **API Endpoints**

#### **User APIs**
- `POST /api/users`: Create a new user.
- `GET /api/users`: Fetch all users or filter by `email`.
- `GET /api/users/{userId}/dashboard`: Get dashboard data (accounts, policies, transactions) for a user.

#### **Account APIs**
- `POST /api/accounts`: Create a new account.
- `GET /api/accounts`: Fetch all accounts or filter by `userId`.

#### **Policy APIs**
- `POST /api/policies`: Create a new policy.
- `GET /api/policies`: Fetch all policies or filter by `userId`.
- `POST /api/policies/{policyId}/risk-assessment`: Assess risk for a policy.

#### **Transaction APIs**
- `POST /api/transactions`: Create a new transaction.
- `GET /api/transactions`: Fetch all transactions or filter by `accountId`.

---

### **Installation Instructions**

#### **Backend Setup**
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo-name/insureflow.git
   cd insureflow/backend
