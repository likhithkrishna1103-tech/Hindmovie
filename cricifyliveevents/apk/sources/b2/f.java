package b2;

import android.net.Uri;
import android.util.Base64;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import v1.n0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends c {
    public byte[] A;
    public int B;
    public int C;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public o f1683z;

    @Override // b2.h
    public final long B(o oVar) throws n0, l {
        e();
        this.f1683z = oVar;
        Uri uri = oVar.f1714a;
        long j4 = oVar.f1719g;
        Uri uriNormalizeScheme = uri.normalizeScheme();
        String scheme = uriNormalizeScheme.getScheme();
        y1.d.a("Unsupported scheme: " + scheme, "data".equals(scheme));
        String schemeSpecificPart = uriNormalizeScheme.getSchemeSpecificPart();
        int i = y1.a0.f14551a;
        String[] strArrSplit = schemeSpecificPart.split(",", -1);
        if (strArrSplit.length != 2) {
            throw new n0("Unexpected URI format: " + uriNormalizeScheme, null, true, 0);
        }
        String str = strArrSplit[1];
        if (strArrSplit[0].contains(";base64")) {
            try {
                this.A = Base64.decode(str, 0);
            } catch (IllegalArgumentException e9) {
                throw new n0(q4.a.n("Error while parsing Base64 encoded string: ", str), e9, true, 0);
            }
        } else {
            this.A = URLDecoder.decode(str, StandardCharsets.US_ASCII.name()).getBytes(StandardCharsets.UTF_8);
        }
        long j7 = oVar.f;
        byte[] bArr = this.A;
        if (j7 > bArr.length) {
            this.A = null;
            throw new l(2008);
        }
        int i10 = (int) j7;
        this.B = i10;
        int length = bArr.length - i10;
        this.C = length;
        if (j4 != -1) {
            this.C = (int) Math.min(length, j4);
        }
        f(oVar);
        return j4 != -1 ? j4 : this.C;
    }

    @Override // b2.h
    public final void close() {
        if (this.A != null) {
            this.A = null;
            c();
        }
        this.f1683z = null;
    }

    @Override // v1.h
    public final int read(byte[] bArr, int i, int i10) {
        if (i10 == 0) {
            return 0;
        }
        int i11 = this.C;
        if (i11 == 0) {
            return -1;
        }
        int iMin = Math.min(i10, i11);
        byte[] bArr2 = this.A;
        int i12 = y1.a0.f14551a;
        System.arraycopy(bArr2, this.B, bArr, i, iMin);
        this.B += iMin;
        this.C -= iMin;
        b(iMin);
        return iMin;
    }

    @Override // b2.h
    public final Uri t() {
        o oVar = this.f1683z;
        if (oVar != null) {
            return oVar.f1714a;
        }
        return null;
    }
}
