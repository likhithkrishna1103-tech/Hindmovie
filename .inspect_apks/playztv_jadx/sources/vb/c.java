package vb;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public enum c implements jb.c {
    /* JADX INFO: Fake field, exist only in values array */
    EF0("UNKNOWN_OS"),
    f13471v("ANDROID"),
    /* JADX INFO: Fake field, exist only in values array */
    EF23("IOS"),
    /* JADX INFO: Fake field, exist only in values array */
    EF31("WEB");


    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f13473u;

    c(String str) {
        this.f13473u = i;
    }

    @Override // jb.c
    public final int a() {
        return this.f13473u;
    }
}
