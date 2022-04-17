// After
import { createRoot } from 'react-dom/client';
import App from './components/props';

const container = document.getElementById('root');
const root = createRoot(container); // createRoot(container!) if you use TypeScript
root.render(<App/>);
