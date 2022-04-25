// After
import { createRoot } from 'react-dom/client';
import App from './router/App.js';

const container = document.getElementById('root');
const root = createRoot(container); // createRoot(container!) if you use TypeScript
root.render(<App/>);
