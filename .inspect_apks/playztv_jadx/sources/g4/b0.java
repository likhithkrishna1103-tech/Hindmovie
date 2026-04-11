package g4;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseBooleanArray;
import com.playz.tv.activities.PlayerActivity;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class b0 {
    public static final q1 B = new q1(1);
    public final Bundle A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4956a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f4957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f4958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x f4959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q9.e f4960e;
    public final PlayerActivity f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f1 f4961g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m0 f4962h;
    public final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final r1 f4963j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final u f4964k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Handler f4965l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final h4.z f4966m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final v f4967n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Handler f4968o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f4969p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f4970q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final aa.j0 f4971r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public h1 f4972s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public j1 f4973t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public z f4974u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f4975v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f4976w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f4977x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final aa.j0 f4978y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final aa.j0 f4979z;

    public b0(u uVar, PlayerActivity playerActivity, String str, p1.w0 w0Var, aa.j0 j0Var, aa.j0 j0Var2, aa.j0 j0Var3, q9.e eVar, Bundle bundle, Bundle bundle2, h4.z zVar) {
        s1.b.k("MediaSessionImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.8.0] [" + s1.b0.f11648b + "]");
        this.f4964k = uVar;
        this.f = playerActivity;
        this.i = str;
        this.f4978y = j0Var;
        this.f4979z = j0Var2;
        this.f4971r = j0Var3;
        this.f4960e = eVar;
        this.A = bundle2;
        this.f4966m = zVar;
        this.f4969p = true;
        this.f4970q = true;
        f1 f1Var = new f1(this);
        this.f4961g = f1Var;
        this.f4968o = new Handler(Looper.getMainLooper());
        Looper looperZ0 = w0Var.z0();
        Handler handler = new Handler(looperZ0);
        this.f4965l = handler;
        this.f4972s = h1.F;
        this.f4958c = new y(this, looperZ0);
        this.f4959d = new x(this, looperZ0);
        Uri uriBuild = new Uri.Builder().scheme(b0.class.getName()).appendPath(str).appendPath(String.valueOf(SystemClock.elapsedRealtime())).build();
        this.f4957b = uriBuild;
        m0 m0Var = new m0(this, uriBuild, handler, bundle, j0Var, j0Var2, q.f5178e, q.f, bundle2);
        this.f4962h = m0Var;
        this.f4963j = new r1(Process.myUid(), playerActivity.getPackageName(), f1Var, bundle, ((h4.t) m0Var.f5118k.f5867v).f5849c.f5863v);
        j1 j1Var = new j1(w0Var);
        this.f4973t = j1Var;
        s1.b0.S(handler, new a2.g0(this, 17, j1Var));
        this.f4976w = 3000L;
        this.f4967n = new v(this, 2);
        s1.b0.S(handler, new v(this, 3));
    }

    public static void a(b0 b0Var) {
        synchronized (b0Var.f4956a) {
            try {
                if (b0Var.f4975v) {
                    return;
                }
                final p1 p1VarB = b0Var.f4973t.b();
                if (!b0Var.f4958c.hasMessages(1)) {
                    p1 p1Var = b0Var.f4972s.f5062c;
                    p1.v0 v0Var = p1VarB.f5170a;
                    int i = v0Var.f10081b;
                    p1.v0 v0Var2 = p1Var.f5170a;
                    if (i == v0Var2.f10081b && v0Var.f10084e == v0Var2.f10084e && v0Var.f10086h == v0Var2.f10086h && v0Var.i == v0Var2.i) {
                        ub.o oVar = b0Var.f4961g.f5006e;
                        aa.j0 j0VarW = oVar.w();
                        for (int i10 = 0; i10 < j0VarW.size(); i10++) {
                            final s sVar = (s) j0VarW.get(i10);
                            oVar.A(sVar);
                            final boolean zG = oVar.G(sVar, 16);
                            final boolean zG2 = oVar.G(sVar, 17);
                            b0Var.c(sVar, new a0() { // from class: g4.w
                                @Override // g4.a0
                                public final void b(r rVar, int i11) {
                                    rVar.d(i11, p1VarB, zG, zG2, sVar.f5201c);
                                }
                            });
                        }
                        try {
                            b0Var.f4962h.i.d(0, p1VarB, true, true, 0);
                        } catch (RemoteException e10) {
                            s1.b.h("MediaSessionImpl", "Exception in using media1 API", e10);
                        }
                    }
                }
                b0Var.t();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean k(s sVar) {
        return sVar != null && Objects.equals(sVar.f5199a.f5792a.f5793a, "com.android.systemui");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(android.view.KeyEvent r8, boolean r9, boolean r10) {
        /*
            r7 = this;
            g4.u r0 = r7.f4964k
            g4.b0 r0 = r0.f5228a
            g4.s r4 = r0.e()
            r4.getClass()
            int r8 = r8.getKeyCode()
            r0 = 85
            if (r8 == r0) goto L17
            r0 = 79
            if (r8 != r0) goto L1b
        L17:
            if (r9 == 0) goto L1b
            r8 = 87
        L1b:
            r9 = 126(0x7e, float:1.77E-43)
            if (r8 == r9) goto L72
            r9 = 127(0x7f, float:1.78E-43)
            if (r8 == r9) goto L6a
            r9 = 272(0x110, float:3.81E-43)
            if (r8 == r9) goto L63
            r9 = 273(0x111, float:3.83E-43)
            if (r8 == r9) goto L5c
            switch(r8) {
                case 85: goto L46;
                case 86: goto L3f;
                case 87: goto L63;
                case 88: goto L5c;
                case 89: goto L38;
                case 90: goto L30;
                default: goto L2e;
            }
        L2e:
            r8 = 0
            return r8
        L30:
            g4.b r8 = new g4.b
            r9 = 3
            r8.<init>(r7, r4, r9)
        L36:
            r5 = r8
            goto L7a
        L38:
            g4.b r8 = new g4.b
            r9 = 4
            r8.<init>(r7, r4, r9)
            goto L36
        L3f:
            g4.b r8 = new g4.b
            r9 = 5
            r8.<init>(r7, r4, r9)
            goto L36
        L46:
            g4.j1 r8 = r7.f4973t
            boolean r8 = r8.C()
            if (r8 == 0) goto L55
            g4.b r8 = new g4.b
            r9 = 6
            r8.<init>(r7, r4, r9)
            goto L36
        L55:
            g4.b r8 = new g4.b
            r9 = 7
            r8.<init>(r7, r4, r9)
            goto L36
        L5c:
            g4.b r8 = new g4.b
            r9 = 2
            r8.<init>(r7, r4, r9)
            goto L36
        L63:
            g4.b r8 = new g4.b
            r9 = 1
            r8.<init>(r7, r4, r9)
            goto L36
        L6a:
            g4.b r8 = new g4.b
            r9 = 9
            r8.<init>(r7, r4, r9)
            goto L36
        L72:
            g4.b r8 = new g4.b
            r9 = 8
            r8.<init>(r7, r4, r9)
            goto L36
        L7a:
            a2.i0 r1 = new a2.i0
            r6 = 1
            r2 = r7
            r3 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            android.os.Handler r8 = r2.f4965l
            s1.b0.S(r8, r1)
            r8 = 1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.b0.b(android.view.KeyEvent, boolean, boolean):boolean");
    }

    public final void c(s sVar, a0 a0Var) {
        int iC;
        f1 f1Var = this.f4961g;
        try {
            l1 l1VarC = f1Var.f5006e.C(sVar);
            if (l1VarC != null) {
                iC = l1VarC.c();
            } else if (!h(sVar)) {
                return;
            } else {
                iC = 0;
            }
            r rVar = sVar.f5202d;
            if (rVar != null) {
                a0Var.b(rVar, iC);
            }
        } catch (DeadObjectException unused) {
            f1Var.f5006e.P(sVar);
        } catch (RemoteException e10) {
            s1.b.q("MediaSessionImpl", "Exception in " + sVar, e10);
        }
    }

    public final void d(a0 a0Var) {
        aa.j0 j0VarW = this.f4961g.f5006e.w();
        for (int i = 0; i < j0VarW.size(); i++) {
            c((s) j0VarW.get(i), a0Var);
        }
        try {
            a0Var.b(this.f4962h.i, 0);
        } catch (RemoteException e10) {
            s1.b.h("MediaSessionImpl", "Exception in using media1 API", e10);
        }
    }

    public final s e() {
        aa.j0 j0VarW = this.f4961g.f5006e.w();
        for (int i = 0; i < j0VarW.size(); i++) {
            s sVar = (s) j0VarW.get(i);
            if (i(sVar)) {
                return sVar;
            }
        }
        return null;
    }

    public final void f(p1.s0 s0Var) {
        this.f4958c.a(false, false);
        d(new a2.f0(15, s0Var));
        try {
            k0 k0Var = this.f4962h.i;
            p1.j jVar = this.f4972s.f5074q;
            k0Var.n();
        } catch (RemoteException e10) {
            s1.b.h("MediaSessionImpl", "Exception in using media1 API", e10);
        }
    }

    public final void g(s sVar, boolean z2) {
        if (o()) {
            boolean z10 = this.f4973t.e0(16) && this.f4973t.F() != null;
            boolean z11 = this.f4973t.e0(31) || this.f4973t.e0(20);
            s sVarS = s(sVar);
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
            s1.d.g(!false);
            sparseBooleanArray.append(1, true);
            s1.d.g(!false);
            p1.s0 s0Var = new p1.s0(new p1.o(sparseBooleanArray));
            if (z10 || !z11) {
                if (!z10) {
                    s1.b.p("MediaSessionImpl", "Play requested without current MediaItem, but playback resumption prevented by missing available commands");
                }
                s1.b0.F(this.f4973t);
                if (z2) {
                    p(sVarS);
                    return;
                }
                return;
            }
            this.f4960e.getClass();
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            ea.u uVar = new ea.u();
            uVar.l(unsupportedOperationException);
            uVar.f(new ea.t(uVar, 0, new com.bumptech.glide.manager.s(this, sVarS, z2, s0Var)), new c2.c0(1, this));
        }
    }

    public final boolean h(s sVar) {
        return this.f4961g.f5006e.F(sVar) || this.f4962h.f.F(sVar);
    }

    public final boolean i(s sVar) {
        return Objects.equals(sVar.f5199a.f5792a.f5793a, this.f.getPackageName()) && sVar.f5200b != 0 && new Bundle(sVar.f5203e).getBoolean("androidx.media3.session.MediaNotificationManager", false);
    }

    public final boolean j() {
        boolean z2;
        synchronized (this.f4956a) {
            z2 = this.f4975v;
        }
        return z2;
    }

    public final ea.y l(s sVar, List list) {
        s(sVar);
        this.f4960e.getClass();
        return q9.e.m(list);
    }

    public final q m(s sVar) {
        boolean z2 = this.f4977x;
        m0 m0Var = this.f4962h;
        if (z2 && k(sVar)) {
            m0Var.getClass();
            n1 n1Var = q.f5178e;
            n1 n1Var2 = m0Var.f5128u;
            n1Var2.getClass();
            p1.s0 s0Var = m0Var.f5129v;
            s0Var.getClass();
            aa.j0 j0Var = m0Var.f5126s;
            aa.j0 j0VarR = j0Var == null ? null : aa.j0.r(j0Var);
            aa.j0 j0Var2 = m0Var.f5127t;
            return new q(n1Var2, s0Var, j0VarR, j0Var2 != null ? aa.j0.r(j0Var2) : null);
        }
        this.f4960e.getClass();
        p1.s0 s0Var2 = q.f;
        n1 n1Var3 = q.f5178e;
        q qVar = new q(n1Var3, s0Var2, null, null);
        if (i(sVar)) {
            this.f4977x = true;
            u uVar = this.f4964k;
            aa.j0 j0Var3 = uVar.f5228a.f4979z;
            int i = 0;
            if (j0Var3.isEmpty()) {
                m0Var.f5126s = uVar.f5228a.f4978y;
            } else {
                m0Var.f5127t = j0Var3;
                Bundle bundle = m0Var.f5125r;
                boolean z10 = bundle.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", false);
                boolean z11 = bundle.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", false);
                m0Var.M();
                if (bundle.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", false) != z10 || bundle.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", false) != z11) {
                    ((h4.t) m0Var.f5118k.f5867v).f5847a.setExtras(bundle);
                }
            }
            b0 b0Var = m0Var.f5115g;
            Bundle bundle2 = m0Var.f5125r;
            boolean z12 = m0Var.f5129v.a(17) != s0Var2.a(17);
            m0Var.f5128u = n1Var3;
            m0Var.f5129v = s0Var2;
            if (!m0Var.f5127t.isEmpty()) {
                boolean z13 = bundle2.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", false);
                boolean z14 = bundle2.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", false);
                m0Var.M();
                if (bundle2.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", false) != z13 || bundle2.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", false) != z14) {
                    ((h4.t) m0Var.f5118k.f5867v).f5847a.setExtras(bundle2);
                }
            }
            if (z12) {
                s1.b0.S(b0Var.f4965l, new f0(m0Var, b0Var.f4973t, i));
                return qVar;
            }
            m0Var.N(b0Var.f4973t);
        }
        return qVar;
    }

    public final ea.v n(s sVar) {
        s(sVar);
        this.f4960e.getClass();
        return b8.h.r(new q1(-6));
    }

    public final boolean o() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        ea.e0 e0Var = new ea.e0();
        this.f4968o.post(new a2.g0(this, 16, e0Var));
        try {
            return ((Boolean) e0Var.get()).booleanValue();
        } catch (InterruptedException | ExecutionException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public final void p(s sVar) {
        s(sVar);
        this.f4960e.getClass();
    }

    public final ea.e0 q(s sVar, List list, final int i, final long j5) {
        s(sVar);
        this.f4960e.getClass();
        return s1.b0.a0(q9.e.m(list), new ea.q() { // from class: g4.p
            @Override // ea.q, j7.e
            public final ea.y apply(Object obj) {
                return b8.h.r(new t((List) obj, i, j5));
            }
        });
    }

    public final void r() {
        s1.b.k("MediaSessionImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.8.0] [" + s1.b0.f11648b + "] [" + p1.h0.b() + "]");
        synchronized (this.f4956a) {
            try {
                if (this.f4975v) {
                    return;
                }
                this.f4975v = true;
                x xVar = this.f4959d;
                a2.g1 g1Var = xVar.f5244a;
                if (g1Var != null) {
                    xVar.removeCallbacks(g1Var);
                    xVar.f5244a = null;
                }
                this.f4965l.removeCallbacksAndMessages(null);
                try {
                    s1.b0.S(this.f4965l, new v(this, 0));
                } catch (Exception e10) {
                    s1.b.q("MediaSessionImpl", "Exception thrown while closing", e10);
                }
                m0 m0Var = this.f4962h;
                ComponentName componentName = m0Var.f5120m;
                b0 b0Var = m0Var.f5115g;
                h4.z zVar = m0Var.f5118k;
                int i = Build.VERSION.SDK_INT;
                int i10 = 0;
                if (i < 31) {
                    if (componentName == null) {
                        ((h4.t) zVar.f5867v).f5847a.setMediaButtonReceiver(null);
                    } else {
                        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON", b0Var.f4957b);
                        intent.setComponent(componentName);
                        ((h4.t) zVar.f5867v).f5847a.setMediaButtonReceiver(PendingIntent.getBroadcast(b0Var.f, 0, intent, m0.f5114w));
                    }
                }
                c2.e eVar = m0Var.f5119l;
                if (eVar != null) {
                    b0Var.f.unregisterReceiver(eVar);
                }
                h4.t tVar = (h4.t) zVar.f5867v;
                MediaSession mediaSession = tVar.f5847a;
                tVar.f.kill();
                if (i == 27) {
                    try {
                        Field declaredField = mediaSession.getClass().getDeclaredField("mCallback");
                        declaredField.setAccessible(true);
                        Handler handler = (Handler) declaredField.get(mediaSession);
                        if (handler != null) {
                            handler.removeCallbacksAndMessages(null);
                        }
                    } catch (Exception e11) {
                        Log.w("MediaSessionCompat", "Exception happened while accessing MediaSession.mCallback.", e11);
                    }
                }
                mediaSession.setCallback(null);
                tVar.f5848b.f5846d.clear();
                mediaSession.release();
                f1 f1Var = this.f4961g;
                Set set = f1Var.f;
                ub.o oVar = f1Var.f5006e;
                aa.j0 j0VarW = oVar.w();
                int size = j0VarW.size();
                while (i10 < size) {
                    Object obj = j0VarW.get(i10);
                    i10++;
                    s sVar = (s) obj;
                    oVar.P(sVar);
                    r rVar = sVar.f5202d;
                    if (rVar != null) {
                        rVar.h();
                    }
                }
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    r rVar2 = ((s) it.next()).f5202d;
                    if (rVar2 != null) {
                        rVar2.h();
                    }
                }
                set.clear();
                f1Var.f5005d.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final s s(s sVar) {
        if (!this.f4977x || !k(sVar)) {
            return sVar;
        }
        s sVarE = e();
        sVarE.getClass();
        return sVarE;
    }

    public final void t() {
        Handler handler = this.f4965l;
        v vVar = this.f4967n;
        handler.removeCallbacks(vVar);
        if (this.f4970q) {
            long j5 = this.f4976w;
            if (j5 > 0) {
                if (this.f4973t.P() || this.f4973t.c()) {
                    handler.postDelayed(vVar, j5);
                }
            }
        }
    }

    public final void u() {
        if (Looper.myLooper() != this.f4965l.getLooper()) {
            throw new IllegalStateException("Player callback method is called from a wrong thread. See javadoc of MediaSession for details.");
        }
    }
}
