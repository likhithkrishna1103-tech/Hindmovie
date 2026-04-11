package androidx.datastore.preferences.protobuf;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends r0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Logger f1076h = Logger.getLogger(k.class.getName());
    public static final boolean i = s1.f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k0 f1077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f1078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1079e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final z0.m f1080g;

    public k(z0.m mVar, int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        int iMax = Math.max(i10, 20);
        this.f1078d = new byte[iMax];
        this.f1079e = iMax;
        this.f1080g = mVar;
    }

    public static int A(long j5) {
        int i10;
        if (((-128) & j5) == 0) {
            return 1;
        }
        if (j5 < 0) {
            return 10;
        }
        if (((-34359738368L) & j5) != 0) {
            j5 >>>= 28;
            i10 = 6;
        } else {
            i10 = 2;
        }
        if (((-2097152) & j5) != 0) {
            i10 += 2;
            j5 >>>= 14;
        }
        return (j5 & (-16384)) != 0 ? i10 + 1 : i10;
    }

    public static int r(int i10, g gVar) {
        return s(gVar) + y(i10);
    }

    public static int s(g gVar) {
        int size = gVar.size();
        return z(size) + size;
    }

    public static int t(int i10) {
        return y(i10) + 4;
    }

    public static int u(int i10) {
        return y(i10) + 8;
    }

    public static int v(int i10, a aVar, b1 b1Var) {
        return aVar.b(b1Var) + (y(i10) * 2);
    }

    public static int w(int i10) {
        if (i10 >= 0) {
            return z(i10);
        }
        return 10;
    }

    public static int x(String str) {
        int length;
        try {
            length = v1.b(str);
        } catch (u1 unused) {
            length = str.getBytes(z.f1147a).length;
        }
        return z(length) + length;
    }

    public static int y(int i10) {
        return z(i10 << 3);
    }

    public static int z(int i10) {
        if ((i10 & (-128)) == 0) {
            return 1;
        }
        if ((i10 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i10) == 0) {
            return 3;
        }
        return (i10 & (-268435456)) == 0 ? 4 : 5;
    }

    public final void B() throws IOException {
        this.f1080g.write(this.f1078d, 0, this.f);
        this.f = 0;
    }

    public final void C(int i10) throws IOException {
        if (this.f1079e - this.f < i10) {
            B();
        }
    }

    public final void D(byte b10) throws IOException {
        if (this.f == this.f1079e) {
            B();
        }
        int i10 = this.f;
        this.f = i10 + 1;
        this.f1078d[i10] = b10;
    }

    public final void E(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = this.f;
        int i13 = this.f1079e;
        int i14 = i13 - i12;
        byte[] bArr2 = this.f1078d;
        if (i14 >= i11) {
            System.arraycopy(bArr, i10, bArr2, i12, i11);
            this.f += i11;
            return;
        }
        System.arraycopy(bArr, i10, bArr2, i12, i14);
        int i15 = i10 + i14;
        int i16 = i11 - i14;
        this.f = i13;
        B();
        if (i16 > i13) {
            this.f1080g.write(bArr, i15, i16);
        } else {
            System.arraycopy(bArr, i15, bArr2, 0, i16);
            this.f = i16;
        }
    }

    public final void F(int i10, boolean z2) throws IOException {
        C(11);
        o(i10, 0);
        byte b10 = z2 ? (byte) 1 : (byte) 0;
        int i11 = this.f;
        this.f = i11 + 1;
        this.f1078d[i11] = b10;
    }

    public final void G(int i10, g gVar) throws IOException {
        R(i10, 2);
        H(gVar);
    }

    public final void H(g gVar) throws IOException {
        T(gVar.size());
        l(gVar.f1046v, gVar.d(), gVar.size());
    }

    public final void I(int i10, int i11) throws IOException {
        C(14);
        o(i10, 5);
        m(i11);
    }

    public final void J(int i10) throws IOException {
        C(4);
        m(i10);
    }

    public final void K(int i10, long j5) throws IOException {
        C(18);
        o(i10, 1);
        n(j5);
    }

    public final void L(long j5) throws IOException {
        C(8);
        n(j5);
    }

    public final void M(int i10, int i11) throws IOException {
        C(20);
        o(i10, 0);
        if (i11 >= 0) {
            p(i11);
        } else {
            q(i11);
        }
    }

    public final void N(int i10) throws IOException {
        if (i10 >= 0) {
            T(i10);
        } else {
            V(i10);
        }
    }

    public final void O(int i10, a aVar, b1 b1Var) throws IOException {
        R(i10, 2);
        T(aVar.b(b1Var));
        b1Var.a(aVar, this.f1077c);
    }

    public final void P(String str, int i10) throws IOException {
        R(i10, 2);
        Q(str);
    }

    public final void Q(String str) throws IOException {
        try {
            int length = str.length() * 3;
            int iZ = z(length);
            int i10 = iZ + length;
            int i11 = this.f1079e;
            if (i10 > i11) {
                byte[] bArr = new byte[length];
                int iF = v1.f1143a.f(str, bArr, 0, length);
                T(iF);
                E(bArr, 0, iF);
                return;
            }
            if (i10 > i11 - this.f) {
                B();
            }
            int iZ2 = z(str.length());
            int i12 = this.f;
            byte[] bArr2 = this.f1078d;
            try {
                try {
                    if (iZ2 == iZ) {
                        int i13 = i12 + iZ2;
                        this.f = i13;
                        int iF2 = v1.f1143a.f(str, bArr2, i13, i11 - i13);
                        this.f = i12;
                        p((iF2 - i12) - iZ2);
                        this.f = iF2;
                    } else {
                        int iB = v1.b(str);
                        p(iB);
                        this.f = v1.f1143a.f(str, bArr2, this.f, iB);
                    }
                } catch (u1 e10) {
                    this.f = i12;
                    throw e10;
                }
            } catch (ArrayIndexOutOfBoundsException e11) {
                throw new j(e11);
            }
        } catch (u1 e12) {
            f1076h.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e12);
            byte[] bytes = str.getBytes(z.f1147a);
            try {
                T(bytes.length);
                l(bytes, 0, bytes.length);
            } catch (j e13) {
                throw e13;
            } catch (IndexOutOfBoundsException e14) {
                throw new j(e14);
            }
        }
    }

    public final void R(int i10, int i11) throws IOException {
        T((i10 << 3) | i11);
    }

    public final void S(int i10, int i11) throws IOException {
        C(20);
        o(i10, 0);
        p(i11);
    }

    public final void T(int i10) throws IOException {
        C(5);
        p(i10);
    }

    public final void U(int i10, long j5) throws IOException {
        C(20);
        o(i10, 0);
        q(j5);
    }

    public final void V(long j5) throws IOException {
        C(10);
        q(j5);
    }

    @Override // androidx.datastore.preferences.protobuf.r0
    public final void l(byte[] bArr, int i10, int i11) throws IOException {
        E(bArr, i10, i11);
    }

    public final void m(int i10) {
        int i11 = this.f;
        int i12 = i11 + 1;
        this.f = i12;
        byte[] bArr = this.f1078d;
        bArr[i11] = (byte) (i10 & 255);
        int i13 = i11 + 2;
        this.f = i13;
        bArr[i12] = (byte) ((i10 >> 8) & 255);
        int i14 = i11 + 3;
        this.f = i14;
        bArr[i13] = (byte) ((i10 >> 16) & 255);
        this.f = i11 + 4;
        bArr[i14] = (byte) ((i10 >> 24) & 255);
    }

    public final void n(long j5) {
        int i10 = this.f;
        int i11 = i10 + 1;
        this.f = i11;
        byte[] bArr = this.f1078d;
        bArr[i10] = (byte) (j5 & 255);
        int i12 = i10 + 2;
        this.f = i12;
        bArr[i11] = (byte) ((j5 >> 8) & 255);
        int i13 = i10 + 3;
        this.f = i13;
        bArr[i12] = (byte) ((j5 >> 16) & 255);
        int i14 = i10 + 4;
        this.f = i14;
        bArr[i13] = (byte) (255 & (j5 >> 24));
        int i15 = i10 + 5;
        this.f = i15;
        bArr[i14] = (byte) (((int) (j5 >> 32)) & 255);
        int i16 = i10 + 6;
        this.f = i16;
        bArr[i15] = (byte) (((int) (j5 >> 40)) & 255);
        int i17 = i10 + 7;
        this.f = i17;
        bArr[i16] = (byte) (((int) (j5 >> 48)) & 255);
        this.f = i10 + 8;
        bArr[i17] = (byte) (((int) (j5 >> 56)) & 255);
    }

    public final void o(int i10, int i11) {
        p((i10 << 3) | i11);
    }

    public final void p(int i10) {
        boolean z2 = i;
        byte[] bArr = this.f1078d;
        if (z2) {
            while ((i10 & (-128)) != 0) {
                int i11 = this.f;
                this.f = i11 + 1;
                s1.j(bArr, i11, (byte) ((i10 & ModuleDescriptor.MODULE_VERSION) | 128));
                i10 >>>= 7;
            }
            int i12 = this.f;
            this.f = i12 + 1;
            s1.j(bArr, i12, (byte) i10);
            return;
        }
        while ((i10 & (-128)) != 0) {
            int i13 = this.f;
            this.f = i13 + 1;
            bArr[i13] = (byte) ((i10 & ModuleDescriptor.MODULE_VERSION) | 128);
            i10 >>>= 7;
        }
        int i14 = this.f;
        this.f = i14 + 1;
        bArr[i14] = (byte) i10;
    }

    public final void q(long j5) {
        boolean z2 = i;
        byte[] bArr = this.f1078d;
        if (z2) {
            while ((j5 & (-128)) != 0) {
                int i10 = this.f;
                this.f = i10 + 1;
                s1.j(bArr, i10, (byte) ((((int) j5) & ModuleDescriptor.MODULE_VERSION) | 128));
                j5 >>>= 7;
            }
            int i11 = this.f;
            this.f = i11 + 1;
            s1.j(bArr, i11, (byte) j5);
            return;
        }
        while ((j5 & (-128)) != 0) {
            int i12 = this.f;
            this.f = i12 + 1;
            bArr[i12] = (byte) ((((int) j5) & ModuleDescriptor.MODULE_VERSION) | 128);
            j5 >>>= 7;
        }
        int i13 = this.f;
        this.f = i13 + 1;
        bArr[i13] = (byte) j5;
    }
}
