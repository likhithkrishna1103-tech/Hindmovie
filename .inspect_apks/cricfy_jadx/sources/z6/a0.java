package z6;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements b0, t7.b {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final l7.a f15227z = t7.d.a(20, new x3.a());

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final t7.e f15228v = new t7.e();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public b0 f15229w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f15230x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f15231y;

    public final synchronized void a() {
        this.f15228v.a();
        if (!this.f15230x) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f15230x = false;
        if (this.f15231y) {
            e();
        }
    }

    @Override // t7.b
    public final t7.e b() {
        return this.f15228v;
    }

    @Override // z6.b0
    public final int c() {
        return this.f15229w.c();
    }

    @Override // z6.b0
    public final Class d() {
        return this.f15229w.d();
    }

    @Override // z6.b0
    public final synchronized void e() {
        this.f15228v.a();
        this.f15231y = true;
        if (!this.f15230x) {
            this.f15229w.e();
            this.f15229w = null;
            f15227z.b(this);
        }
    }

    @Override // z6.b0
    public final Object get() {
        return this.f15229w.get();
    }
}
