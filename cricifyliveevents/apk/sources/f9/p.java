package f9;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p {
    public static final p f = new p((Boolean) null, 100, (Boolean) null, (String) null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f4316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EnumMap f4318e;

    public p(Boolean bool, int i, Boolean bool2, String str) {
        EnumMap enumMap = new EnumMap(f2.class);
        this.f4318e = enumMap;
        enumMap.put(f2.f4172y, bool == null ? d2.f4070w : bool.booleanValue() ? d2.f4073z : d2.f4072y);
        this.f4314a = i;
        this.f4315b = d();
        this.f4316c = bool2;
        this.f4317d = str;
    }

    public static p b(String str) {
        if (str == null || str.length() <= 0) {
            return f;
        }
        String[] strArrSplit = str.split(":");
        int i = Integer.parseInt(strArrSplit[0]);
        EnumMap enumMap = new EnumMap(f2.class);
        f2[] f2VarArr = e2.DMA.f4101v;
        int length = f2VarArr.length;
        int i10 = 1;
        int i11 = 0;
        while (i11 < length) {
            enumMap.put(f2VarArr[i11], g2.e(strArrSplit[i10].charAt(0)));
            i11++;
            i10++;
        }
        return new p(enumMap, i, (Boolean) null, (String) null);
    }

    public static p c(int i, Bundle bundle) {
        if (bundle == null) {
            return new p((Boolean) null, i, (Boolean) null, (String) null);
        }
        EnumMap enumMap = new EnumMap(f2.class);
        for (f2 f2Var : e2.DMA.f4101v) {
            enumMap.put(f2Var, g2.d(bundle.getString(f2Var.f4174v)));
        }
        return new p(enumMap, i, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    public final d2 a() {
        d2 d2Var = (d2) this.f4318e.get(f2.f4172y);
        return d2Var == null ? d2.f4070w : d2Var;
    }

    public final String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4314a);
        for (f2 f2Var : e2.DMA.f4101v) {
            sb.append(":");
            sb.append(g2.h((d2) this.f4318e.get(f2Var)));
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f4315b.equalsIgnoreCase(pVar.f4315b) && Objects.equals(this.f4316c, pVar.f4316c)) {
            return Objects.equals(this.f4317d, pVar.f4317d);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.f4316c;
        int i = bool == null ? 3 : true != bool.booleanValue() ? 13 : 7;
        String str = this.f4317d;
        return ((str == null ? 17 : str.hashCode()) * 137) + this.f4315b.hashCode() + (i * 29);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(g2.a(this.f4314a));
        for (f2 f2Var : e2.DMA.f4101v) {
            sb.append(",");
            sb.append(f2Var.f4174v);
            sb.append("=");
            d2 d2Var = (d2) this.f4318e.get(f2Var);
            if (d2Var == null) {
                sb.append("uninitialized");
            } else {
                int iOrdinal = d2Var.ordinal();
                if (iOrdinal == 0) {
                    sb.append("uninitialized");
                } else if (iOrdinal == 1) {
                    sb.append("eu_consent_policy");
                } else if (iOrdinal == 2) {
                    sb.append("denied");
                } else if (iOrdinal == 3) {
                    sb.append("granted");
                }
            }
        }
        Boolean bool = this.f4316c;
        if (bool != null) {
            sb.append(",isDmaRegion=");
            sb.append(bool);
        }
        String str = this.f4317d;
        if (str != null) {
            sb.append(",cpsDisplayStr=");
            sb.append(str);
        }
        return sb.toString();
    }

    public p(EnumMap enumMap, int i, Boolean bool, String str) {
        EnumMap enumMap2 = new EnumMap(f2.class);
        this.f4318e = enumMap2;
        enumMap2.putAll(enumMap);
        this.f4314a = i;
        this.f4315b = d();
        this.f4316c = bool;
        this.f4317d = str;
    }
}
