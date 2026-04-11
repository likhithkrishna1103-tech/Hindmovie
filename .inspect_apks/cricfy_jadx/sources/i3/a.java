package i3;

import a3.e0;
import a3.i0;
import a3.p;
import a3.q;
import a3.r;
import a3.t;
import a3.u;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.List;
import ua.g0;
import ua.z0;
import v1.m0;
import v1.o;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6163a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f6164b;

    public a(int i) {
        if ((i & 1) != 0) {
            this.f6164b = new e0(65496, 2, "image/jpeg");
        } else {
            this.f6164b = new b();
        }
    }

    @Override // a3.p
    public final p a() {
        int i = this.f6163a;
        return this;
    }

    @Override // a3.p
    public final void c(r rVar) {
        switch (this.f6163a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((p) this.f6164b).c(rVar);
                break;
            default:
                i0 i0VarP = rVar.p(0, 3);
                rVar.s(new u(-9223372036854775807L));
                rVar.e();
                v1.p pVar = (v1.p) this.f6164b;
                o oVarA = pVar.a();
                oVarA.f12893m = m0.p("text/x-unknown");
                oVarA.f12890j = pVar.f12946n;
                l0.e.s(oVarA, i0VarP);
                break;
        }
    }

    @Override // a3.p
    public final void e(long j4, long j7) {
        switch (this.f6163a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((p) this.f6164b).e(j4, j7);
                break;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0002. Please report as an issue. */
    @Override // a3.p
    public final List f() {
        switch (this.f6163a) {
        }
        g0 g0Var = ua.i0.f12341w;
        return z0.f12413z;
    }

    @Override // a3.p
    public final boolean h(q qVar) {
        switch (this.f6163a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((p) this.f6164b).h(qVar);
            default:
                return true;
        }
    }

    @Override // a3.p
    public final int i(q qVar, t tVar) {
        switch (this.f6163a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((p) this.f6164b).i(qVar, tVar);
            default:
                return qVar.a(Integer.MAX_VALUE) == -1 ? -1 : 0;
        }
    }

    @Override // a3.p
    public final void release() {
        switch (this.f6163a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((p) this.f6164b).release();
                break;
        }
    }

    public a(v1.p pVar) {
        this.f6164b = pVar;
    }

    private final void b() {
    }

    private final void d(long j4, long j7) {
    }
}
