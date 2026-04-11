package w7;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final SparseArray f14054v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ h0[] f14055w;

    /* JADX INFO: Fake field, exist only in values array */
    h0 EF0;

    static {
        h0 h0Var = new h0("MOBILE", 0);
        h0 h0Var2 = new h0("WIFI", 1);
        h0 h0Var3 = new h0("MOBILE_MMS", 2);
        h0 h0Var4 = new h0("MOBILE_SUPL", 3);
        h0 h0Var5 = new h0("MOBILE_DUN", 4);
        h0 h0Var6 = new h0("MOBILE_HIPRI", 5);
        h0 h0Var7 = new h0("WIMAX", 6);
        h0 h0Var8 = new h0("BLUETOOTH", 7);
        h0 h0Var9 = new h0("DUMMY", 8);
        h0 h0Var10 = new h0("ETHERNET", 9);
        h0 h0Var11 = new h0("MOBILE_FOTA", 10);
        h0 h0Var12 = new h0("MOBILE_IMS", 11);
        h0 h0Var13 = new h0("MOBILE_CBS", 12);
        h0 h0Var14 = new h0("WIFI_P2P", 13);
        h0 h0Var15 = new h0("MOBILE_IA", 14);
        h0 h0Var16 = new h0("MOBILE_EMERGENCY", 15);
        h0 h0Var17 = new h0("PROXY", 16);
        h0 h0Var18 = new h0("VPN", 17);
        h0 h0Var19 = new h0("NONE", 18);
        f14055w = new h0[]{h0Var, h0Var2, h0Var3, h0Var4, h0Var5, h0Var6, h0Var7, h0Var8, h0Var9, h0Var10, h0Var11, h0Var12, h0Var13, h0Var14, h0Var15, h0Var16, h0Var17, h0Var18, h0Var19};
        SparseArray sparseArray = new SparseArray();
        f14054v = sparseArray;
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
        sparseArray.put(-1, h0Var19);
    }

    public static h0 valueOf(String str) {
        return (h0) Enum.valueOf(h0.class, str);
    }

    public static h0[] values() {
        return (h0[]) f14055w.clone();
    }
}
