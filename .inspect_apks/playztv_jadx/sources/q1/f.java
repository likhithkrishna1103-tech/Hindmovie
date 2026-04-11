package q1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends Exception {
    public f(e eVar) {
        this("Unhandled input format:", eVar);
    }

    public f(String str, e eVar) {
        super(str + " " + eVar);
    }
}
