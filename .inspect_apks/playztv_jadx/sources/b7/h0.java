package b7;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final SparseArray f1857u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ h0[] f1858v;

    /* JADX INFO: Fake field, exist only in values array */
    h0 EF0;

    static {
        h0 h0Var = new h0("UNKNOWN_MOBILE_SUBTYPE", 0);
        h0 h0Var2 = new h0("GPRS", 1);
        h0 h0Var3 = new h0("EDGE", 2);
        h0 h0Var4 = new h0("UMTS", 3);
        h0 h0Var5 = new h0("CDMA", 4);
        h0 h0Var6 = new h0("EVDO_0", 5);
        h0 h0Var7 = new h0("EVDO_A", 6);
        h0 h0Var8 = new h0("RTT", 7);
        h0 h0Var9 = new h0("HSDPA", 8);
        h0 h0Var10 = new h0("HSUPA", 9);
        h0 h0Var11 = new h0("HSPA", 10);
        h0 h0Var12 = new h0("IDEN", 11);
        h0 h0Var13 = new h0("EVDO_B", 12);
        h0 h0Var14 = new h0("LTE", 13);
        h0 h0Var15 = new h0("EHRPD", 14);
        h0 h0Var16 = new h0("HSPAP", 15);
        h0 h0Var17 = new h0("GSM", 16);
        h0 h0Var18 = new h0("TD_SCDMA", 17);
        h0 h0Var19 = new h0("IWLAN", 18);
        h0 h0Var20 = new h0("LTE_CA", 19);
        f1858v = new h0[]{h0Var, h0Var2, h0Var3, h0Var4, h0Var5, h0Var6, h0Var7, h0Var8, h0Var9, h0Var10, h0Var11, h0Var12, h0Var13, h0Var14, h0Var15, h0Var16, h0Var17, h0Var18, h0Var19, h0Var20, new h0("COMBINED", 20)};
        SparseArray sparseArray = new SparseArray();
        f1857u = sparseArray;
        sparseArray.put(0, h0Var);
        sparseArray.put(1, h0Var2);
        sparseArray.put(2, h0Var3);
        sparseArray.put(3, h0Var4);
        sparseArray.put(4, h0Var5);
        sparseArray.put(5, h0Var6);
        sparseArray.put(6, h0Var7);
        sparseArray.put(7, h0Var8);
        sparseArray.put(8, h0Var9);
        sparseArray.put(9, h0Var10);
        sparseArray.put(10, h0Var11);
        sparseArray.put(11, h0Var12);
        sparseArray.put(12, h0Var13);
        sparseArray.put(13, h0Var14);
        sparseArray.put(14, h0Var15);
        sparseArray.put(15, h0Var16);
        sparseArray.put(16, h0Var17);
        sparseArray.put(17, h0Var18);
        sparseArray.put(18, h0Var19);
        sparseArray.put(19, h0Var20);
    }

    public static h0 valueOf(String str) {
        return (h0) Enum.valueOf(h0.class, str);
    }

    public static h0[] values() {
        return (h0[]) f1858v.clone();
    }
}
