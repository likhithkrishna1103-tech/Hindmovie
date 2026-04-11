package p1;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10107a;

    static {
        int i = s1.b0.f11647a;
        f10107a = Integer.toString(0, 36);
    }

    public static x0 a(Bundle bundle) {
        String str = f10107a;
        int i = bundle.getInt(str, -1);
        if (i == 0) {
            String str2 = s.f10052d;
            s1.d.b(bundle.getInt(str, -1) == 0);
            return bundle.getBoolean(s.f10052d, false) ? new s(bundle.getBoolean(s.f10053e, false)) : new s();
        }
        if (i == 1) {
            String str3 = o0.f9954c;
            s1.d.b(bundle.getInt(str, -1) == 1);
            float f = bundle.getFloat(o0.f9954c, -1.0f);
            return f == -1.0f ? new o0() : new o0(f);
        }
        if (i != 2) {
            if (i != 3) {
                throw new IllegalArgumentException(e6.j.l("Unknown RatingType: ", i));
            }
            String str4 = a1.f9640d;
            s1.d.b(bundle.getInt(str, -1) == 3);
            return bundle.getBoolean(a1.f9640d, false) ? new a1(bundle.getBoolean(a1.f9641e, false)) : new a1();
        }
        String str5 = y0.f10109d;
        s1.d.b(bundle.getInt(str, -1) == 2);
        int i10 = bundle.getInt(y0.f10109d, 5);
        float f4 = bundle.getFloat(y0.f10110e, -1.0f);
        return f4 == -1.0f ? new y0(i10) : new y0(i10, f4);
    }

    public abstract boolean b();

    public abstract Bundle c();
}
