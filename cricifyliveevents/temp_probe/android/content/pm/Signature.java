package android.content.pm;

import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class Signature {
    private final byte[] value;

    public Signature(String value) {
        this.value = Base64.getDecoder().decode(value);
    }

    public Signature(byte[] value) {
        this.value = value;
    }

    public byte[] toByteArray() {
        System.err.println("Signature.toByteArray()");
        String pem = "-----BEGIN CERTIFICATE-----\n"
            + Base64.getMimeEncoder(64, new byte[] { '\n' }).encodeToString(value)
            + "\n-----END CERTIFICATE-----\n";
        return pem.getBytes(StandardCharsets.US_ASCII);
    }

    public String toCharsString() {
        System.err.println("Signature.toCharsString()");
        StringBuilder sb = new StringBuilder(value.length * 2);
        for (byte b : value) {
            sb.append(Character.forDigit((b >> 4) & 0xF, 16));
            sb.append(Character.forDigit(b & 0xF, 16));
        }
        return sb.toString();
    }
}
