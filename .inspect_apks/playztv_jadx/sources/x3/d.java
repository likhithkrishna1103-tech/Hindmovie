package x3;

import android.graphics.Color;
import b1.j;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f14247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f14248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f14249e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f14250g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f14251h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f14252j;

    public d(String str, int i, Integer num, Integer num2, float f, boolean z2, boolean z10, boolean z11, boolean z12, int i10) {
        this.f14245a = str;
        this.f14246b = i;
        this.f14247c = num;
        this.f14248d = num2;
        this.f14249e = f;
        this.f = z2;
        this.f14250g = z10;
        this.f14251h = z11;
        this.i = z12;
        this.f14252j = i10;
    }

    public static int a(String str) {
        boolean z2;
        try {
            int i = Integer.parseInt(str.trim());
            switch (i) {
                case 1:
                case 2:
                case 3:
                case j.LONG_FIELD_NUMBER /* 4 */:
                case j.STRING_FIELD_NUMBER /* 5 */:
                case j.STRING_SET_FIELD_NUMBER /* 6 */:
                case j.DOUBLE_FIELD_NUMBER /* 7 */:
                case 8:
                case 9:
                    z2 = true;
                    break;
                default:
                    z2 = false;
                    break;
            }
            if (z2) {
                return i;
            }
        } catch (NumberFormatException unused) {
        }
        e6.j.r("Ignoring unknown alignment: ", str, "SsaStyle");
        return -1;
    }

    public static boolean b(String str) {
        try {
            int i = Integer.parseInt(str);
            return i == 1 || i == -1;
        } catch (NumberFormatException e10) {
            s1.b.q("SsaStyle", "Failed to parse boolean value: '" + str + "'", e10);
            return false;
        }
    }

    public static Integer c(String str) {
        try {
            long j5 = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            s1.d.b(j5 <= 4294967295L);
            return Integer.valueOf(Color.argb(q1.c.n(((j5 >> 24) & 255) ^ 255), q1.c.n(j5 & 255), q1.c.n((j5 >> 8) & 255), q1.c.n((j5 >> 16) & 255)));
        } catch (IllegalArgumentException e10) {
            s1.b.q("SsaStyle", "Failed to parse color expression: '" + str + "'", e10);
            return null;
        }
    }
}
