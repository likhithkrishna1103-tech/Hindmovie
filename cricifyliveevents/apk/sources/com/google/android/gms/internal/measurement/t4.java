package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public enum t4 implements k5 {
    f2636w("PURPOSE_RESTRICTION_NOT_ALLOWED"),
    f2637x("PURPOSE_RESTRICTION_REQUIRE_CONSENT"),
    f2638y("PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST"),
    f2639z("PURPOSE_RESTRICTION_UNDEFINED"),
    A("UNRECOGNIZED");


    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f2640v;

    t4(String str) {
        this.f2640v = i;
    }

    @Override // com.google.android.gms.internal.measurement.k5
    public final int a() {
        if (this != A) {
            return this.f2640v;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f2640v);
    }
}
