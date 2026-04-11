package o8;

import androidx.media3.decoder.DecoderInputBuffer;
import ea.t;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m implements n, e, d, b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f9435u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Executor f9436v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f9437w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f9438x;

    public m(Executor executor, b bVar) {
        this.f9435u = 0;
        this.f9437w = new Object();
        this.f9436v = executor;
        this.f9438x = bVar;
    }

    private final void b(o oVar) {
        synchronized (this.f9437w) {
        }
        this.f9436v.execute(new t(24, this, oVar, false));
    }

    private final void d(o oVar) {
        if (oVar.j() || oVar.f9442d) {
            return;
        }
        synchronized (this.f9437w) {
        }
        this.f9436v.execute(new t(25, this, oVar, false));
    }

    private final void e(o oVar) {
        if (oVar.j()) {
            synchronized (this.f9437w) {
            }
            this.f9436v.execute(new t(26, this, oVar, false));
        }
    }

    @Override // o8.n
    public final void a(o oVar) {
        switch (this.f9435u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (oVar.f9442d) {
                    synchronized (this.f9437w) {
                        break;
                    }
                    this.f9436v.execute(new androidx.fragment.app.e(17, this));
                    return;
                }
                return;
            case 1:
                b(oVar);
                return;
            case 2:
                d(oVar);
                return;
            case 3:
                e(oVar);
                return;
            default:
                this.f9436v.execute(new t(27, this, oVar, false));
                return;
        }
    }

    @Override // o8.e
    public void c(Object obj) {
        ((o) this.f9438x).m(obj);
    }

    @Override // o8.b
    public void h() {
        ((o) this.f9438x).n();
    }

    @Override // o8.d
    public void t(Exception exc) {
        ((o) this.f9438x).l(exc);
    }

    public m(Executor executor, c cVar) {
        this.f9435u = 1;
        this.f9437w = new Object();
        this.f9436v = executor;
        this.f9438x = cVar;
    }

    public m(Executor executor, d dVar) {
        this.f9435u = 2;
        this.f9437w = new Object();
        this.f9436v = executor;
        this.f9438x = dVar;
    }

    public m(Executor executor, e eVar) {
        this.f9435u = 3;
        this.f9437w = new Object();
        this.f9436v = executor;
        this.f9438x = eVar;
    }

    public m(Executor executor, g gVar, o oVar) {
        this.f9435u = 4;
        this.f9436v = executor;
        this.f9437w = gVar;
        this.f9438x = oVar;
    }
}
