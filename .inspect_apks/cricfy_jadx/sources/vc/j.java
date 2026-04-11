package vc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public enum j implements cc.f {
    /* JADX INFO: Fake field, exist only in values array */
    EF0("COLLECTION_UNKNOWN"),
    f13648w("COLLECTION_SDK_NOT_INSTALLED"),
    f13649x("COLLECTION_ENABLED"),
    f13650y("COLLECTION_DISABLED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF43("COLLECTION_DISABLED_REMOTE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF51("COLLECTION_SAMPLED");


    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f13652v;

    j(String str) {
        this.f13652v = i;
    }

    @Override // cc.f
    public final int a() {
        return this.f13652v;
    }
}
