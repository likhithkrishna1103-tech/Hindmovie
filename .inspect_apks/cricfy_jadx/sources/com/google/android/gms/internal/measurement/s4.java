package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public enum s4 implements k5 {
    /* JADX INFO: Fake field, exist only in values array */
    EF0("IAB_TCF_PURPOSE_UNKNOWN"),
    f2604w("IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE"),
    f2605x("IAB_TCF_PURPOSE_SELECT_BASIC_ADS"),
    f2606y("IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE"),
    f2607z("IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS"),
    /* JADX INFO: Fake field, exist only in values array */
    EF10("IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_CONTENT_PROFILE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF12("IAB_TCF_PURPOSE_SELECT_PERSONALISED_CONTENT"),
    A("IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("IAB_TCF_PURPOSE_MEASURE_CONTENT_PERFORMANCE"),
    B("IAB_TCF_PURPOSE_APPLY_MARKET_RESEARCH_TO_GENERATE_AUDIENCE_INSIGHTS"),
    C("IAB_TCF_PURPOSE_DEVELOP_AND_IMPROVE_PRODUCTS"),
    /* JADX INFO: Fake field, exist only in values array */
    EF9("IAB_TCF_PURPOSE_USE_LIMITED_DATA_TO_SELECT_CONTENT"),
    D("UNRECOGNIZED");


    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f2608v;

    s4(String str) {
        this.f2608v = i;
    }

    @Override // com.google.android.gms.internal.measurement.k5
    public final int a() {
        if (this != D) {
            return this.f2608v;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f2608v);
    }
}
