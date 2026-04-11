package g2;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w2.e f4768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f4771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f4772e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f4773g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap f4774h;
    public long i;

    public j() {
        w2.e eVar = new w2.e();
        k(1000, 0, "bufferForPlaybackMs", "0");
        k(2000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        k(50000, 1000, "minBufferMs", "bufferForPlaybackMs");
        k(50000, 2000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        k(50000, 50000, "maxBufferMs", "minBufferMs");
        k(0, 0, "backBufferDurationMs", "0");
        this.f4768a = eVar;
        long j4 = 50000;
        this.f4769b = y1.a0.O(j4);
        this.f4770c = y1.a0.O(j4);
        this.f4771d = y1.a0.O(1000);
        this.f4772e = y1.a0.O(2000);
        this.f = -1;
        this.f4773g = y1.a0.O(0);
        this.f4774h = new HashMap();
        this.i = -1L;
    }

    public static void k(int i, int i10, String str, String str2) {
        y1.d.a(str + " cannot be less than " + str2, i >= i10);
    }

    @Override // g2.q0
    public final void a(h2.l lVar) {
        if (this.f4774h.remove(lVar) != null) {
            w2.e eVar = this.f4768a;
            if (this.f4774h.isEmpty()) {
                synchronized (eVar) {
                    if (eVar.f13845a) {
                        eVar.b(0);
                    }
                }
            } else {
                eVar.b(l());
            }
        }
        if (this.f4774h.isEmpty()) {
            this.i = -1L;
        }
    }

    @Override // g2.q0
    public final boolean b() {
        return false;
    }

    @Override // g2.q0
    public final boolean c(p0 p0Var) {
        i iVar = (i) this.f4774h.get(p0Var.f4875a);
        iVar.getClass();
        boolean z10 = this.f4768a.a() >= l();
        float f = p0Var.f4877c;
        long j4 = this.f4770c;
        long jMin = this.f4769b;
        if (f > 1.0f) {
            jMin = Math.min(y1.a0.x(jMin, f), j4);
        }
        long jMax = Math.max(jMin, 500000L);
        long j7 = p0Var.f4876b;
        if (j7 < jMax) {
            iVar.f4746a = !z10;
            if (z10 && j7 < 500000) {
                y1.b.p("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j7 >= j4 || z10) {
            iVar.f4746a = false;
        }
        return iVar.f4746a;
    }

    @Override // g2.q0
    public final boolean d() {
        Iterator it = this.f4774h.values().iterator();
        while (it.hasNext()) {
            if (((i) it.next()).f4746a) {
                return false;
            }
        }
        return true;
    }

    @Override // g2.q0
    public final boolean e(p0 p0Var) {
        long jB = y1.a0.B(p0Var.f4876b, p0Var.f4877c);
        long jMin = p0Var.f4878d ? this.f4772e : this.f4771d;
        long j4 = p0Var.f4879e;
        if (j4 != -9223372036854775807L) {
            jMin = Math.min(j4 / 2, jMin);
        }
        return jMin <= 0 || jB >= jMin || this.f4768a.a() >= l();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // g2.q0
    public final void f(p0 p0Var, v2.q[] qVarArr) {
        i iVar = (i) this.f4774h.get(p0Var.f4875a);
        iVar.getClass();
        int iMax = this.f;
        if (iMax == -1) {
            int length = qVarArr.length;
            int i = 0;
            int i10 = 0;
            while (true) {
                int i11 = 13107200;
                if (i < length) {
                    v2.q qVar = qVarArr[i];
                    if (qVar != null) {
                        switch (qVar.i().f12704c) {
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
                            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                                i11 = 131072;
                                i10 += i11;
                                break;
                            case g1.h.LONG_FIELD_NUMBER /* 4 */:
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
        iVar.f4747b = iMax;
        w2.e eVar = this.f4768a;
        if (!this.f4774h.isEmpty()) {
            eVar.b(l());
            return;
        }
        synchronized (eVar) {
            if (eVar.f13845a) {
                eVar.b(0);
            }
        }
    }

    @Override // g2.q0
    public final w2.e g() {
        return this.f4768a;
    }

    @Override // g2.q0
    public final void h(h2.l lVar) {
        long id2 = Thread.currentThread().getId();
        long j4 = this.i;
        y1.d.f("Players that share the same LoadControl must share the same playback thread. See ExoPlayer.Builder.setPlaybackLooper(Looper).", j4 == -1 || j4 == id2);
        this.i = id2;
        HashMap map = this.f4774h;
        if (!map.containsKey(lVar)) {
            map.put(lVar, new i());
        }
        i iVar = (i) map.get(lVar);
        iVar.getClass();
        int i = this.f;
        if (i == -1) {
            i = 13107200;
        }
        iVar.f4747b = i;
        iVar.f4746a = false;
    }

    @Override // g2.q0
    public final long i() {
        return this.f4773g;
    }

    @Override // g2.q0
    public final void j(h2.l lVar) {
        if (this.f4774h.remove(lVar) != null) {
            w2.e eVar = this.f4768a;
            if (!this.f4774h.isEmpty()) {
                eVar.b(l());
                return;
            }
            synchronized (eVar) {
                if (eVar.f13845a) {
                    eVar.b(0);
                }
            }
        }
    }

    public final int l() {
        Iterator it = this.f4774h.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((i) it.next()).f4747b;
        }
        return i;
    }
}
