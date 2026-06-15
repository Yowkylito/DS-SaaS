const fs = require("fs");
const path = require("path");

// Get JSON from GitHub Action input
const payload = JSON.parse(process.argv[2]);

if (!payload.files) {
  console.error("No files provided");
  process.exit(1);
}

for (const file of payload.files) {
  const filePath = path.join(process.cwd(), file.path);

  // Ensure folder exists
  fs.mkdirSync(path.dirname(filePath), { recursive: true });

  // Write file content
  fs.writeFileSync(filePath, file.content, "utf8");

  console.log(`Wrote: ${file.path}`);
}
