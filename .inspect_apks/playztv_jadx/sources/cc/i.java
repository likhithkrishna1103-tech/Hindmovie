package cc;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public enum i implements ib.f {
    /* JADX INFO: Fake field, exist only in values array */
    EF0("COLLECTION_UNKNOWN"),
    f2655v("COLLECTION_SDK_NOT_INSTALLED"),
    f2656w("COLLECTION_ENABLED"),
    f2657x("COLLECTION_DISABLED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF43("COLLECTION_DISABLED_REMOTE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF51("COLLECTION_SAMPLED");


    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f2659u;

    i(String str) {
        this.f2659u = i;
    }

    @Override // ib.f
    public final int a() {
        return this.f2659u;
    }
}
