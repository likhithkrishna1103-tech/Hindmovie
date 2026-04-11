package e4;

import java.math.RoundingMode;
import p1.m0;
import p1.n0;
import p1.p;
import s1.b0;
import s1.u;
import w2.h0;
import w2.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f4389m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f4390n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f4391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f4392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f4393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f4395e;
    public final u f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f4396g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p1.q f4397h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f4398j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4399k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f4400l;

    public a(q qVar, h0 h0Var, e eVar) throws n0 {
        this.f4391a = qVar;
        this.f4392b = h0Var;
        this.f4393c = eVar;
        int i = eVar.f4415v;
        int iMax = Math.max(1, i / 10);
        this.f4396g = iMax;
        u uVar = new u((byte[]) eVar.f4418y);
        uVar.q();
        int iQ = uVar.q();
        this.f4394d = iQ;
        int i10 = eVar.f4414u;
        int i11 = eVar.f4416w;
        int i12 = (((i11 - (i10 * 4)) * 8) / (eVar.f4417x * i10)) + 1;
        if (iQ != i12) {
            throw n0.a(null, "Expected frames per block: " + i12 + "; got: " + iQ);
        }
        int iF = b0.f(iMax, iQ);
        this.f4395e = new byte[iF * i11];
        this.f = new u(iQ * 2 * i10 * iF);
        int i13 = ((i11 * i) * 8) / iQ;
        p pVar = new p();
        pVar.f9967m = m0.p("audio/raw");
        pVar.f9963h = i13;
        pVar.i = i13;
        pVar.f9968n = iMax * 2 * i10;
        pVar.E = i10;
        pVar.F = i;
        pVar.G = 2;
        this.f4397h = new p1.q(pVar);
    }

    @Override // e4.b
    public final void a(int i, long j5) {
        this.f4391a.j(new h(this.f4393c, this.f4394d, i, j5));
        this.f4392b.d(this.f4397h);
    }

    @Override // e4.b
    public final void b(long j5) {
        this.i = 0;
        this.f4398j = j5;
        this.f4399k = 0;
        this.f4400l = 0L;
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
    @Override // e4.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(w2.p r25, long r26) {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.a.c(w2.p, long):boolean");
    }

    public final void d(int i) {
        long j5 = this.f4398j;
        long j8 = this.f4400l;
        e eVar = this.f4393c;
        long j10 = eVar.f4415v;
        int i10 = b0.f11647a;
        long jW = j5 + b0.W(j8, 1000000L, j10, RoundingMode.DOWN);
        int i11 = i * 2 * eVar.f4414u;
        this.f4392b.a(jW, 1, i11, this.f4399k - i11, null);
        this.f4400l += (long) i;
        this.f4399k -= i11;
    }
}
