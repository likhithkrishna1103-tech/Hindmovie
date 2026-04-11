package l2;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import k4.r0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f7634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f7635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i2.k f7636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p6.d f7637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f7638e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap f7639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final y1.i f7640h;
    public final f9.a0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h2.l f7641j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final z f7642k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final UUID f7643l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Looper f7644m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final h.d f7645n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f7646o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f7647p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public HandlerThread f7648q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a f7649r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public e2.b f7650s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public g f7651t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public byte[] f7652u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public byte[] f7653v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public r f7654w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public t f7655x;

    public c(UUID uuid, u uVar, i2.k kVar, p6.d dVar, List list, boolean z10, boolean z11, byte[] bArr, HashMap map, z zVar, Looper looper, f9.a0 a0Var, h2.l lVar) {
        this.f7643l = uuid;
        this.f7636c = kVar;
        this.f7637d = dVar;
        this.f7635b = uVar;
        this.f7638e = z10;
        this.f = z11;
        if (bArr != null) {
            this.f7653v = bArr;
            this.f7634a = null;
        } else {
            list.getClass();
            this.f7634a = Collections.unmodifiableList(list);
        }
        this.f7639g = map;
        this.f7642k = zVar;
        this.f7640h = new y1.i();
        this.i = a0Var;
        this.f7641j = lVar;
        this.f7646o = 2;
        this.f7644m = looper;
        this.f7645n = new h.d(this, looper, 2);
    }

    @Override // l2.h
    public final boolean a() {
        o();
        return this.f7638e;
    }

    @Override // l2.h
    public final UUID b() {
        o();
        return this.f7643l;
    }

    @Override // l2.h
    public final void c(k kVar) {
        o();
        int i = this.f7647p;
        if (i <= 0) {
            y1.b.g("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i10 = i - 1;
        this.f7647p = i10;
        if (i10 == 0) {
            this.f7646o = 0;
            h.d dVar = this.f7645n;
            int i11 = y1.a0.f14551a;
            dVar.removeCallbacksAndMessages(null);
            a aVar = this.f7649r;
            synchronized (aVar) {
                aVar.removeCallbacksAndMessages(null);
                aVar.f7628a = true;
            }
            this.f7649r = null;
            this.f7648q.quit();
            this.f7648q = null;
            this.f7650s = null;
            this.f7651t = null;
            this.f7654w = null;
            this.f7655x = null;
            byte[] bArr = this.f7652u;
            if (bArr != null) {
                this.f7635b.d(bArr);
                this.f7652u = null;
            }
        }
        if (kVar != null) {
            this.f7640h.b(kVar);
            if (this.f7640h.a(kVar) == 0) {
                kVar.e();
            }
        }
        p6.d dVar2 = this.f7637d;
        int i12 = this.f7647p;
        f fVar = (f) dVar2.f10037w;
        if (i12 == 1 && fVar.J > 0 && fVar.F != -9223372036854775807L) {
            fVar.I.add(this);
            Handler handler = fVar.O;
            handler.getClass();
            handler.postAtTime(new androidx.emoji2.text.w(21, this), this, SystemClock.uptimeMillis() + fVar.F);
        } else if (i12 == 0) {
            fVar.G.remove(this);
            if (fVar.L == this) {
                fVar.L = null;
            }
            if (fVar.M == this) {
                fVar.M = null;
            }
            i2.k kVar2 = fVar.C;
            HashSet hashSet = (HashSet) kVar2.f6085v;
            hashSet.remove(this);
            if (((c) kVar2.f6086w) == this) {
                kVar2.f6086w = null;
                if (!hashSet.isEmpty()) {
                    c cVar = (c) hashSet.iterator().next();
                    kVar2.f6086w = cVar;
                    t tVarG = cVar.f7635b.g();
                    cVar.f7655x = tVarG;
                    a aVar2 = cVar.f7649r;
                    int i13 = y1.a0.f14551a;
                    tVarG.getClass();
                    aVar2.getClass();
                    aVar2.obtainMessage(1, new b(s2.t.f11325b.getAndIncrement(), true, SystemClock.elapsedRealtime(), tVarG)).sendToTarget();
                }
            }
            if (fVar.F != -9223372036854775807L) {
                Handler handler2 = fVar.O;
                handler2.getClass();
                handler2.removeCallbacksAndMessages(this);
                fVar.I.remove(this);
            }
        }
        fVar.j();
    }

    @Override // l2.h
    public final void d(k kVar) {
        o();
        if (this.f7647p < 0) {
            y1.b.g("DefaultDrmSession", "Session reference count less than zero: " + this.f7647p);
            this.f7647p = 0;
        }
        if (kVar != null) {
            y1.i iVar = this.f7640h;
            synchronized (iVar.f14577v) {
                try {
                    ArrayList arrayList = new ArrayList(iVar.f14580y);
                    arrayList.add(kVar);
                    iVar.f14580y = Collections.unmodifiableList(arrayList);
                    Integer num = (Integer) iVar.f14578w.get(kVar);
                    if (num == null) {
                        HashSet hashSet = new HashSet(iVar.f14579x);
                        hashSet.add(kVar);
                        iVar.f14579x = Collections.unmodifiableSet(hashSet);
                    }
                    iVar.f14578w.put(kVar, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
                } finally {
                }
            }
        }
        int i = this.f7647p + 1;
        this.f7647p = i;
        if (i == 1) {
            y1.d.g(this.f7646o == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.f7648q = handlerThread;
            handlerThread.start();
            this.f7649r = new a(this, this.f7648q.getLooper());
            if (m()) {
                i(true);
            }
        } else if (kVar != null && j() && this.f7640h.a(kVar) == 1) {
            kVar.c(this.f7646o);
        }
        f fVar = (f) this.f7637d.f10037w;
        if (fVar.F != -9223372036854775807L) {
            fVar.I.remove(this);
            Handler handler = fVar.O;
            handler.getClass();
            handler.removeCallbacksAndMessages(this);
        }
    }

    @Override // l2.h
    public final boolean e(String str) {
        o();
        byte[] bArr = this.f7652u;
        y1.d.h(bArr);
        return this.f7635b.l(str, bArr);
    }

    @Override // l2.h
    public final g f() {
        o();
        if (this.f7646o == 1) {
            return this.f7651t;
        }
        return null;
    }

    @Override // l2.h
    public final e2.b g() {
        o();
        return this.f7650s;
    }

    @Override // l2.h
    public final int getState() {
        o();
        return this.f7646o;
    }

    public final void h(r0 r0Var) {
        Set set;
        y1.i iVar = this.f7640h;
        synchronized (iVar.f14577v) {
            set = iVar.f14579x;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((k) it.next()).a();
        }
    }

    public final void i(boolean z10) {
        long jMin;
        String str;
        Set set;
        if (this.f) {
            return;
        }
        byte[] bArr = this.f7652u;
        int i = y1.a0.f14551a;
        boolean z11 = true;
        if (this.f7653v == null) {
            n(1, z10, bArr);
            return;
        }
        if (this.f7646o != 4) {
            try {
                this.f7635b.a(this.f7652u, this.f7653v);
            } catch (Exception | NoSuchMethodError e9) {
                k(e9, 1);
                z11 = false;
            }
            if (!z11) {
                return;
            }
        }
        if (v1.f.f12660d.equals(this.f7643l)) {
            o();
            byte[] bArr2 = this.f7652u;
            Pair pair = null;
            Map mapB = bArr2 == null ? null : this.f7635b.b(bArr2);
            if (mapB != null) {
                long j4 = -9223372036854775807L;
                try {
                    str = (String) mapB.get("LicenseDurationRemaining");
                } catch (NumberFormatException unused) {
                }
                long j7 = str != null ? Long.parseLong(str) : -9223372036854775807L;
                Long lValueOf = Long.valueOf(j7);
                try {
                    String str2 = (String) mapB.get("PlaybackDurationRemaining");
                    if (str2 != null) {
                        j4 = Long.parseLong(str2);
                    }
                } catch (NumberFormatException unused2) {
                }
                pair = new Pair(lValueOf, Long.valueOf(j4));
            }
            pair.getClass();
            jMin = Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
        } else {
            jMin = Long.MAX_VALUE;
        }
        if (jMin <= 60) {
            y1.b.f("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + jMin);
            n(2, z10, bArr);
            return;
        }
        if (jMin <= 0) {
            k(new y(), 2);
            return;
        }
        this.f7646o = 4;
        y1.i iVar = this.f7640h;
        synchronized (iVar.f14577v) {
            set = iVar.f14579x;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((k) it.next()).b();
        }
    }

    public final boolean j() {
        int i = this.f7646o;
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
            l2.g r0 = new l2.g
            boolean r1 = r6 instanceof android.media.MediaDrm.MediaDrmStateException
            r2 = 1
            if (r1 == 0) goto L17
            r7 = r6
            android.media.MediaDrm$MediaDrmStateException r7 = (android.media.MediaDrm.MediaDrmStateException) r7
            java.lang.String r7 = r7.getDiagnosticInfo()
            int r7 = y1.a0.w(r7)
            int r7 = y1.a0.v(r7)
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
            boolean r1 = w4.v.k(r6)
            if (r1 == 0) goto L2c
            goto L54
        L2c:
            boolean r1 = r6 instanceof android.media.DeniedByServerException
            if (r1 == 0) goto L33
            r7 = 6007(0x1777, float:8.418E-42)
            goto L5c
        L33:
            boolean r1 = r6 instanceof l2.b0
            if (r1 == 0) goto L3a
            r7 = 6001(0x1771, float:8.409E-42)
            goto L5c
        L3a:
            boolean r1 = r6 instanceof l2.d
            if (r1 == 0) goto L41
            r7 = 6003(0x1773, float:8.412E-42)
            goto L5c
        L41:
            boolean r1 = r6 instanceof l2.y
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
            r5.f7651t = r0
            java.lang.String r7 = "DefaultDrmSession"
            java.lang.String r0 = "DRM session error"
            y1.b.h(r7, r0, r6)
            boolean r7 = r6 instanceof java.lang.Exception
            if (r7 == 0) goto L8e
            y1.i r7 = r5.f7640h
            java.lang.Object r0 = r7.f14577v
            monitor-enter(r0)
            java.util.Set r7 = r7.f14579x     // Catch: java.lang.Throwable -> L8b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8b
            java.util.Iterator r7 = r7.iterator()
        L78:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto La2
            java.lang.Object r0 = r7.next()
            l2.k r0 = (l2.k) r0
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
            boolean r7 = w4.v.l(r6)
            if (r7 != 0) goto La2
            boolean r7 = w4.v.k(r6)
            if (r7 == 0) goto L9f
            goto La2
        L9f:
            java.lang.Error r6 = (java.lang.Error) r6
            throw r6
        La2:
            int r6 = r5.f7646o
            r7 = 4
            if (r6 == r7) goto La9
            r5.f7646o = r2
        La9:
            return
        Laa:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Unexpected Throwable subclass"
            r7.<init>(r0, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.c.k(java.lang.Throwable, int):void");
    }

    public final void l(Throwable th, boolean z10) {
        if ((th instanceof NotProvisionedException) || w4.v.k(th)) {
            this.f7636c.r(this);
        } else {
            k(th, z10 ? 1 : 2);
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
            l2.u r0 = r4.f7635b     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            byte[] r0 = r0.m()     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            r4.f7652u = r0     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            l2.u r2 = r4.f7635b     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            h2.l r3 = r4.f7641j     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            r2.c(r0, r3)     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            l2.u r0 = r4.f7635b     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            byte[] r2 = r4.f7652u     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            e2.b r0 = r0.k(r2)     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            r4.f7650s = r0     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            r0 = 3
            r4.f7646o = r0     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            y1.i r2 = r4.f7640h     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            java.lang.Object r3 = r2.f14577v     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            monitor-enter(r3)     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            java.util.Set r2 = r2.f14579x     // Catch: java.lang.Throwable -> L4a
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L4a
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
        L30:
            boolean r3 = r2.hasNext()     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            if (r3 == 0) goto L40
            java.lang.Object r3 = r2.next()     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            l2.k r3 = (l2.k) r3     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            r3.c(r0)     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            goto L30
        L40:
            byte[] r0 = r4.f7652u     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
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
            boolean r2 = w4.v.k(r0)
            if (r2 == 0) goto L59
            i2.k r0 = r4.f7636c
            r0.r(r4)
            goto L62
        L59:
            r4.k(r0, r1)
            goto L62
        L5d:
            i2.k r0 = r4.f7636c
            r0.r(r4)
        L62:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.c.m():boolean");
    }

    public final void n(int i, boolean z10, byte[] bArr) {
        try {
            r rVarI = this.f7635b.i(bArr, this.f7634a, i, this.f7639g);
            this.f7654w = rVarI;
            a aVar = this.f7649r;
            int i10 = y1.a0.f14551a;
            rVarI.getClass();
            aVar.getClass();
            aVar.obtainMessage(2, new b(s2.t.f11325b.getAndIncrement(), z10, SystemClock.elapsedRealtime(), rVarI)).sendToTarget();
        } catch (Exception | NoSuchMethodError e9) {
            l(e9, true);
        }
    }

    public final void o() {
        Thread threadCurrentThread = Thread.currentThread();
        Looper looper = this.f7644m;
        if (threadCurrentThread != looper.getThread()) {
            y1.b.q("DefaultDrmSession", "DefaultDrmSession accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + looper.getThread().getName(), new IllegalStateException());
        }
    }
}
