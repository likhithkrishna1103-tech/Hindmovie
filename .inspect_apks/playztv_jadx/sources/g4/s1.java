package g4;

import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s1 {
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f5205j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f5206k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f5207l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f5208m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f5209n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f5210o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f5211p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f5212q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f5213r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f5218e;
    public final IBinder f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f5219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MediaSession.Token f5220h;

    static {
        int i10 = s1.b0.f11647a;
        i = Integer.toString(0, 36);
        f5205j = Integer.toString(1, 36);
        f5206k = Integer.toString(2, 36);
        f5207l = Integer.toString(3, 36);
        f5208m = Integer.toString(4, 36);
        f5209n = Integer.toString(5, 36);
        f5210o = Integer.toString(6, 36);
        f5211p = Integer.toString(7, 36);
        f5212q = Integer.toString(8, 36);
        f5213r = Integer.toString(9, 36);
    }

    public s1(int i10, String str, f1 f1Var, Bundle bundle, MediaSession.Token token) {
        str.getClass();
        this.f5214a = i10;
        this.f5215b = 1008000300;
        this.f5216c = 5;
        this.f5217d = str;
        this.f5218e = "";
        this.f = f1Var;
        this.f5219g = bundle;
        this.f5220h = token;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof s1)) {
            return false;
        }
        s1 s1Var = (s1) obj;
        return this.f5214a == s1Var.f5214a && this.f5215b == s1Var.f5215b && this.f5216c == s1Var.f5216c && TextUtils.equals(this.f5217d, s1Var.f5217d) && TextUtils.equals(this.f5218e, s1Var.f5218e) && Objects.equals(this.f, s1Var.f) && Objects.equals(this.f5220h, s1Var.f5220h);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f5214a), 0, Integer.valueOf(this.f5215b), Integer.valueOf(this.f5216c), this.f5217d, this.f5218e, null, this.f, this.f5220h);
    }

    public final String toString() {
        return "SessionToken {pkg=" + this.f5217d + " type=0 libraryVersion=" + this.f5215b + " interfaceVersion=" + this.f5216c + " service=" + this.f5218e + " IMediaSession=" + this.f + " extras=" + this.f5219g + "}";
    }
}
