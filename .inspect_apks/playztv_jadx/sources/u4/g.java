package u4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class g implements y4.c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final z4.a f12772u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f12773v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f12774w;

    public g(z4.a aVar, String str) {
        this.f12772u = aVar;
        this.f12773v = str;
    }

    @Override // y4.c
    public final boolean O() {
        return getLong(0) != 0;
    }

    public final void a() {
        if (this.f12774w) {
            android.support.v4.media.session.b.O("statement is closed", 21);
            throw null;
        }
    }
}
