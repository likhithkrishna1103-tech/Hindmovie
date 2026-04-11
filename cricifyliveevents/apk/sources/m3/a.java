package m3;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import l0.e;
import v1.i0;
import v1.k0;
import v1.m0;
import v1.p;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8154e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f8155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f8156h;

    public a(int i, String str, String str2, int i10, int i11, int i12, int i13, byte[] bArr) {
        this.f8150a = i;
        this.f8151b = str;
        this.f8152c = str2;
        this.f8153d = i10;
        this.f8154e = i11;
        this.f = i12;
        this.f8155g = i13;
        this.f8156h = bArr;
    }

    public static a d(t tVar) {
        int iJ = tVar.j();
        String strP = m0.p(tVar.v(tVar.j(), StandardCharsets.US_ASCII));
        String strV = tVar.v(tVar.j(), StandardCharsets.UTF_8);
        int iJ2 = tVar.j();
        int iJ3 = tVar.j();
        int iJ4 = tVar.j();
        int iJ5 = tVar.j();
        int iJ6 = tVar.j();
        byte[] bArr = new byte[iJ6];
        tVar.h(bArr, 0, iJ6);
        return new a(iJ, strP, strV, iJ2, iJ3, iJ4, iJ5, bArr);
    }

    @Override // v1.k0
    public final /* synthetic */ p a() {
        return null;
    }

    @Override // v1.k0
    public final /* synthetic */ byte[] b() {
        return null;
    }

    @Override // v1.k0
    public final void c(i0 i0Var) {
        i0Var.a(this.f8150a, this.f8156h);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f8150a == aVar.f8150a && this.f8151b.equals(aVar.f8151b) && this.f8152c.equals(aVar.f8152c) && this.f8153d == aVar.f8153d && this.f8154e == aVar.f8154e && this.f == aVar.f && this.f8155g == aVar.f8155g && Arrays.equals(this.f8156h, aVar.f8156h)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f8156h) + ((((((((e.e(e.e((527 + this.f8150a) * 31, 31, this.f8151b), 31, this.f8152c) + this.f8153d) * 31) + this.f8154e) * 31) + this.f) * 31) + this.f8155g) * 31);
    }

    public final String toString() {
        return "Picture: mimeType=" + this.f8151b + ", description=" + this.f8152c;
    }
}
