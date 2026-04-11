package u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends g {
    public final /* synthetic */ j B;

    public i(j jVar) {
        this.B = jVar;
    }

    @Override // u.g
    public final String h() {
        h hVar = (h) this.B.f12522u.get();
        if (hVar == null) {
            return "Completer object has been garbage collected, future will fail soon";
        }
        return "tag=[" + hVar.f12518a + "]";
    }
}
