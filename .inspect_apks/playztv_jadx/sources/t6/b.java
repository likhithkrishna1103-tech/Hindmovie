package t6;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements d, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f12208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f12209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile c f12210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile c f12211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12212e = 3;
    public int f = 3;

    public b(Object obj, d dVar) {
        this.f12208a = obj;
        this.f12209b = dVar;
    }

    @Override // t6.d, t6.c
    public final boolean a() {
        boolean z2;
        synchronized (this.f12208a) {
            try {
                z2 = this.f12210c.a() || this.f12211d.a();
            } finally {
            }
        }
        return z2;
    }

    @Override // t6.d
    public final void b(c cVar) {
        synchronized (this.f12208a) {
            try {
                if (cVar.equals(this.f12211d)) {
                    this.f = 5;
                    d dVar = this.f12209b;
                    if (dVar != null) {
                        dVar.b(this);
                    }
                    return;
                }
                this.f12212e = 5;
                if (this.f != 1) {
                    this.f = 1;
                    this.f12211d.h();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t6.c
    public final boolean c() {
        boolean z2;
        synchronized (this.f12208a) {
            try {
                z2 = this.f12212e == 3 && this.f == 3;
            } finally {
            }
        }
        return z2;
    }

    @Override // t6.c
    public final void clear() {
        synchronized (this.f12208a) {
            try {
                this.f12212e = 3;
                this.f12210c.clear();
                if (this.f != 3) {
                    this.f = 3;
                    this.f12211d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t6.d
    public final boolean d(c cVar) {
        boolean z2;
        int i;
        synchronized (this.f12208a) {
            d dVar = this.f12209b;
            z2 = false;
            if (dVar == null || dVar.d(this)) {
                if (this.f12212e != 5 ? cVar.equals(this.f12210c) : cVar.equals(this.f12211d) && ((i = this.f) == 4 || i == 5)) {
                    z2 = true;
                }
            }
        }
        return z2;
    }

    @Override // t6.d
    public final void e(c cVar) {
        synchronized (this.f12208a) {
            try {
                if (cVar.equals(this.f12210c)) {
                    this.f12212e = 4;
                } else if (cVar.equals(this.f12211d)) {
                    this.f = 4;
                }
                d dVar = this.f12209b;
                if (dVar != null) {
                    dVar.e(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t6.c
    public final void f() {
        synchronized (this.f12208a) {
            try {
                if (this.f12212e == 1) {
                    this.f12212e = 2;
                    this.f12210c.f();
                }
                if (this.f == 1) {
                    this.f = 2;
                    this.f12211d.f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t6.d
    public final boolean g(c cVar) {
        boolean z2;
        synchronized (this.f12208a) {
            d dVar = this.f12209b;
            z2 = dVar == null || dVar.g(this);
        }
        return z2;
    }

    @Override // t6.d
    public final d getRoot() {
        d root;
        synchronized (this.f12208a) {
            try {
                d dVar = this.f12209b;
                root = dVar != null ? dVar.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // t6.c
    public final void h() {
        synchronized (this.f12208a) {
            try {
                if (this.f12212e != 1) {
                    this.f12212e = 1;
                    this.f12210c.h();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t6.c
    public final boolean i(c cVar) {
        if (cVar instanceof b) {
            b bVar = (b) cVar;
            if (this.f12210c.i(bVar.f12210c) && this.f12211d.i(bVar.f12211d)) {
                return true;
            }
        }
        return false;
    }

    @Override // t6.c
    public final boolean isRunning() {
        boolean z2;
        synchronized (this.f12208a) {
            try {
                z2 = true;
                if (this.f12212e != 1 && this.f != 1) {
                    z2 = false;
                }
            } finally {
            }
        }
        return z2;
    }

    @Override // t6.d
    public final boolean j(c cVar) {
        boolean z2;
        synchronized (this.f12208a) {
            d dVar = this.f12209b;
            z2 = (dVar == null || dVar.j(this)) && cVar.equals(this.f12210c);
        }
        return z2;
    }

    @Override // t6.c
    public final boolean k() {
        boolean z2;
        synchronized (this.f12208a) {
            try {
                z2 = this.f12212e == 4 || this.f == 4;
            } finally {
            }
        }
        return z2;
    }
}
