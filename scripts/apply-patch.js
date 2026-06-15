#!/usr/bin/env node

const fs = require('fs');
const path = require('path');

// Parse the JSON payload passed as an argument
const payload = JSON.parse(process.argv[2]);

// Extract files array
const { files } = payload;

if (!Array.isArray(files)) {
  throw new Error('Payload must contain a "files" array');
}

// Apply changes to files
files.forEach(({ path: filePath, content }) => {
  const fullPath = path.join(process.cwd(), filePath);
  const dir = path.dirname(fullPath);
  
  // Create directory if it doesn't exist
  if (!fs.existsSync(dir)) {
    fs.mkdirSync(dir, { recursive: true });
  }
  
  // Write the file
  fs.writeFileSync(fullPath, content, 'utf8');
  console.log(`✓ Updated: ${filePath}`);
});

console.log('All files updated successfully!');
