package v1;

import android.net.Uri;
import android.util.Base64;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import p1.n0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends c {
    public int A;
    public int B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public m f13135y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public byte[] f13136z;

    @Override // v1.h
    public final void close() {
        if (this.f13136z != null) {
            this.f13136z = null;
            c();
        }
        this.f13135y = null;
    }

    @Override // v1.h
    public final long h(m mVar) throws j, n0 {
        d();
        this.f13135y = mVar;
        Uri uri = mVar.f13157a;
        long j5 = mVar.f13162g;
        Uri uriNormalizeScheme = uri.normalizeScheme();
        String scheme = uriNormalizeScheme.getScheme();
        s1.d.a("Unsupported scheme: " + scheme, "data".equals(scheme));
        String schemeSpecificPart = uriNormalizeScheme.getSchemeSpecificPart();
        int i = s1.b0.f11647a;
        String[] strArrSplit = schemeSpecificPart.split(",", -1);
        if (strArrSplit.length != 2) {
            throw new n0("Unexpected URI format: " + uriNormalizeScheme, null, true, 0);
        }
        String str = strArrSplit[1];
        if (strArrSplit[0].contains(";base64")) {
            try {
                this.f13136z = Base64.decode(str, 0);
            } catch (IllegalArgumentException e10) {
                throw new n0(l4.a.m("Error while parsing Base64 encoded string: ", str), e10, true, 0);
            }
        } else {
            this.f13136z = URLDecoder.decode(str, StandardCharsets.US_ASCII.name()).getBytes(StandardCharsets.UTF_8);
        }
        long j8 = mVar.f;
        byte[] bArr = this.f13136z;
        if (j8 > bArr.length) {
            this.f13136z = null;
            throw new j(2008);
        }
        int i10 = (int) j8;
        this.A = i10;
        int length = bArr.length - i10;
        this.B = length;
        if (j5 != -1) {
            this.B = (int) Math.min(length, j5);
        }
        e(mVar);
        return j5 != -1 ? j5 : this.B;
    }

    @Override // v1.h
    public final Uri o() {
        m mVar = this.f13135y;
        if (mVar != null) {
            return mVar.f13157a;
        }
        return null;
    }

    @Override // p1.i
    public final int read(byte[] bArr, int i, int i10) {
        if (i10 == 0) {
            return 0;
        }
        int i11 = this.B;
        if (i11 == 0) {
            return -1;
        }
        int iMin = Math.min(i10, i11);
        byte[] bArr2 = this.f13136z;
        int i12 = s1.b0.f11647a;
        System.arraycopy(bArr2, this.A, bArr, i, iMin);
        this.A += iMin;
        this.B -= iMin;
        b(iMin);
        return iMin;
    }
}
