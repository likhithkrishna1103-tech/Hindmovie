package a2;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l implements a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s2.e f305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f309e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f310g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap f311h;
    public long i;

    public l() {
        s2.e eVar = new s2.e();
        k(1000, 0, "bufferForPlaybackMs", "0");
        k(2000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        k(50000, 1000, "minBufferMs", "bufferForPlaybackMs");
        k(50000, 2000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        k(50000, 50000, "maxBufferMs", "minBufferMs");
        k(0, 0, "backBufferDurationMs", "0");
        this.f305a = eVar;
        long j5 = 50000;
        this.f306b = s1.b0.O(j5);
        this.f307c = s1.b0.O(j5);
        this.f308d = s1.b0.O(1000);
        this.f309e = s1.b0.O(2000);
        this.f = -1;
        this.f310g = s1.b0.O(0);
        this.f311h = new HashMap();
        this.i = -1L;
    }

    public static void k(int i, int i10, String str, String str2) {
        s1.d.a(str + " cannot be less than " + str2, i >= i10);
    }

    @Override // a2.a1
    public final void a(b2.o oVar) {
        if (this.f311h.remove(oVar) != null) {
            s2.e eVar = this.f305a;
            if (!this.f311h.isEmpty()) {
                eVar.b(l());
                return;
            }
            synchronized (eVar) {
                if (eVar.f11732a) {
                    eVar.b(0);
                }
            }
        }
    }

    @Override // a2.a1
    public final void b(b2.o oVar) {
        if (this.f311h.remove(oVar) != null) {
            s2.e eVar = this.f305a;
            if (this.f311h.isEmpty()) {
                synchronized (eVar) {
                    if (eVar.f11732a) {
                        eVar.b(0);
                    }
                }
            } else {
                eVar.b(l());
            }
        }
        if (this.f311h.isEmpty()) {
            this.i = -1L;
        }
    }

    @Override // a2.a1
    public final boolean c() {
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // a2.a1
    public final void d(z0 z0Var, r2.r[] rVarArr) {
        k kVar = (k) this.f311h.get(z0Var.f518a);
        kVar.getClass();
        int iMax = this.f;
        if (iMax == -1) {
            int length = rVarArr.length;
            int i = 0;
            int i10 = 0;
            while (true) {
                int i11 = 13107200;
                if (i < length) {
                    r2.r rVar = rVarArr[i];
                    if (rVar != null) {
                        switch (rVar.k().f9764c) {
                            case -2:
                                i11 = 0;
                                i10 += i11;
                                break;
                            case -1:
                            case 1:
                                i10 += i11;
                                break;
                            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                i11 = 144310272;
                                i10 += i11;
                                break;
                            case 2:
                                i11 = 131072000;
                                i10 += i11;
                                break;
                            case 3:
                            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                                i11 = 131072;
                                i10 += i11;
                                break;
                            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                                i11 = 26214400;
                                i10 += i11;
                                break;
                            default:
                                throw new IllegalArgumentException();
                        }
                    }
                    i++;
                } else {
                    iMax = Math.max(13107200, i10);
                }
            }
        }
        kVar.f298b = iMax;
        s2.e eVar = this.f305a;
        if (!this.f311h.isEmpty()) {
            eVar.b(l());
            return;
        }
        synchronized (eVar) {
            if (eVar.f11732a) {
                eVar.b(0);
            }
        }
    }

    @Override // a2.a1
    public final boolean e() {
        Iterator it = this.f311h.values().iterator();
        while (it.hasNext()) {
            if (((k) it.next()).f297a) {
                return false;
            }
        }
        return true;
    }

    @Override // a2.a1
    public final s2.e f() {
        return this.f305a;
    }

    @Override // a2.a1
    public final boolean g(z0 z0Var) {
        long jB = s1.b0.B(z0Var.f519b, z0Var.f520c);
        long jMin = z0Var.f521d ? this.f309e : this.f308d;
        long j5 = z0Var.f522e;
        if (j5 != -9223372036854775807L) {
            jMin = Math.min(j5 / 2, jMin);
        }
        return jMin <= 0 || jB >= jMin || this.f305a.a() >= l();
    }

    @Override // a2.a1
    public final void h(b2.o oVar) {
        long id2 = Thread.currentThread().getId();
        long j5 = this.i;
        s1.d.f("Players that share the same LoadControl must share the same playback thread. See ExoPlayer.Builder.setPlaybackLooper(Looper).", j5 == -1 || j5 == id2);
        this.i = id2;
        HashMap map = this.f311h;
        if (!map.containsKey(oVar)) {
            map.put(oVar, new k());
        }
        k kVar = (k) map.get(oVar);
        kVar.getClass();
        int i = this.f;
        if (i == -1) {
            i = 13107200;
        }
        kVar.f298b = i;
        kVar.f297a = false;
    }

    @Override // a2.a1
    public final long i() {
        return this.f310g;
    }

    @Override // a2.a1
    public final boolean j(z0 z0Var) {
        k kVar = (k) this.f311h.get(z0Var.f518a);
        kVar.getClass();
        boolean z2 = this.f305a.a() >= l();
        float f = z0Var.f520c;
        long j5 = this.f307c;
        long jMin = this.f306b;
        if (f > 1.0f) {
            jMin = Math.min(s1.b0.x(jMin, f), j5);
        }
        long jMax = Math.max(jMin, 500000L);
        long j8 = z0Var.f519b;
        if (j8 < jMax) {
            kVar.f297a = !z2;
            if (z2 && j8 < 500000) {
                s1.b.p("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j8 >= j5 || z2) {
            kVar.f297a = false;
        }
        return kVar.f297a;
    }

    public final int l() {
        Iterator it = this.f311h.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((k) it.next()).f298b;
        }
        return i;
    }
}
