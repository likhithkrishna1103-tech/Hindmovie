package k4;

import android.media.session.MediaSession;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7133c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q1 f7134a;

    static {
        v1.h0.a("media3.session");
        int i = y1.a0.f14551a;
        f7132b = Integer.toString(0, 36);
        f7133c = Integer.toString(1, 36);
    }

    public p1(int i, String str, d1 d1Var, Bundle bundle, MediaSession.Token token) {
        this.f7134a = new q1(i, str, d1Var, bundle, token);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof p1) {
            return this.f7134a.equals(((p1) obj).f7134a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f7134a.hashCode();
    }

    public final String toString() {
        return this.f7134a.toString();
    }
}
