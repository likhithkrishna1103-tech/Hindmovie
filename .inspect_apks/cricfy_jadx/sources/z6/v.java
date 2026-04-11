package z6;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v implements b0 {
    public int A;
    public boolean B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f15317v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f15318w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b0 f15319x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final u f15320y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final x6.e f15321z;

    public v(b0 b0Var, boolean z10, boolean z11, x6.e eVar, u uVar) {
        s7.f.c(b0Var, "Argument must not be null");
        this.f15319x = b0Var;
        this.f15317v = z10;
        this.f15318w = z11;
        this.f15321z = eVar;
        s7.f.c(uVar, "Argument must not be null");
        this.f15320y = uVar;
    }

    public final synchronized void a() {
        if (this.B) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.A++;
    }

    public final void b() {
        boolean z10;
        synchronized (this) {
            int i = this.A;
            if (i <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z10 = true;
            int i10 = i - 1;
            this.A = i10;
            if (i10 != 0) {
                z10 = false;
            }
        }
        if (z10) {
            ((n) this.f15320y).f(this.f15321z, this);
        }
    }

    @Override // z6.b0
    public final int c() {
        return this.f15319x.c();
    }

    @Override // z6.b0
    public final Class d() {
        return this.f15319x.d();
    }

    @Override // z6.b0
    public final synchronized void e() {
        if (this.A > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.B) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.B = true;
        if (this.f15318w) {
            this.f15319x.e();
        }
    }

    @Override // z6.b0
    public final Object get() {
        return this.f15319x.get();
    }

    public final synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f15317v + ", listener=" + this.f15320y + ", key=" + this.f15321z + ", acquired=" + this.A + ", isRecycled=" + this.B + ", resource=" + this.f15319x + '}';
    }
}
