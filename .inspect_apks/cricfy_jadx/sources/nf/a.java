package nf;

import ge.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f9150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f9151d;

    public a(String str) {
        i.e(str, "name");
        this.f9148a = str;
        this.f9149b = true;
        this.f9151d = -1L;
    }

    public abstract long a();

    public final String toString() {
        return this.f9148a;
    }
}
