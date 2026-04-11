package b7;

import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements t7.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final MessageDigest f1837v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final t7.e f1838w = new t7.e();

    public h(MessageDigest messageDigest) {
        this.f1837v = messageDigest;
    }

    @Override // t7.b
    public final t7.e b() {
        return this.f1838w;
    }
}
