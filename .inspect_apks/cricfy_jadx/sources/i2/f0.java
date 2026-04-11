package i2;

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
import androidx.fragment.app.f1;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import ua.z0;
import v1.m0;
import v1.q0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 implements s {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final Object f6000n0 = new Object();
    public static ScheduledExecutorService o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static int f6001p0;
    public v1.c A;
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
    public final Context f6002a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public v1.d f6003a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.emoji2.text.v f6004b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public p6.d f6005b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f6006c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f6007c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l0 f6008d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public long f6009d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w1.l f6010e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public long f6011e0;
    public final k0 f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f6012f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final z0 f6013g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f6014g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final v f6015h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public Looper f6016h0;
    public final ArrayDeque i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public long f6017i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6018j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public long f6019j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public androidx.emoji2.text.v f6020k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public Handler f6021k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c0 f6022l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public Context f6023l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c0 f6024m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final boolean f6025m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final g0 f6026n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final k f6027o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final g0 f6028p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f6029q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public h2.l f6030r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public p f6031s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public y f6032t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public y f6033u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public w1.e f6034v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AudioTrack f6035w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public c f6036x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public f f6037y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public androidx.emoji2.text.v f6038z;

    public f0(x xVar) {
        int deviceId;
        Context context = xVar.f6143a;
        Context applicationContext = context == null ? null : context.getApplicationContext();
        this.f6002a = applicationContext;
        this.A = v1.c.f12586h;
        this.f6036x = applicationContext == null ? (c) xVar.f6145c : null;
        this.f6004b = (androidx.emoji2.text.v) xVar.f6146d;
        int i = Build.VERSION.SDK_INT;
        this.f6018j = 0;
        this.f6026n = (g0) xVar.f6147e;
        k kVar = (k) xVar.f6148g;
        kVar.getClass();
        this.f6027o = kVar;
        this.f6015h = new v(new p6.c(21, this));
        w wVar = new w();
        this.f6006c = wVar;
        l0 l0Var = new l0();
        l0Var.f6090m = y1.a0.f14553c;
        this.f6008d = l0Var;
        this.f6010e = new w1.l();
        this.f = new k0();
        this.f6013g = ua.i0.p(l0Var, wVar);
        this.P = 1.0f;
        this.Y = 0;
        this.f6003a0 = new v1.d();
        q0 q0Var = q0.f12966d;
        this.C = new z(q0Var, 0L, 0L);
        this.D = q0Var;
        this.E = false;
        this.i = new ArrayDeque();
        this.f6022l = new c0();
        this.f6024m = new c0();
        this.f6028p = (g0) xVar.f;
        int i10 = -1;
        if (i >= 34 && context != null && (deviceId = context.getDeviceId()) != 0 && deviceId != -1) {
            i10 = deviceId;
        }
        this.f6029q = i10;
        this.f6025m0 = true;
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
                this.f6035w.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(this.D.f12968a).setPitch(this.D.f12969b).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e9) {
                y1.b.q("DefaultAudioSink", "Failed to set playback params", e9);
            }
            q0 q0Var = new q0(this.f6035w.getPlaybackParams().getSpeed(), this.f6035w.getPlaybackParams().getPitch());
            this.D = q0Var;
            float f = q0Var.f12968a;
            v vVar = this.f6015h;
            vVar.f6124h = f;
            u uVar = vVar.f6122e;
            if (uVar != null) {
                uVar.a(0);
            }
            vVar.f();
        }
    }

    public final void C(v1.d dVar) {
        if (this.f6003a0.equals(dVar)) {
            return;
        }
        dVar.getClass();
        if (this.f6035w != null) {
            this.f6003a0.getClass();
        }
        this.f6003a0 = dVar;
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
        throw new UnsupportedOperationException("Method not decompiled: i2.f0.D(java.nio.ByteBuffer):void");
    }

    public final void E(q0 q0Var) {
        this.D = new q0(y1.a0.h(q0Var.f12968a, 0.1f, 8.0f), y1.a0.h(q0Var.f12969b, 0.1f, 8.0f));
        y yVar = this.f6033u;
        if (yVar != null && yVar.f6156j) {
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

    public final boolean F(v1.p pVar) {
        return k(pVar) != 0;
    }

    public final void a(long j4) {
        q0 q0Var;
        y yVar = this.f6033u;
        boolean z10 = false;
        androidx.emoji2.text.v vVar = this.f6004b;
        if (yVar == null || !yVar.f6156j) {
            if (this.f6007c0 || yVar.f6151c != 0) {
                q0Var = q0.f12966d;
            } else {
                int i = yVar.f6149a.H;
                q0Var = this.D;
                w1.k kVar = (w1.k) vVar.f890y;
                float f = q0Var.f12968a;
                kVar.getClass();
                y1.d.b(f > 0.0f);
                if (kVar.f13824c != f) {
                    kVar.f13824c = f;
                    kVar.i = true;
                }
                float f10 = q0Var.f12969b;
                y1.d.b(f10 > 0.0f);
                if (kVar.f13825d != f10) {
                    kVar.f13825d = f10;
                    kVar.i = true;
                }
            }
            this.D = q0Var;
        } else {
            q0Var = q0.f12966d;
        }
        q0 q0Var2 = q0Var;
        if (!this.f6007c0) {
            y yVar2 = this.f6033u;
            if (yVar2.f6151c == 0) {
                int i10 = yVar2.f6149a.H;
                z10 = this.E;
                ((j0) vVar.f889x).f6077o = z10;
            }
        }
        this.E = z10;
        this.i.add(new z(q0Var2, Math.max(0L, j4), y1.a0.U(this.f6033u.f6153e, m())));
        w1.e eVar = this.f6033u.i;
        this.f6034v = eVar;
        eVar.a();
        p pVar = this.f6031s;
        if (pVar != null) {
            pVar.b(this.E);
        }
    }

    public final AudioTrack b(m mVar, v1.c cVar, int i, v1.p pVar, Context context) throws o {
        try {
            AudioTrack audioTrackA = this.f6028p.a(mVar, cVar, i, context);
            int state = audioTrackA.getState();
            if (state == 1) {
                return audioTrackA;
            }
            try {
                audioTrackA.release();
            } catch (Exception unused) {
            }
            throw new o(state, mVar.f6094b, mVar.f6095c, mVar.f6093a, mVar.f, pVar, mVar.f6097e, null);
        } catch (IllegalArgumentException | UnsupportedOperationException e9) {
            throw new o(0, mVar.f6094b, mVar.f6095c, mVar.f6093a, mVar.f, pVar, mVar.f6097e, e9);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.media.AudioTrack c(i2.y r9) throws i2.o {
        /*
            r8 = this;
            int r0 = r8.Y     // Catch: i2.o -> L3a
            int r1 = r8.f6029q     // Catch: i2.o -> L3a
            r2 = -1
            if (r1 == r2) goto L26
            android.content.Context r2 = r8.f6002a     // Catch: i2.o -> L1c
            if (r2 == 0) goto L26
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: i2.o -> L1c
            r4 = 34
            if (r3 < r4) goto L26
            android.content.Context r0 = r8.f6023l0     // Catch: i2.o -> L1c
            if (r0 != 0) goto L20
            android.content.Context r0 = c.a.g(r2, r1)     // Catch: i2.o -> L1c
            r8.f6023l0 = r0     // Catch: i2.o -> L1c
            goto L20
        L1c:
            r0 = move-exception
            r9 = r0
            r2 = r8
            goto L3d
        L20:
            android.content.Context r0 = r8.f6023l0     // Catch: i2.o -> L1c
            r1 = 0
            r7 = r0
            r5 = r1
            goto L29
        L26:
            r1 = 0
            r5 = r0
            r7 = r1
        L29:
            i2.m r3 = r9.a()     // Catch: i2.o -> L3a
            v1.c r4 = r8.A     // Catch: i2.o -> L3a
            v1.p r6 = r9.f6149a     // Catch: i2.o -> L3a
            r2 = r8
            android.media.AudioTrack r9 = r2.b(r3, r4, r5, r6, r7)     // Catch: i2.o -> L37
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
            i2.p r0 = r2.f6031s
            if (r0 == 0) goto L44
            r0.q(r9)
        L44:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.f0.c(i2.y):android.media.AudioTrack");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(v1.p r26, int[] r27) throws i2.n {
        /*
            Method dump skipped, instruction units count: 702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.f0.d(v1.p, int[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(long r13) throws i2.r {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.f0.e(long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0044 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f() throws i2.r {
        /*
            r6 = this;
            w1.e r0 = r6.f6034v
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
            w1.e r0 = r6.f6034v
            boolean r5 = r0.d()
            if (r5 == 0) goto L2e
            boolean r5 = r0.f13789d
            if (r5 == 0) goto L21
            goto L2e
        L21:
            r0.f13789d = r4
            java.util.ArrayList r0 = r0.f13787b
            java.lang.Object r0 = r0.get(r3)
            w1.h r0 = (w1.h) r0
            r0.d()
        L2e:
            r6.x(r1)
            w1.e r0 = r6.f6034v
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
        throw new UnsupportedOperationException("Method not decompiled: i2.f0.f():boolean");
    }

    public final void g() {
        androidx.emoji2.text.v vVar;
        if (q()) {
            this.H = 0L;
            this.I = 0L;
            this.J = 0L;
            this.K = 0L;
            this.f6014g0 = false;
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
            this.f6008d.f6092o = 0L;
            w1.e eVar = this.f6033u.i;
            this.f6034v = eVar;
            eVar.a();
            AudioTrack audioTrack = this.f6015h.f6120c;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 3) {
                this.f6035w.pause();
            }
            if (r(this.f6035w)) {
                androidx.emoji2.text.v vVar2 = this.f6020k;
                vVar2.getClass();
                this.f6035w.unregisterStreamEventCallback((e0) vVar2.f889x);
                ((Handler) vVar2.f888w).removeCallbacksAndMessages(null);
            }
            m mVarA = this.f6033u.a();
            y yVar = this.f6032t;
            if (yVar != null) {
                this.f6033u = yVar;
                this.f6032t = null;
            }
            v vVar3 = this.f6015h;
            vVar3.f();
            vVar3.f6120c = null;
            vVar3.f6122e = null;
            if (Build.VERSION.SDK_INT >= 24 && (vVar = this.f6038z) != null) {
                AudioTrack audioTrack2 = (AudioTrack) vVar.f888w;
                b0 b0Var = (b0) vVar.f890y;
                b0Var.getClass();
                audioTrack2.removeOnRoutingChangedListener(b0Var);
                vVar.f890y = null;
                this.f6038z = null;
            }
            AudioTrack audioTrack3 = this.f6035w;
            p pVar = this.f6031s;
            Handler handler = new Handler(Looper.myLooper());
            synchronized (f6000n0) {
                try {
                    if (o0 == null) {
                        int i = y1.a0.f14551a;
                        o0 = Executors.newSingleThreadScheduledExecutor(new y1.z());
                    }
                    f6001p0++;
                    o0.schedule(new c8.a(audioTrack3, pVar, handler, mVarA, 2), 20L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.f6035w = null;
        }
        c0 c0Var = this.f6024m;
        c0Var.f5984c = null;
        c0Var.f5982a = -9223372036854775807L;
        c0Var.f5983b = -9223372036854775807L;
        c0 c0Var2 = this.f6022l;
        c0Var2.f5984c = null;
        c0Var2.f5982a = -9223372036854775807L;
        c0Var2.f5983b = -9223372036854775807L;
        this.f6017i0 = 0L;
        this.f6019j0 = 0L;
        Handler handler2 = this.f6021k0;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    public final long h() {
        if (!q()) {
            return -9223372036854775807L;
        }
        AudioTrack audioTrack = this.f6035w;
        y yVar = this.f6033u;
        if (yVar.f6151c == 0) {
            return y1.a0.U(yVar.f6153e, audioTrack.getBufferSizeInFrames());
        }
        long bufferSizeInFrames = audioTrack.getBufferSizeInFrames();
        int i = a3.b.i(yVar.f6154g);
        y1.d.g(i != -2147483647);
        return y1.a0.W(bufferSizeInFrames, 1000000L, i, RoundingMode.DOWN);
    }

    public final long i() {
        ArrayDeque arrayDeque;
        long j4;
        if (!q() || this.N) {
            return Long.MIN_VALUE;
        }
        long jMin = Math.min(this.f6015h.a(), y1.a0.U(this.f6033u.f6153e, m()));
        while (true) {
            arrayDeque = this.i;
            if (arrayDeque.isEmpty() || jMin < ((z) arrayDeque.getFirst()).f6161c) {
                break;
            }
            this.C = (z) arrayDeque.remove();
        }
        z zVar = this.C;
        long jW = jMin - zVar.f6161c;
        long jX = y1.a0.x(jW, zVar.f6159a.f12968a);
        boolean zIsEmpty = arrayDeque.isEmpty();
        androidx.emoji2.text.v vVar = this.f6004b;
        if (zIsEmpty) {
            w1.k kVar = (w1.k) vVar.f890y;
            if (kVar.a()) {
                if (kVar.f13834o >= 1024) {
                    long j7 = kVar.f13833n;
                    w1.j jVar = kVar.f13829j;
                    jVar.getClass();
                    long j10 = j7 - ((long) ((jVar.f13810k * jVar.f13803b) * 2));
                    int i = kVar.f13828h.f13791a;
                    int i10 = kVar.f13827g.f13791a;
                    jW = i == i10 ? y1.a0.W(jW, j10, kVar.f13834o, RoundingMode.DOWN) : y1.a0.W(jW, j10 * ((long) i), kVar.f13834o * ((long) i10), RoundingMode.DOWN);
                } else {
                    jW = (long) (((double) kVar.f13824c) * jW);
                }
            }
            z zVar2 = this.C;
            j4 = zVar2.f6160b + jW;
            zVar2.f6162d = jW - jX;
        } else {
            z zVar3 = this.C;
            j4 = zVar3.f6160b + jX + zVar3.f6162d;
        }
        long j11 = ((j0) vVar.f889x).f6079q;
        long jU = y1.a0.U(this.f6033u.f6153e, j11) + j4;
        long j12 = this.f6017i0;
        if (j11 > j12) {
            long jU2 = y1.a0.U(this.f6033u.f6153e, j11 - j12);
            this.f6017i0 = j11;
            this.f6019j0 += jU2;
            if (this.f6021k0 == null) {
                this.f6021k0 = new Handler(Looper.myLooper());
            }
            this.f6021k0.removeCallbacksAndMessages(null);
            this.f6021k0.postDelayed(new androidx.emoji2.text.w(15, this), 100L);
        }
        return jU;
    }

    public final h j(v1.p pVar) {
        boolean zBooleanValue;
        if (this.f6012f0) {
            return h.f6044d;
        }
        v1.c cVar = this.A;
        k kVar = this.f6027o;
        kVar.getClass();
        pVar.getClass();
        int i = pVar.G;
        cVar.getClass();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 29 || i == -1) {
            return h.f6044d;
        }
        Context context = (Context) kVar.f6085v;
        Boolean bool = (Boolean) kVar.f6086w;
        boolean z10 = false;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        } else {
            if (context != null) {
                String parameters = w1.d.g(context).getParameters("offloadVariableRateSupported");
                kVar.f6086w = Boolean.valueOf(parameters != null && parameters.equals("offloadVariableRateSupported=1"));
            } else {
                kVar.f6086w = Boolean.FALSE;
            }
            zBooleanValue = ((Boolean) kVar.f6086w).booleanValue();
        }
        String str = pVar.f12946n;
        str.getClass();
        int iD = m0.d(str, pVar.f12943k);
        if (iD == 0 || i10 < y1.a0.p(iD)) {
            return h.f6044d;
        }
        int iQ = y1.a0.q(pVar.F);
        if (iQ == 0) {
            return h.f6044d;
        }
        try {
            AudioFormat audioFormatBuild = new AudioFormat.Builder().setSampleRate(i).setChannelMask(iQ).setEncoding(iD).build();
            if (i10 < 31) {
                if (!AudioManager.isOffloadedPlaybackSupported(audioFormatBuild, (AudioAttributes) cVar.b().f12977a)) {
                    return h.f6044d;
                }
                g gVar = new g();
                gVar.f6039a = true;
                gVar.f6041c = zBooleanValue;
                return gVar.a();
            }
            int playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(audioFormatBuild, (AudioAttributes) cVar.b().f12977a);
            if (playbackOffloadSupport == 0) {
                return h.f6044d;
            }
            g gVar2 = new g();
            if (i10 > 32 && playbackOffloadSupport == 2) {
                z10 = true;
            }
            gVar2.f6039a = true;
            gVar2.f6040b = z10;
            gVar2.f6041c = zBooleanValue;
            return gVar2.a();
        } catch (IllegalArgumentException unused) {
            return h.f6044d;
        }
    }

    public final int k(v1.p pVar) {
        s();
        String str = pVar.f12946n;
        int i = pVar.H;
        if ("audio/raw".equals(str)) {
            if (!y1.a0.J(i)) {
                l0.e.p(i, "Invalid PCM encoding: ", "DefaultAudioSink");
                return 0;
            }
            if (i != 2) {
                return 1;
            }
        } else if (this.f6036x.d(pVar, this.A) == null) {
            return 0;
        }
        return 2;
    }

    public final long l() {
        y yVar = this.f6033u;
        return yVar.f6151c == 0 ? this.H / ((long) yVar.f6150b) : this.I;
    }

    public final long m() {
        y yVar = this.f6033u;
        if (yVar.f6151c != 0) {
            return this.K;
        }
        long j4 = this.J;
        long j7 = yVar.f6152d;
        int i = y1.a0.f14551a;
        return ((j4 + j7) - 1) / j7;
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
    public final boolean n(long r28, int r30, java.nio.ByteBuffer r31) throws i2.o, i2.r {
        /*
            Method dump skipped, instruction units count: 1214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.f0.n(long, int, java.nio.ByteBuffer):boolean");
    }

    public final boolean o() {
        if (!q()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 29 && this.f6035w.isOffloadedPlayback() && this.V) {
            return false;
        }
        long jM = m();
        v vVar = this.f6015h;
        long jA = vVar.a();
        int i = vVar.f;
        int i10 = y1.a0.f14551a;
        return jM > y1.a0.W(jA, (long) i, 1000000L, RoundingMode.UP);
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p() throws i2.o {
        /*
            Method dump skipped, instruction units count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.f0.p():boolean");
    }

    public final boolean q() {
        return this.f6035w != null;
    }

    public final void s() {
        Context context;
        c cVar;
        Looper looperMyLooper = Looper.myLooper();
        boolean z10 = this.f6037y == null || this.f6016h0 == looperMyLooper;
        StringBuilder sb = new StringBuilder("DefaultAudioSink accessed on multiple threads: ");
        Looper looper = this.f6016h0;
        sb.append(looper == null ? "null" : looper.getThread().getName());
        sb.append(" and ");
        sb.append(looperMyLooper != null ? looperMyLooper.getThread().getName() : "null");
        y1.d.f(sb.toString(), z10);
        if (this.f6037y == null && (context = this.f6002a) != null) {
            this.f6016h0 = looperMyLooper;
            f fVar = new f(context, new f1(21, this), this.A, this.f6005b0);
            this.f6037y = fVar;
            Handler handler = (Handler) fVar.f5995d;
            Context context2 = (Context) fVar.f5993b;
            if (fVar.f5992a) {
                cVar = (c) fVar.f5998h;
                cVar.getClass();
            } else {
                fVar.f5992a = true;
                e eVar = (e) fVar.f5997g;
                if (eVar != null) {
                    eVar.f5988a.registerContentObserver(eVar.f5989b, false, eVar);
                }
                d dVar = (d) fVar.f5996e;
                if (dVar != null) {
                    w1.d.g(context2).registerAudioDeviceCallback(dVar, handler);
                }
                c cVarB = c.b(context2, context2.registerReceiver((com.bumptech.glide.manager.r) fVar.f, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), null, handler), (v1.c) fVar.f5999j, (p6.d) fVar.i);
                fVar.f5998h = cVarB;
                cVar = cVarB;
            }
            this.f6036x = cVar;
        }
        this.f6036x.getClass();
    }

    public final void t() {
        this.W = false;
        if (q()) {
            v vVar = this.f6015h;
            vVar.f();
            if (vVar.f6139x == -9223372036854775807L) {
                u uVar = vVar.f6122e;
                uVar.getClass();
                uVar.a(0);
            }
            vVar.f6141z = vVar.b();
            if (!this.U || r(this.f6035w)) {
                this.f6035w.pause();
            }
        }
    }

    public final void u() {
        this.W = true;
        if (q()) {
            v vVar = this.f6015h;
            if (vVar.f6139x != -9223372036854775807L) {
                vVar.G.getClass();
                vVar.f6139x = y1.a0.O(SystemClock.elapsedRealtime());
            }
            vVar.f6125j = y1.a0.U(vVar.f, vVar.b());
            u uVar = vVar.f6122e;
            uVar.getClass();
            uVar.a(0);
            if (!this.U || r(this.f6035w)) {
                this.f6035w.play();
            }
        }
    }

    public final void v() {
        if (this.U) {
            return;
        }
        this.U = true;
        long jM = m();
        v vVar = this.f6015h;
        vVar.f6141z = vVar.b();
        vVar.G.getClass();
        vVar.f6139x = y1.a0.O(SystemClock.elapsedRealtime());
        vVar.A = jM;
        if (r(this.f6035w)) {
            this.V = false;
        }
        this.f6035w.stop();
        this.G = 0;
    }

    public final void w() {
        if (!this.T && q() && f()) {
            v();
            this.T = true;
        }
    }

    public final void x(long j4) throws r {
        ByteBuffer byteBuffer;
        e(j4);
        if (this.S != null) {
            return;
        }
        if (!this.f6034v.d()) {
            ByteBuffer byteBuffer2 = this.Q;
            if (byteBuffer2 != null) {
                D(byteBuffer2);
                e(j4);
                return;
            }
            return;
        }
        while (!this.f6034v.c()) {
            do {
                w1.e eVar = this.f6034v;
                if (eVar.d()) {
                    ByteBuffer byteBuffer3 = eVar.f13788c[eVar.b()];
                    if (byteBuffer3.hasRemaining()) {
                        byteBuffer = byteBuffer3;
                    } else {
                        eVar.e(w1.h.f13795a);
                        byteBuffer = eVar.f13788c[eVar.b()];
                    }
                } else {
                    byteBuffer = w1.h.f13795a;
                }
                if (byteBuffer.hasRemaining()) {
                    D(byteBuffer);
                    e(j4);
                } else {
                    ByteBuffer byteBuffer4 = this.Q;
                    if (byteBuffer4 == null || !byteBuffer4.hasRemaining()) {
                        return;
                    }
                    w1.e eVar2 = this.f6034v;
                    ByteBuffer byteBuffer5 = this.Q;
                    if (eVar2.d() && !eVar2.f13789d) {
                        eVar2.e(byteBuffer5);
                    }
                }
            } while (this.S == null);
            return;
        }
    }

    public final void y() {
        g();
        ua.g0 g0VarM = this.f6013g.listIterator(0);
        while (g0VarM.hasNext()) {
            ((w1.h) g0VarM.next()).reset();
        }
        this.f6010e.reset();
        this.f.reset();
        w1.e eVar = this.f6034v;
        if (eVar != null) {
            ua.i0 i0Var = eVar.f13786a;
            for (int i = 0; i < i0Var.size(); i++) {
                w1.h hVar = (w1.h) i0Var.get(i);
                hVar.flush();
                hVar.reset();
            }
            eVar.f13788c = new ByteBuffer[0];
            w1.f fVar = w1.f.f13790e;
            eVar.f13789d = false;
        }
        this.W = false;
        this.f6012f0 = false;
    }

    public final void z(v1.c cVar) {
        if (this.A.equals(cVar)) {
            return;
        }
        this.A = cVar;
        if (this.f6007c0) {
            return;
        }
        f fVar = this.f6037y;
        if (fVar != null) {
            fVar.f5999j = cVar;
            fVar.d(c.c((Context) fVar.f5993b, cVar, (p6.d) fVar.i));
        }
        g();
    }
}
