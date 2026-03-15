import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { login } from '../services/authService';

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError]       = useState('');
    const [loading, setLoading]   = useState(false);
    const navigate = useNavigate();


    const handleLogin = async (e) => {
        e.preventDefault();
        setError('');
        setLoading(true);

        try {
            await login(username, password);
            navigate('/dashboard'); 
        } catch (err) {
            setError(
                err.response?.data?.message ||
                'Invalid username or password. Please try again.'
            );
        } finally {
            setLoading(false);
        }
    };


    return (
        <div style={styles.page}>
            <div style={styles.card}>

                {/* Header */}
                <div style={styles.header}>
                    <div style={styles.logo}>🎓</div>
                    <h1 style={styles.title}>Student Portal</h1>
                    <p style={styles.subtitle}>Sign in to your account</p>
                </div>

               
                {error && (
                    <div style={styles.errorBox}>
                        ⚠️ {error}
                    </div>
                )}

              
                <form onSubmit={handleLogin} style={styles.form}>

                    <div style={styles.field}>
                        <label style={styles.label}>Username</label>
                        <input
                            type="text"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                            placeholder="Enter your username"
                            style={styles.input}
                            required
                        />
                    </div>

                    <div style={styles.field}>
                        <label style={styles.label}>Password</label>
                        <input
                            type="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            placeholder="Enter your password"
                            style={styles.input}
                            required
                        />
                    </div>

                    <button
                        type="submit"
                        style={loading ? styles.buttonDisabled : styles.button}
                        disabled={loading}
                    >
                        {loading ? 'Signing in...' : 'Sign In'}
                    </button>

                </form>
            </div>
        </div>
    );
};


const styles = {
    page: {
        minHeight: '100vh',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        background: 'linear-gradient(135deg, #1e3a5f 0%, #2d6a9f 100%)',
        fontFamily: "'Segoe UI', sans-serif",
    },
    card: {
        background: '#fff',
        borderRadius: '16px',
        padding: '40px',
        width: '100%',
        maxWidth: '420px',
        boxShadow: '0 20px 60px rgba(0,0,0,0.2)',
    },
    header: {
        textAlign: 'center',
        marginBottom: '32px',
    },
    logo: {
        fontSize: '48px',
        marginBottom: '12px',
    },
    title: {
        fontSize: '26px',
        fontWeight: '700',
        color: '#1e3a5f',
        margin: '0 0 6px',
    },
    subtitle: {
        fontSize: '14px',
        color: '#888',
        margin: 0,
    },
    errorBox: {
        background: '#fff0f0',
        border: '1px solid #ffcccc',
        color: '#cc0000',
        borderRadius: '8px',
        padding: '12px 16px',
        marginBottom: '20px',
        fontSize: '14px',
    },
    form: {
        display: 'flex',
        flexDirection: 'column',
        gap: '20px',
    },
    field: {
        display: 'flex',
        flexDirection: 'column',
        gap: '6px',
    },
    label: {
        fontSize: '14px',
        fontWeight: '600',
        color: '#333',
    },
    input: {
        padding: '12px 16px',
        borderRadius: '8px',
        border: '1.5px solid #ddd',
        fontSize: '15px',
        outline: 'none',
        transition: 'border-color 0.2s',
    },
    button: {
        padding: '14px',
        background: 'linear-gradient(135deg, #1e3a5f, #2d6a9f)',
        color: '#fff',
        border: 'none',
        borderRadius: '8px',
        fontSize: '16px',
        fontWeight: '600',
        cursor: 'pointer',
        marginTop: '8px',
    },
    buttonDisabled: {
        padding: '14px',
        background: '#aaa',
        color: '#fff',
        border: 'none',
        borderRadius: '8px',
        fontSize: '16px',
        fontWeight: '600',
        cursor: 'not-allowed',
        marginTop: '8px',
    },
};

export default Login;