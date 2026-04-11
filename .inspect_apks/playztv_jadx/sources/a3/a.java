package a3;

import aa.c1;
import aa.h0;
import aa.j0;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.List;
import w2.d0;
import w2.o;
import w2.p;
import w2.q;
import w2.s;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f532b;

    public a(int i) {
        this.f531a = i;
        switch (i) {
            case 1:
                this.f532b = new d0(35152, 2, "image/png");
                break;
            default:
                this.f532b = new d0(16973, 2, "image/bmp");
                break;
        }
    }

    @Override // w2.o
    public final o a() {
        int i = this.f531a;
        return this;
    }

    @Override // w2.o
    public final void c(q qVar) {
        switch (this.f531a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f532b.c(qVar);
                break;
            default:
                this.f532b.c(qVar);
                break;
        }
    }

    @Override // w2.o
    public final boolean e(p pVar) {
        switch (this.f531a) {
        }
        return this.f532b.e(pVar);
    }

    @Override // w2.o
    public final void f(long j5, long j8) {
        switch (this.f531a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f532b.f(j5, j8);
                break;
            default:
                this.f532b.f(j5, j8);
                break;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0002. Please report as an issue. */
    @Override // w2.o
    public final List g() {
        switch (this.f531a) {
        }
        h0 h0Var = j0.f690v;
        return c1.f650y;
    }

    @Override // w2.o
    public final int l(p pVar, s sVar) {
        switch (this.f531a) {
        }
        return this.f532b.l(pVar, sVar);
    }

    @Override // w2.o
    public final void release() {
        int i = this.f531a;
    }

    private final void b() {
    }

    private final void d() {
    }
}
