package j9;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.Executor;
import ya.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements o, f, e, c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f6702v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Executor f6703w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f6704x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Object f6705y;

    public n(Executor executor, c cVar) {
        this.f6702v = 0;
        this.f6704x = new Object();
        this.f6703w = executor;
        this.f6705y = cVar;
    }

    private final void d(p pVar) {
        synchronized (this.f6704x) {
        }
        this.f6703w.execute(new s(24, this, pVar, false));
    }

    private final void e(p pVar) {
        if (pVar.j() || pVar.f6709d) {
            return;
        }
        synchronized (this.f6704x) {
            try {
                if (((e) this.f6705y) == null) {
                    return;
                }
                this.f6703w.execute(new s(25, this, pVar, false));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void f(p pVar) {
        if (pVar.j()) {
            synchronized (this.f6704x) {
                try {
                    if (((f) this.f6705y) == null) {
                        return;
                    }
                    this.f6703w.execute(new s(26, this, pVar, false));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // j9.f
    public void a(Object obj) {
        ((p) this.f6705y).l(obj);
    }

    @Override // j9.c
    public void b() {
        ((p) this.f6705y).o();
    }

    @Override // j9.o
    public final void c(p pVar) {
        switch (this.f6702v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (pVar.f6709d) {
                    synchronized (this.f6704x) {
                        try {
                            if (((c) this.f6705y) != null) {
                                this.f6703w.execute(new androidx.fragment.app.m(16, this));
                            }
                        } finally {
                        }
                    }
                    return;
                }
                return;
            case 1:
                d(pVar);
                return;
            case 2:
                e(pVar);
                return;
            case 3:
                f(pVar);
                return;
            default:
                this.f6703w.execute(new s(27, this, pVar, false));
                return;
        }
    }

    @Override // j9.e
    public void y(Exception exc) {
        ((p) this.f6705y).n(exc);
    }

    public n(Executor executor, d dVar) {
        this.f6702v = 1;
        this.f6704x = new Object();
        this.f6703w = executor;
        this.f6705y = dVar;
    }

    public n(Executor executor, e eVar) {
        this.f6702v = 2;
        this.f6704x = new Object();
        this.f6703w = executor;
        this.f6705y = eVar;
    }

    public n(Executor executor, f fVar) {
        this.f6702v = 3;
        this.f6704x = new Object();
        this.f6703w = executor;
        this.f6705y = fVar;
    }

    public n(Executor executor, h hVar, p pVar) {
        this.f6702v = 4;
        this.f6703w = executor;
        this.f6704x = hVar;
        this.f6705y = pVar;
    }
}
