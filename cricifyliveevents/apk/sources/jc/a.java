package jc;

import l0.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f6732e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f6733g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte f6734h;

    public final b a() {
        if (this.f6734h == 3 && this.f6729b != 0) {
            return new b(this.f6728a, this.f6729b, this.f6730c, this.f6731d, this.f6732e, this.f, this.f6733g);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f6729b == 0) {
            sb.append(" registrationStatus");
        }
        if ((this.f6734h & 1) == 0) {
            sb.append(" expiresInSecs");
        }
        if ((this.f6734h & 2) == 0) {
            sb.append(" tokenCreationEpochInSecs");
        }
        throw new IllegalStateException(e.l("Missing required properties:", sb));
    }
}
