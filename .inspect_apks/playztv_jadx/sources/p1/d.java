package p1;

import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f9682h = new d(0, 0, 1, 1, 0, false);
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f9683j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f9684k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f9685l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f9686m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f9687n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9692e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r0 f9693g;

    static {
        int i10 = s1.b0.f11647a;
        i = Integer.toString(0, 36);
        f9683j = Integer.toString(1, 36);
        f9684k = Integer.toString(2, 36);
        f9685l = Integer.toString(3, 36);
        f9686m = Integer.toString(4, 36);
        f9687n = Integer.toString(5, 36);
    }

    public d(int i10, int i11, int i12, int i13, int i14, boolean z2) {
        this.f9688a = i10;
        this.f9689b = i11;
        this.f9690c = i12;
        this.f9691d = i13;
        this.f9692e = i14;
        this.f = z2;
    }

    public static d a(Bundle bundle) {
        String str = i;
        int i10 = bundle.containsKey(str) ? bundle.getInt(str) : 0;
        String str2 = f9683j;
        int i11 = bundle.containsKey(str2) ? bundle.getInt(str2) : 0;
        String str3 = f9684k;
        int i12 = bundle.containsKey(str3) ? bundle.getInt(str3) : 1;
        String str4 = f9685l;
        int i13 = bundle.containsKey(str4) ? bundle.getInt(str4) : 1;
        String str5 = f9686m;
        int i14 = bundle.containsKey(str5) ? bundle.getInt(str5) : 0;
        String str6 = f9687n;
        return new d(i10, i11, i12, i13, i14, bundle.containsKey(str6) ? bundle.getBoolean(str6) : false);
    }

    public final r0 b() {
        if (this.f9693g == null) {
            r0 r0Var = new r0();
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.f9688a).setFlags(this.f9689b).setUsage(this.f9690c);
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 29) {
                usage.setAllowedCapturePolicy(this.f9691d);
            }
            if (i10 >= 32) {
                usage.setSpatializationBehavior(this.f9692e);
                usage.setIsContentSpatialized(this.f);
            }
            r0Var.f10045a = usage.build();
            this.f9693g = r0Var;
        }
        return this.f9693g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f9688a == dVar.f9688a && this.f9689b == dVar.f9689b && this.f9690c == dVar.f9690c && this.f9691d == dVar.f9691d && this.f9692e == dVar.f9692e && this.f == dVar.f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((527 + this.f9688a) * 31) + this.f9689b) * 31) + this.f9690c) * 31) + this.f9691d) * 31) + this.f9692e) * 31) + (this.f ? 1 : 0);
    }
}
