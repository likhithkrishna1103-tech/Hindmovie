package b4;

import android.graphics.Color;
import g1.h;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f1777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f1778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f1779e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f1780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f1781h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f1782j;

    public e(String str, int i, Integer num, Integer num2, float f, boolean z10, boolean z11, boolean z12, boolean z13, int i10) {
        this.f1775a = str;
        this.f1776b = i;
        this.f1777c = num;
        this.f1778d = num2;
        this.f1779e = f;
        this.f = z10;
        this.f1780g = z11;
        this.f1781h = z12;
        this.i = z13;
        this.f1782j = i10;
    }

    public static int a(String str) {
        boolean z10;
        try {
            int i = Integer.parseInt(str.trim());
            switch (i) {
                case 1:
                case 2:
                case 3:
                case h.LONG_FIELD_NUMBER /* 4 */:
                case h.STRING_FIELD_NUMBER /* 5 */:
                case h.STRING_SET_FIELD_NUMBER /* 6 */:
                case h.DOUBLE_FIELD_NUMBER /* 7 */:
                case h.BYTES_FIELD_NUMBER /* 8 */:
                case 9:
                    z10 = true;
                    break;
                default:
                    z10 = false;
                    break;
            }
            if (z10) {
                return i;
            }
        } catch (NumberFormatException unused) {
        }
        l0.e.r("Ignoring unknown alignment: ", str, "SsaStyle");
        return -1;
    }

    public static boolean b(String str) {
        try {
            int i = Integer.parseInt(str);
            return i == 1 || i == -1;
        } catch (NumberFormatException e9) {
            y1.b.q("SsaStyle", "Failed to parse boolean value: '" + str + "'", e9);
            return false;
        }
    }

    public static Integer c(String str) {
        try {
            long j4 = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            y1.d.b(j4 <= 4294967295L);
            return Integer.valueOf(Color.argb(com.bumptech.glide.d.l(((j4 >> 24) & 255) ^ 255), com.bumptech.glide.d.l(j4 & 255), com.bumptech.glide.d.l((j4 >> 8) & 255), com.bumptech.glide.d.l((j4 >> 16) & 255)));
        } catch (IllegalArgumentException e9) {
            y1.b.q("SsaStyle", "Failed to parse color expression: '" + str + "'", e9);
            return null;
        }
    }
}
