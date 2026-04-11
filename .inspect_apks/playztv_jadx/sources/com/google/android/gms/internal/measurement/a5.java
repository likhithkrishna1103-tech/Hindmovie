package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class a5 implements Serializable, Iterable {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a5 f2884w = new a5(l5.f3087b);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final k5 f2885x = new k5(4);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f2886u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final byte[] f2887v;

    public a5(byte[] bArr) {
        bArr.getClass();
        this.f2887v = bArr;
    }

    public static int d(int i, int i10, int i11) {
        int i12 = i10 - i;
        if ((i | i10 | i12 | (i11 - i10)) >= 0) {
            return i12;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(e6.j.j(i, "Beginning index: ", " < 0"));
        }
        if (i10 < i) {
            throw new IndexOutOfBoundsException(l4.a.l(i, i10, "Beginning index larger than ending index: ", ", "));
        }
        throw new IndexOutOfBoundsException(l4.a.l(i10, i11, "End index: ", " >= "));
    }

    public static a5 e(byte[] bArr, int i, int i10) {
        d(i, i + i10, bArr.length);
        f2885x.getClass();
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, i, bArr2, 0, i10);
        return new a5(bArr2);
    }

    public byte b(int i) {
        return this.f2887v[i];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a5) || h() != ((a5) obj).h()) {
            return false;
        }
        if (h() == 0) {
            return true;
        }
        if (!(obj instanceof a5)) {
            return obj.equals(this);
        }
        a5 a5Var = (a5) obj;
        int i = this.f2886u;
        int i10 = a5Var.f2886u;
        if (i != 0 && i10 != 0 && i != i10) {
            return false;
        }
        int iH = h();
        if (iH > a5Var.h()) {
            throw new IllegalArgumentException("Length too large: " + iH + h());
        }
        if (iH > a5Var.h()) {
            throw new IllegalArgumentException(l4.a.l(iH, a5Var.h(), "Ran off end of other: 0, ", ", "));
        }
        byte[] bArr = a5Var.f2887v;
        int i11 = i() + iH;
        int i12 = i();
        int i13 = a5Var.i();
        while (i12 < i11) {
            if (this.f2887v[i12] != bArr[i13]) {
                return false;
            }
            i12++;
            i13++;
        }
        return true;
    }

    public byte f(int i) {
        return this.f2887v[i];
    }

    public int h() {
        return this.f2887v.length;
    }

    public final int hashCode() {
        int i = this.f2886u;
        if (i != 0) {
            return i;
        }
        int iH = h();
        int i10 = i();
        int i11 = iH;
        for (int i12 = i10; i12 < i10 + iH; i12++) {
            i11 = (i11 * 31) + this.f2887v[i12];
        }
        if (i11 == 0) {
            i11 = 1;
        }
        this.f2886u = i11;
        return i11;
    }

    public int i() {
        return 0;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new androidx.datastore.preferences.protobuf.e(this);
    }

    public final String toString() {
        String strM;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iH = h();
        if (h() <= 50) {
            strM = q0.c(this);
        } else {
            int iD = d(0, 47, h());
            strM = e6.j.m(q0.c(iD == 0 ? f2884w : new z4(this.f2887v, i(), iD)), "...");
        }
        StringBuilder sb2 = new StringBuilder("<ByteString@");
        sb2.append(hexString);
        sb2.append(" size=");
        sb2.append(iH);
        sb2.append(" contents=\"");
        return l4.a.o(sb2, strM, "\">");
    }
}
