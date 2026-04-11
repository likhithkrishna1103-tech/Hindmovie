package t6;

import e6.j;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements d, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f12243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile h f12245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile c f12246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12247e = 3;
    public int f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f12248g;

    public i(Object obj, d dVar) {
        this.f12244b = obj;
        this.f12243a = dVar;
    }

    @Override // t6.d, t6.c
    public final boolean a() {
        boolean z2;
        synchronized (this.f12244b) {
            try {
                z2 = this.f12246d.a() || this.f12245c.a();
            } finally {
            }
        }
        return z2;
    }

    @Override // t6.d
    public final void b(c cVar) {
        synchronized (this.f12244b) {
            try {
                if (!cVar.equals(this.f12245c)) {
                    this.f = 5;
                    return;
                }
                this.f12247e = 5;
                d dVar = this.f12243a;
                if (dVar != null) {
                    dVar.b(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t6.c
    public final boolean c() {
        boolean z2;
        synchronized (this.f12244b) {
            z2 = this.f12247e == 3;
        }
        return z2;
    }

    @Override // t6.c
    public final void clear() {
        synchronized (this.f12244b) {
            this.f12248g = false;
            this.f12247e = 3;
            this.f = 3;
            this.f12246d.clear();
            this.f12245c.clear();
        }
    }

    @Override // t6.d
    public final boolean d(c cVar) {
        boolean z2;
        synchronized (this.f12244b) {
            try {
                d dVar = this.f12243a;
                z2 = (dVar == null || dVar.d(this)) && cVar.equals(this.f12245c) && !a();
            } finally {
            }
        }
        return z2;
    }

    @Override // t6.d
    public final void e(c cVar) {
        synchronized (this.f12244b) {
            try {
                if (cVar.equals(this.f12246d)) {
                    this.f = 4;
                    return;
                }
                this.f12247e = 4;
                d dVar = this.f12243a;
                if (dVar != null) {
                    dVar.e(this);
                }
                if (!j.f(this.f)) {
                    this.f12246d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t6.c
    public final void f() {
        synchronized (this.f12244b) {
            try {
                if (!j.f(this.f)) {
                    this.f = 2;
                    this.f12246d.f();
                }
                if (!j.f(this.f12247e)) {
                    this.f12247e = 2;
                    this.f12245c.f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t6.d
    public final boolean g(c cVar) {
        boolean z2;
        synchronized (this.f12244b) {
            try {
                d dVar = this.f12243a;
                z2 = (dVar == null || dVar.g(this)) && (cVar.equals(this.f12245c) || this.f12247e != 4);
            } finally {
            }
        }
        return z2;
    }

    @Override // t6.d
    public final d getRoot() {
        d root;
        synchronized (this.f12244b) {
            try {
                d dVar = this.f12243a;
                root = dVar != null ? dVar.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // t6.c
    public final void h() {
        synchronized (this.f12244b) {
            try {
                this.f12248g = true;
                try {
                    if (this.f12247e != 4 && this.f != 1) {
                        this.f = 1;
                        this.f12246d.h();
                    }
                    if (this.f12248g && this.f12247e != 1) {
                        this.f12247e = 1;
                        this.f12245c.h();
                    }
                    this.f12248g = false;
                } catch (Throwable th) {
                    this.f12248g = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // t6.c
    public final boolean i(c cVar) {
        if (!(cVar instanceof i)) {
            return false;
        }
        i iVar = (i) cVar;
        if (this.f12245c == null) {
            if (iVar.f12245c != null) {
                return false;
            }
        } else if (!this.f12245c.i(iVar.f12245c)) {
            return false;
        }
        return this.f12246d == null ? iVar.f12246d == null : this.f12246d.i(iVar.f12246d);
    }

    @Override // t6.c
    public final boolean isRunning() {
        boolean z2;
        synchronized (this.f12244b) {
            z2 = true;
            if (this.f12247e != 1) {
                z2 = false;
            }
        }
        return z2;
    }

    @Override // t6.d
    public final boolean j(c cVar) {
        boolean z2;
        synchronized (this.f12244b) {
            try {
                d dVar = this.f12243a;
                z2 = (dVar == null || dVar.j(this)) && cVar.equals(this.f12245c) && this.f12247e != 2;
            } finally {
            }
        }
        return z2;
    }

    @Override // t6.c
    public final boolean k() {
        boolean z2;
        synchronized (this.f12244b) {
            z2 = this.f12247e == 4;
        }
        return z2;
    }
}
