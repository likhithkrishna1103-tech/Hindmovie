package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class a5 implements Iterable, Serializable {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a5 f2316x = new a5(p5.f2571b);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2317v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final byte[] f2318w;

    static {
        int i = w4.f2707a;
    }

    public a5(byte[] bArr) {
        bArr.getClass();
        this.f2318w = bArr;
    }

    public static a5 d(byte[] bArr, int i, int i10) {
        f(i, i + i10, bArr.length);
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, i, bArr2, 0, i10);
        return new a5(bArr2);
    }

    public static int f(int i, int i10, int i11) {
        int i12 = i10 - i;
        if ((i | i10 | i12 | (i11 - i10)) >= 0) {
            return i12;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i10 < i) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i).length() + 44 + String.valueOf(i10).length());
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i10);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(String.valueOf(i10).length() + 15 + String.valueOf(i11).length());
        sb3.append("End index: ");
        sb3.append(i10);
        sb3.append(" >= ");
        sb3.append(i11);
        throw new IndexOutOfBoundsException(sb3.toString());
    }

    public byte a(int i) {
        return this.f2318w[i];
    }

    public byte b(int i) {
        return this.f2318w[i];
    }

    public int c() {
        return this.f2318w.length;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof a5) && c() == ((a5) obj).c()) {
            if (c() == 0) {
                return true;
            }
            if (!(obj instanceof a5)) {
                return obj.equals(this);
            }
            a5 a5Var = (a5) obj;
            int i = this.f2317v;
            int i10 = a5Var.f2317v;
            if (i == 0 || i10 == 0 || i == i10) {
                int iC = c();
                if (iC > a5Var.c()) {
                    int iC2 = c();
                    StringBuilder sb = new StringBuilder(String.valueOf(iC).length() + 18 + String.valueOf(iC2).length());
                    sb.append("Length too large: ");
                    sb.append(iC);
                    sb.append(iC2);
                    throw new IllegalArgumentException(sb.toString());
                }
                if (iC <= a5Var.c()) {
                    byte[] bArr = a5Var.f2318w;
                    int i11 = 0;
                    int i12 = 0;
                    while (i11 < iC) {
                        if (this.f2318w[i11] == bArr[i12]) {
                            i11++;
                            i12++;
                        }
                    }
                    return true;
                }
                int iC3 = a5Var.c();
                StringBuilder sb2 = new StringBuilder(String.valueOf(iC).length() + 27 + String.valueOf(iC3).length());
                sb2.append("Ran off end of other: 0, ");
                sb2.append(iC);
                sb2.append(", ");
                sb2.append(iC3);
                throw new IllegalArgumentException(sb2.toString());
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f2317v;
        if (i != 0) {
            return i;
        }
        int iC = c();
        int i10 = iC;
        for (int i11 = 0; i11 < iC; i11++) {
            i10 = (i10 * 31) + this.f2318w[i11];
        }
        if (i10 == 0) {
            i10 = 1;
        }
        this.f2317v = i10;
        return i10;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new androidx.datastore.preferences.protobuf.d(this);
    }

    public final String toString() {
        String strConcat;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iC = c();
        if (c() <= 50) {
            strConcat = w4.v.y(this);
        } else {
            int iF = f(0, 47, c());
            strConcat = w4.v.y(iF == 0 ? f2316x : new z4(iF, this.f2318w)).concat("...");
        }
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(iC);
        sb.append(" contents=\"");
        return q4.a.q(sb, strConcat, "\">");
    }
}
