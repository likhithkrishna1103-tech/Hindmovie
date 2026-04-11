package a3;

import java.nio.ByteOrder;
import java.util.Collections;
import v1.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f235e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f236g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f237h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f238j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final l4.c0 f239k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final v1.l0 f240l;

    public v(int i, byte[] bArr) {
        k0 k0Var = new k0(bArr.length, bArr);
        k0Var.q(i * 8);
        this.f231a = k0Var.i(16);
        this.f232b = k0Var.i(16);
        this.f233c = k0Var.i(24);
        this.f234d = k0Var.i(24);
        int i10 = k0Var.i(20);
        this.f235e = i10;
        this.f = d(i10);
        this.f236g = k0Var.i(3) + 1;
        int i11 = k0Var.i(5) + 1;
        this.f237h = i11;
        this.i = a(i11);
        this.f238j = k0Var.k(36);
        this.f239k = null;
        this.f240l = null;
    }

    public static int a(int i) {
        if (i == 8) {
            return 1;
        }
        if (i == 12) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 20) {
            return 5;
        }
        if (i != 24) {
            return i != 32 ? -1 : 7;
        }
        return 6;
    }

    public static int d(int i) {
        switch (i) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public final long b() {
        long j4 = this.f238j;
        if (j4 == 0) {
            return -9223372036854775807L;
        }
        return (j4 * 1000000) / ((long) this.f235e);
    }

    public final v1.p c(byte[] bArr, v1.l0 l0Var) {
        bArr[4] = -128;
        int i = this.f234d;
        if (i <= 0) {
            i = -1;
        }
        v1.l0 l0Var2 = this.f240l;
        if (l0Var2 != null) {
            l0Var = l0Var2.b(l0Var);
        }
        v1.o oVar = new v1.o();
        oVar.f12893m = m0.p("audio/flac");
        oVar.f12894n = i;
        oVar.E = this.f236g;
        oVar.F = this.f235e;
        int i10 = y1.a0.f14551a;
        oVar.G = y1.a0.z(this.f237h, ByteOrder.LITTLE_ENDIAN);
        oVar.f12896p = Collections.singletonList(bArr);
        oVar.f12891k = l0Var;
        return new v1.p(oVar);
    }

    public v(int i, int i10, int i11, int i12, int i13, int i14, int i15, long j4, l4.c0 c0Var, v1.l0 l0Var) {
        this.f231a = i;
        this.f232b = i10;
        this.f233c = i11;
        this.f234d = i12;
        this.f235e = i13;
        this.f = d(i13);
        this.f236g = i14;
        this.f237h = i15;
        this.i = a(i15);
        this.f238j = j4;
        this.f239k = c0Var;
        this.f240l = l0Var;
    }
}
