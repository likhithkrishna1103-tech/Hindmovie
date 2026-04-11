package wa;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f13811e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f13812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f13813h;
    public List i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte f13814j;

    public final d0 a() {
        String str;
        if (this.f13814j == 63 && (str = this.f13808b) != null) {
            return new d0(this.f13807a, str, this.f13809c, this.f13810d, this.f13811e, this.f, this.f13812g, this.f13813h, this.i);
        }
        StringBuilder sb2 = new StringBuilder();
        if ((this.f13814j & 1) == 0) {
            sb2.append(" pid");
        }
        if (this.f13808b == null) {
            sb2.append(" processName");
        }
        if ((this.f13814j & 2) == 0) {
            sb2.append(" reasonCode");
        }
        if ((this.f13814j & 4) == 0) {
            sb2.append(" importance");
        }
        if ((this.f13814j & 8) == 0) {
            sb2.append(" pss");
        }
        if ((this.f13814j & 16) == 0) {
            sb2.append(" rss");
        }
        if ((this.f13814j & 32) == 0) {
            sb2.append(" timestamp");
        }
        throw new IllegalStateException(e6.j.o("Missing required properties:", sb2));
    }
}
