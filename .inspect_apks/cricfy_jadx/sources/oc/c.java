package oc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public enum c implements dc.c {
    /* JADX INFO: Fake field, exist only in values array */
    EF0("UNKNOWN_OS"),
    f9752w("ANDROID"),
    /* JADX INFO: Fake field, exist only in values array */
    EF23("IOS"),
    /* JADX INFO: Fake field, exist only in values array */
    EF31("WEB");


    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f9754v;

    c(String str) {
        this.f9754v = i;
    }

    @Override // dc.c
    public final int a() {
        return this.f9754v;
    }
}
