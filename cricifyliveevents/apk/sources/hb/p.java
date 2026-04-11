package hb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements hc.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h2.e f5906c = new h2.e(9);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f5907d = new f(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public hc.a f5908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile hc.b f5909b;

    public p(h2.e eVar, hc.b bVar) {
        this.f5908a = eVar;
        this.f5909b = bVar;
    }

    public final void a(hc.a aVar) {
        hc.b bVar;
        hc.b bVar2;
        hc.b bVar3 = this.f5909b;
        f fVar = f5907d;
        if (bVar3 != fVar) {
            aVar.j(bVar3);
            return;
        }
        synchronized (this) {
            bVar = this.f5909b;
            if (bVar != fVar) {
                bVar2 = bVar;
            } else {
                this.f5908a = new androidx.fragment.app.e(7, this.f5908a, aVar);
                bVar2 = null;
            }
        }
        if (bVar2 != null) {
            aVar.j(bVar);
        }
    }

    @Override // hc.b
    public final Object get() {
        return this.f5909b.get();
    }
}
