package f5;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f implements c5.c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final d5.b f3972v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f3973w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f3974x;

    public f(d5.b bVar, String str) {
        this.f3972v = bVar;
        this.f3973w = str;
    }

    @Override // c5.c
    public boolean L() {
        return getLong(0) != 0;
    }

    public final void a() {
        if (this.f3974x) {
            android.support.v4.media.session.b.N(21, "statement is closed");
            throw null;
        }
    }

    @Override // c5.c
    public void f() {
        a();
    }

    @Override // c5.c
    public void reset() {
        a();
    }
}
