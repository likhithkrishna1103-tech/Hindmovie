package i3;

import e6.j;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import p1.i0;
import p1.k0;
import p1.m0;
import p1.q;
import s1.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f6204e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f6205g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f6206h;

    public a(int i, String str, String str2, int i10, int i11, int i12, int i13, byte[] bArr) {
        this.f6200a = i;
        this.f6201b = str;
        this.f6202c = str2;
        this.f6203d = i10;
        this.f6204e = i11;
        this.f = i12;
        this.f6205g = i13;
        this.f6206h = bArr;
    }

    public static a d(u uVar) {
        int iJ = uVar.j();
        String strP = m0.p(uVar.v(uVar.j(), StandardCharsets.US_ASCII));
        String strV = uVar.v(uVar.j(), StandardCharsets.UTF_8);
        int iJ2 = uVar.j();
        int iJ3 = uVar.j();
        int iJ4 = uVar.j();
        int iJ5 = uVar.j();
        int iJ6 = uVar.j();
        byte[] bArr = new byte[iJ6];
        uVar.h(bArr, 0, iJ6);
        return new a(iJ, strP, strV, iJ2, iJ3, iJ4, iJ5, bArr);
    }

    @Override // p1.k0
    public final void a(i0 i0Var) {
        i0Var.a(this.f6200a, this.f6206h);
    }

    @Override // p1.k0
    public final /* synthetic */ q b() {
        return null;
    }

    @Override // p1.k0
    public final /* synthetic */ byte[] c() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f6200a == aVar.f6200a && this.f6201b.equals(aVar.f6201b) && this.f6202c.equals(aVar.f6202c) && this.f6203d == aVar.f6203d && this.f6204e == aVar.f6204e && this.f == aVar.f && this.f6205g == aVar.f6205g && Arrays.equals(this.f6206h, aVar.f6206h)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f6206h) + ((((((((j.h(j.h((527 + this.f6200a) * 31, 31, this.f6201b), 31, this.f6202c) + this.f6203d) * 31) + this.f6204e) * 31) + this.f) * 31) + this.f6205g) * 31);
    }

    public final String toString() {
        return "Picture: mimeType=" + this.f6201b + ", description=" + this.f6202c;
    }
}
