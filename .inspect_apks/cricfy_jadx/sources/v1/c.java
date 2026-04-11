package v1;

import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f12586h = new c(0, 0, 1, 1, 0, false);
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f12587j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f12588k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f12589l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f12590m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f12591n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12596e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r0 f12597g;

    static {
        int i10 = y1.a0.f14551a;
        i = Integer.toString(0, 36);
        f12587j = Integer.toString(1, 36);
        f12588k = Integer.toString(2, 36);
        f12589l = Integer.toString(3, 36);
        f12590m = Integer.toString(4, 36);
        f12591n = Integer.toString(5, 36);
    }

    public c(int i10, int i11, int i12, int i13, int i14, boolean z10) {
        this.f12592a = i10;
        this.f12593b = i11;
        this.f12594c = i12;
        this.f12595d = i13;
        this.f12596e = i14;
        this.f = z10;
    }

    public static c a(Bundle bundle) {
        String str = i;
        int i10 = bundle.containsKey(str) ? bundle.getInt(str) : 0;
        String str2 = f12587j;
        int i11 = bundle.containsKey(str2) ? bundle.getInt(str2) : 0;
        String str3 = f12588k;
        int i12 = bundle.containsKey(str3) ? bundle.getInt(str3) : 1;
        String str4 = f12589l;
        int i13 = bundle.containsKey(str4) ? bundle.getInt(str4) : 1;
        String str5 = f12590m;
        int i14 = bundle.containsKey(str5) ? bundle.getInt(str5) : 0;
        String str6 = f12591n;
        return new c(i10, i11, i12, i13, i14, bundle.containsKey(str6) ? bundle.getBoolean(str6) : false);
    }

    public final r0 b() {
        if (this.f12597g == null) {
            r0 r0Var = new r0();
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.f12592a).setFlags(this.f12593b).setUsage(this.f12594c);
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 29) {
                usage.setAllowedCapturePolicy(this.f12595d);
            }
            if (i10 >= 32) {
                usage.setSpatializationBehavior(this.f12596e);
                usage.setIsContentSpatialized(this.f);
            }
            r0Var.f12977a = usage.build();
            this.f12597g = r0Var;
        }
        return this.f12597g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass()) {
            c cVar = (c) obj;
            if (this.f12592a == cVar.f12592a && this.f12593b == cVar.f12593b && this.f12594c == cVar.f12594c && this.f12595d == cVar.f12595d && this.f12596e == cVar.f12596e && this.f == cVar.f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((527 + this.f12592a) * 31) + this.f12593b) * 31) + this.f12594c) * 31) + this.f12595d) * 31) + this.f12596e) * 31) + (this.f ? 1 : 0);
    }
}
