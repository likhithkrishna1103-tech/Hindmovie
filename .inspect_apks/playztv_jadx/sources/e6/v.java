package e6;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v implements b0 {
    public boolean A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f4565u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f4566v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b0 f4567w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final u f4568x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final c6.f f4569y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f4570z;

    public v(b0 b0Var, boolean z2, boolean z10, c6.f fVar, u uVar) {
        x6.f.c(b0Var, "Argument must not be null");
        this.f4567w = b0Var;
        this.f4565u = z2;
        this.f4566v = z10;
        this.f4569y = fVar;
        x6.f.c(uVar, "Argument must not be null");
        this.f4568x = uVar;
    }

    public final synchronized void a() {
        if (this.A) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f4570z++;
    }

    @Override // e6.b0
    public final int b() {
        return this.f4567w.b();
    }

    @Override // e6.b0
    public final Class c() {
        return this.f4567w.c();
    }

    @Override // e6.b0
    public final synchronized void d() {
        if (this.f4570z > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.A) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.A = true;
        if (this.f4566v) {
            this.f4567w.d();
        }
    }

    public final void e() {
        boolean z2;
        synchronized (this) {
            int i = this.f4570z;
            if (i <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z2 = true;
            int i10 = i - 1;
            this.f4570z = i10;
            if (i10 != 0) {
                z2 = false;
            }
        }
        if (z2) {
            ((n) this.f4568x).f(this.f4569y, this);
        }
    }

    @Override // e6.b0
    public final Object get() {
        return this.f4567w.get();
    }

    public final synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f4565u + ", listener=" + this.f4568x + ", key=" + this.f4569y + ", acquired=" + this.f4570z + ", isRecycled=" + this.A + ", resource=" + this.f4567w + '}';
    }
}
