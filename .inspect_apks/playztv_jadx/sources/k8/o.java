package k8;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o {
    public static final o f = new o((Boolean) null, 100, (Boolean) null, (String) null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f7339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f7340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EnumMap f7341e;

    public o(Boolean bool, int i, Boolean bool2, String str) {
        EnumMap enumMap = new EnumMap(y1.class);
        this.f7341e = enumMap;
        enumMap.put(y1.f7556x, bool == null ? b2.f7089v : bool.booleanValue() ? b2.f7092y : b2.f7091x);
        this.f7337a = i;
        this.f7338b = e();
        this.f7339c = bool2;
        this.f7340d = str;
    }

    public static Boolean a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        int i = r.f7387a[z1.g(bundle.getString("ad_personalization")).ordinal()];
        if (i == 3) {
            return Boolean.FALSE;
        }
        if (i != 4) {
            return null;
        }
        return Boolean.TRUE;
    }

    public static o b(int i, Bundle bundle) {
        if (bundle == null) {
            return new o((Boolean) null, i, (Boolean) null, (String) null);
        }
        EnumMap enumMap = new EnumMap(y1.class);
        for (y1 y1Var : a2.DMA.f7074u) {
            enumMap.put(y1Var, z1.g(bundle.getString(y1Var.f7559u)));
        }
        return new o(enumMap, i, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    public static o c(String str) {
        if (str == null || str.length() <= 0) {
            return f;
        }
        String[] strArrSplit = str.split(":");
        int i = Integer.parseInt(strArrSplit[0]);
        EnumMap enumMap = new EnumMap(y1.class);
        y1[] y1VarArr = a2.DMA.f7074u;
        int length = y1VarArr.length;
        int i10 = 1;
        int i11 = 0;
        while (i11 < length) {
            enumMap.put(y1VarArr[i11], z1.f(strArrSplit[i10].charAt(0)));
            i11++;
            i10++;
        }
        return new o(enumMap, i, (Boolean) null, (String) null);
    }

    public final b2 d() {
        b2 b2Var = (b2) this.f7341e.get(y1.f7556x);
        return b2Var == null ? b2.f7089v : b2Var;
    }

    public final String e() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f7337a);
        for (y1 y1Var : a2.DMA.f7074u) {
            sb2.append(":");
            sb2.append(z1.a((b2) this.f7341e.get(y1Var)));
        }
        return sb2.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f7338b.equalsIgnoreCase(oVar.f7338b) && Objects.equals(this.f7339c, oVar.f7339c)) {
            return Objects.equals(this.f7340d, oVar.f7340d);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.f7339c;
        int i = bool == null ? 3 : bool == Boolean.TRUE ? 7 : 13;
        String str = this.f7340d;
        return ((str == null ? 17 : str.hashCode()) * 137) + (i * 29) + this.f7338b.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("source=");
        sb2.append(z1.b(this.f7337a));
        for (y1 y1Var : a2.DMA.f7074u) {
            sb2.append(",");
            sb2.append(y1Var.f7559u);
            sb2.append("=");
            b2 b2Var = (b2) this.f7341e.get(y1Var);
            if (b2Var == null) {
                sb2.append("uninitialized");
            } else {
                int i = r.f7387a[b2Var.ordinal()];
                if (i == 1) {
                    sb2.append("uninitialized");
                } else if (i == 2) {
                    sb2.append("eu_consent_policy");
                } else if (i == 3) {
                    sb2.append("denied");
                } else if (i == 4) {
                    sb2.append("granted");
                }
            }
        }
        Boolean bool = this.f7339c;
        if (bool != null) {
            sb2.append(",isDmaRegion=");
            sb2.append(bool);
        }
        String str = this.f7340d;
        if (str != null) {
            sb2.append(",cpsDisplayStr=");
            sb2.append(str);
        }
        return sb2.toString();
    }

    public o(EnumMap enumMap, int i, Boolean bool, String str) {
        EnumMap enumMap2 = new EnumMap(y1.class);
        this.f7341e = enumMap2;
        enumMap2.putAll(enumMap);
        this.f7337a = i;
        this.f7338b = e();
        this.f7339c = bool;
        this.f7340d = str;
    }
}
