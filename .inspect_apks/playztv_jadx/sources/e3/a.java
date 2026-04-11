package e3;

import aa.c1;
import aa.j0;
import androidx.media3.decoder.DecoderInputBuffer;
import e6.j;
import java.util.List;
import p1.m0;
import p1.p;
import w2.d0;
import w2.h0;
import w2.o;
import w2.q;
import w2.s;
import w2.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4371a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4372b;

    public a(int i) {
        if ((i & 1) != 0) {
            this.f4372b = new d0(65496, 2, "image/jpeg");
        } else {
            this.f4372b = new b();
        }
    }

    @Override // w2.o
    public final o a() {
        int i = this.f4371a;
        return this;
    }

    @Override // w2.o
    public final void c(q qVar) {
        switch (this.f4371a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((o) this.f4372b).c(qVar);
                break;
            default:
                h0 h0VarQ = qVar.q(0, 3);
                qVar.j(new t(-9223372036854775807L));
                qVar.e();
                p1.q qVar2 = (p1.q) this.f4372b;
                p pVarA = qVar2.a();
                pVarA.f9967m = m0.p("text/x-unknown");
                pVarA.f9964j = qVar2.f10023n;
                j.s(pVarA, h0VarQ);
                break;
        }
    }

    @Override // w2.o
    public final boolean e(w2.p pVar) {
        switch (this.f4371a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((o) this.f4372b).e(pVar);
            default:
                return true;
        }
    }

    @Override // w2.o
    public final void f(long j5, long j8) {
        switch (this.f4371a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((o) this.f4372b).f(j5, j8);
                break;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0002. Please report as an issue. */
    @Override // w2.o
    public final List g() {
        switch (this.f4371a) {
        }
        aa.h0 h0Var = j0.f690v;
        return c1.f650y;
    }

    @Override // w2.o
    public final int l(w2.p pVar, s sVar) {
        switch (this.f4371a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((o) this.f4372b).l(pVar, sVar);
            default:
                return pVar.a(Integer.MAX_VALUE) == -1 ? -1 : 0;
        }
    }

    @Override // w2.o
    public final void release() {
        switch (this.f4371a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((o) this.f4372b).release();
                break;
        }
    }

    public a(p1.q qVar) {
        this.f4372b = qVar;
    }

    private final void b() {
    }

    private final void d(long j5, long j8) {
    }
}
