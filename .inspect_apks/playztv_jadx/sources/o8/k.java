package o8;

import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k implements e, d, b {
    public Exception A;
    public boolean B;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f9425u = new Object();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f9426v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final o f9427w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f9428x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f9429y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f9430z;

    public k(int i, o oVar) {
        this.f9426v = i;
        this.f9427w = oVar;
    }

    public final void a() {
        int i = this.f9428x + this.f9429y + this.f9430z;
        int i10 = this.f9426v;
        if (i == i10) {
            Exception exc = this.A;
            o oVar = this.f9427w;
            if (exc == null) {
                if (this.B) {
                    oVar.n();
                    return;
                } else {
                    oVar.m(null);
                    return;
                }
            }
            oVar.l(new ExecutionException(this.f9429y + " out of " + i10 + " underlying tasks failed", this.A));
        }
    }

    @Override // o8.e
    public final void c(Object obj) {
        synchronized (this.f9425u) {
            this.f9428x++;
            a();
        }
    }

    @Override // o8.b
    public final void h() {
        synchronized (this.f9425u) {
            this.f9430z++;
            this.B = true;
            a();
        }
    }

    @Override // o8.d
    public final void t(Exception exc) {
        synchronized (this.f9425u) {
            this.f9429y++;
            this.A = exc;
            a();
        }
    }
}
