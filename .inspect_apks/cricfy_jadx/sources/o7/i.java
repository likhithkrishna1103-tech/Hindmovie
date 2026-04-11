package o7;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements d, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f9603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f9604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile h f9605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile c f9606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9607e = 3;
    public int f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9608g;

    public i(Object obj, d dVar) {
        this.f9604b = obj;
        this.f9603a = dVar;
    }

    @Override // o7.d, o7.c
    public final boolean a() {
        boolean z10;
        synchronized (this.f9604b) {
            try {
                z10 = this.f9606d.a() || this.f9605c.a();
            } finally {
            }
        }
        return z10;
    }

    @Override // o7.d
    public final void b(c cVar) {
        synchronized (this.f9604b) {
            try {
                if (cVar.equals(this.f9606d)) {
                    this.f = 4;
                    return;
                }
                this.f9607e = 4;
                d dVar = this.f9603a;
                if (dVar != null) {
                    dVar.b(this);
                }
                if (!l0.e.d(this.f)) {
                    this.f9606d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // o7.c
    public final void c() {
        synchronized (this.f9604b) {
            try {
                if (!l0.e.d(this.f)) {
                    this.f = 2;
                    this.f9606d.c();
                }
                if (!l0.e.d(this.f9607e)) {
                    this.f9607e = 2;
                    this.f9605c.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // o7.c
    public final void clear() {
        synchronized (this.f9604b) {
            this.f9608g = false;
            this.f9607e = 3;
            this.f = 3;
            this.f9606d.clear();
            this.f9605c.clear();
        }
    }

    @Override // o7.c
    public final boolean d(c cVar) {
        if (!(cVar instanceof i)) {
            return false;
        }
        i iVar = (i) cVar;
        if (this.f9605c == null) {
            if (iVar.f9605c != null) {
                return false;
            }
        } else if (!this.f9605c.d(iVar.f9605c)) {
            return false;
        }
        return this.f9606d == null ? iVar.f9606d == null : this.f9606d.d(iVar.f9606d);
    }

    @Override // o7.d
    public final boolean e(c cVar) {
        boolean z10;
        synchronized (this.f9604b) {
            try {
                d dVar = this.f9603a;
                z10 = (dVar == null || dVar.e(this)) && cVar.equals(this.f9605c) && this.f9607e != 2;
            } finally {
            }
        }
        return z10;
    }

    @Override // o7.c
    public final boolean f() {
        boolean z10;
        synchronized (this.f9604b) {
            z10 = this.f9607e == 3;
        }
        return z10;
    }

    @Override // o7.d
    public final boolean g(c cVar) {
        boolean z10;
        synchronized (this.f9604b) {
            try {
                d dVar = this.f9603a;
                z10 = (dVar == null || dVar.g(this)) && (cVar.equals(this.f9605c) || this.f9607e != 4);
            } finally {
            }
        }
        return z10;
    }

    @Override // o7.d
    public final d getRoot() {
        d root;
        synchronized (this.f9604b) {
            try {
                d dVar = this.f9603a;
                root = dVar != null ? dVar.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // o7.c
    public final void h() {
        synchronized (this.f9604b) {
            try {
                this.f9608g = true;
                try {
                    if (this.f9607e != 4 && this.f != 1) {
                        this.f = 1;
                        this.f9606d.h();
                    }
                    if (this.f9608g && this.f9607e != 1) {
                        this.f9607e = 1;
                        this.f9605c.h();
                    }
                    this.f9608g = false;
                } catch (Throwable th) {
                    this.f9608g = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // o7.d
    public final void i(c cVar) {
        synchronized (this.f9604b) {
            try {
                if (!cVar.equals(this.f9605c)) {
                    this.f = 5;
                    return;
                }
                this.f9607e = 5;
                d dVar = this.f9603a;
                if (dVar != null) {
                    dVar.i(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // o7.c
    public final boolean isRunning() {
        boolean z10;
        synchronized (this.f9604b) {
            z10 = true;
            if (this.f9607e != 1) {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // o7.c
    public final boolean j() {
        boolean z10;
        synchronized (this.f9604b) {
            z10 = this.f9607e == 4;
        }
        return z10;
    }

    @Override // o7.d
    public final boolean k(c cVar) {
        boolean z10;
        synchronized (this.f9604b) {
            try {
                d dVar = this.f9603a;
                z10 = (dVar == null || dVar.k(this)) && cVar.equals(this.f9605c) && !a();
            } finally {
            }
        }
        return z10;
    }
}
