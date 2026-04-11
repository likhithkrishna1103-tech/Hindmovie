package d3;

import a3.e0;
import a3.l;
import a3.p;
import a3.q;
import a3.r;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;
import ua.g0;
import ua.i0;
import ua.z0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f3333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e0 f3334c;

    public a(int i) {
        this.f3332a = i;
        switch (i) {
            case 1:
                this.f3333b = new t(4);
                this.f3334c = new e0(-1, -1, "image/heif");
                break;
            case 2:
                this.f3333b = new t(4);
                this.f3334c = new e0(-1, -1, "image/webp");
                break;
            default:
                this.f3333b = new t(4);
                this.f3334c = new e0(-1, -1, "image/avif");
                break;
        }
    }

    @Override // a3.p
    public final p a() {
        int i = this.f3332a;
        return this;
    }

    @Override // a3.p
    public final void c(r rVar) {
        switch (this.f3332a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f3334c.c(rVar);
                break;
            case 1:
                this.f3334c.c(rVar);
                break;
            default:
                this.f3334c.c(rVar);
                break;
        }
    }

    @Override // a3.p
    public final void e(long j4, long j7) {
        switch (this.f3332a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f3334c.e(j4, j7);
                break;
            case 1:
                this.f3334c.e(j4, j7);
                break;
            default:
                this.f3334c.e(j4, j7);
                break;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0002. Please report as an issue. */
    @Override // a3.p
    public final List f() {
        switch (this.f3332a) {
        }
        g0 g0Var = i0.f12341w;
        return z0.f12413z;
    }

    @Override // a3.p
    public final boolean h(q qVar) throws EOFException, InterruptedIOException {
        switch (this.f3332a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                l lVar = (l) qVar;
                lVar.b(4, false);
                t tVar = this.f3333b;
                tVar.G(4);
                lVar.v(tVar.f14609a, 0, 4, false);
                if (tVar.z() == 1718909296) {
                    tVar.G(4);
                    lVar.v(tVar.f14609a, 0, 4, false);
                    if (tVar.z() == 1635150182) {
                    }
                }
                break;
            case 1:
                l lVar2 = (l) qVar;
                lVar2.b(4, false);
                t tVar2 = this.f3333b;
                tVar2.G(4);
                lVar2.v(tVar2.f14609a, 0, 4, false);
                if (tVar2.z() == 1718909296) {
                    tVar2.G(4);
                    lVar2.v(tVar2.f14609a, 0, 4, false);
                    if (tVar2.z() == 1751476579) {
                    }
                }
                break;
            default:
                t tVar3 = this.f3333b;
                tVar3.G(4);
                l lVar3 = (l) qVar;
                lVar3.v(tVar3.f14609a, 0, 4, false);
                if (tVar3.z() == 1380533830) {
                    lVar3.b(4, false);
                    tVar3.G(4);
                    lVar3.v(tVar3.f14609a, 0, 4, false);
                    if (tVar3.z() == 1464156752) {
                    }
                }
                break;
        }
        return false;
    }

    @Override // a3.p
    public final int i(q qVar, a3.t tVar) {
        switch (this.f3332a) {
        }
        return this.f3334c.i(qVar, tVar);
    }

    @Override // a3.p
    public final void release() {
        int i = this.f3332a;
    }

    private final void b() {
    }

    private final void d() {
    }

    private final void g() {
    }
}
