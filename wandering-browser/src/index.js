// After
import { createRoot } from 'react-dom/client';
import 'antd/dist/antd.min.css';
import App from './antd-now/menu.js';

const container = document.getElementById('root');
const root = createRoot(container); // createRoot(container!) if you use TypeScript
root.render(<App/>);
