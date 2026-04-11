package yc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final f Companion = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f15034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f15035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f15036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f15037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f15038e;

    public /* synthetic */ g(int i, Boolean bool, Double d10, Integer num, Integer num2, Long l10) {
        if (31 != (i & 31)) {
            df.k.a(i, 31, e.f15033a.d());
            throw null;
        }
        this.f15034a = bool;
        this.f15035b = d10;
        this.f15036c = num;
        this.f15037d = num2;
        this.f15038e = l10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return ge.i.a(this.f15034a, gVar.f15034a) && ge.i.a(this.f15035b, gVar.f15035b) && ge.i.a(this.f15036c, gVar.f15036c) && ge.i.a(this.f15037d, gVar.f15037d) && ge.i.a(this.f15038e, gVar.f15038e);
    }

    public final int hashCode() {
        Boolean bool = this.f15034a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Double d10 = this.f15035b;
        int iHashCode2 = (iHashCode + (d10 == null ? 0 : d10.hashCode())) * 31;
        Integer num = this.f15036c;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f15037d;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l10 = this.f15038e;
        return iHashCode4 + (l10 != null ? l10.hashCode() : 0);
    }

    public final String toString() {
        return "SessionConfigs(sessionsEnabled=" + this.f15034a + ", sessionSamplingRate=" + this.f15035b + ", sessionTimeoutSeconds=" + this.f15036c + ", cacheDurationSeconds=" + this.f15037d + ", cacheUpdatedTimeSeconds=" + this.f15038e + ')';
    }

    public g(Boolean bool, Double d10, Integer num, Integer num2, Long l10) {
        this.f15034a = bool;
        this.f15035b = d10;
        this.f15036c = num;
        this.f15037d = num2;
        this.f15038e = l10;
    }
}
