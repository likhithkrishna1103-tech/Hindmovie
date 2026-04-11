package w2;

import java.nio.ByteOrder;
import java.util.Collections;
import p1.l0;
import p1.m0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13672e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f13673g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f13674h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f13675j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final p2.c f13676k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final l0 f13677l;

    public u(int i, byte[] bArr) {
        s1.t tVar = new s1.t(bArr.length, bArr);
        tVar.q(i * 8);
        this.f13668a = tVar.i(16);
        this.f13669b = tVar.i(16);
        this.f13670c = tVar.i(24);
        this.f13671d = tVar.i(24);
        int i10 = tVar.i(20);
        this.f13672e = i10;
        this.f = d(i10);
        this.f13673g = tVar.i(3) + 1;
        int i11 = tVar.i(5) + 1;
        this.f13674h = i11;
        this.i = a(i11);
        this.f13675j = tVar.k(36);
        this.f13676k = null;
        this.f13677l = null;
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
        long j5 = this.f13675j;
        if (j5 == 0) {
            return -9223372036854775807L;
        }
        return (j5 * 1000000) / ((long) this.f13672e);
    }

    public final p1.q c(byte[] bArr, l0 l0Var) {
        bArr[4] = -128;
        int i = this.f13671d;
        if (i <= 0) {
            i = -1;
        }
        l0 l0Var2 = this.f13677l;
        if (l0Var2 != null) {
            l0Var = l0Var2.b(l0Var);
        }
        p1.p pVar = new p1.p();
        pVar.f9967m = m0.p("audio/flac");
        pVar.f9968n = i;
        pVar.E = this.f13673g;
        pVar.F = this.f13672e;
        int i10 = s1.b0.f11647a;
        pVar.G = s1.b0.z(this.f13674h, ByteOrder.LITTLE_ENDIAN);
        pVar.f9970p = Collections.singletonList(bArr);
        pVar.f9965k = l0Var;
        return new p1.q(pVar);
    }

    public u(int i, int i10, int i11, int i12, int i13, int i14, int i15, long j5, p2.c cVar, l0 l0Var) {
        this.f13668a = i;
        this.f13669b = i10;
        this.f13670c = i11;
        this.f13671d = i12;
        this.f13672e = i13;
        this.f = d(i13);
        this.f13673g = i14;
        this.f13674h = i15;
        this.i = a(i15);
        this.f13675j = j5;
        this.f13676k = cVar;
        this.f13677l = l0Var;
    }
}
