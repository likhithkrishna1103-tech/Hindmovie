package k4;

import android.media.session.MediaSession;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q1 {
    public static final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f7143g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f7144h;
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f7145j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f7146k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f7147l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f7148m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f7149n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f7150o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d1 f7153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f7154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MediaSession.Token f7155e;

    static {
        int i10 = y1.a0.f14551a;
        f = Integer.toString(0, 36);
        f7143g = Integer.toString(1, 36);
        f7144h = Integer.toString(2, 36);
        i = Integer.toString(3, 36);
        f7145j = Integer.toString(4, 36);
        f7146k = Integer.toString(5, 36);
        f7147l = Integer.toString(6, 36);
        f7148m = Integer.toString(7, 36);
        f7149n = Integer.toString(8, 36);
        f7150o = Integer.toString(9, 36);
    }

    public q1(int i10, String str, d1 d1Var, Bundle bundle, MediaSession.Token token) {
        str.getClass();
        this.f7151a = i10;
        this.f7152b = str;
        this.f7153c = d1Var;
        this.f7154d = bundle;
        this.f7155e = token;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof q1)) {
            return false;
        }
        q1 q1Var = (q1) obj;
        return this.f7151a == q1Var.f7151a && TextUtils.equals(this.f7152b, q1Var.f7152b) && TextUtils.equals("", "") && this.f7153c.equals(q1Var.f7153c) && Objects.equals(this.f7155e, q1Var.f7155e);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f7151a), 0, 1008000300, 5, this.f7152b, "", null, this.f7153c, this.f7155e);
    }

    public final String toString() {
        return "SessionToken {pkg=" + this.f7152b + " type=0 libraryVersion=1008000300 interfaceVersion=5 service= IMediaSession=" + this.f7153c + " extras=" + this.f7154d + "}";
    }
}
