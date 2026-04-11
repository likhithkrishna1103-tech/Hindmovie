package rf;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s {
    public static int a(int i, int i10, int i11) throws IOException {
        if ((i10 & 8) != 0) {
            i--;
        }
        if (i11 <= i) {
            return i - i11;
        }
        throw new IOException(q4.a.m(i11, i, "PROTOCOL_ERROR padding ", " > remaining length "));
    }
}
