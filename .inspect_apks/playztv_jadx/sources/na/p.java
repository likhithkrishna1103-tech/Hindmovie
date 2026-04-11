package na;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p implements nb.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ia.b f8910c = new ia.b(4);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f8911d = new f(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public nb.a f8912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile nb.b f8913b;

    public p(ia.b bVar, nb.b bVar2) {
        this.f8912a = bVar;
        this.f8913b = bVar2;
    }

    public final void a(nb.a aVar) {
        nb.b bVar;
        nb.b bVar2;
        nb.b bVar3 = this.f8913b;
        f fVar = f8911d;
        if (bVar3 != fVar) {
            aVar.c(bVar3);
            return;
        }
        synchronized (this) {
            bVar = this.f8913b;
            if (bVar != fVar) {
                bVar2 = bVar;
            } else {
                this.f8912a = new b2.b(this.f8912a, 15, aVar);
                bVar2 = null;
            }
        }
        if (bVar2 != null) {
            aVar.c(bVar);
        }
    }

    @Override // nb.b
    public final Object get() {
        return this.f8913b.get();
    }
}
