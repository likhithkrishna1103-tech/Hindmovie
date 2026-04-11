package d3;

import aa.c1;
import aa.h0;
import aa.j0;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;
import s1.u;
import w2.d0;
import w2.l;
import w2.o;
import w2.p;
import w2.q;
import w2.s;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f3768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0 f3769c;

    public a(int i) {
        this.f3767a = i;
        switch (i) {
            case 1:
                this.f3768b = new u(4);
                this.f3769c = new d0(-1, -1, "image/webp");
                break;
            case 2:
                this.f3768b = new u(4);
                this.f3769c = new d0(-1, -1, "image/avif");
                break;
            default:
                this.f3768b = new u(4);
                this.f3769c = new d0(-1, -1, "image/heif");
                break;
        }
    }

    @Override // w2.o
    public final o a() {
        int i = this.f3767a;
        return this;
    }

    @Override // w2.o
    public final void c(q qVar) {
        switch (this.f3767a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f3769c.c(qVar);
                break;
            case 1:
                this.f3769c.c(qVar);
                break;
            default:
                this.f3769c.c(qVar);
                break;
        }
    }

    @Override // w2.o
    public final boolean e(p pVar) throws EOFException, InterruptedIOException {
        switch (this.f3767a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                l lVar = (l) pVar;
                lVar.b(4, false);
                u uVar = this.f3768b;
                uVar.G(4);
                lVar.r(uVar.f11709a, 0, 4, false);
                if (uVar.z() == 1718909296) {
                    uVar.G(4);
                    lVar.r(uVar.f11709a, 0, 4, false);
                    if (uVar.z() == 1751476579) {
                    }
                }
                break;
            case 1:
                u uVar2 = this.f3768b;
                uVar2.G(4);
                l lVar2 = (l) pVar;
                lVar2.r(uVar2.f11709a, 0, 4, false);
                if (uVar2.z() == 1380533830) {
                    lVar2.b(4, false);
                    uVar2.G(4);
                    lVar2.r(uVar2.f11709a, 0, 4, false);
                    if (uVar2.z() == 1464156752) {
                    }
                }
                break;
            default:
                l lVar3 = (l) pVar;
                lVar3.b(4, false);
                u uVar3 = this.f3768b;
                uVar3.G(4);
                lVar3.r(uVar3.f11709a, 0, 4, false);
                if (uVar3.z() == 1718909296) {
                    uVar3.G(4);
                    lVar3.r(uVar3.f11709a, 0, 4, false);
                    if (uVar3.z() == 1635150182) {
                    }
                }
                break;
        }
        return false;
    }

    @Override // w2.o
    public final void f(long j5, long j8) {
        switch (this.f3767a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f3769c.f(j5, j8);
                break;
            case 1:
                this.f3769c.f(j5, j8);
                break;
            default:
                this.f3769c.f(j5, j8);
                break;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0002. Please report as an issue. */
    @Override // w2.o
    public final List g() {
        switch (this.f3767a) {
        }
        h0 h0Var = j0.f690v;
        return c1.f650y;
    }

    @Override // w2.o
    public final int l(p pVar, s sVar) {
        switch (this.f3767a) {
        }
        return this.f3769c.l(pVar, sVar);
    }

    @Override // w2.o
    public final void release() {
        int i = this.f3767a;
    }

    private final void b() {
    }

    private final void d() {
    }

    private final void h() {
    }
}
