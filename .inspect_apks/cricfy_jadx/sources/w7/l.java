package w7;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f14076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f14079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f14080e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f14081g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f14082h;
    public final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f14083j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f14084k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f14085l;

    public l(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f14076a = num;
        this.f14077b = str;
        this.f14078c = str2;
        this.f14079d = str3;
        this.f14080e = str4;
        this.f = str5;
        this.f14081g = str6;
        this.f14082h = str7;
        this.i = str8;
        this.f14083j = str9;
        this.f14084k = str10;
        this.f14085l = str11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            Integer num = this.f14076a;
            if (num != null ? num.equals(((l) aVar).f14076a) : ((l) aVar).f14076a == null) {
                String str = this.f14077b;
                if (str != null ? str.equals(((l) aVar).f14077b) : ((l) aVar).f14077b == null) {
                    String str2 = this.f14078c;
                    if (str2 != null ? str2.equals(((l) aVar).f14078c) : ((l) aVar).f14078c == null) {
                        String str3 = this.f14079d;
                        if (str3 != null ? str3.equals(((l) aVar).f14079d) : ((l) aVar).f14079d == null) {
                            String str4 = this.f14080e;
                            if (str4 != null ? str4.equals(((l) aVar).f14080e) : ((l) aVar).f14080e == null) {
                                String str5 = this.f;
                                if (str5 != null ? str5.equals(((l) aVar).f) : ((l) aVar).f == null) {
                                    String str6 = this.f14081g;
                                    if (str6 != null ? str6.equals(((l) aVar).f14081g) : ((l) aVar).f14081g == null) {
                                        String str7 = this.f14082h;
                                        if (str7 != null ? str7.equals(((l) aVar).f14082h) : ((l) aVar).f14082h == null) {
                                            String str8 = this.i;
                                            if (str8 != null ? str8.equals(((l) aVar).i) : ((l) aVar).i == null) {
                                                String str9 = this.f14083j;
                                                if (str9 != null ? str9.equals(((l) aVar).f14083j) : ((l) aVar).f14083j == null) {
                                                    String str10 = this.f14084k;
                                                    if (str10 != null ? str10.equals(((l) aVar).f14084k) : ((l) aVar).f14084k == null) {
                                                        String str11 = this.f14085l;
                                                        if (str11 != null ? str11.equals(((l) aVar).f14085l) : ((l) aVar).f14085l == null) {
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.f14076a;
        int iHashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f14077b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f14078c;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f14079d;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f14080e;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f14081g;
        int iHashCode7 = (iHashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f14082h;
        int iHashCode8 = (iHashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.i;
        int iHashCode9 = (iHashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.f14083j;
        int iHashCode10 = (iHashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.f14084k;
        int iHashCode11 = (iHashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.f14085l;
        return (str11 != null ? str11.hashCode() : 0) ^ iHashCode11;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AndroidClientInfo{sdkVersion=");
        sb.append(this.f14076a);
        sb.append(", model=");
        sb.append(this.f14077b);
        sb.append(", hardware=");
        sb.append(this.f14078c);
        sb.append(", device=");
        sb.append(this.f14079d);
        sb.append(", product=");
        sb.append(this.f14080e);
        sb.append(", osBuild=");
        sb.append(this.f);
        sb.append(", manufacturer=");
        sb.append(this.f14081g);
        sb.append(", fingerprint=");
        sb.append(this.f14082h);
        sb.append(", locale=");
        sb.append(this.i);
        sb.append(", country=");
        sb.append(this.f14083j);
        sb.append(", mccMnc=");
        sb.append(this.f14084k);
        sb.append(", applicationBuild=");
        return q4.a.q(sb, this.f14085l, "}");
    }
}
