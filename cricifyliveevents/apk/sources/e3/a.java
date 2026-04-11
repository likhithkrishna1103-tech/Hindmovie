package e3;

import a3.e0;
import a3.p;
import a3.q;
import a3.r;
import a3.t;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.List;
import ua.g0;
import ua.i0;
import ua.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e0 f3775b;

    public a(int i) {
        this.f3774a = i;
        switch (i) {
            case 1:
                this.f3775b = new e0(35152, 2, "image/png");
                break;
            default:
                this.f3775b = new e0(16973, 2, "image/bmp");
                break;
        }
    }

    @Override // a3.p
    public final p a() {
        int i = this.f3774a;
        return this;
    }

    @Override // a3.p
    public final void c(r rVar) {
        switch (this.f3774a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f3775b.c(rVar);
                break;
            default:
                this.f3775b.c(rVar);
                break;
        }
    }

    @Override // a3.p
    public final void e(long j4, long j7) {
        switch (this.f3774a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f3775b.e(j4, j7);
                break;
            default:
                this.f3775b.e(j4, j7);
                break;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0002. Please report as an issue. */
    @Override // a3.p
    public final List f() {
        switch (this.f3774a) {
        }
        g0 g0Var = i0.f12341w;
        return z0.f12413z;
    }

    @Override // a3.p
    public final boolean h(q qVar) {
        switch (this.f3774a) {
        }
        return this.f3775b.h(qVar);
    }

    @Override // a3.p
    public final int i(q qVar, t tVar) {
        switch (this.f3774a) {
        }
        return this.f3775b.i(qVar, tVar);
    }

    @Override // a3.p
    public final void release() {
        int i = this.f3774a;
    }

    private final void b() {
    }

    private final void d() {
    }
}
