package e6;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements b0, y6.b {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final kc.b f4468y = y6.d.a(20, new lb.e(10));

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final y6.e f4469u = new y6.e();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public b0 f4470v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f4471w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f4472x;

    @Override // y6.b
    public final y6.e a() {
        return this.f4469u;
    }

    @Override // e6.b0
    public final int b() {
        return this.f4470v.b();
    }

    @Override // e6.b0
    public final Class c() {
        return this.f4470v.c();
    }

    @Override // e6.b0
    public final synchronized void d() {
        this.f4469u.a();
        this.f4472x = true;
        if (!this.f4471w) {
            this.f4470v.d();
            this.f4470v = null;
            f4468y.b(this);
        }
    }

    public final synchronized void e() {
        this.f4469u.a();
        if (!this.f4471w) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f4471w = false;
        if (this.f4472x) {
            d();
        }
    }

    @Override // e6.b0
    public final Object get() {
        return this.f4470v.get();
    }
}
