package cc;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public enum r implements ib.f {
    /* JADX INFO: Fake field, exist only in values array */
    EF0("LOG_ENVIRONMENT_UNKNOWN"),
    /* JADX INFO: Fake field, exist only in values array */
    EF2("LOG_ENVIRONMENT_AUTOPUSH"),
    /* JADX INFO: Fake field, exist only in values array */
    EF4("LOG_ENVIRONMENT_STAGING"),
    f2703v("LOG_ENVIRONMENT_PROD");


    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f2705u;

    r(String str) {
        this.f2705u = i;
    }

    @Override // ib.f
    public final int a() {
        return this.f2705u;
    }
}
