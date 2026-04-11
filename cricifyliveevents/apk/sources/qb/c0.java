package qb;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f10514e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f10515g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f10516h;
    public List i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte f10517j;

    public final d0 a() {
        String str;
        if (this.f10517j == 63 && (str = this.f10511b) != null) {
            return new d0(this.f10510a, str, this.f10512c, this.f10513d, this.f10514e, this.f, this.f10515g, this.f10516h, this.i);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f10517j & 1) == 0) {
            sb.append(" pid");
        }
        if (this.f10511b == null) {
            sb.append(" processName");
        }
        if ((this.f10517j & 2) == 0) {
            sb.append(" reasonCode");
        }
        if ((this.f10517j & 4) == 0) {
            sb.append(" importance");
        }
        if ((this.f10517j & 8) == 0) {
            sb.append(" pss");
        }
        if ((this.f10517j & 16) == 0) {
            sb.append(" rss");
        }
        if ((this.f10517j & 32) == 0) {
            sb.append(" timestamp");
        }
        throw new IllegalStateException(l0.e.l("Missing required properties:", sb));
    }
}
