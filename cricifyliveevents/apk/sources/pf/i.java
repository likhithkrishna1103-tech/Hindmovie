package pf;

import ag.q;
import kf.b0;
import kf.s;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends b0 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f10303w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f10304x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final q f10305y;

    public i(String str, long j4, q qVar) {
        this.f10303w = str;
        this.f10304x = j4;
        this.f10305y = qVar;
    }

    @Override // kf.b0
    public final long a() {
        return this.f10304x;
    }

    @Override // kf.b0
    public final s g() {
        String str = this.f10303w;
        if (str == null) {
            return null;
        }
        ne.g gVar = s.f7522c;
        try {
            return t1.g(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Override // kf.b0
    public final ag.g q() {
        return this.f10305y;
    }
}
