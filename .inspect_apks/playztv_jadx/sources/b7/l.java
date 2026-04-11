package b7;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f1881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f1885e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f1886g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f1887h;
    public final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f1888j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f1889k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f1890l;

    public l(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f1881a = num;
        this.f1882b = str;
        this.f1883c = str2;
        this.f1884d = str3;
        this.f1885e = str4;
        this.f = str5;
        this.f1886g = str6;
        this.f1887h = str7;
        this.i = str8;
        this.f1888j = str9;
        this.f1889k = str10;
        this.f1890l = str11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            Integer num = this.f1881a;
            if (num != null ? num.equals(((l) aVar).f1881a) : ((l) aVar).f1881a == null) {
                String str = this.f1882b;
                if (str != null ? str.equals(((l) aVar).f1882b) : ((l) aVar).f1882b == null) {
                    String str2 = this.f1883c;
                    if (str2 != null ? str2.equals(((l) aVar).f1883c) : ((l) aVar).f1883c == null) {
                        String str3 = this.f1884d;
                        if (str3 != null ? str3.equals(((l) aVar).f1884d) : ((l) aVar).f1884d == null) {
                            String str4 = this.f1885e;
                            if (str4 != null ? str4.equals(((l) aVar).f1885e) : ((l) aVar).f1885e == null) {
                                String str5 = this.f;
                                if (str5 != null ? str5.equals(((l) aVar).f) : ((l) aVar).f == null) {
                                    String str6 = this.f1886g;
                                    if (str6 != null ? str6.equals(((l) aVar).f1886g) : ((l) aVar).f1886g == null) {
                                        String str7 = this.f1887h;
                                        if (str7 != null ? str7.equals(((l) aVar).f1887h) : ((l) aVar).f1887h == null) {
                                            String str8 = this.i;
                                            if (str8 != null ? str8.equals(((l) aVar).i) : ((l) aVar).i == null) {
                                                String str9 = this.f1888j;
                                                if (str9 != null ? str9.equals(((l) aVar).f1888j) : ((l) aVar).f1888j == null) {
                                                    String str10 = this.f1889k;
                                                    if (str10 != null ? str10.equals(((l) aVar).f1889k) : ((l) aVar).f1889k == null) {
                                                        String str11 = this.f1890l;
                                                        if (str11 != null ? str11.equals(((l) aVar).f1890l) : ((l) aVar).f1890l == null) {
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
        Integer num = this.f1881a;
        int iHashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f1882b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f1883c;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f1884d;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f1885e;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f1886g;
        int iHashCode7 = (iHashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f1887h;
        int iHashCode8 = (iHashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.i;
        int iHashCode9 = (iHashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.f1888j;
        int iHashCode10 = (iHashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.f1889k;
        int iHashCode11 = (iHashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.f1890l;
        return (str11 != null ? str11.hashCode() : 0) ^ iHashCode11;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("AndroidClientInfo{sdkVersion=");
        sb2.append(this.f1881a);
        sb2.append(", model=");
        sb2.append(this.f1882b);
        sb2.append(", hardware=");
        sb2.append(this.f1883c);
        sb2.append(", device=");
        sb2.append(this.f1884d);
        sb2.append(", product=");
        sb2.append(this.f1885e);
        sb2.append(", osBuild=");
        sb2.append(this.f);
        sb2.append(", manufacturer=");
        sb2.append(this.f1886g);
        sb2.append(", fingerprint=");
        sb2.append(this.f1887h);
        sb2.append(", locale=");
        sb2.append(this.i);
        sb2.append(", country=");
        sb2.append(this.f1888j);
        sb2.append(", mccMnc=");
        sb2.append(this.f1889k);
        sb2.append(", applicationBuild=");
        return l4.a.o(sb2, this.f1890l, "}");
    }
}
