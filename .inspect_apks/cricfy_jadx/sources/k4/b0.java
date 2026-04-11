package k4;

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
import app.cricfy.tv.activities.PlayerActivity;
import com.google.android.gms.internal.measurement.i4;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class b0 {
    public static final o1 B = new o1(1);
    public final Bundle A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6907a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f6908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f6909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x f6910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f9.b0 f6911e;
    public final PlayerActivity f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d1 f6912g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l0 f6913h;
    public final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p1 f6914j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final u f6915k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Handler f6916l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final i2.k f6917m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final v f6918n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Handler f6919o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f6920p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f6921q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ua.i0 f6922r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public f1 f6923s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public h1 f6924t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public z f6925u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f6926v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f6927w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f6928x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ua.i0 f6929y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ua.i0 f6930z;

    public b0(u uVar, PlayerActivity playerActivity, String str, v1.w0 w0Var, ua.i0 i0Var, ua.i0 i0Var2, ua.i0 i0Var3, f9.b0 b0Var, Bundle bundle, Bundle bundle2, i2.k kVar) {
        y1.b.k("MediaSessionImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.8.0] [" + y1.a0.f14552b + "]");
        this.f6915k = uVar;
        this.f = playerActivity;
        this.i = str;
        this.f6929y = i0Var;
        this.f6930z = i0Var2;
        this.f6922r = i0Var3;
        this.f6911e = b0Var;
        this.A = bundle2;
        this.f6917m = kVar;
        this.f6920p = true;
        this.f6921q = true;
        d1 d1Var = new d1(this);
        this.f6912g = d1Var;
        this.f6919o = new Handler(Looper.getMainLooper());
        Looper looperY0 = w0Var.y0();
        Handler handler = new Handler(looperY0);
        this.f6916l = handler;
        this.f6923s = f1.F;
        this.f6909c = new y(this, looperY0);
        this.f6910d = new x(this, looperY0);
        Uri uriBuild = new Uri.Builder().scheme(b0.class.getName()).appendPath(str).appendPath(String.valueOf(SystemClock.elapsedRealtime())).build();
        this.f6908b = uriBuild;
        l0 l0Var = new l0(this, uriBuild, handler, bundle, i0Var, i0Var2, q.f7135e, q.f, bundle2);
        this.f6913h = l0Var;
        this.f6914j = new p1(Process.myUid(), playerActivity.getPackageName(), d1Var, bundle, ((l4.w) l0Var.f7063k.f7705w).f7767c.f7701w);
        h1 h1Var = new h1(w0Var);
        this.f6924t = h1Var;
        y1.a0.S(handler, new androidx.fragment.app.d(22, this, h1Var));
        this.f6927w = 3000L;
        this.f6918n = new v(this, 2);
        y1.a0.S(handler, new v(this, 3));
    }

    public static void a(b0 b0Var) {
        synchronized (b0Var.f6907a) {
            try {
                if (b0Var.f6926v) {
                    return;
                }
                final n1 n1VarC = b0Var.f6924t.C();
                if (!b0Var.f6909c.hasMessages(1)) {
                    n1 n1Var = b0Var.f6923s.f6973c;
                    v1.v0 v0Var = n1VarC.f7106a;
                    int i = v0Var.f13014b;
                    v1.v0 v0Var2 = n1Var.f7106a;
                    if (i == v0Var2.f13014b && v0Var.f13017e == v0Var2.f13017e && v0Var.f13019h == v0Var2.f13019h && v0Var.i == v0Var2.i) {
                        b6.f fVar = b0Var.f6912g.f6944e;
                        ua.i0 i0VarG = fVar.g();
                        for (int i10 = 0; i10 < i0VarG.size(); i10++) {
                            final s sVar = (s) i0VarG.get(i10);
                            fVar.i(sVar);
                            final boolean zM = fVar.m(sVar, 16);
                            final boolean zM2 = fVar.m(sVar, 17);
                            b0Var.c(sVar, new a0() { // from class: k4.w
                                @Override // k4.a0
                                public final void b(r rVar, int i11) {
                                    rVar.d(i11, n1VarC, zM, zM2, sVar.f7159c);
                                }
                            });
                        }
                        try {
                            b0Var.f6913h.i.d(0, n1VarC, true, true, 0);
                        } catch (RemoteException e9) {
                            y1.b.h("MediaSessionImpl", "Exception in using media1 API", e9);
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
        return sVar != null && Objects.equals(sVar.f7157a.f7710a.f7712a, "com.android.systemui");
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
            k4.u r0 = r7.f6915k
            k4.b0 r0 = r0.f7170a
            k4.s r4 = r0.e()
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
            k4.b r8 = new k4.b
            r9 = 3
            r8.<init>(r7, r4, r9)
        L36:
            r5 = r8
            goto L7a
        L38:
            k4.b r8 = new k4.b
            r9 = 4
            r8.<init>(r7, r4, r9)
            goto L36
        L3f:
            k4.b r8 = new k4.b
            r9 = 5
            r8.<init>(r7, r4, r9)
            goto L36
        L46:
            k4.h1 r8 = r7.f6924t
            boolean r8 = r8.w()
            if (r8 == 0) goto L55
            k4.b r8 = new k4.b
            r9 = 6
            r8.<init>(r7, r4, r9)
            goto L36
        L55:
            k4.b r8 = new k4.b
            r9 = 7
            r8.<init>(r7, r4, r9)
            goto L36
        L5c:
            k4.b r8 = new k4.b
            r9 = 2
            r8.<init>(r7, r4, r9)
            goto L36
        L63:
            k4.b r8 = new k4.b
            r9 = 1
            r8.<init>(r7, r4, r9)
            goto L36
        L6a:
            k4.b r8 = new k4.b
            r9 = 9
            r8.<init>(r7, r4, r9)
            goto L36
        L72:
            k4.b r8 = new k4.b
            r9 = 8
            r8.<init>(r7, r4, r9)
            goto L36
        L7a:
            g2.a0 r1 = new g2.a0
            r2 = 1
            r3 = r7
            r6 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            android.os.Handler r8 = r3.f6916l
            y1.a0.S(r8, r1)
            r8 = 1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.b0.b(android.view.KeyEvent, boolean, boolean):boolean");
    }

    public final void c(s sVar, a0 a0Var) {
        int iC;
        d1 d1Var = this.f6912g;
        try {
            j1 j1VarK = d1Var.f6944e.k(sVar);
            if (j1VarK != null) {
                iC = j1VarK.c();
            } else if (!h(sVar)) {
                return;
            } else {
                iC = 0;
            }
            r rVar = sVar.f7160d;
            if (rVar != null) {
                a0Var.b(rVar, iC);
            }
        } catch (DeadObjectException unused) {
            d1Var.f6944e.p(sVar);
        } catch (RemoteException e9) {
            y1.b.q("MediaSessionImpl", "Exception in " + sVar, e9);
        }
    }

    public final void d(a0 a0Var) {
        ua.i0 i0VarG = this.f6912g.f6944e.g();
        for (int i = 0; i < i0VarG.size(); i++) {
            c((s) i0VarG.get(i), a0Var);
        }
        try {
            a0Var.b(this.f6913h.i, 0);
        } catch (RemoteException e9) {
            y1.b.h("MediaSessionImpl", "Exception in using media1 API", e9);
        }
    }

    public final s e() {
        ua.i0 i0VarG = this.f6912g.f6944e.g();
        for (int i = 0; i < i0VarG.size(); i++) {
            s sVar = (s) i0VarG.get(i);
            if (i(sVar)) {
                return sVar;
            }
        }
        return null;
    }

    public final void f(v1.s0 s0Var) {
        this.f6909c.a(false, false);
        d(new androidx.fragment.app.f1(23, s0Var));
        try {
            b7.d dVar = this.f6913h.i;
            v1.i iVar = this.f6923s.f6985q;
            dVar.o();
        } catch (RemoteException e9) {
            y1.b.h("MediaSessionImpl", "Exception in using media1 API", e9);
        }
    }

    public final void g(s sVar, boolean z10) {
        if (o()) {
            boolean z11 = this.f6924t.Z(16) && this.f6924t.z() != null;
            boolean z12 = this.f6924t.Z(31) || this.f6924t.Z(20);
            s sVarS = s(sVar);
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
            y1.d.g(!false);
            sparseBooleanArray.append(1, true);
            y1.d.g(!false);
            v1.s0 s0Var = new v1.s0(new v1.n(sparseBooleanArray));
            if (z11 || !z12) {
                if (!z11) {
                    y1.b.p("MediaSessionImpl", "Play requested without current MediaItem, but playback resumption prevented by missing available commands");
                }
                y1.a0.F(this.f6924t);
                if (z10) {
                    p(sVarS);
                    return;
                }
                return;
            }
            this.f6911e.getClass();
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            ya.t tVar = new ya.t();
            tVar.l(unsupportedOperationException);
            tVar.h(new ya.s(0, tVar, new i4(this, sVarS, z10, s0Var)), new i2.d0(1, this));
        }
    }

    public final boolean h(s sVar) {
        return this.f6912g.f6944e.l(sVar) || this.f6913h.f.l(sVar);
    }

    public final boolean i(s sVar) {
        return Objects.equals(sVar.f7157a.f7710a.f7712a, this.f.getPackageName()) && sVar.f7158b != 0 && new Bundle(sVar.f7161e).getBoolean("androidx.media3.session.MediaNotificationManager", false);
    }

    public final boolean j() {
        boolean z10;
        synchronized (this.f6907a) {
            z10 = this.f6926v;
        }
        return z10;
    }

    public final ya.w l(s sVar, List list) {
        s(sVar);
        this.f6911e.getClass();
        return f9.b0.y(list);
    }

    public final q m(s sVar) {
        boolean z10 = this.f6928x;
        l0 l0Var = this.f6913h;
        if (z10 && k(sVar)) {
            l0Var.getClass();
            l1 l1Var = q.f7135e;
            l1 l1Var2 = l0Var.f7073u;
            l1Var2.getClass();
            v1.s0 s0Var = l0Var.f7074v;
            s0Var.getClass();
            ua.i0 i0Var = l0Var.f7071s;
            ua.i0 i0VarK = i0Var == null ? null : ua.i0.k(i0Var);
            ua.i0 i0Var2 = l0Var.f7072t;
            return new q(l1Var2, s0Var, i0VarK, i0Var2 != null ? ua.i0.k(i0Var2) : null);
        }
        this.f6911e.getClass();
        v1.s0 s0Var2 = q.f;
        l1 l1Var3 = q.f7135e;
        q qVar = new q(l1Var3, s0Var2, null, null);
        if (i(sVar)) {
            this.f6928x = true;
            u uVar = this.f6915k;
            ua.i0 i0Var3 = uVar.f7170a.f6930z;
            int i = 0;
            if (i0Var3.isEmpty()) {
                l0Var.f7071s = uVar.f7170a.f6929y;
            } else {
                l0Var.f7072t = i0Var3;
                Bundle bundle = l0Var.f7070r;
                boolean z11 = bundle.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", false);
                boolean z12 = bundle.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", false);
                l0Var.M();
                if (bundle.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", false) != z11 || bundle.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", false) != z12) {
                    ((l4.w) l0Var.f7063k.f7705w).f7765a.setExtras(bundle);
                }
            }
            b0 b0Var = l0Var.f7060g;
            Bundle bundle2 = l0Var.f7070r;
            boolean z13 = l0Var.f7074v.a(17) != s0Var2.a(17);
            l0Var.f7073u = l1Var3;
            l0Var.f7074v = s0Var2;
            if (!l0Var.f7072t.isEmpty()) {
                boolean z14 = bundle2.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", false);
                boolean z15 = bundle2.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", false);
                l0Var.M();
                if (bundle2.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", false) != z14 || bundle2.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", false) != z15) {
                    ((l4.w) l0Var.f7063k.f7705w).f7765a.setExtras(bundle2);
                }
            }
            if (z13) {
                y1.a0.S(b0Var.f6916l, new f0(l0Var, b0Var.f6924t, i));
                return qVar;
            }
            l0Var.N(b0Var.f6924t);
        }
        return qVar;
    }

    public final ya.u n(s sVar) {
        s(sVar);
        this.f6911e.getClass();
        return w1.d.l(new o1(-6));
    }

    public final boolean o() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        ya.c0 c0Var = new ya.c0();
        this.f6919o.post(new androidx.fragment.app.d(21, this, c0Var));
        try {
            return ((Boolean) c0Var.get()).booleanValue();
        } catch (InterruptedException | ExecutionException e9) {
            throw new IllegalStateException(e9);
        }
    }

    public final void p(s sVar) {
        s(sVar);
        this.f6911e.getClass();
    }

    public final ya.c0 q(s sVar, List list, final int i, final long j4) {
        s(sVar);
        this.f6911e.getClass();
        return y1.a0.a0(f9.b0.y(list), new ya.p() { // from class: k4.p
            @Override // ya.p
            public final ya.w apply(Object obj) {
                return w1.d.l(new t((List) obj, i, j4));
            }
        });
    }

    public final void r() {
        y1.b.k("MediaSessionImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.8.0] [" + y1.a0.f14552b + "] [" + v1.h0.b() + "]");
        synchronized (this.f6907a) {
            try {
                if (this.f6926v) {
                    return;
                }
                this.f6926v = true;
                x xVar = this.f6910d;
                androidx.emoji2.text.n nVar = xVar.f7189a;
                if (nVar != null) {
                    xVar.removeCallbacks(nVar);
                    xVar.f7189a = null;
                }
                this.f6916l.removeCallbacksAndMessages(null);
                try {
                    y1.a0.S(this.f6916l, new v(this, 0));
                } catch (Exception e9) {
                    y1.b.q("MediaSessionImpl", "Exception thrown while closing", e9);
                }
                l0 l0Var = this.f6913h;
                ComponentName componentName = l0Var.f7065m;
                b0 b0Var = l0Var.f7060g;
                l4.c0 c0Var = l0Var.f7063k;
                int i = Build.VERSION.SDK_INT;
                int i10 = 0;
                if (i < 31) {
                    if (componentName == null) {
                        ((l4.w) c0Var.f7705w).f7765a.setMediaButtonReceiver(null);
                    } else {
                        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON", b0Var.f6908b);
                        intent.setComponent(componentName);
                        ((l4.w) c0Var.f7705w).f7765a.setMediaButtonReceiver(PendingIntent.getBroadcast(b0Var.f, 0, intent, l0.f7059w));
                    }
                }
                com.bumptech.glide.manager.r rVar = l0Var.f7064l;
                if (rVar != null) {
                    b0Var.f.unregisterReceiver(rVar);
                }
                l4.w wVar = (l4.w) c0Var.f7705w;
                MediaSession mediaSession = wVar.f7765a;
                wVar.f.kill();
                if (i == 27) {
                    try {
                        Field declaredField = mediaSession.getClass().getDeclaredField("mCallback");
                        declaredField.setAccessible(true);
                        Handler handler = (Handler) declaredField.get(mediaSession);
                        if (handler != null) {
                            handler.removeCallbacksAndMessages(null);
                        }
                    } catch (Exception e10) {
                        Log.w("MediaSessionCompat", "Exception happened while accessing MediaSession.mCallback.", e10);
                    }
                }
                mediaSession.setCallback(null);
                wVar.f7766b.f7764d.clear();
                mediaSession.release();
                d1 d1Var = this.f6912g;
                Set set = d1Var.f;
                b6.f fVar = d1Var.f6944e;
                ua.i0 i0VarG = fVar.g();
                int size = i0VarG.size();
                while (i10 < size) {
                    Object obj = i0VarG.get(i10);
                    i10++;
                    s sVar = (s) obj;
                    fVar.p(sVar);
                    r rVar2 = sVar.f7160d;
                    if (rVar2 != null) {
                        rVar2.e();
                    }
                }
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    r rVar3 = ((s) it.next()).f7160d;
                    if (rVar3 != null) {
                        rVar3.e();
                    }
                }
                set.clear();
                d1Var.f6943d.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final s s(s sVar) {
        if (!this.f6928x || !k(sVar)) {
            return sVar;
        }
        s sVarE = e();
        sVarE.getClass();
        return sVarE;
    }

    public final void t() {
        Handler handler = this.f6916l;
        v vVar = this.f6918n;
        handler.removeCallbacks(vVar);
        if (this.f6921q) {
            long j4 = this.f6927w;
            if (j4 > 0) {
                if (this.f6924t.M() || this.f6924t.a()) {
                    handler.postDelayed(vVar, j4);
                }
            }
        }
    }

    public final void u() {
        if (Looper.myLooper() != this.f6916l.getLooper()) {
            throw new IllegalStateException("Player callback method is called from a wrong thread. See javadoc of MediaSession for details.");
        }
    }
}
