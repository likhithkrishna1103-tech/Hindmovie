package f9;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f4429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w0 f4430d;

    public u0(w0 w0Var, int i, boolean z10, boolean z11) {
        this.f4430d = w0Var;
        this.f4427a = i;
        this.f4428b = z10;
        this.f4429c = z11;
    }

    public final void a(String str) {
        this.f4430d.v1(this.f4427a, this.f4428b, this.f4429c, str, null, null, null);
    }

    public final void b(Object obj, String str) {
        this.f4430d.v1(this.f4427a, this.f4428b, this.f4429c, str, obj, null, null);
    }

    public final void c(Object obj, Object obj2, String str) {
        this.f4430d.v1(this.f4427a, this.f4428b, this.f4429c, str, obj, obj2, null);
    }

    public final void d(String str, Object obj, Object obj2, Object obj3) {
        this.f4430d.v1(this.f4427a, this.f4428b, this.f4429c, str, obj, obj2, obj3);
    }
}
