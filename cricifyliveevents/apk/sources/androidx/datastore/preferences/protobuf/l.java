package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends w4.v {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Logger f738n = Logger.getLogger(l.class.getName());

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final boolean f739o = h1.f720e;
    public e0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final byte[] f740j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f741k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f742l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d1.n1 f743m;

    public l(d1.n1 n1Var, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        int iMax = Math.max(i, 20);
        this.f740j = new byte[iMax];
        this.f741k = iMax;
        this.f743m = n1Var;
    }

    public static int E(int i, g gVar) {
        int iG = G(i);
        int size = gVar.size();
        return H(size) + size + iG;
    }

    public static int F(String str) {
        int length;
        try {
            length = k1.a(str);
        } catch (j1 unused) {
            length = str.getBytes(x.f808a).length;
        }
        return H(length) + length;
    }

    public static int G(int i) {
        return H(i << 3);
    }

    public static int H(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int I(long j4) {
        return (640 - (Long.numberOfLeadingZeros(j4) * 9)) >>> 6;
    }

    public final void A(long j4) {
        int i = this.f742l;
        int i10 = i + 1;
        this.f742l = i10;
        byte[] bArr = this.f740j;
        bArr[i] = (byte) (j4 & 255);
        int i11 = i + 2;
        this.f742l = i11;
        bArr[i10] = (byte) ((j4 >> 8) & 255);
        int i12 = i + 3;
        this.f742l = i12;
        bArr[i11] = (byte) ((j4 >> 16) & 255);
        int i13 = i + 4;
        this.f742l = i13;
        bArr[i12] = (byte) (255 & (j4 >> 24));
        int i14 = i + 5;
        this.f742l = i14;
        bArr[i13] = (byte) (((int) (j4 >> 32)) & 255);
        int i15 = i + 6;
        this.f742l = i15;
        bArr[i14] = (byte) (((int) (j4 >> 40)) & 255);
        int i16 = i + 7;
        this.f742l = i16;
        bArr[i15] = (byte) (((int) (j4 >> 48)) & 255);
        this.f742l = i + 8;
        bArr[i16] = (byte) (((int) (j4 >> 56)) & 255);
    }

    public final void B(int i, int i10) {
        C((i << 3) | i10);
    }

    public final void C(int i) {
        boolean z10 = f739o;
        byte[] bArr = this.f740j;
        if (z10) {
            while ((i & (-128)) != 0) {
                int i10 = this.f742l;
                this.f742l = i10 + 1;
                h1.j(bArr, i10, (byte) ((i | 128) & 255));
                i >>>= 7;
            }
            int i11 = this.f742l;
            this.f742l = i11 + 1;
            h1.j(bArr, i11, (byte) i);
            return;
        }
        while ((i & (-128)) != 0) {
            int i12 = this.f742l;
            this.f742l = i12 + 1;
            bArr[i12] = (byte) ((i | 128) & 255);
            i >>>= 7;
        }
        int i13 = this.f742l;
        this.f742l = i13 + 1;
        bArr[i13] = (byte) i;
    }

    public final void D(long j4) {
        boolean z10 = f739o;
        byte[] bArr = this.f740j;
        if (z10) {
            while ((j4 & (-128)) != 0) {
                int i = this.f742l;
                this.f742l = i + 1;
                h1.j(bArr, i, (byte) ((((int) j4) | 128) & 255));
                j4 >>>= 7;
            }
            int i10 = this.f742l;
            this.f742l = i10 + 1;
            h1.j(bArr, i10, (byte) j4);
            return;
        }
        while ((j4 & (-128)) != 0) {
            int i11 = this.f742l;
            this.f742l = i11 + 1;
            bArr[i11] = (byte) ((((int) j4) | 128) & 255);
            j4 >>>= 7;
        }
        int i12 = this.f742l;
        this.f742l = i12 + 1;
        bArr[i12] = (byte) j4;
    }

    public final void J() throws IOException {
        this.f743m.write(this.f740j, 0, this.f742l);
        this.f742l = 0;
    }

    public final void K(int i) throws IOException {
        if (this.f741k - this.f742l < i) {
            J();
        }
    }

    public final void L(byte b8) throws IOException {
        if (this.f742l == this.f741k) {
            J();
        }
        int i = this.f742l;
        this.f742l = i + 1;
        this.f740j[i] = b8;
    }

    public final void M(byte[] bArr, int i, int i10) throws IOException {
        int i11 = this.f742l;
        int i12 = this.f741k;
        int i13 = i12 - i11;
        byte[] bArr2 = this.f740j;
        if (i13 >= i10) {
            System.arraycopy(bArr, i, bArr2, i11, i10);
            this.f742l += i10;
            return;
        }
        System.arraycopy(bArr, i, bArr2, i11, i13);
        int i14 = i + i13;
        int i15 = i10 - i13;
        this.f742l = i12;
        J();
        if (i15 > i12) {
            this.f743m.write(bArr, i14, i15);
        } else {
            System.arraycopy(bArr, i14, bArr2, 0, i15);
            this.f742l = i15;
        }
    }

    public final void N(int i, boolean z10) throws IOException {
        K(11);
        B(i, 0);
        byte b8 = z10 ? (byte) 1 : (byte) 0;
        int i10 = this.f742l;
        this.f742l = i10 + 1;
        this.f740j[i10] = b8;
    }

    public final void O(int i, g gVar) {
        Z(i, 2);
        P(gVar);
    }

    public final void P(g gVar) throws IOException {
        b0(gVar.size());
        x(gVar.f706w, gVar.f(), gVar.size());
    }

    public final void Q(int i, int i10) {
        K(14);
        B(i, 5);
        z(i10);
    }

    public final void R(int i) throws IOException {
        K(4);
        z(i);
    }

    public final void S(int i, long j4) {
        K(18);
        B(i, 1);
        A(j4);
    }

    public final void T(long j4) throws IOException {
        K(8);
        A(j4);
    }

    public final void U(int i, int i10) throws IOException {
        K(20);
        B(i, 0);
        if (i10 >= 0) {
            C(i10);
        } else {
            D(i10);
        }
    }

    public final void V(int i) throws IOException {
        if (i >= 0) {
            b0(i);
        } else {
            d0(i);
        }
    }

    public final void W(int i, a aVar, u0 u0Var) throws IOException {
        Z(i, 2);
        b0(aVar.a(u0Var));
        u0Var.b(aVar, this.i);
    }

    public final void X(int i, String str) throws IOException {
        Z(i, 2);
        Y(str);
    }

    public final void Y(String str) throws IOException {
        try {
            int length = str.length() * 3;
            int iH = H(length);
            int i = iH + length;
            int i10 = this.f741k;
            if (i > i10) {
                byte[] bArr = new byte[length];
                int i11 = k1.f737a.i(str, bArr, 0, length);
                b0(i11);
                M(bArr, 0, i11);
                return;
            }
            if (i > i10 - this.f742l) {
                J();
            }
            int iH2 = H(str.length());
            int i12 = this.f742l;
            byte[] bArr2 = this.f740j;
            try {
                if (iH2 == iH) {
                    int i13 = i12 + iH2;
                    this.f742l = i13;
                    int i14 = k1.f737a.i(str, bArr2, i13, i10 - i13);
                    this.f742l = i12;
                    C((i14 - i12) - iH2);
                    this.f742l = i14;
                } else {
                    int iA = k1.a(str);
                    C(iA);
                    this.f742l = k1.f737a.i(str, bArr2, this.f742l, iA);
                }
            } catch (j1 e9) {
                this.f742l = i12;
                throw e9;
            } catch (ArrayIndexOutOfBoundsException e10) {
                throw new a2.a(e10);
            }
        } catch (j1 e11) {
            f738n.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e11);
            byte[] bytes = str.getBytes(x.f808a);
            try {
                b0(bytes.length);
                x(bytes, 0, bytes.length);
            } catch (IndexOutOfBoundsException e12) {
                throw new a2.a(e12);
            }
        }
    }

    public final void Z(int i, int i10) {
        b0((i << 3) | i10);
    }

    public final void a0(int i, int i10) throws IOException {
        K(20);
        B(i, 0);
        C(i10);
    }

    public final void b0(int i) throws IOException {
        K(5);
        C(i);
    }

    public final void c0(int i, long j4) {
        K(20);
        B(i, 0);
        D(j4);
    }

    public final void d0(long j4) throws IOException {
        K(10);
        D(j4);
    }

    @Override // w4.v
    public final void x(byte[] bArr, int i, int i10) throws IOException {
        M(bArr, i, i10);
    }

    public final void z(int i) {
        int i10 = this.f742l;
        int i11 = i10 + 1;
        this.f742l = i11;
        byte[] bArr = this.f740j;
        bArr[i10] = (byte) (i & 255);
        int i12 = i10 + 2;
        this.f742l = i12;
        bArr[i11] = (byte) ((i >> 8) & 255);
        int i13 = i10 + 3;
        this.f742l = i13;
        bArr[i12] = (byte) ((i >> 16) & 255);
        this.f742l = i10 + 4;
        bArr[i13] = (byte) ((i >> 24) & 255);
    }
}
