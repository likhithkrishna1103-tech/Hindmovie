package f7;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public enum c implements jb.c {
    f4795v("REASON_UNKNOWN"),
    f4796w("MESSAGE_TOO_OLD"),
    f4797x("CACHE_FULL"),
    f4798y("PAYLOAD_TOO_BIG"),
    f4799z("MAX_RETRIES_REACHED"),
    A("INVALID_PAYLOD"),
    B("SERVER_ERROR");


    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f4800u;

    c(String str) {
        this.f4800u = i;
    }

    @Override // jb.c
    public final int a() {
        return this.f4800u;
    }
}
