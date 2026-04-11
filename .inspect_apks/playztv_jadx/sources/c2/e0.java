package c2;

import aa.c1;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import p1.m0;
import p1.q0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e0 implements q {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final Object f2260n0 = new Object();

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static ScheduledExecutorService f2261o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static int f2262p0;
    public p1.d A;
    public z B;
    public z C;
    public q0 D;
    public boolean E;
    public ByteBuffer F;
    public int G;
    public long H;
    public long I;
    public long J;
    public long K;
    public int L;
    public boolean M;
    public boolean N;
    public long O;
    public float P;
    public ByteBuffer Q;
    public int R;
    public ByteBuffer S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public int Y;
    public boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2263a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public p1.e f2264a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a7.b f2265b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public wb.c f2266b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f2267c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f2268c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k0 f2269d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public long f2270d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q1.k f2271e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public long f2272e0;
    public final j0 f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f2273f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c1 f2274g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f2275g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final t f2276h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public Looper f2277h0;
    public final ArrayDeque i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public long f2278i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2279j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public long f2280j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a7.b f2281k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public Handler f2282k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b0 f2283l;
    public Context l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b0 f2284m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final boolean f2285m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final f0 f2286n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final h4.z f2287o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final f0 f2288p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f2289q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b2.o f2290r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public n f2291s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public y f2292t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public y f2293u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public q1.d f2294v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AudioTrack f2295w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public b f2296x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public f f2297y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public a7.b f2298z;

    public e0(x xVar) {
        int deviceId;
        Context context = xVar.f2412a;
        Context applicationContext = context == null ? null : context.getApplicationContext();
        this.f2263a = applicationContext;
        this.A = p1.d.f9682h;
        this.f2296x = applicationContext == null ? (b) xVar.f2414c : null;
        this.f2265b = (a7.b) xVar.f2415d;
        int i = Build.VERSION.SDK_INT;
        this.f2279j = 0;
        this.f2286n = (f0) xVar.f2416e;
        h4.z zVar = (h4.z) xVar.f2417g;
        zVar.getClass();
        this.f2287o = zVar;
        this.f2276h = new t(new u5.c(6, this));
        u uVar = new u();
        this.f2267c = uVar;
        k0 k0Var = new k0();
        k0Var.f2359m = s1.b0.f11649c;
        this.f2269d = k0Var;
        this.f2271e = new q1.k();
        this.f = new j0();
        this.f2274g = aa.j0.w(k0Var, uVar);
        this.P = 1.0f;
        this.Y = 0;
        this.f2264a0 = new p1.e();
        q0 q0Var = q0.f10036d;
        this.C = new z(q0Var, 0L, 0L);
        this.D = q0Var;
        this.E = false;
        this.i = new ArrayDeque();
        this.f2283l = new b0();
        this.f2284m = new b0();
        this.f2288p = (f0) xVar.f;
        int i10 = -1;
        if (i >= 34 && context != null && (deviceId = context.getDeviceId()) != 0 && deviceId != -1) {
            i10 = deviceId;
        }
        this.f2289q = i10;
        this.f2285m0 = true;
    }

    public static boolean r(AudioTrack audioTrack) {
        return Build.VERSION.SDK_INT >= 29 && audioTrack.isOffloadedPlayback();
    }

    public final void A(int i) {
        if (this.Z) {
            if (this.Y != i) {
                return;
            } else {
                this.Z = false;
            }
        }
        if (this.Y != i) {
            this.Y = i;
            this.X = i != 0;
            g();
        }
    }

    public final void B() {
        if (q()) {
            try {
                this.f2295w.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(this.D.f10038a).setPitch(this.D.f10039b).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e10) {
                s1.b.q("DefaultAudioSink", "Failed to set playback params", e10);
            }
            q0 q0Var = new q0(this.f2295w.getPlaybackParams().getSpeed(), this.f2295w.getPlaybackParams().getPitch());
            this.D = q0Var;
            float f = q0Var.f10038a;
            t tVar = this.f2276h;
            tVar.f2388h = f;
            s sVar = tVar.f2386e;
            if (sVar != null) {
                sVar.a(0);
            }
            tVar.f();
        }
    }

    public final void C(p1.e eVar) {
        if (this.f2264a0.equals(eVar)) {
            return;
        }
        eVar.getClass();
        if (this.f2295w != null) {
            this.f2264a0.getClass();
        }
        this.f2264a0 = eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ed A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0057 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D(java.nio.ByteBuffer r19) {
        /*
            Method dump skipped, instruction units count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.e0.D(java.nio.ByteBuffer):void");
    }

    public final void E(q0 q0Var) {
        this.D = new q0(s1.b0.h(q0Var.f10038a, 0.1f, 8.0f), s1.b0.h(q0Var.f10039b, 0.1f, 8.0f));
        y yVar = this.f2293u;
        if (yVar != null && yVar.f2425j) {
            B();
            return;
        }
        z zVar = new z(q0Var, -9223372036854775807L, -9223372036854775807L);
        if (q()) {
            this.B = zVar;
        } else {
            this.C = zVar;
        }
    }

    public final boolean F(p1.q qVar) {
        return k(qVar) != 0;
    }

    public final void a(long j5) {
        q0 q0Var;
        y yVar = this.f2293u;
        boolean z2 = false;
        a7.b bVar = this.f2265b;
        if (yVar == null || !yVar.f2425j) {
            if (this.f2268c0 || yVar.f2420c != 0) {
                q0Var = q0.f10036d;
            } else {
                int i = yVar.f2418a.H;
                q0Var = this.D;
                q1.j jVar = (q1.j) bVar.f620x;
                float f = q0Var.f10038a;
                jVar.getClass();
                s1.d.b(f > 0.0f);
                if (jVar.f10576c != f) {
                    jVar.f10576c = f;
                    jVar.i = true;
                }
                float f4 = q0Var.f10039b;
                s1.d.b(f4 > 0.0f);
                if (jVar.f10577d != f4) {
                    jVar.f10577d = f4;
                    jVar.i = true;
                }
            }
            this.D = q0Var;
        } else {
            q0Var = q0.f10036d;
        }
        q0 q0Var2 = q0Var;
        if (!this.f2268c0) {
            y yVar2 = this.f2293u;
            if (yVar2.f2420c == 0) {
                int i10 = yVar2.f2418a.H;
                z2 = this.E;
                ((i0) bVar.f619w).f2343o = z2;
            }
        }
        this.E = z2;
        this.i.add(new z(q0Var2, Math.max(0L, j5), s1.b0.U(this.f2293u.f2422e, m())));
        q1.d dVar = this.f2293u.i;
        this.f2294v = dVar;
        dVar.a();
        n nVar = this.f2291s;
        if (nVar != null) {
            nVar.a(this.E);
        }
    }

    public final AudioTrack b(k kVar, p1.d dVar, int i, p1.q qVar, Context context) throws m {
        try {
            AudioTrack audioTrackA = this.f2288p.a(kVar, dVar, i, context);
            int state = audioTrackA.getState();
            if (state == 1) {
                return audioTrackA;
            }
            try {
                audioTrackA.release();
            } catch (Exception unused) {
            }
            throw new m(state, kVar.f2352b, kVar.f2353c, kVar.f2351a, kVar.f, qVar, kVar.f2355e, null);
        } catch (IllegalArgumentException | UnsupportedOperationException e10) {
            throw new m(0, kVar.f2352b, kVar.f2353c, kVar.f2351a, kVar.f, qVar, kVar.f2355e, e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.media.AudioTrack c(c2.y r9) throws c2.m {
        /*
            r8 = this;
            int r0 = r8.Y     // Catch: c2.m -> L3a
            int r1 = r8.f2289q     // Catch: c2.m -> L3a
            r2 = -1
            if (r1 == r2) goto L26
            android.content.Context r2 = r8.f2263a     // Catch: c2.m -> L1c
            if (r2 == 0) goto L26
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: c2.m -> L1c
            r4 = 34
            if (r3 < r4) goto L26
            android.content.Context r0 = r8.l0     // Catch: c2.m -> L1c
            if (r0 != 0) goto L20
            android.content.Context r0 = c.a.f(r2, r1)     // Catch: c2.m -> L1c
            r8.l0 = r0     // Catch: c2.m -> L1c
            goto L20
        L1c:
            r0 = move-exception
            r9 = r0
            r2 = r8
            goto L3d
        L20:
            android.content.Context r0 = r8.l0     // Catch: c2.m -> L1c
            r1 = 0
            r7 = r0
            r5 = r1
            goto L29
        L26:
            r1 = 0
            r5 = r0
            r7 = r1
        L29:
            c2.k r3 = r9.a()     // Catch: c2.m -> L3a
            p1.d r4 = r8.A     // Catch: c2.m -> L3a
            p1.q r6 = r9.f2418a     // Catch: c2.m -> L3a
            r2 = r8
            android.media.AudioTrack r9 = r2.b(r3, r4, r5, r6, r7)     // Catch: c2.m -> L37
            return r9
        L37:
            r0 = move-exception
        L38:
            r9 = r0
            goto L3d
        L3a:
            r0 = move-exception
            r2 = r8
            goto L38
        L3d:
            c2.n r0 = r2.f2291s
            if (r0 == 0) goto L44
            r0.o(r9)
        L44:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.e0.c(c2.y):android.media.AudioTrack");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(p1.q r26, int[] r27) throws c2.l {
        /*
            Method dump skipped, instruction units count: 702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.e0.d(p1.q, int[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(long r13) throws c2.p {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.e0.e(long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0044 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f() throws c2.p {
        /*
            r6 = this;
            q1.d r0 = r6.f2294v
            boolean r0 = r0.d()
            r1 = -9223372036854775808
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L14
            r6.e(r1)
            java.nio.ByteBuffer r0 = r6.S
            if (r0 != 0) goto L44
            goto L43
        L14:
            q1.d r0 = r6.f2294v
            boolean r5 = r0.d()
            if (r5 == 0) goto L2e
            boolean r5 = r0.f10541d
            if (r5 == 0) goto L21
            goto L2e
        L21:
            r0.f10541d = r4
            java.util.ArrayList r0 = r0.f10539b
            java.lang.Object r0 = r0.get(r3)
            q1.g r0 = (q1.g) r0
            r0.d()
        L2e:
            r6.x(r1)
            q1.d r0 = r6.f2294v
            boolean r0 = r0.c()
            if (r0 == 0) goto L44
            java.nio.ByteBuffer r0 = r6.S
            if (r0 == 0) goto L43
            boolean r0 = r0.hasRemaining()
            if (r0 != 0) goto L44
        L43:
            return r4
        L44:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.e0.f():boolean");
    }

    public final void g() {
        a7.b bVar;
        if (q()) {
            this.H = 0L;
            this.I = 0L;
            this.J = 0L;
            this.K = 0L;
            this.f2275g0 = false;
            this.L = 0;
            this.C = new z(this.D, 0L, 0L);
            this.O = 0L;
            this.B = null;
            this.i.clear();
            this.Q = null;
            this.R = 0;
            this.S = null;
            this.U = false;
            this.T = false;
            this.V = false;
            this.F = null;
            this.G = 0;
            this.f2269d.f2361o = 0L;
            q1.d dVar = this.f2293u.i;
            this.f2294v = dVar;
            dVar.a();
            AudioTrack audioTrack = this.f2276h.f2384c;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 3) {
                this.f2295w.pause();
            }
            if (r(this.f2295w)) {
                a7.b bVar2 = this.f2281k;
                bVar2.getClass();
                this.f2295w.unregisterStreamEventCallback((d0) bVar2.f619w);
                ((Handler) bVar2.f618v).removeCallbacksAndMessages(null);
            }
            k kVarA = this.f2293u.a();
            y yVar = this.f2292t;
            if (yVar != null) {
                this.f2293u = yVar;
                this.f2292t = null;
            }
            t tVar = this.f2276h;
            tVar.f();
            tVar.f2384c = null;
            tVar.f2386e = null;
            if (Build.VERSION.SDK_INT >= 24 && (bVar = this.f2298z) != null) {
                AudioTrack audioTrack2 = (AudioTrack) bVar.f618v;
                a0 a0Var = (a0) bVar.f620x;
                a0Var.getClass();
                audioTrack2.removeOnRoutingChangedListener(a0Var);
                bVar.f620x = null;
                this.f2298z = null;
            }
            AudioTrack audioTrack3 = this.f2295w;
            n nVar = this.f2291s;
            Handler handler = new Handler(Looper.myLooper());
            synchronized (f2260n0) {
                try {
                    if (f2261o0 == null) {
                        int i = s1.b0.f11647a;
                        f2261o0 = Executors.newSingleThreadScheduledExecutor(new s1.a0());
                    }
                    f2262p0++;
                    f2261o0.schedule(new w(audioTrack3, nVar, handler, kVarA, 0), 20L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.f2295w = null;
        }
        b0 b0Var = this.f2284m;
        b0Var.f2250c = null;
        b0Var.f2248a = -9223372036854775807L;
        b0Var.f2249b = -9223372036854775807L;
        b0 b0Var2 = this.f2283l;
        b0Var2.f2250c = null;
        b0Var2.f2248a = -9223372036854775807L;
        b0Var2.f2249b = -9223372036854775807L;
        this.f2278i0 = 0L;
        this.f2280j0 = 0L;
        Handler handler2 = this.f2282k0;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    public final long h() {
        if (!q()) {
            return -9223372036854775807L;
        }
        AudioTrack audioTrack = this.f2295w;
        y yVar = this.f2293u;
        if (yVar.f2420c == 0) {
            return s1.b0.U(yVar.f2422e, audioTrack.getBufferSizeInFrames());
        }
        long bufferSizeInFrames = audioTrack.getBufferSizeInFrames();
        int iJ = w2.b.j(yVar.f2423g);
        s1.d.g(iJ != -2147483647);
        return s1.b0.W(bufferSizeInFrames, 1000000L, iJ, RoundingMode.DOWN);
    }

    public final long i() {
        ArrayDeque arrayDeque;
        long j5;
        if (!q() || this.N) {
            return Long.MIN_VALUE;
        }
        long jMin = Math.min(this.f2276h.a(), s1.b0.U(this.f2293u.f2422e, m()));
        while (true) {
            arrayDeque = this.i;
            if (arrayDeque.isEmpty() || jMin < ((z) arrayDeque.getFirst()).f2430c) {
                break;
            }
            this.C = (z) arrayDeque.remove();
        }
        z zVar = this.C;
        long jW = jMin - zVar.f2430c;
        long jX = s1.b0.x(jW, zVar.f2428a.f10038a);
        boolean zIsEmpty = arrayDeque.isEmpty();
        a7.b bVar = this.f2265b;
        if (zIsEmpty) {
            q1.j jVar = (q1.j) bVar.f620x;
            if (jVar.a()) {
                if (jVar.f10586o >= 1024) {
                    long j8 = jVar.f10585n;
                    q1.i iVar = jVar.f10581j;
                    iVar.getClass();
                    long j10 = j8 - ((long) ((iVar.f10562k * iVar.f10555b) * 2));
                    int i = jVar.f10580h.f10543a;
                    int i10 = jVar.f10579g.f10543a;
                    jW = i == i10 ? s1.b0.W(jW, j10, jVar.f10586o, RoundingMode.DOWN) : s1.b0.W(jW, j10 * ((long) i), jVar.f10586o * ((long) i10), RoundingMode.DOWN);
                } else {
                    jW = (long) (((double) jVar.f10576c) * jW);
                }
            }
            z zVar2 = this.C;
            j5 = zVar2.f2429b + jW;
            zVar2.f2431d = jW - jX;
        } else {
            z zVar3 = this.C;
            j5 = zVar3.f2429b + jX + zVar3.f2431d;
        }
        long j11 = ((i0) bVar.f619w).f2345q;
        long jU = s1.b0.U(this.f2293u.f2422e, j11) + j5;
        long j12 = this.f2278i0;
        if (j11 > j12) {
            long jU2 = s1.b0.U(this.f2293u.f2422e, j11 - j12);
            this.f2278i0 = j11;
            this.f2280j0 += jU2;
            if (this.f2282k0 == null) {
                this.f2282k0 = new Handler(Looper.myLooper());
            }
            this.f2282k0.removeCallbacksAndMessages(null);
            this.f2282k0.postDelayed(new a2.a(9, this), 100L);
        }
        return jU;
    }

    public final g j(p1.q qVar) {
        boolean zBooleanValue;
        if (this.f2273f0) {
            return g.f2309d;
        }
        p1.d dVar = this.A;
        h4.z zVar = this.f2287o;
        zVar.getClass();
        qVar.getClass();
        int i = qVar.G;
        dVar.getClass();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 29 || i == -1) {
            return g.f2309d;
        }
        Context context = (Context) zVar.f5867v;
        Boolean bool = (Boolean) zVar.f5868w;
        boolean z2 = false;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        } else {
            if (context != null) {
                String parameters = q1.c.C(context).getParameters("offloadVariableRateSupported");
                zVar.f5868w = Boolean.valueOf(parameters != null && parameters.equals("offloadVariableRateSupported=1"));
            } else {
                zVar.f5868w = Boolean.FALSE;
            }
            zBooleanValue = ((Boolean) zVar.f5868w).booleanValue();
        }
        String str = qVar.f10023n;
        str.getClass();
        int iD = m0.d(str, qVar.f10020k);
        if (iD == 0 || i10 < s1.b0.p(iD)) {
            return g.f2309d;
        }
        int iQ = s1.b0.q(qVar.F);
        if (iQ == 0) {
            return g.f2309d;
        }
        try {
            AudioFormat audioFormatBuild = new AudioFormat.Builder().setSampleRate(i).setChannelMask(iQ).setEncoding(iD).build();
            if (i10 < 31) {
                if (!AudioManager.isOffloadedPlaybackSupported(audioFormatBuild, (AudioAttributes) dVar.b().f10045a)) {
                    return g.f2309d;
                }
                bb.b bVar = new bb.b();
                bVar.f1977a = true;
                bVar.f1979c = zBooleanValue;
                return bVar.a();
            }
            int playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(audioFormatBuild, (AudioAttributes) dVar.b().f10045a);
            if (playbackOffloadSupport == 0) {
                return g.f2309d;
            }
            bb.b bVar2 = new bb.b();
            if (i10 > 32 && playbackOffloadSupport == 2) {
                z2 = true;
            }
            bVar2.f1977a = true;
            bVar2.f1978b = z2;
            bVar2.f1979c = zBooleanValue;
            return bVar2.a();
        } catch (IllegalArgumentException unused) {
            return g.f2309d;
        }
    }

    public final int k(p1.q qVar) {
        s();
        String str = qVar.f10023n;
        int i = qVar.H;
        if ("audio/raw".equals(str)) {
            if (!s1.b0.J(i)) {
                e6.j.p(i, "Invalid PCM encoding: ", "DefaultAudioSink");
                return 0;
            }
            if (i != 2) {
                return 1;
            }
        } else if (this.f2296x.d(qVar, this.A) == null) {
            return 0;
        }
        return 2;
    }

    public final long l() {
        y yVar = this.f2293u;
        return yVar.f2420c == 0 ? this.H / ((long) yVar.f2419b) : this.I;
    }

    public final long m() {
        y yVar = this.f2293u;
        if (yVar.f2420c != 0) {
            return this.K;
        }
        long j5 = this.J;
        long j8 = yVar.f2421d;
        int i = s1.b0.f11647a;
        return ((j5 + j8) - 1) / j8;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x03b5, code lost:
    
        if (r15 == 0) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b3, code lost:
    
        if (p() == false) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0464  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x016c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n(long r28, int r30, java.nio.ByteBuffer r31) throws c2.m, c2.p {
        /*
            Method dump skipped, instruction units count: 1214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.e0.n(long, int, java.nio.ByteBuffer):boolean");
    }

    public final boolean o() {
        if (!q()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 29 && this.f2295w.isOffloadedPlayback() && this.V) {
            return false;
        }
        long jM = m();
        t tVar = this.f2276h;
        long jA = tVar.a();
        int i = tVar.f;
        int i10 = s1.b0.f11647a;
        return jM > s1.b0.W(jA, (long) i, 1000000L, RoundingMode.UP);
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p() throws c2.m {
        /*
            Method dump skipped, instruction units count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.e0.p():boolean");
    }

    public final boolean q() {
        return this.f2295w != null;
    }

    public final void s() {
        Context context;
        b bVar;
        Looper looperMyLooper = Looper.myLooper();
        boolean z2 = this.f2297y == null || this.f2277h0 == looperMyLooper;
        StringBuilder sb2 = new StringBuilder("DefaultAudioSink accessed on multiple threads: ");
        Looper looper = this.f2277h0;
        sb2.append(looper == null ? "null" : looper.getThread().getName());
        sb2.append(" and ");
        sb2.append(looperMyLooper != null ? looperMyLooper.getThread().getName() : "null");
        s1.d.f(sb2.toString(), z2);
        if (this.f2297y == null && (context = this.f2263a) != null) {
            this.f2277h0 = looperMyLooper;
            f fVar = new f(context, new a2.f0(12, this), this.A, this.f2266b0);
            this.f2297y = fVar;
            Handler handler = (Handler) fVar.f2302d;
            Context context2 = (Context) fVar.f2300b;
            if (fVar.f2299a) {
                bVar = (b) fVar.f2305h;
                bVar.getClass();
            } else {
                fVar.f2299a = true;
                d dVar = (d) fVar.f2304g;
                if (dVar != null) {
                    dVar.f2254a.registerContentObserver(dVar.f2255b, false, dVar);
                }
                c cVar = (c) fVar.f2303e;
                if (cVar != null) {
                    q1.c.C(context2).registerAudioDeviceCallback(cVar, handler);
                }
                b bVarB = b.b(context2, context2.registerReceiver((e) fVar.f, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), null, handler), (p1.d) fVar.f2306j, (wb.c) fVar.i);
                fVar.f2305h = bVarB;
                bVar = bVarB;
            }
            this.f2296x = bVar;
        }
        this.f2296x.getClass();
    }

    public final void t() {
        this.W = false;
        if (q()) {
            t tVar = this.f2276h;
            tVar.f();
            if (tVar.f2403x == -9223372036854775807L) {
                s sVar = tVar.f2386e;
                sVar.getClass();
                sVar.a(0);
            }
            tVar.f2405z = tVar.b();
            if (!this.U || r(this.f2295w)) {
                this.f2295w.pause();
            }
        }
    }

    public final void u() {
        this.W = true;
        if (q()) {
            t tVar = this.f2276h;
            if (tVar.f2403x != -9223372036854775807L) {
                tVar.G.getClass();
                tVar.f2403x = s1.b0.O(SystemClock.elapsedRealtime());
            }
            tVar.f2389j = s1.b0.U(tVar.f, tVar.b());
            s sVar = tVar.f2386e;
            sVar.getClass();
            sVar.a(0);
            if (!this.U || r(this.f2295w)) {
                this.f2295w.play();
            }
        }
    }

    public final void v() {
        if (this.U) {
            return;
        }
        this.U = true;
        long jM = m();
        t tVar = this.f2276h;
        tVar.f2405z = tVar.b();
        tVar.G.getClass();
        tVar.f2403x = s1.b0.O(SystemClock.elapsedRealtime());
        tVar.A = jM;
        if (r(this.f2295w)) {
            this.V = false;
        }
        this.f2295w.stop();
        this.G = 0;
    }

    public final void w() {
        if (!this.T && q() && f()) {
            v();
            this.T = true;
        }
    }

    public final void x(long j5) throws p {
        ByteBuffer byteBuffer;
        e(j5);
        if (this.S != null) {
            return;
        }
        if (!this.f2294v.d()) {
            ByteBuffer byteBuffer2 = this.Q;
            if (byteBuffer2 != null) {
                D(byteBuffer2);
                e(j5);
                return;
            }
            return;
        }
        while (!this.f2294v.c()) {
            do {
                q1.d dVar = this.f2294v;
                if (dVar.d()) {
                    ByteBuffer byteBuffer3 = dVar.f10540c[dVar.b()];
                    if (byteBuffer3.hasRemaining()) {
                        byteBuffer = byteBuffer3;
                    } else {
                        dVar.e(q1.g.f10547a);
                        byteBuffer = dVar.f10540c[dVar.b()];
                    }
                } else {
                    byteBuffer = q1.g.f10547a;
                }
                if (byteBuffer.hasRemaining()) {
                    D(byteBuffer);
                    e(j5);
                } else {
                    ByteBuffer byteBuffer4 = this.Q;
                    if (byteBuffer4 == null || !byteBuffer4.hasRemaining()) {
                        return;
                    }
                    q1.d dVar2 = this.f2294v;
                    ByteBuffer byteBuffer5 = this.Q;
                    if (dVar2.d() && !dVar2.f10541d) {
                        dVar2.e(byteBuffer5);
                    }
                }
            } while (this.S == null);
            return;
        }
    }

    public final void y() {
        g();
        aa.h0 h0VarT = this.f2274g.listIterator(0);
        while (h0VarT.hasNext()) {
            ((q1.g) h0VarT.next()).reset();
        }
        this.f2271e.reset();
        this.f.reset();
        q1.d dVar = this.f2294v;
        if (dVar != null) {
            aa.j0 j0Var = dVar.f10538a;
            for (int i = 0; i < j0Var.size(); i++) {
                q1.g gVar = (q1.g) j0Var.get(i);
                gVar.flush();
                gVar.reset();
            }
            dVar.f10540c = new ByteBuffer[0];
            q1.e eVar = q1.e.f10542e;
            dVar.f10541d = false;
        }
        this.W = false;
        this.f2273f0 = false;
    }

    public final void z(p1.d dVar) {
        if (this.A.equals(dVar)) {
            return;
        }
        this.A = dVar;
        if (this.f2268c0) {
            return;
        }
        f fVar = this.f2297y;
        if (fVar != null) {
            fVar.f2306j = dVar;
            fVar.a(b.c((Context) fVar.f2300b, dVar, (wb.c) fVar.i));
        }
        g();
    }
}
