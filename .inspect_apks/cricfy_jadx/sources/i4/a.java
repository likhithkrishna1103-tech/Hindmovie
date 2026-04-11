package i4;

import a3.i0;
import a3.r;
import com.google.android.material.datepicker.o;
import java.math.RoundingMode;
import v1.m0;
import v1.n0;
import v1.p;
import y1.a0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f6181m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f6182n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f6183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i0 f6184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f6185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f6187e;
    public final t f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f6188g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p f6189h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f6190j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6191k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f6192l;

    public a(r rVar, i0 i0Var, o oVar) throws n0 {
        this.f6183a = rVar;
        this.f6184b = i0Var;
        this.f6185c = oVar;
        int i = oVar.f2876w;
        int iMax = Math.max(1, i / 10);
        this.f6188g = iMax;
        t tVar = new t((byte[]) oVar.f2879z);
        tVar.q();
        int iQ = tVar.q();
        this.f6186d = iQ;
        int i10 = oVar.f2875v;
        int i11 = oVar.f2877x;
        int i12 = (((i11 - (i10 * 4)) * 8) / (oVar.f2878y * i10)) + 1;
        if (iQ != i12) {
            throw n0.a(null, "Expected frames per block: " + i12 + "; got: " + iQ);
        }
        int iF = a0.f(iMax, iQ);
        this.f6187e = new byte[iF * i11];
        this.f = new t(iQ * 2 * i10 * iF);
        int i13 = ((i11 * i) * 8) / iQ;
        v1.o oVar2 = new v1.o();
        oVar2.f12893m = m0.p("audio/raw");
        oVar2.f12889h = i13;
        oVar2.i = i13;
        oVar2.f12894n = iMax * 2 * i10;
        oVar2.E = i10;
        oVar2.F = i;
        oVar2.G = 2;
        this.f6189h = new p(oVar2);
    }

    @Override // i4.b
    public final void a(int i, long j4) {
        this.f6183a.s(new g(this.f6185c, this.f6186d, i, j4));
        this.f6184b.f(this.f6189h);
    }

    @Override // i4.b
    public final void b(long j4) {
        this.i = 0;
        this.f6190j = j4;
        this.f6191k = 0;
        this.f6192l = 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0045 A[ADDED_TO_REGION, EDGE_INSN: B:43:0x0045->B:14:0x0045 BREAK  A[LOOP:0: B:6:0x0023->B:13:0x003f], REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x003c -> B:4:0x0020). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // i4.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(a3.q r25, long r26) {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.a.c(a3.q, long):boolean");
    }

    public final void d(int i) {
        long j4 = this.f6190j;
        long j7 = this.f6192l;
        o oVar = this.f6185c;
        long j10 = oVar.f2876w;
        int i10 = a0.f14551a;
        long jW = j4 + a0.W(j7, 1000000L, j10, RoundingMode.DOWN);
        int i11 = i * 2 * oVar.f2875v;
        this.f6184b.e(jW, 1, i11, this.f6191k - i11, null);
        this.f6192l += (long) i;
        this.f6191k -= i11;
    }
}
