package g4;

import android.media.session.MediaSession;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5197c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s1 f5198a;

    static {
        p1.h0.a("media3.session");
        int i = s1.b0.f11647a;
        f5196b = Integer.toString(0, 36);
        f5197c = Integer.toString(1, 36);
    }

    public r1(int i, String str, f1 f1Var, Bundle bundle, MediaSession.Token token) {
        this.f5198a = new s1(i, str, f1Var, bundle, token);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof r1) {
            return this.f5198a.equals(((r1) obj).f5198a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5198a.hashCode();
    }

    public final String toString() {
        return this.f5198a.toString();
    }
}
