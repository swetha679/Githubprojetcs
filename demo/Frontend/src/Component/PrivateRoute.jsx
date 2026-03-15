import { Navigate } from 'react-router-dom';
import { isLoggedIn } from './authService';

// ─────────────────────────────────────────────
//  Private Route — Protects pages from guests
// ─────────────────────────────────────────────

const PrivateRoute = ({ children }) => {
    return isLoggedIn() ? children : <Navigate to="/login" replace />;
};

export default PrivateRoute;
