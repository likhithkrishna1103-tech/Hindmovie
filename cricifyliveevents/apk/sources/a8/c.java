package a8;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public enum c implements dc.c {
    f344w("REASON_UNKNOWN"),
    f345x("MESSAGE_TOO_OLD"),
    f346y("CACHE_FULL"),
    f347z("PAYLOAD_TOO_BIG"),
    A("MAX_RETRIES_REACHED"),
    B("INVALID_PAYLOD"),
    C("SERVER_ERROR");


    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f348v;

    c(String str) {
        this.f348v = i;
    }

    @Override // dc.c
    public final int a() {
        return this.f348v;
    }
}
