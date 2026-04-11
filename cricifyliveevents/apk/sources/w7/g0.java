package w7;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final SparseArray f14050v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ g0[] f14051w;

    /* JADX INFO: Fake field, exist only in values array */
    g0 EF0;

    static {
        g0 g0Var = new g0("UNKNOWN_MOBILE_SUBTYPE", 0);
        g0 g0Var2 = new g0("GPRS", 1);
        g0 g0Var3 = new g0("EDGE", 2);
        g0 g0Var4 = new g0("UMTS", 3);
        g0 g0Var5 = new g0("CDMA", 4);
        g0 g0Var6 = new g0("EVDO_0", 5);
        g0 g0Var7 = new g0("EVDO_A", 6);
        g0 g0Var8 = new g0("RTT", 7);
        g0 g0Var9 = new g0("HSDPA", 8);
        g0 g0Var10 = new g0("HSUPA", 9);
        g0 g0Var11 = new g0("HSPA", 10);
        g0 g0Var12 = new g0("IDEN", 11);
        g0 g0Var13 = new g0("EVDO_B", 12);
        g0 g0Var14 = new g0("LTE", 13);
        g0 g0Var15 = new g0("EHRPD", 14);
        g0 g0Var16 = new g0("HSPAP", 15);
        g0 g0Var17 = new g0("GSM", 16);
        g0 g0Var18 = new g0("TD_SCDMA", 17);
        g0 g0Var19 = new g0("IWLAN", 18);
        g0 g0Var20 = new g0("LTE_CA", 19);
        f14051w = new g0[]{g0Var, g0Var2, g0Var3, g0Var4, g0Var5, g0Var6, g0Var7, g0Var8, g0Var9, g0Var10, g0Var11, g0Var12, g0Var13, g0Var14, g0Var15, g0Var16, g0Var17, g0Var18, g0Var19, g0Var20, new g0("COMBINED", 20)};
        SparseArray sparseArray = new SparseArray();
        f14050v = sparseArray;
        sparseArray.put(0, g0Var);
        sparseArray.put(1, g0Var2);
        sparseArray.put(2, g0Var3);
        sparseArray.put(3, g0Var4);
        sparseArray.put(4, g0Var5);
        sparseArray.put(5, g0Var6);
        sparseArray.put(6, g0Var7);
        sparseArray.put(7, g0Var8);
        sparseArray.put(8, g0Var9);
        sparseArray.put(9, g0Var10);
        sparseArray.put(10, g0Var11);
        sparseArray.put(11, g0Var12);
        sparseArray.put(12, g0Var13);
        sparseArray.put(13, g0Var14);
        sparseArray.put(14, g0Var15);
        sparseArray.put(15, g0Var16);
        sparseArray.put(16, g0Var17);
        sparseArray.put(17, g0Var18);
        sparseArray.put(18, g0Var19);
        sparseArray.put(19, g0Var20);
    }

    public static g0 valueOf(String str) {
        return (g0) Enum.valueOf(g0.class, str);
    }

    public static g0[] values() {
        return (g0[]) f14051w.clone();
    }
}
