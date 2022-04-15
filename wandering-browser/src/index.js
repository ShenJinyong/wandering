// After
import { createRoot } from 'react-dom/client';
import App from './components/bind';

const container = document.getElementById('root');
const root = createRoot(container); // createRoot(container!) if you use TypeScript
root.render(<App/>);
