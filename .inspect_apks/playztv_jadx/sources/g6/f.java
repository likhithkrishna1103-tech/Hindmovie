package g6;

import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements y6.b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final MessageDigest f5328u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final y6.e f5329v = new y6.e();

    public f(MessageDigest messageDigest) {
        this.f5328u = messageDigest;
    }

    @Override // y6.b
    public final y6.e a() {
        return this.f5329v;
    }
}
