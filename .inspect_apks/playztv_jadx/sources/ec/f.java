package ec;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f4651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f4652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f4653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f4654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f4655e;

    public f(Boolean bool, Double d10, Integer num, Integer num2, Long l10) {
        this.f4651a = bool;
        this.f4652b = d10;
        this.f4653c = num;
        this.f4654d = num2;
        this.f4655e = l10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return be.h.a(this.f4651a, fVar.f4651a) && be.h.a(this.f4652b, fVar.f4652b) && be.h.a(this.f4653c, fVar.f4653c) && be.h.a(this.f4654d, fVar.f4654d) && be.h.a(this.f4655e, fVar.f4655e);
    }

    public final int hashCode() {
        Boolean bool = this.f4651a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Double d10 = this.f4652b;
        int iHashCode2 = (iHashCode + (d10 == null ? 0 : d10.hashCode())) * 31;
        Integer num = this.f4653c;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f4654d;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l10 = this.f4655e;
        return iHashCode4 + (l10 != null ? l10.hashCode() : 0);
    }

    public final String toString() {
        return "SessionConfigs(sessionEnabled=" + this.f4651a + ", sessionSamplingRate=" + this.f4652b + ", sessionRestartTimeout=" + this.f4653c + ", cacheDuration=" + this.f4654d + ", cacheUpdatedTime=" + this.f4655e + ')';
    }
}
