package o7;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements d, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f9570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile c f9571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile c f9572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9573e = 3;
    public int f = 3;

    public b(Object obj, d dVar) {
        this.f9569a = obj;
        this.f9570b = dVar;
    }

    @Override // o7.d, o7.c
    public final boolean a() {
        boolean z10;
        synchronized (this.f9569a) {
            try {
                z10 = this.f9571c.a() || this.f9572d.a();
            } finally {
            }
        }
        return z10;
    }

    @Override // o7.d
    public final void b(c cVar) {
        synchronized (this.f9569a) {
            try {
                if (cVar.equals(this.f9571c)) {
                    this.f9573e = 4;
                } else if (cVar.equals(this.f9572d)) {
                    this.f = 4;
                }
                d dVar = this.f9570b;
                if (dVar != null) {
                    dVar.b(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // o7.c
    public final void c() {
        synchronized (this.f9569a) {
            try {
                if (this.f9573e == 1) {
                    this.f9573e = 2;
                    this.f9571c.c();
                }
                if (this.f == 1) {
                    this.f = 2;
                    this.f9572d.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // o7.c
    public final void clear() {
        synchronized (this.f9569a) {
            try {
                this.f9573e = 3;
                this.f9571c.clear();
                if (this.f != 3) {
                    this.f = 3;
                    this.f9572d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // o7.c
    public final boolean d(c cVar) {
        if (cVar instanceof b) {
            b bVar = (b) cVar;
            if (this.f9571c.d(bVar.f9571c) && this.f9572d.d(bVar.f9572d)) {
                return true;
            }
        }
        return false;
    }

    @Override // o7.d
    public final boolean e(c cVar) {
        boolean z10;
        synchronized (this.f9569a) {
            d dVar = this.f9570b;
            z10 = (dVar == null || dVar.e(this)) && cVar.equals(this.f9571c);
        }
        return z10;
    }

    @Override // o7.c
    public final boolean f() {
        boolean z10;
        synchronized (this.f9569a) {
            try {
                z10 = this.f9573e == 3 && this.f == 3;
            } finally {
            }
        }
        return z10;
    }

    @Override // o7.d
    public final boolean g(c cVar) {
        boolean z10;
        synchronized (this.f9569a) {
            d dVar = this.f9570b;
            z10 = dVar == null || dVar.g(this);
        }
        return z10;
    }

    @Override // o7.d
    public final d getRoot() {
        d root;
        synchronized (this.f9569a) {
            try {
                d dVar = this.f9570b;
                root = dVar != null ? dVar.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // o7.c
    public final void h() {
        synchronized (this.f9569a) {
            try {
                if (this.f9573e != 1) {
                    this.f9573e = 1;
                    this.f9571c.h();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // o7.d
    public final void i(c cVar) {
        synchronized (this.f9569a) {
            try {
                if (cVar.equals(this.f9572d)) {
                    this.f = 5;
                    d dVar = this.f9570b;
                    if (dVar != null) {
                        dVar.i(this);
                    }
                    return;
                }
                this.f9573e = 5;
                if (this.f != 1) {
                    this.f = 1;
                    this.f9572d.h();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // o7.c
    public final boolean isRunning() {
        boolean z10;
        synchronized (this.f9569a) {
            try {
                z10 = true;
                if (this.f9573e != 1 && this.f != 1) {
                    z10 = false;
                }
            } finally {
            }
        }
        return z10;
    }

    @Override // o7.c
    public final boolean j() {
        boolean z10;
        synchronized (this.f9569a) {
            try {
                z10 = this.f9573e == 4 || this.f == 4;
            } finally {
            }
        }
        return z10;
    }

    @Override // o7.d
    public final boolean k(c cVar) {
        boolean z10;
        int i;
        synchronized (this.f9569a) {
            d dVar = this.f9570b;
            z10 = false;
            if (dVar == null || dVar.k(this)) {
                if (this.f9573e != 5 ? cVar.equals(this.f9571c) : cVar.equals(this.f9572d) && ((i = this.f) == 4 || i == 5)) {
                    z10 = true;
                }
            }
        }
        return z10;
    }
}
