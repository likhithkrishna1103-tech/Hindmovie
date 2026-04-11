package bf;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class r {
    public static int a(int i, int i10, int i11) throws IOException {
        if ((i10 & 8) != 0) {
            i--;
        }
        if (i11 <= i) {
            return i - i11;
        }
        throw new IOException(l4.a.l(i11, i, "PROTOCOL_ERROR padding ", " > remaining length "));
    }
}
