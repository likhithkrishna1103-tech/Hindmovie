package c2;

import android.media.AudioTrack;
import android.os.SystemClock;
import java.lang.reflect.Method;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t {
    public long A;
    public boolean B;
    public long C;
    public long D;
    public boolean E;
    public long F;
    public s1.w G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u5.c f2382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f2383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AudioTrack f2384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s f2386e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f2387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f2388h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f2389j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2390k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f2391l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f2392m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Method f2393n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f2394o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2395p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2396q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f2397r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f2398s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f2399t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f2400u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2401v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2402w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f2403x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f2404y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f2405z;

    public t(u5.c cVar) {
        this.f2382a = cVar;
        try {
            this.f2393n = AudioTrack.class.getMethod("getLatency", null);
        } catch (NoSuchMethodException unused) {
        }
        this.f2383b = new long[10];
        this.D = -9223372036854775807L;
        this.C = -9223372036854775807L;
        this.G = s1.w.f11715a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long a() {
        /*
            Method dump skipped, instruction units count: 911
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.t.a():long");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long b() {
        /*
            r12 = this;
            long r0 = r12.f2403x
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L16
            long r0 = r12.d()
            long r2 = r12.A
            long r0 = java.lang.Math.min(r2, r0)
            return r0
        L16:
            s1.w r0 = r12.G
            r0.getClass()
            long r0 = android.os.SystemClock.elapsedRealtime()
            long r4 = r12.f2398s
            long r4 = r0 - r4
            r6 = 5
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 < 0) goto L7f
            android.media.AudioTrack r4 = r12.f2384c
            r4.getClass()
            int r5 = r4.getPlayState()
            r6 = 1
            if (r5 != r6) goto L36
            goto L7d
        L36:
            int r4 = r4.getPlaybackHeadPosition()
            long r6 = (long) r4
            r8 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r6 = r6 & r8
            int r4 = android.os.Build.VERSION.SDK_INT
            r8 = 29
            if (r4 > r8) goto L61
            r8 = 0
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 != 0) goto L5f
            long r10 = r12.f2399t
            int r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r4 <= 0) goto L5f
            r4 = 3
            if (r5 != r4) goto L5f
            long r4 = r12.f2404y
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L7d
            r12.f2404y = r0
            goto L7d
        L5f:
            r12.f2404y = r2
        L61:
            long r2 = r12.f2399t
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 <= 0) goto L7b
            boolean r4 = r12.E
            if (r4 == 0) goto L74
            long r4 = r12.F
            long r4 = r4 + r2
            r12.F = r4
            r2 = 0
            r12.E = r2
            goto L7b
        L74:
            long r2 = r12.f2400u
            r4 = 1
            long r2 = r2 + r4
            r12.f2400u = r2
        L7b:
            r12.f2399t = r6
        L7d:
            r12.f2398s = r0
        L7f:
            long r0 = r12.f2399t
            long r2 = r12.F
            long r0 = r0 + r2
            long r2 = r12.f2400u
            r4 = 32
            long r2 = r2 << r4
            long r0 = r0 + r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.t.b():long");
    }

    public final long c(long j5) {
        long jX;
        if (this.f2402w != 0) {
            jX = s1.b0.x(j5 + this.f2391l, this.f2388h);
        } else if (this.f2403x != -9223372036854775807L) {
            jX = s1.b0.U(this.f, d());
        } else {
            jX = s1.b0.U(this.f, b());
        }
        long jMax = Math.max(0L, jX - this.f2394o);
        if (this.f2403x == -9223372036854775807L) {
            return jMax;
        }
        return Math.min(s1.b0.U(this.f, this.A), jMax);
    }

    public final long d() {
        AudioTrack audioTrack = this.f2384c;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 2) {
            return this.f2405z;
        }
        this.G.getClass();
        return this.f2405z + s1.b0.W(s1.b0.x(s1.b0.O(SystemClock.elapsedRealtime()) - this.f2403x, this.f2388h), this.f, 1000000L, RoundingMode.UP);
    }

    public final void e(long j5) {
        if (this.B) {
            long j8 = this.f2389j;
            if (j8 == -9223372036854775807L || j5 < j8) {
                return;
            }
            long jB = s1.b0.B(j5 - j8, this.f2388h);
            this.G.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis() - s1.b0.b0(jB);
            this.f2389j = -9223372036854775807L;
            n nVar = ((e0) this.f2382a.f12782v).f2291s;
            if (nVar != null) {
                nVar.f(jCurrentTimeMillis);
            }
        }
    }

    public final void f() {
        this.f2391l = 0L;
        this.f2402w = 0;
        this.f2401v = 0;
        this.f2392m = 0L;
        this.C = -9223372036854775807L;
        this.D = -9223372036854775807L;
        this.i = false;
    }
}
