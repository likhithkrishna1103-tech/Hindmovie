package b7;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import b2.j;
import f9.q4;
import f9.r1;
import i2.d0;
import i2.k;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import k4.b0;
import k4.h1;
import k4.k1;
import k4.l;
import k4.l0;
import k4.n1;
import k4.o1;
import k4.v;
import l4.c0;
import l4.m;
import l4.w;
import v1.e1;
import v1.f1;
import v1.g0;
import v1.j0;
import v1.s0;
import y1.a0;
import ya.r;
import ya.s;
import ya.y;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements a, r, k4.r {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f1825v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f1826w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Serializable f1827x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f1828y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f1829z;

    public /* synthetic */ d(q4 q4Var) {
        this.f1829z = q4Var;
    }

    @Override // ya.r
    public void a(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        l0 l0Var = (l0) ((d) this.f1829z).f1829z;
        if (this != l0Var.f7068p) {
            return;
        }
        l0.E(l0Var.f7063k, l.b((j0) this.f1826w, (String) this.f1827x, (Uri) this.f1828y, this.f1825v, bitmap));
        b0 b0Var = l0Var.f7060g;
        a0.S(b0Var.f6919o, new v(b0Var, 1));
    }

    @Override // k4.r
    public void b(int i, k1 k1Var) {
        Bundle bundle = Bundle.EMPTY;
        c0 c0Var = ((l0) this.f1829z).f7063k;
        String str = k1Var.f7056b;
        c0Var.getClass();
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("event cannot be null or empty");
        }
        ((w) c0Var.f7705w).f7765a.sendSessionEvent(str, bundle);
    }

    @Override // k4.r
    public void d(int i, n1 n1Var, boolean z10, boolean z11, int i10) {
        l0 l0Var = (l0) this.f1829z;
        l0Var.N(l0Var.f7060g.f6924t);
    }

    @Override // b7.a
    public File f(x6.e eVar) {
        String strN = ((c0) this.f1826w).N(eVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strN + " for for Key: " + eVar);
        }
        try {
            m2.e eVarA = m().A(strN);
            if (eVarA != null) {
                return ((File[]) eVarA.f8050v)[0];
            }
            return null;
        } catch (IOException e9) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e9);
            return null;
        }
    }

    @Override // ya.r
    public void g(Throwable th) {
        if (this != ((l0) ((d) this.f1829z).f1829z).f7068p) {
            return;
        }
        y1.b.p("MediaSessionLegacyStub", "Failed to load bitmap: " + th.getMessage());
    }

    @Override // b7.a
    public void h(x6.e eVar, z6.e eVar2) {
        b bVarA;
        boolean z10;
        String strN = ((c0) this.f1826w).N(eVar);
        c0 c0Var = (c0) this.f1828y;
        synchronized (c0Var) {
            try {
                bVarA = (b) ((HashMap) c0Var.f7705w).get(strN);
                if (bVarA == null) {
                    bVarA = ((c) c0Var.f7706x).a();
                    ((HashMap) c0Var.f7705w).put(strN, bVarA);
                }
                bVarA.f1823b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        bVarA.f1822a.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strN + " for for Key: " + eVar);
            }
            try {
                u6.c cVarM = m();
                if (cVarM.A(strN) == null) {
                    com.bumptech.glide.l lVarS = cVarM.s(strN);
                    if (lVarS == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: ".concat(strN));
                    }
                    try {
                        if (((x6.b) eVar2.f15251a).m(eVar2.f15252b, lVarS.i(), (x6.h) eVar2.f15253c)) {
                            u6.c.a((u6.c) lVarS.f2225y, lVarS, true);
                            lVarS.f2222v = true;
                        }
                        if (!z10) {
                            try {
                                lVarS.c();
                            } catch (IOException unused) {
                            }
                        }
                    } finally {
                        if (!lVarS.f2222v) {
                            try {
                                lVarS.c();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                }
            } catch (IOException e9) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e9);
                }
            }
        } finally {
            ((c0) this.f1828y).T(strN);
        }
    }

    @Override // k4.r
    public void k(int i, s0 s0Var) {
        l0 l0Var = (l0) this.f1829z;
        h1 h1Var = l0Var.f7060g.f6924t;
        int i10 = h1Var.Z(20) ? 4 : 0;
        if (l0Var.f7069q != i10) {
            l0Var.f7069q = i10;
            ((w) l0Var.f7063k.f7705w).f7765a.setFlags(i10 | 3);
        }
        l0Var.N(h1Var);
    }

    public synchronized u6.c m() {
        try {
            if (((u6.c) this.f1829z) == null) {
                this.f1829z = u6.c.J((File) this.f1827x, this.f1825v);
            }
        } catch (Throwable th) {
            throw th;
        }
        return (u6.c) this.f1829z;
    }

    public void n(v1.c cVar) {
        l0 l0Var = (l0) this.f1829z;
        l0Var.f7060g.f6924t.c0().getClass();
        int iE = l.e(cVar);
        w wVar = (w) l0Var.f7063k.f7705w;
        wVar.getClass();
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setLegacyStreamType(iE);
        wVar.f7765a.setPlaybackToLocal(builder.build());
    }

    public void o() {
        l0 l0Var = (l0) this.f1829z;
        h1 h1Var = l0Var.f7060g.f6924t;
        h1Var.c0().getClass();
        int iE = l.e(h1Var.Z(21) ? h1Var.W() : v1.c.f12586h);
        w wVar = (w) l0Var.f7063k.f7705w;
        wVar.getClass();
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setLegacyStreamType(iE);
        wVar.f7765a.setPlaybackToLocal(builder.build());
    }

    public void p(g0 g0Var) {
        l0 l0Var = (l0) this.f1829z;
        c0 c0Var = l0Var.f7063k;
        v();
        if (g0Var == null) {
            ((w) c0Var.f7705w).f7765a.setRatingType(0);
        } else {
            ((w) c0Var.f7705w).f7765a.setRatingType(l.f(g0Var.f12699d.i));
        }
        l0Var.N(l0Var.f7060g.f6924t);
    }

    public void q(int i, h1 h1Var) {
        l0 l0Var = (l0) this.f1829z;
        u(h1Var.f0());
        r(h1Var.Z(18) ? h1Var.L() : j0.K);
        h1Var.A0();
        v();
        t(h1Var.C0());
        s(h1Var.u0());
        h1Var.c0();
        o();
        int i10 = h1Var.Z(20) ? 4 : 0;
        if (l0Var.f7069q != i10) {
            l0Var.f7069q = i10;
            ((w) l0Var.f7063k.f7705w).f7765a.setFlags(i10 | 3);
        }
        p(h1Var.a0());
    }

    public void r(j0 j0Var) {
        l0 l0Var = (l0) this.f1829z;
        c0 c0Var = l0Var.f7063k;
        CharSequence queueTitle = ((m) ((p6.d) c0Var.f7706x).f10037w).f7741a.getQueueTitle();
        CharSequence charSequence = j0Var.f12765a;
        if (TextUtils.equals(queueTitle, charSequence)) {
            return;
        }
        h1 h1Var = l0Var.f7060g.f6924t;
        if (!l0Var.f7074v.a(17) || !h1Var.u().a(17)) {
            charSequence = null;
        }
        ((w) c0Var.f7705w).f7765a.setQueueTitle(charSequence);
    }

    public void s(int i) {
        c0 c0Var = ((l0) this.f1829z).f7063k;
        int i10 = l.f7058a;
        int i11 = 0;
        if (i != 0) {
            if (i == 1) {
                i11 = 1;
            } else if (i != 2) {
                y1.b.p("LegacyConversions", "Unrecognized RepeatMode: " + i + " was converted to `PlaybackStateCompat.REPEAT_MODE_NONE`");
            } else {
                i11 = 2;
            }
        }
        w wVar = (w) c0Var.f7705w;
        if (wVar.f7772j != i11) {
            wVar.f7772j = i11;
            synchronized (wVar.f7768d) {
                for (int iBeginBroadcast = wVar.f.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                    try {
                        ((l4.g) wVar.f.getBroadcastItem(iBeginBroadcast)).c(i11);
                    } catch (RemoteException | SecurityException e9) {
                        Log.e("MediaSessionCompat", "Dead object in setRepeatMode.", e9);
                    }
                }
                wVar.f.finishBroadcast();
            }
        }
    }

    public void t(boolean z10) {
        c0 c0Var = ((l0) this.f1829z).f7063k;
        int i = l.f7058a;
        w wVar = (w) c0Var.f7705w;
        if (wVar.f7773k != z10) {
            wVar.f7773k = z10 ? 1 : 0;
            synchronized (wVar.f7768d) {
                for (int iBeginBroadcast = wVar.f.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                    try {
                        ((l4.g) wVar.f.getBroadcastItem(iBeginBroadcast)).y(z10 ? 1 : 0);
                    } catch (RemoteException | SecurityException e9) {
                        Log.e("MediaSessionCompat", "Dead object in setShuffleMode.", e9);
                    }
                }
                wVar.f.finishBroadcast();
            }
        }
    }

    public void u(f1 f1Var) {
        w(f1Var);
        v();
    }

    public void v() {
        ya.w wVarF;
        Uri uri;
        Bitmap bitmap;
        Uri uri2;
        l0 l0Var = (l0) this.f1829z;
        b0 b0Var = l0Var.f7060g;
        h1 h1Var = b0Var.f6924t;
        g0 g0VarA0 = h1Var.a0();
        j0 j0VarA0 = h1Var.A0();
        long duration = -9223372036854775807L;
        if ((!h1Var.Z(16) || !h1Var.X0()) && h1Var.Z(16)) {
            duration = h1Var.getDuration();
        }
        String str = g0VarA0 != null ? g0VarA0.f12696a : "";
        Uri uri3 = (g0VarA0 == null || (uri2 = g0VarA0.f.f12625a) == null) ? null : uri2;
        if (Objects.equals((j0) this.f1826w, j0VarA0) && Objects.equals((String) this.f1827x, str) && Objects.equals((Uri) this.f1828y, uri3) && this.f1825v == duration) {
            return;
        }
        this.f1827x = str;
        this.f1828y = uri3;
        this.f1826w = j0VarA0;
        this.f1825v = duration;
        k kVar = b0Var.f6917m;
        kVar.getClass();
        byte[] bArr = j0VarA0.f12773k;
        if (bArr != null) {
            wVarF = kVar.f(bArr);
        } else {
            Uri uri4 = j0VarA0.f12775m;
            if (uri4 != null) {
                androidx.emoji2.text.v vVar = (androidx.emoji2.text.v) kVar.f6086w;
                if (vVar == null || (uri = (Uri) vVar.f889x) == null || !uri.equals(uri4)) {
                    b2.k kVar2 = (b2.k) kVar.f6085v;
                    ya.w wVarA = ((y) kVar2.f1697a).a(new j(1, kVar2, uri4));
                    kVar.f6086w = new androidx.emoji2.text.v(uri4, wVarA);
                    wVarF = wVarA;
                } else {
                    wVarF = (ya.w) ((androidx.emoji2.text.v) kVar.f6086w).f890y;
                    y1.d.h(wVarF);
                }
            } else {
                wVarF = null;
            }
        }
        if (wVarF != null) {
            l0Var.f7068p = null;
            if (wVarF.isDone()) {
                try {
                    bitmap = (Bitmap) w1.d.i(wVarF);
                } catch (CancellationException | ExecutionException e9) {
                    y1.b.p("MediaSessionLegacyStub", "Failed to load bitmap: " + e9.getMessage());
                    bitmap = null;
                }
            } else {
                d dVar = new d();
                dVar.f1829z = this;
                dVar.f1826w = j0VarA0;
                dVar.f1827x = str;
                dVar.f1828y = uri3;
                dVar.f1825v = duration;
                l0Var.f7068p = dVar;
                Handler handler = b0Var.f6916l;
                Objects.requireNonNull(handler);
                wVarF.h(new s(0, wVarF, dVar), new d0(0, handler));
            }
            bitmap = null;
        } else {
            bitmap = null;
        }
        l0.E(l0Var.f7063k, l.b(j0VarA0, str, uri3, duration, bitmap));
    }

    public void w(f1 f1Var) {
        l0 l0Var = (l0) this.f1829z;
        b0 b0Var = l0Var.f7060g;
        h1 h1Var = b0Var.f6924t;
        if (!l0Var.f7074v.a(17) || !h1Var.u().a(17) || f1Var.p()) {
            l0.D(l0Var.f7063k, null);
            return;
        }
        int i = l.f7058a;
        ArrayList arrayList = new ArrayList();
        e1 e1Var = new e1();
        for (int i10 = 0; i10 < f1Var.o(); i10++) {
            arrayList.add(f1Var.m(i10, e1Var, 0L).f12645c);
        }
        ArrayList arrayList2 = new ArrayList();
        c8.a aVar = new c8.a(this, new AtomicInteger(0), arrayList, arrayList2, 4);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            byte[] bArr = ((g0) arrayList.get(i11)).f12699d.f12773k;
            if (bArr == null) {
                arrayList2.add(null);
                aVar.run();
            } else {
                ya.w wVarF = b0Var.f6917m.f(bArr);
                arrayList2.add(wVarF);
                Handler handler = b0Var.f6916l;
                Objects.requireNonNull(handler);
                wVarF.h(aVar, new d0(0, handler));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean x(long r11, com.google.android.gms.internal.measurement.b3 r13) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b7.d.x(long, com.google.android.gms.internal.measurement.b3):boolean");
    }

    public void y() {
        f9.f1 f1Var = (f9.f1) this.f1829z;
        f1Var.m1();
        ((r1) f1Var.f307w).F.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editorEdit = f1Var.q1().edit();
        editorEdit.remove((String) this.f1827x);
        editorEdit.remove((String) this.f1828y);
        editorEdit.putLong((String) this.f1826w, jCurrentTimeMillis);
        editorEdit.apply();
    }

    @Override // k4.r
    public void e() {
    }

    @Override // k4.r
    public /* synthetic */ void c(int i) {
    }

    @Override // k4.r
    public /* synthetic */ void j(int i, o1 o1Var) {
    }

    @Override // k4.r
    public /* synthetic */ void l(int i, k4.m mVar) {
    }

    @Override // k4.r
    public /* synthetic */ void i(int i, k4.f1 f1Var, s0 s0Var, boolean z10, boolean z11) {
    }
}
