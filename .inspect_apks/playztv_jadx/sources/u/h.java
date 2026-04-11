package u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f12518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f12519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f12520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12521d;

    public final void finalize() {
        k kVar;
        j jVar = this.f12519b;
        if (jVar != null) {
            i iVar = jVar.f12523v;
            if (!iVar.isDone()) {
                iVar.k(new ea.b("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f12518a, 2));
            }
        }
        if (this.f12521d || (kVar = this.f12520c) == null) {
            return;
        }
        kVar.j(null);
    }
}
