package f2;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import cc.q0;
import com.google.android.gms.internal.measurement.k4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f4701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f4702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k4 f4703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final wb.c f4704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f4705e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap f4706g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final s1.i f4707h;
    public final k8.a0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b2.o f4708j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final z f4709k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final UUID f4710l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Looper f4711m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final q0 f4712n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4713o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4714p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public HandlerThread f4715q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a f4716r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public y1.b f4717s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public g f4718t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public byte[] f4719u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public byte[] f4720v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public r f4721w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public t f4722x;

    public c(UUID uuid, u uVar, k4 k4Var, wb.c cVar, List list, boolean z2, boolean z10, byte[] bArr, HashMap map, z zVar, Looper looper, k8.a0 a0Var, b2.o oVar) {
        this.f4710l = uuid;
        this.f4703c = k4Var;
        this.f4704d = cVar;
        this.f4702b = uVar;
        this.f4705e = z2;
        this.f = z10;
        if (bArr != null) {
            this.f4720v = bArr;
            this.f4701a = null;
        } else {
            list.getClass();
            this.f4701a = Collections.unmodifiableList(list);
        }
        this.f4706g = map;
        this.f4709k = zVar;
        this.f4707h = new s1.i();
        this.i = a0Var;
        this.f4708j = oVar;
        this.f4713o = 2;
        this.f4711m = looper;
        this.f4712n = new q0(this, looper, 1);
    }

    @Override // f2.h
    public final boolean a() {
        o();
        return this.f4705e;
    }

    @Override // f2.h
    public final void b(k kVar) {
        o();
        if (this.f4714p < 0) {
            s1.b.g("DefaultDrmSession", "Session reference count less than zero: " + this.f4714p);
            this.f4714p = 0;
        }
        if (kVar != null) {
            s1.i iVar = this.f4707h;
            synchronized (iVar.f11671u) {
                try {
                    ArrayList arrayList = new ArrayList(iVar.f11674x);
                    arrayList.add(kVar);
                    iVar.f11674x = Collections.unmodifiableList(arrayList);
                    Integer num = (Integer) iVar.f11672v.get(kVar);
                    if (num == null) {
                        HashSet hashSet = new HashSet(iVar.f11673w);
                        hashSet.add(kVar);
                        iVar.f11673w = Collections.unmodifiableSet(hashSet);
                    }
                    iVar.f11672v.put(kVar, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
                } finally {
                }
            }
        }
        int i = this.f4714p + 1;
        this.f4714p = i;
        if (i == 1) {
            s1.d.g(this.f4713o == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.f4715q = handlerThread;
            handlerThread.start();
            this.f4716r = new a(this, this.f4715q.getLooper());
            if (m()) {
                i(true);
            }
        } else if (kVar != null && j() && this.f4707h.b(kVar) == 1) {
            kVar.c(this.f4713o);
        }
        f fVar = (f) this.f4704d.f14088v;
        if (fVar.E != -9223372036854775807L) {
            fVar.H.remove(this);
            Handler handler = fVar.N;
            handler.getClass();
            handler.removeCallbacksAndMessages(this);
        }
    }

    @Override // f2.h
    public final void c(k kVar) {
        o();
        int i = this.f4714p;
        if (i <= 0) {
            s1.b.g("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i10 = i - 1;
        this.f4714p = i10;
        if (i10 == 0) {
            this.f4713o = 0;
            q0 q0Var = this.f4712n;
            int i11 = s1.b0.f11647a;
            q0Var.removeCallbacksAndMessages(null);
            a aVar = this.f4716r;
            synchronized (aVar) {
                aVar.removeCallbacksAndMessages(null);
                aVar.f4695a = true;
            }
            this.f4716r = null;
            this.f4715q.quit();
            this.f4715q = null;
            this.f4717s = null;
            this.f4718t = null;
            this.f4721w = null;
            this.f4722x = null;
            byte[] bArr = this.f4719u;
            if (bArr != null) {
                this.f4702b.c(bArr);
                this.f4719u = null;
            }
        }
        if (kVar != null) {
            this.f4707h.d(kVar);
            if (this.f4707h.b(kVar) == 0) {
                kVar.e();
            }
        }
        wb.c cVar = this.f4704d;
        int i12 = this.f4714p;
        f fVar = (f) cVar.f14088v;
        if (i12 == 1 && fVar.I > 0 && fVar.E != -9223372036854775807L) {
            fVar.H.add(this);
            Handler handler = fVar.N;
            handler.getClass();
            handler.postAtTime(new a2.a(14, this), this, SystemClock.uptimeMillis() + fVar.E);
        } else if (i12 == 0) {
            fVar.F.remove(this);
            if (fVar.K == this) {
                fVar.K = null;
            }
            if (fVar.L == this) {
                fVar.L = null;
            }
            k4 k4Var = fVar.B;
            HashSet hashSet = (HashSet) k4Var.f3070u;
            hashSet.remove(this);
            if (((c) k4Var.f3071v) == this) {
                k4Var.f3071v = null;
                if (!hashSet.isEmpty()) {
                    c cVar2 = (c) hashSet.iterator().next();
                    k4Var.f3071v = cVar2;
                    t tVarF = cVar2.f4702b.f();
                    cVar2.f4722x = tVarF;
                    a aVar2 = cVar2.f4716r;
                    int i13 = s1.b0.f11647a;
                    tVarF.getClass();
                    aVar2.getClass();
                    aVar2.obtainMessage(1, new b(o2.u.f9216b.getAndIncrement(), true, SystemClock.elapsedRealtime(), tVarF)).sendToTarget();
                }
            }
            if (fVar.E != -9223372036854775807L) {
                Handler handler2 = fVar.N;
                handler2.getClass();
                handler2.removeCallbacksAndMessages(this);
                fVar.H.remove(this);
            }
        }
        fVar.k();
    }

    @Override // f2.h
    public final UUID d() {
        o();
        return this.f4710l;
    }

    @Override // f2.h
    public final boolean e(String str) {
        o();
        byte[] bArr = this.f4719u;
        s1.d.h(bArr);
        return this.f4702b.l(str, bArr);
    }

    @Override // f2.h
    public final g f() {
        o();
        if (this.f4713o == 1) {
            return this.f4718t;
        }
        return null;
    }

    @Override // f2.h
    public final y1.b g() {
        o();
        return this.f4717s;
    }

    @Override // f2.h
    public final int getState() {
        o();
        return this.f4713o;
    }

    public final void h(b2.f fVar) {
        Set set;
        s1.i iVar = this.f4707h;
        synchronized (iVar.f11671u) {
            set = iVar.f11673w;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((k) it.next()).a();
        }
    }

    public final void i(boolean z2) {
        long jMin;
        String str;
        Set set;
        if (this.f) {
            return;
        }
        byte[] bArr = this.f4719u;
        int i = s1.b0.f11647a;
        boolean z10 = true;
        if (this.f4720v == null) {
            n(1, z2, bArr);
            return;
        }
        if (this.f4713o != 4) {
            try {
                this.f4702b.a(this.f4719u, this.f4720v);
            } catch (Exception | NoSuchMethodError e10) {
                k(e10, 1);
                z10 = false;
            }
            if (!z10) {
                return;
            }
        }
        if (p1.g.f9748d.equals(this.f4710l)) {
            o();
            byte[] bArr2 = this.f4719u;
            Pair pair = null;
            Map mapB = bArr2 == null ? null : this.f4702b.b(bArr2);
            if (mapB != null) {
                long j5 = -9223372036854775807L;
                try {
                    str = (String) mapB.get("LicenseDurationRemaining");
                } catch (NumberFormatException unused) {
                }
                long j8 = str != null ? Long.parseLong(str) : -9223372036854775807L;
                Long lValueOf = Long.valueOf(j8);
                try {
                    String str2 = (String) mapB.get("PlaybackDurationRemaining");
                    if (str2 != null) {
                        j5 = Long.parseLong(str2);
                    }
                } catch (NumberFormatException unused2) {
                }
                pair = new Pair(lValueOf, Long.valueOf(j5));
            }
            pair.getClass();
            jMin = Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
        } else {
            jMin = Long.MAX_VALUE;
        }
        if (jMin <= 60) {
            s1.b.f("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + jMin);
            n(2, z2, bArr);
            return;
        }
        if (jMin <= 0) {
            k(new y(), 2);
            return;
        }
        this.f4713o = 4;
        s1.i iVar = this.f4707h;
        synchronized (iVar.f11671u) {
            set = iVar.f11673w;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((k) it.next()).b();
        }
    }

    public final boolean j() {
        int i = this.f4713o;
        return i == 3 || i == 4;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(java.lang.Throwable r6, int r7) {
        /*
            r5 = this;
            f2.g r0 = new f2.g
            boolean r1 = r6 instanceof android.media.MediaDrm.MediaDrmStateException
            r2 = 1
            if (r1 == 0) goto L17
            r7 = r6
            android.media.MediaDrm$MediaDrmStateException r7 = (android.media.MediaDrm.MediaDrmStateException) r7
            java.lang.String r7 = r7.getDiagnosticInfo()
            int r7 = s1.b0.w(r7)
            int r7 = s1.b0.v(r7)
            goto L5c
        L17:
            boolean r1 = r6 instanceof android.media.MediaDrmResetException
            r3 = 6006(0x1776, float:8.416E-42)
            if (r1 == 0) goto L1f
        L1d:
            r7 = r3
            goto L5c
        L1f:
            boolean r1 = r6 instanceof android.media.NotProvisionedException
            r4 = 6002(0x1772, float:8.41E-42)
            if (r1 != 0) goto L54
            boolean r1 = cf.l.v(r6)
            if (r1 == 0) goto L2c
            goto L54
        L2c:
            boolean r1 = r6 instanceof android.media.DeniedByServerException
            if (r1 == 0) goto L33
            r7 = 6007(0x1777, float:8.418E-42)
            goto L5c
        L33:
            boolean r1 = r6 instanceof f2.b0
            if (r1 == 0) goto L3a
            r7 = 6001(0x1771, float:8.409E-42)
            goto L5c
        L3a:
            boolean r1 = r6 instanceof f2.d
            if (r1 == 0) goto L41
            r7 = 6003(0x1773, float:8.412E-42)
            goto L5c
        L41:
            boolean r1 = r6 instanceof f2.y
            if (r1 == 0) goto L48
            r7 = 6008(0x1778, float:8.419E-42)
            goto L5c
        L48:
            if (r7 != r2) goto L4b
            goto L1d
        L4b:
            r1 = 2
            if (r7 != r1) goto L51
            r7 = 6004(0x1774, float:8.413E-42)
            goto L5c
        L51:
            r1 = 3
            if (r7 != r1) goto L56
        L54:
            r7 = r4
            goto L5c
        L56:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            r6.<init>()
            throw r6
        L5c:
            r0.<init>(r6, r7)
            r5.f4718t = r0
            java.lang.String r7 = "DefaultDrmSession"
            java.lang.String r0 = "DRM session error"
            s1.b.h(r7, r0, r6)
            boolean r7 = r6 instanceof java.lang.Exception
            if (r7 == 0) goto L8e
            s1.i r7 = r5.f4707h
            java.lang.Object r0 = r7.f11671u
            monitor-enter(r0)
            java.util.Set r7 = r7.f11673w     // Catch: java.lang.Throwable -> L8b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8b
            java.util.Iterator r7 = r7.iterator()
        L78:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto La2
            java.lang.Object r0 = r7.next()
            f2.k r0 = (f2.k) r0
            r1 = r6
            java.lang.Exception r1 = (java.lang.Exception) r1
            r0.d(r1)
            goto L78
        L8b:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8b
            throw r6
        L8e:
            boolean r7 = r6 instanceof java.lang.Error
            if (r7 == 0) goto Laa
            boolean r7 = cf.l.w(r6)
            if (r7 != 0) goto La2
            boolean r7 = cf.l.v(r6)
            if (r7 == 0) goto L9f
            goto La2
        L9f:
            java.lang.Error r6 = (java.lang.Error) r6
            throw r6
        La2:
            int r6 = r5.f4713o
            r7 = 4
            if (r6 == r7) goto La9
            r5.f4713o = r2
        La9:
            return
        Laa:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Unexpected Throwable subclass"
            r7.<init>(r0, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.c.k(java.lang.Throwable, int):void");
    }

    public final void l(Throwable th, boolean z2) {
        if ((th instanceof NotProvisionedException) || cf.l.v(th)) {
            this.f4703c.y(this);
        } else {
            k(th, z2 ? 1 : 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m() {
        /*
            r4 = this;
            boolean r0 = r4.j()
            r1 = 1
            if (r0 == 0) goto L8
            return r1
        L8:
            f2.u r0 = r4.f4702b     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            byte[] r0 = r0.m()     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            r4.f4719u = r0     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            f2.u r2 = r4.f4702b     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            b2.o r3 = r4.f4708j     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            r2.k(r0, r3)     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            f2.u r0 = r4.f4702b     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            byte[] r2 = r4.f4719u     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            y1.b r0 = r0.j(r2)     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            r4.f4717s = r0     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            r0 = 3
            r4.f4713o = r0     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            s1.i r2 = r4.f4707h     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            java.lang.Object r3 = r2.f11671u     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            monitor-enter(r3)     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            java.util.Set r2 = r2.f11673w     // Catch: java.lang.Throwable -> L4a
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L4a
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
        L30:
            boolean r3 = r2.hasNext()     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            if (r3 == 0) goto L40
            java.lang.Object r3 = r2.next()     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            f2.k r3 = (f2.k) r3     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            r3.c(r0)     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            goto L30
        L40:
            byte[] r0 = r4.f4719u     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            r0.getClass()     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            return r1
        L46:
            r0 = move-exception
            goto L4d
        L48:
            r0 = move-exception
            goto L4d
        L4a:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L4a
            throw r0     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
        L4d:
            boolean r2 = cf.l.v(r0)
            if (r2 == 0) goto L59
            com.google.android.gms.internal.measurement.k4 r0 = r4.f4703c
            r0.y(r4)
            goto L62
        L59:
            r4.k(r0, r1)
            goto L62
        L5d:
            com.google.android.gms.internal.measurement.k4 r0 = r4.f4703c
            r0.y(r4)
        L62:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.c.m():boolean");
    }

    public final void n(int i, boolean z2, byte[] bArr) {
        try {
            r rVarH = this.f4702b.h(bArr, this.f4701a, i, this.f4706g);
            this.f4721w = rVarH;
            a aVar = this.f4716r;
            int i10 = s1.b0.f11647a;
            rVarH.getClass();
            aVar.getClass();
            aVar.obtainMessage(2, new b(o2.u.f9216b.getAndIncrement(), z2, SystemClock.elapsedRealtime(), rVarH)).sendToTarget();
        } catch (Exception | NoSuchMethodError e10) {
            l(e10, true);
        }
    }

    public final void o() {
        Thread threadCurrentThread = Thread.currentThread();
        Looper looper = this.f4711m;
        if (threadCurrentThread != looper.getThread()) {
            s1.b.q("DefaultDrmSession", "DefaultDrmSession accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + looper.getThread().getName(), new IllegalStateException());
        }
    }
}
