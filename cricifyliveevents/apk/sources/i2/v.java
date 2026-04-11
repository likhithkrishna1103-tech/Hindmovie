package i2;

import android.media.AudioTrack;
import android.os.SystemClock;
import java.lang.reflect.Method;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v {
    public long A;
    public boolean B;
    public long C;
    public long D;
    public boolean E;
    public long F;
    public y1.v G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p6.c f6118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f6119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AudioTrack f6120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public u f6122e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f6123g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f6124h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f6125j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6126k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f6127l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f6128m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Method f6129n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f6130o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f6131p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6132q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f6133r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f6134s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f6135t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f6136u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6137v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6138w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f6139x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f6140y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f6141z;

    public v(p6.c cVar) {
        this.f6118a = cVar;
        try {
            this.f6129n = AudioTrack.class.getMethod("getLatency", null);
        } catch (NoSuchMethodException unused) {
        }
        this.f6119b = new long[10];
        this.D = -9223372036854775807L;
        this.C = -9223372036854775807L;
        this.G = y1.v.f14615a;
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
        throw new UnsupportedOperationException("Method not decompiled: i2.v.a():long");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long b() {
        /*
            r12 = this;
            long r0 = r12.f6139x
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L16
            long r0 = r12.d()
            long r2 = r12.A
            long r0 = java.lang.Math.min(r2, r0)
            return r0
        L16:
            y1.v r0 = r12.G
            r0.getClass()
            long r0 = android.os.SystemClock.elapsedRealtime()
            long r4 = r12.f6134s
            long r4 = r0 - r4
            r6 = 5
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 < 0) goto L7f
            android.media.AudioTrack r4 = r12.f6120c
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
            long r10 = r12.f6135t
            int r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r4 <= 0) goto L5f
            r4 = 3
            if (r5 != r4) goto L5f
            long r4 = r12.f6140y
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L7d
            r12.f6140y = r0
            goto L7d
        L5f:
            r12.f6140y = r2
        L61:
            long r2 = r12.f6135t
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
            long r2 = r12.f6136u
            r4 = 1
            long r2 = r2 + r4
            r12.f6136u = r2
        L7b:
            r12.f6135t = r6
        L7d:
            r12.f6134s = r0
        L7f:
            long r0 = r12.f6135t
            long r2 = r12.F
            long r0 = r0 + r2
            long r2 = r12.f6136u
            r4 = 32
            long r2 = r2 << r4
            long r0 = r0 + r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.v.b():long");
    }

    public final long c(long j4) {
        long jX;
        if (this.f6138w != 0) {
            jX = y1.a0.x(j4 + this.f6127l, this.f6124h);
        } else if (this.f6139x != -9223372036854775807L) {
            jX = y1.a0.U(this.f, d());
        } else {
            jX = y1.a0.U(this.f, b());
        }
        long jMax = Math.max(0L, jX - this.f6130o);
        if (this.f6139x == -9223372036854775807L) {
            return jMax;
        }
        return Math.min(y1.a0.U(this.f, this.A), jMax);
    }

    public final long d() {
        AudioTrack audioTrack = this.f6120c;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 2) {
            return this.f6141z;
        }
        this.G.getClass();
        return this.f6141z + y1.a0.W(y1.a0.x(y1.a0.O(SystemClock.elapsedRealtime()) - this.f6139x, this.f6124h), this.f, 1000000L, RoundingMode.UP);
    }

    public final void e(long j4) {
        if (this.B) {
            long j7 = this.f6125j;
            if (j7 == -9223372036854775807L || j4 < j7) {
                return;
            }
            long jB = y1.a0.B(j4 - j7, this.f6124h);
            this.G.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis() - y1.a0.b0(jB);
            this.f6125j = -9223372036854775807L;
            p pVar = ((f0) this.f6118a.f10035w).f6031s;
            if (pVar != null) {
                pVar.f(jCurrentTimeMillis);
            }
        }
    }

    public final void f() {
        this.f6127l = 0L;
        this.f6138w = 0;
        this.f6137v = 0;
        this.f6128m = 0L;
        this.C = -9223372036854775807L;
        this.D = -9223372036854775807L;
        this.i = false;
    }
}
