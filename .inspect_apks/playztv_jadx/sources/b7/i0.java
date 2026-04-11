package b7;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final SparseArray f1867u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ i0[] f1868v;

    /* JADX INFO: Fake field, exist only in values array */
    i0 EF0;

    static {
        i0 i0Var = new i0("MOBILE", 0);
        i0 i0Var2 = new i0("WIFI", 1);
        i0 i0Var3 = new i0("MOBILE_MMS", 2);
        i0 i0Var4 = new i0("MOBILE_SUPL", 3);
        i0 i0Var5 = new i0("MOBILE_DUN", 4);
        i0 i0Var6 = new i0("MOBILE_HIPRI", 5);
        i0 i0Var7 = new i0("WIMAX", 6);
        i0 i0Var8 = new i0("BLUETOOTH", 7);
        i0 i0Var9 = new i0("DUMMY", 8);
        i0 i0Var10 = new i0("ETHERNET", 9);
        i0 i0Var11 = new i0("MOBILE_FOTA", 10);
        i0 i0Var12 = new i0("MOBILE_IMS", 11);
        i0 i0Var13 = new i0("MOBILE_CBS", 12);
        i0 i0Var14 = new i0("WIFI_P2P", 13);
        i0 i0Var15 = new i0("MOBILE_IA", 14);
        i0 i0Var16 = new i0("MOBILE_EMERGENCY", 15);
        i0 i0Var17 = new i0("PROXY", 16);
        i0 i0Var18 = new i0("VPN", 17);
        i0 i0Var19 = new i0("NONE", 18);
        f1868v = new i0[]{i0Var, i0Var2, i0Var3, i0Var4, i0Var5, i0Var6, i0Var7, i0Var8, i0Var9, i0Var10, i0Var11, i0Var12, i0Var13, i0Var14, i0Var15, i0Var16, i0Var17, i0Var18, i0Var19};
        SparseArray sparseArray = new SparseArray();
        f1867u = sparseArray;
        sparseArray.put(0, i0Var);
        sparseArray.put(1, i0Var2);
        sparseArray.put(2, i0Var3);
        sparseArray.put(3, i0Var4);
        sparseArray.put(4, i0Var5);
        sparseArray.put(5, i0Var6);
        sparseArray.put(6, i0Var7);
        sparseArray.put(7, i0Var8);
        sparseArray.put(8, i0Var9);
        sparseArray.put(9, i0Var10);
        sparseArray.put(10, i0Var11);
        sparseArray.put(11, i0Var12);
        sparseArray.put(12, i0Var13);
        sparseArray.put(13, i0Var14);
        sparseArray.put(14, i0Var15);
        sparseArray.put(15, i0Var16);
        sparseArray.put(16, i0Var17);
        sparseArray.put(17, i0Var18);
        sparseArray.put(-1, i0Var19);
    }

    public static i0 valueOf(String str) {
        return (i0) Enum.valueOf(i0.class, str);
    }

    public static i0[] values() {
        return (i0[]) f1868v.clone();
    }
}
