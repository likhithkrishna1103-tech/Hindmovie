const crypto = require("crypto");

const USER_AGENT = "Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Mobile Safari/537.36";
const VIDFAST_HEADERS = {
  "Accept": "*/*",
  "Referer": "https://vidfast.pro/",
  "User-Agent": USER_AGENT,
  "X-Csrf-Token": "22Xg4bhHnx4uUolyJWs7rdNBbIzYVz8z",
  "X-Requested-With": "XMLHttpRequest"
};
const VIDFAST_STATIC_PATH = "hezushon/8ee77bc2e110fd6e6ac7659b33c6f9146497cb81b1a2694590a68f22c5b495b9/APA91DQqR0e_8UTJpaNhNS9c2Bgrg21PeT12bVxpsCvoUhB9rNLJgMZMHxO7oigbPWv7eXn4NavycM9jt2EGVHBmkXIeSJUXh2AOEvWyji1iNx4Txr2OZONKK5IjKp8GBmmzCCb6-rh1I0o50c5eLc_cZ6KnwX7TrB_UsqfYsbMwBqhvWBEEZ1Q/bdf45bbf7c054d8a75d7575767e40745f967d0a8";
const VIDFAST_AES_KEY = Buffer.from("50bb6a529bfb4abb1969c1a29c8cac6df1f00ec63a7297c4c06dcc9473cdacc4", "hex");
const VIDFAST_AES_IV = Buffer.from("ffe7765f45669a794181d0b4a8d9e96b", "hex");
const VIDFAST_XOR_SEED_KEY = Buffer.from("1a5d66c3fbf2", "hex");

function customBase64Encode(inputBytes) {
  const sourceChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_";
  const targetChars = "4jrpDdPNYKMiBLgwczuHGksmOIoS2-JVRCnbfl769A0UeE5Qyt_aWq1xTF3vhXZ8";
  const encoded = Buffer.from(inputBytes).toString("base64").replace(/\+/g, "-").replace(/\//g, "_").replace(/=+$/g, "");
  let out = "";
  for (const ch of encoded) {
    const idx = sourceChars.indexOf(ch);
    out += idx === -1 ? ch : targetChars[idx];
  }
  return out;
}

function generateKsa(seedBytes, size) {
  let state =
    (seedBytes.readUInt32LE(0) ^
      seedBytes.readUInt32LE(4) ^
      seedBytes.readUInt32LE(8) ^
      seedBytes.readUInt32LE(12)) >>> 0;
  const box = Array.from({ length: size }, (_, i) => i);
  for (let i = size - 1; i > 0; i--) {
    state ^= (state << 13) >>> 0;
    state ^= state >>> 17;
    state ^= (state << 5) >>> 0;
    state >>>= 0;
    const j = state % (i + 1);
    [box[i], box[j]] = [box[j], box[i]];
  }
  return box;
}

function transformByte(inputByte, keyByte) {
  const r = keyByte % 8;
  const rotated = (((inputByte << r) | (inputByte >>> (8 - r))) & 255) >>> 0;
  return (rotated + (keyByte ^ 0xa5)) & 255;
}

function shuffleBlocks(payload, pbox) {
  const numBlocks = pbox.length;
  const blockSize = payload.length / numBlocks;
  const out = Buffer.alloc(payload.length);
  for (let i = 0; i < numBlocks; i++) {
    const srcBlock = pbox[i];
    payload.copy(out, i * blockSize, srcBlock * blockSize, srcBlock * blockSize + blockSize);
  }
  return out;
}

async function run() {
  const pageRes = await fetch("https://vidfast.pro/movie/24428?autoPlay=false&title=true&poster=true&nextButton=false&autoNext=false&theme=ffffff", {
    headers: VIDFAST_HEADERS
  });
  const html = await pageRes.text();
  let rawData = (html.match(/"en":"([^"]+)"/) || [])[1];
  if (!rawData) {
    const marker = html.indexOf('"en":"');
    if (marker >= 0) {
      const start = marker + 6;
      const end = html.indexOf('"', start);
      rawData = html.slice(start, end);
    }
  }
  console.log("rawData", rawData);

  const randomIv = crypto.randomBytes(16);
  const timestampBytes = Buffer.alloc(8);
  let timestamp = Date.now();
  for (let i = 0; i < 8; i++) {
    timestampBytes[i] = timestamp & 255;
    timestamp = Math.floor(timestamp / 256);
  }

  const combinedInput = Buffer.concat([randomIv, timestampBytes, Buffer.from(rawData)]);
  const pad = 16 - (combinedInput.length % 16 || 16) || 16;
  const padded = Buffer.concat([combinedInput, Buffer.alloc(pad, pad)]);
  const cipher = crypto.createCipheriv("aes-256-cbc", VIDFAST_AES_KEY, VIDFAST_AES_IV);
  cipher.setAutoPadding(false);
  const encrypted = Buffer.concat([cipher.update(padded), cipher.final()]);

  let xorHash = crypto.createHash("sha256").update(Buffer.concat([VIDFAST_XOR_SEED_KEY, randomIv])).digest();
  const xorOutput = Buffer.alloc(encrypted.length);
  for (let i = 0; i < encrypted.length; i++) {
    if (i > 0 && i % xorHash.length === 0) xorHash = crypto.createHash("sha256").update(xorHash).digest();
    xorOutput[i] = encrypted[i] ^ xorHash[i % xorHash.length];
  }

  const transformHash = crypto.createHash("sha256").update(Buffer.concat([VIDFAST_AES_KEY, randomIv])).digest();
  const transformOutput = Buffer.alloc(xorOutput.length);
  for (let i = 0; i < xorOutput.length; i++) {
    transformOutput[i] = transformByte(xorOutput[i], transformHash[i % transformHash.length]);
  }

  const ksaHash = crypto.createHash("sha256").update(Buffer.concat([randomIv, VIDFAST_XOR_SEED_KEY, VIDFAST_AES_IV])).digest();
  const ksa = generateKsa(ksaHash, 256);
  const payloadSwaps = Buffer.alloc(transformOutput.length);
  for (let i = 0; i < transformOutput.length; i++) payloadSwaps[i] = ksa[transformOutput[i] & 255] & 255;

  const permutationCount = payloadSwaps.length / 16;
  const permKsa = generateKsa(crypto.createHash("sha256").update(Buffer.concat([VIDFAST_XOR_SEED_KEY, randomIv])).digest(), permutationCount);
  const shuffled = shuffleBlocks(payloadSwaps, permKsa);
  const permHash = crypto.createHash("sha256").update(Buffer.concat([VIDFAST_AES_KEY, randomIv, Buffer.from([shuffled.length])])).digest();
  const permSBox = generateKsa(permHash, 112);
  const finalPayload = Buffer.alloc(112);
  for (let i = 0; i < 112; i++) finalPayload[i] = shuffled[permSBox[i]];

  const swapOrder = Buffer.alloc(permKsa.length * 4);
  for (let i = 0; i < permKsa.length; i++) swapOrder[i * 4] = permKsa[i];

  const finalBuffer = Buffer.concat([swapOrder, finalPayload]);
  const footer = crypto.createHash("sha256").update(finalBuffer).digest().subarray(0, 8);
  const finalPacket = Buffer.concat([Buffer.from([1]), randomIv, Buffer.from([permutationCount, 0]), finalBuffer, footer]);
  const serversToken = Buffer.from(customBase64Encode(finalPacket)).reverse().toString("hex");
  const serversUrl = `https://vidfast.pro/${VIDFAST_STATIC_PATH}/N1dm4OEpPc8/${serversToken}`;
  console.log("serversUrl", serversUrl);

  const serversRes = await fetch(serversUrl, { headers: VIDFAST_HEADERS });
  const serversText = await serversRes.text();
  console.log("servers status", serversRes.status);
  console.log("servers body", serversText);
}

run().catch((error) => {
  console.error(error);
  process.exit(1);
});
